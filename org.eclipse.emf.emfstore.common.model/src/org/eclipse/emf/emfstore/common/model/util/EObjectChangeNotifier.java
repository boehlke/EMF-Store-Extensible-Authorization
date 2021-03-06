/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.emfstore.common.model.NotifiableIdEObjectCollection;

/**
 * Notifies a about changes in its containment hierarchy.
 * 
 * @author koegel
 * @author emueller
 */
public class EObjectChangeNotifier extends EContentAdapter {

	private final NotifiableIdEObjectCollection collection;
	private boolean isInitializing;
	private Set<EObject> removedModelElements;
	private Stack<Notification> currentNotifications;
	private int reentrantCallToAddAdapterCounter;
	private boolean notificationDisabled;

	/**
	 * Constructor. Attaches an {@link Adapter} to the given {@link Notifier} and forwards notifications to the given
	 * {@link NotifiableIdEObjectCollection}, that reacts appropriately.
	 * 
	 * @param notifiableCollection
	 *            a {@link NotifiableIdEObjectCollection}
	 * @param notifier
	 *            the {@link Notifier} to listen to
	 */
	public EObjectChangeNotifier(NotifiableIdEObjectCollection notifiableCollection, Notifier notifier) {
		this.collection = notifiableCollection;
		isInitializing = true;
		currentNotifications = new Stack<Notification>();
		notifier.eAdapters().add(this);
		isInitializing = false;
		reentrantCallToAddAdapterCounter = 0;
		notificationDisabled = false;
		removedModelElements = new HashSet<EObject>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {

		try {
			reentrantCallToAddAdapterCounter += 1;
			if (!notifier.eAdapters().contains(this)) {
				super.addAdapter(notifier);
			}
		} finally {
			reentrantCallToAddAdapterCounter -= 1;
		}
		if (reentrantCallToAddAdapterCounter > 0 || currentNotifications.isEmpty()) {
			// any other than the first call in re-entrant calls to addAdapter
			// are going to call the project
			return;
		}

		Notification currentNotification = currentNotifications.peek();

		if (currentNotification != null && !currentNotification.isTouch() && !isInitializing
			&& notifier instanceof EObject && !ModelUtil.isIgnoredDatatype((EObject) notifier)) {
			EObject modelElement = (EObject) notifier;
			if (!collection.containsInstance(modelElement) && isInCollection(modelElement)) {
				collection.modelElementAdded(collection, modelElement);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#removeAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void removeAdapter(Notifier notifier) {
		if (isInitializing || currentNotifications.isEmpty()) {
			return;
		}

		Notification currentNotification = currentNotifications.peek();

		if (currentNotification != null && currentNotification.isTouch()) {
			return;
		}

		if (currentNotification != null && currentNotification.getFeature() instanceof EReference) {
			EReference eReference = (EReference) currentNotification.getFeature();
			if (eReference.isContainment() && eReference.getEOpposite() != null
				&& !eReference.getEOpposite().isTransient()) {
				return;
			}
		}

		if (notifier instanceof EObject) {
			EObject modelElement = (EObject) notifier;
			if (!isInCollection(modelElement)
				&& (collection.containsInstance(modelElement) || collection.getDeletedModelElementId(modelElement) != null)) {
				removedModelElements.add(modelElement);
			}
		}

	}

	/**
	 * Checks whether the given {@link EObject} is within the collection.
	 * 
	 * @param modelElement
	 *            the {@link EObject} whose containment should be checked
	 * @return true, if the {@link EObject} is contained in the collection,
	 *         false otherwise
	 */
	private boolean isInCollection(EObject modelElement) {
		EObject parent = modelElement.eContainer();
		if (parent == null) {
			return false;
		}

		if (parent == collection) {
			return true;
		}

		if (collection.containsInstance(parent)) {
			return true;
		}

		return isInCollection(parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

		if (notificationDisabled) {
			return;
		}

		currentNotifications.push(notification);
		Object feature = notification.getFeature();
		Object notifier = notification.getNotifier();

		if (feature instanceof EReference) {
			EReference eReference = (EReference) feature;

			// Do not create notifications for transient features
			if (eReference.isTransient()) {
				return;
			}

			if (eReference.isContainer()) {
				handleContainer(notification, eReference);
			}
		}

		super.notifyChanged(notification);
		currentNotifications.pop();

		// collection itself is not a valid model element
		if (!notification.isTouch() && notifier instanceof EObject) {
			collection.notify(notification, collection, (EObject) notifier);
		}
		for (EObject removedModelElement : removedModelElements) {
			collection.modelElementRemoved(collection, removedModelElement);
		}
		removedModelElements.clear();
	}

	/**
	 * @param notification
	 */
	private void handleContainer(Notification notification, EReference eReference) {
		if (notification.getEventType() == Notification.SET) {
			Object newValue = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (newValue == null && oldValue != null) {
				removeAdapter((Notifier) notification.getNotifier());
			}
		}
	}

	/**
	 * @param notificationDisabled
	 *            the notificationDisabled to set
	 */
	public void disableNotifications(boolean notificationDisabled) {
		this.notificationDisabled = notificationDisabled;
	}

}
