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
package org.eclipse.emf.emfstore.client.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.changeTracking.NotificationToOperationConverter;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.FilterStack;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.recording.NotificationRecorder;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.CommonUtil;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.EObjectChangeNotifier;
import org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SettingWithReferencedElement;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

/**
 * Tracks changes on any given {@link IdEObjectCollection}.
 * 
 * @author koegel
 * @author emueller
 */
public class OperationRecorder implements CommandObserver, IdEObjectCollectionChangeObserver {

	/**
	 * Name of unknown creator.
	 */
	public static final String UNKOWN_CREATOR = "unknown";
	private EMFStoreCommandStack emfStoreCommandStack;
	private int currentOperationListSize;
	private EditingDomain editingDomain;
	private Set<EObject> currentClipboard;
	private List<AbstractOperation> operations;
	private List<EObject> removedElements;

	private NotificationToOperationConverter converter;

	private boolean commandIsRunning;

	private NotificationRecorder notificationRecorder;
	private boolean isRecording;

	private IdEObjectCollection rootEObject;

	private CompositeOperation compositeOperation;
	private List<OperationRecorderListener> operationRecordedListeners;

	private EObjectChangeNotifier changeNotifier;
	private boolean checkForIncomingCrossReferences;
	private boolean cutOffIncomingCrossReferences;
	private boolean emitOperationsWhenCommandCompleted;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace
	 *            the project space the change tracker is operating on.
	 */
	public OperationRecorder(IdEObjectCollection rootEObject, EObjectChangeNotifier changeNotifier) {
		// projectSpace) {
		// this.projectSpace = projectSpace;
		// this.isRecording = false;
		this.rootEObject = rootEObject;
		this.changeNotifier = changeNotifier;
		this.operations = new ArrayList<AbstractOperation>();
		operationRecordedListeners = new ArrayList<OperationRecorderListener>();

		editingDomain = Configuration.getEditingDomain();

		CommandStack commandStack = editingDomain.getCommandStack();
		// operations = new ArrayList<AbstractOperation>();

		if (commandStack instanceof EMFStoreCommandStack) {
			emfStoreCommandStack = (EMFStoreCommandStack) commandStack;
			emfStoreCommandStack.addCommandStackObserver(this);
		} else {
			throw new IllegalStateException("Setup of ResourceSet is invalid, there is no EMFStoreCommandStack!");
		}

		removedElements = new ArrayList<EObject>();
		converter = new NotificationToOperationConverter(rootEObject);
		// explicitly disable checks for cross-references
		checkForIncomingCrossReferences = false;
		cutOffIncomingCrossReferences = false;

		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.emfstore.client.recording.options");
		if (elements != null && elements.length > 0) {
			checkForIncomingCrossReferences = Boolean.parseBoolean(elements[0]
				.getAttribute("checkForIncomingCrossReferences"));
			cutOffIncomingCrossReferences = Boolean.parseBoolean(elements[0]
				.getAttribute("cutOffIncomingCrossReferences"));
		}

		emitOperationsWhenCommandCompleted = true;
	}

	public void clearOperations() {
		operations.clear();
	}

	// TODO: EM, remove method
	public EObjectChangeNotifier getChangeNotifier() {
		return changeNotifier;
	}

	public IdEObjectCollection getCollection() {
		return rootEObject;
	}

	/**
	 * @return the removedElements
	 */
	public List<EObject> getRemovedElements() {
		return removedElements;
	}

	private Set<EObject> getModelElementsFromClipboard() {
		Set<EObject> result = new HashSet<EObject>();
		if (editingDomain == null) {
			return result;
		}
		Collection<Object> clipboard = editingDomain.getClipboard();
		if (clipboard == null) {
			return result;
		}
		for (Object element : clipboard) {
			if (element instanceof EObject) {
				result.add((EObject) element);
			}
		}
		return result;
	}

	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		// if element was just pasted from clipboard then do nothing
		if (this.getModelElementsFromClipboard().contains(modelElement)) {
			return;
		}

		if (isRecording) {
			Set<EObject> allModelElements = new HashSet<EObject>();
			allModelElements.add(modelElement);
			allModelElements.addAll(ModelUtil.getAllContainedModelElements(modelElement, false));

			// collect in- and out-going cross-reference for containment tree of modelElement
			List<SettingWithReferencedElement> crossReferences = ModelUtil.collectOutgoingCrossReferences(rootEObject,
				allModelElements);

			List<SettingWithReferencedElement> ingoingCrossReferences = collectIngoingCrossReferences(rootEObject,
				allModelElements);
			crossReferences.addAll(ingoingCrossReferences);

			// TODO: check if all cross-references are cut on copy
			CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(modelElement, false);

			// collect recorded operations and add to create operation
			List<ReferenceOperation> recordedOperations = generateCrossReferenceOperations(crossReferences);

			createDeleteOperation.getSubOperations().addAll(recordedOperations);

			if (this.compositeOperation != null) {
				compositeOperation.getSubOperations().add(createDeleteOperation);
			} else {
				if (commandIsRunning && emitOperationsWhenCommandCompleted) {
					operations.add(createDeleteOperation);
				} else {
					operationRecorded(createDeleteOperation);
				}
			}
		}
	}

	public static List<SettingWithReferencedElement> collectIngoingCrossReferences(IdEObjectCollection collection,
		Set<EObject> allModelElements) {
		List<SettingWithReferencedElement> settings = new ArrayList<SettingWithReferencedElement>();
		for (EObject modelElement : allModelElements) {
			Collection<Setting> inverseReferences = WorkspaceManager.getInstance().findInverseCrossReferences(
				modelElement);

			for (Setting setting : inverseReferences) {
				if (!ModelUtil.shouldBeCollected(collection, allModelElements, setting.getEObject())) {
					continue;
				}
				EReference reference = (EReference) setting.getEStructuralFeature();
				EClassifier eType = reference.getEType();

				if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()
					|| (!(eType instanceof EClass))) {
					continue;
				}

				SettingWithReferencedElement settingWithReferencedElement = new SettingWithReferencedElement(setting,
					modelElement);
				settings.add(settingWithReferencedElement);
			}
		}

		return settings;
	}

	private List<ReferenceOperation> generateCrossReferenceOperations(
		Collection<SettingWithReferencedElement> crossReferences) {
		List<ReferenceOperation> result = new ArrayList<ReferenceOperation>();

		for (SettingWithReferencedElement setting : crossReferences) {
			EObject referencedElement = setting.getReferencedElement();

			// fetch ID of referenced element
			ModelElementId newModelElementId = rootEObject.getModelElementId(referencedElement);
			if (newModelElementId == null) {
				newModelElementId = rootEObject.getDeletedModelElementId(referencedElement);
			}

			EObject eObject = setting.getSetting().getEObject();
			EReference reference = (EReference) setting.getSetting().getEStructuralFeature();

			if (setting.getSetting().getEStructuralFeature().isMany()) {
				int position = ((List<EObject>) eObject.eGet(reference)).indexOf(referencedElement);
				MultiReferenceOperation multiRefOp = NotificationToOperationConverter.createMultiReferenceOperation(
					rootEObject, eObject, reference, Arrays.asList(referencedElement), true, position);
				result.add(multiRefOp);
			} else {
				SingleReferenceOperation singleRefOp = NotificationToOperationConverter.createSingleReferenceOperation(
					rootEObject, null, newModelElementId, reference, eObject);
				result.add(singleRefOp);
			}
		}

		return result;
	}

	private void operationsRecorded(List<? extends AbstractOperation> operations) {
		for (OperationRecorderListener listener : operationRecordedListeners) {
			listener.operationsRecorded(operations);
		}
	}

	public void addOperationRecorderListener(OperationRecorderListener listener) {
		operationRecordedListeners.add(listener);
	}

	public void removeOperationRecorderListener(OperationRecorderListener listener) {
		operationRecordedListeners.remove(listener);
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		if (notificationRecorder == null) {
			notificationRecorder = new NotificationRecorder();
		}
		isRecording = true;
	}

	/**
	 * 
	 * 
	 * @param notificationDisabled
	 *            the notificationDisabled to set
	 */
	public void disableNotifications(boolean notificationDisabled) {
		if (this.changeNotifier != null) {
			this.changeNotifier.disableNotifications(notificationDisabled);
		}
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.isRecording = false;
	}

	private List<AbstractOperation> recordingFinished() {

		// create operations from "valid" notifications, log invalid ones,
		// accumulate the ops
		List<AbstractOperation> ops = new LinkedList<AbstractOperation>();
		List<NotificationInfo> rec = notificationRecorder.getRecording().asMutableList();
		for (NotificationInfo n : rec) {
			if (!n.isValid()) {
				WorkspaceUtil.log("INVALID NOTIFICATION MESSAGE DETECTED: " + n.getValidationMessage(), null, 0);
				continue;
			} else {
				AbstractOperation op = converter.convert(n);
				if (op != null) {
					ops.add(op);
				} else {
					// we should never get here, this would indicate a
					// consistency error,
					// n.isValid() should have been false
					WorkspaceUtil.log("INVALID NOTIFICATION CLASSIFICATION,"
						+ " notification is valid, but cannot be converted to an operation: " + n.toString(), null, 0);
					continue;
				}
			}
		}

		return ops;
	}

	/**
	 * Returns the notification recorder of the project space.
	 * 
	 * @return the notification recorder
	 */
	public NotificationRecorder getNotificationRecorder() {
		return notificationRecorder;
	}

	/**
	 * Create a CreateDeleteOperation.
	 * 
	 * @param modelElement
	 *            the model element to delete or create
	 * @param delete
	 *            whether the element is deleted or created
	 * @return the operation
	 */
	private CreateDeleteOperation createCreateDeleteOperation(EObject modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		EObject element = modelElement;

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(element, false);
		allContainedModelElements.add(element);

		Copier copier = new Copier(true, false);
		EObject copiedElement = copier.copy(element);
		copier.copyReferences();

		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);

			if (ModelUtil.isIgnoredDatatype(child)) {
				continue;
			}

			EObject copiedChild = copiedAllContainedModelElements.get(i);
			ModelElementId childId = rootEObject.getModelElementId(child);

			((CreateDeleteOperationImpl) createDeleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		createDeleteOperation.setModelElement(copiedElement);
		createDeleteOperation.setModelElementId(rootEObject.getModelElementId(modelElement));

		createDeleteOperation.setClientDate(new Date());
		return createDeleteOperation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementRemoved(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.emfstore.common.model.ModelElement)
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		if (isRecording) {
			removedElements.add(modelElement);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandCompleted(org.eclipse.emf.common.command.Command)
	 */
	public void commandCompleted(Command command) {

		// means that we have not seen a command start yet
		// if (currentClipboard == null) {
		// return;
		// }

		List<EObject> deletedElements = new ArrayList<EObject>();
		for (int i = removedElements.size() - 1; i >= 0; i--) {
			EObject removedElement = removedElements.get(i);
			if (!rootEObject.containsInstance(removedElement)) {
				if (!deletedElements.contains(removedElement)) {
					deletedElements.add(0, removedElement);
				}
			}
		}

		Set<EObject> newElementsOnClipboardAfterCommand = getModelElementsFromClipboard();
		// newElementsOnClipboardAfterCommand.removeAll(currentClipboard);

		// handle deleted elements => cut command
		for (EObject deletedElement : deletedElements) {
			if (newElementsOnClipboardAfterCommand.contains(deletedElement)) {
				// TODO: EM, where to put cut elements?
				// element was cut
				// projectSpace.getProject().getCutElements().add(deletedElement);
			} else {
				// element was deleted
				handleElementDelete(deletedElement);
				// cleanResources(deletedElement);
			}
		}

		operationsRecorded(operations);
		removedElements.clear();
		operations.clear();

		commandIsRunning = false;

		// remove all deleted elements
		newElementsOnClipboardAfterCommand.removeAll(deletedElements);
	}

	private void deleteOutgoingCrossReferencesOfContainmentTree(EObject modelElement) {
		deleteOutgoingCrossReferences(modelElement);
		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			deleteOutgoingCrossReferences(child);
		}
	}

	private void deleteOutgoingCrossReferences(EObject modelElement) {
		// delete all non containment cross references to other elments
		for (EReference reference : modelElement.eClass().getEAllReferences()) {
			EClassifier eType = reference.getEType();

			// if the reference is a containment map feature and its referenced entries do have at least one
			// non-containment reference (e.g. key or value)
			// then delete the map entries
			// instead of waiting for the referenced element to be cut of from the map entry
			// in the children recursion
			// since cutting of a key or value reference will render the map into an invalid state which can result in
			// unresolved proxies.
			if (Map.Entry.class.isAssignableFrom(eType.getInstanceClass()) && reference.isContainment()
				&& reference.isChangeable() && eType instanceof EClass) {
				EClass mapEntryEClass = (EClass) eType;
				if (hasOnlyContainmentReferences(mapEntryEClass)) {
					modelElement.eUnset(reference);
					continue;
				}
				@SuppressWarnings("unchecked")
				List<EObject> mapEntriesEList = (List<EObject>) modelElement.eGet(reference);
				// copy list before clearing reference
				// TODO is this really the underlying list
				List<EObject> mapEntries = new ArrayList<EObject>(mapEntriesEList);
				Resource resource = this.editingDomain.getResourceSet().createResource(URI.createURI("AAA"));
				resource.getContents().add(modelElement);
				EcoreUtil.resolveAll(modelElement);
				modelElement.eUnset(reference);
				for (EObject mapEntry : mapEntries) {
					handleElementDelete(mapEntry);
				}
				continue;
			}

			if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()) {
				continue;
			}

			if (eType instanceof EClass) {
				modelElement.eUnset(reference);
			}
		}
	}

	private boolean hasOnlyContainmentReferences(EClass mapEntryEClass) {
		for (EReference mapEntryReference : mapEntryEClass.getEAllReferences()) {
			if (!mapEntryReference.isContainment()) {
				return false;
			}
		}
		return true;
	}

	private void handleElementDelete(EObject deletedElement) {
		deleteOutgoingCrossReferencesOfContainmentTree(deletedElement);

		if (!CommonUtil.isSelfContained(deletedElement, true)) {
			throw new IllegalStateException(
				"Element was removed from containment of project but still has cross references!: "
					+ rootEObject.getDeletedModelElementId(deletedElement).getId());
			// TODO: EM, remove project cast, if possible
		} else if (checkForIncomingCrossReferences) {

			// delete incoming cross references
			Collection<Setting> inverseReferences = WorkspaceManager.getInstance().findInverseCrossReferences(
				deletedElement);
			ModelUtil.deleteIncomingCrossReferencesFromParent(inverseReferences, deletedElement);

			// ModelUtil.handleIncomingCrossReferences(deletedElement, (Project) rootEObject,
			// cutOffIncomingCrossReferences);
		}

		if (!isRecording) {
			return;
		}

		CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		deleteOperation.setClientDate(new Date());

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(deletedElement, false);
		allContainedModelElements.add(deletedElement);
		EObject copiedElement = EcoreUtil.copy(deletedElement);
		deleteOperation.setModelElement(copiedElement);
		deleteOperation.setModelElementId(rootEObject.getDeletedModelElementId(deletedElement));
		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);
			EObject copiedChild = copiedAllContainedModelElements.get(i);
			ModelElementId childId = rootEObject.getDeletedModelElementId(child);
			((CreateDeleteOperationImpl) deleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		deleteOperation.setDelete(true);

		List<CompositeOperation> compositeOperationsToDelete = new ArrayList<CompositeOperation>();
		deleteOperation.getSubOperations().addAll(
			extractReferenceOperationsForDelete(deletedElement, compositeOperationsToDelete));
		operations.removeAll(compositeOperationsToDelete);

		if (this.compositeOperation != null) {
			this.compositeOperation.getSubOperations().add(deleteOperation);
			// TODO: EM, save resource
			// projectSpace.saveResource(compositeOperation.eResource());
			try {
				compositeOperation.eResource().save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (commandIsRunning) {
				operations.add(deleteOperation);
			} else {
				operationRecorded(deleteOperation);
			}
		}

		// remove deleted model element and children from resource
		// ModelUtil.removeModelElementAndChildrenFromResource(deletedElement);
	}

	@SuppressWarnings("unchecked")
	private List<ReferenceOperation> extractReferenceOperationsForDelete(EObject deletedElement,
		List<CompositeOperation> compositeOperationsToDelete) {
		Set<ModelElementId> allDeletedElementsIds = new HashSet<ModelElementId>();
		for (EObject child : ModelUtil.getAllContainedModelElements(deletedElement, false)) {
			ModelElementId childId = rootEObject.getDeletedModelElementId(child);
			allDeletedElementsIds.add(childId);
		}
		allDeletedElementsIds.add(rootEObject.getDeletedModelElementId(deletedElement));

		List<ReferenceOperation> referenceOperationsForDelete = new ArrayList<ReferenceOperation>();
		// if (currentOperationListSize >= operations.size()) {
		// return referenceOperationsForDelete;
		// }
		List<AbstractOperation> newOperations = operations.subList(0, operations.size());

		List<AbstractOperation> l = new ArrayList<AbstractOperation>();

		for (int i = newOperations.size() - 1; i >= 0; i--) {
			AbstractOperation operation = newOperations.get(i);
			if (belongsToDelete(operation, allDeletedElementsIds)) {
				referenceOperationsForDelete.add(0, (ReferenceOperation) operation);
				l.add(operation);
				continue;
			}
			if (operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() != null) {
				CompositeOperation compositeOperation = (CompositeOperation) operation;
				boolean doesNotBelongToDelete = false;
				for (AbstractOperation subOperation : compositeOperation.getSubOperations()) {
					if (!belongsToDelete(subOperation, allDeletedElementsIds)) {
						doesNotBelongToDelete = true;
						break;
					}
				}
				if (!doesNotBelongToDelete) {
					referenceOperationsForDelete.addAll(0,
						(Collection<? extends ReferenceOperation>) compositeOperation.getSubOperations());
					compositeOperationsToDelete.add(compositeOperation);
				}
				continue;
			}
			break;
		}

		operations.removeAll(l);

		return referenceOperationsForDelete;
	}

	private boolean belongsToDelete(AbstractOperation operation, Set<ModelElementId> allDeletedElementsIds) {
		if (operation instanceof ReferenceOperation) {
			ReferenceOperation referenceOperation = (ReferenceOperation) operation;
			Set<ModelElementId> allInvolvedModelElements = referenceOperation.getAllInvolvedModelElements();
			if (allInvolvedModelElements.removeAll(allDeletedElementsIds)) {
				return isDestructorReferenceOperation(referenceOperation);
			}
		}
		return false;
	}

	private boolean isDestructorReferenceOperation(ReferenceOperation referenceOperation) {
		if (referenceOperation instanceof MultiReferenceOperation) {
			MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) referenceOperation;
			return !multiReferenceOperation.isAdd();
		} else if (referenceOperation instanceof SingleReferenceOperation) {
			SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) referenceOperation;
			return singleReferenceOperation.getOldValue() != null && singleReferenceOperation.getNewValue() == null;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandFailed(org.eclipse.emf.common.command.Command,
	 *      org.eclipse.core.runtime.OperationCanceledException)
	 */
	public void commandFailed(Command command, Exception exception) {

		// this is a backup in order to remove obsolete operations. In most
		// (all?) cases though, the rollback of the
		// transaction does this.

		if (compositeOperation != null) {
			for (int i = compositeOperation.getSubOperations().size() - 1; i >= currentOperationListSize; i--) {
				compositeOperation.getSubOperations().remove(i);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandStarted(org.eclipse.emf.common.command.Command)
	 */
	public void commandStarted(Command command) {
		// if (compositeOperation == null) {
		currentOperationListSize = 0;
		// } else {
		// currentOperationListSize = compositeOperation.getSubOperations()
		// .size();
		// }
		currentClipboard = getModelElementsFromClipboard();
		commandIsRunning = true;
	}

	public CompositeOperation getCompositeOperation() {
		return compositeOperation;
	}

	public CompositeOperationHandle beginCompositeOperation() {

		if (compositeOperation != null) {
			throw new IllegalStateException("Can only have one composite at once!");
		}

		compositeOperation = OperationsFactory.eINSTANCE.createCompositeOperation();
		CompositeOperationHandle handle = new CompositeOperationHandle(this, compositeOperation);
		notificationRecorder.newRecording();

		operations.add(compositeOperation);
		// currentOperationListSize++;

		return handle;
	}

	/**
	 * Replace and complete the current composite operation.
	 * 
	 * @param semanticCompositeOperation
	 *            the semantic operation that replaces the composite operation
	 */
	public void endCompositeOperation(SemanticCompositeOperation semanticCompositeOperation) {
		// operations.remove(operations.size() - 1);
		// operations.add(semanticCompositeOperation);
		compositeOperation = semanticCompositeOperation;
		endCompositeOperation();
	}

	/**
	 * Complete the current composite operation.
	 */
	// TODO: EM, remove method
	public void endCompositeOperation() {
		// operationRecorded(compositeOperation);
		// projectSpace.notifyOperationExecuted(compositeOperation);
		// if (commandIsRunning) {
		// operations.add(compositeOperation);
		// } else {
		// operationRecorded(compositeOperation);
		// }
		// operations.remove(compositeOperation);
		this.compositeOperation = null;
	}

	/**
	 * Aborts the current composite operation.
	 */
	public void abortCompositeOperation() {
		if (operations.size() > 0) {
			AbstractOperation lastOp = operations.get(operations.size() - 1);

			stopChangeRecording();
			try {
				lastOp.reverse().apply(getCollection());
				operations.remove(operations.size() - 1);
			} finally {
				startChangeRecording();
			}
			this.removedElements.clear();
		}
		notificationRecorder.stopRecording();

		compositeOperation = null;
		currentOperationListSize = operations.size();
		removedElements.clear();
	}

	// TODO: EM, update dirty state
	// updateDirtyState();

	public void notify(Notification notification, IdEObjectCollection collection, EObject modelElement) {

		// filter unwanted notifications
		if (FilterStack.DEFAULT.check(new NotificationInfo(notification))) {
			return;
		}

		// save(modelElement);
		if (isRecording) {
			notificationRecorder.record(notification);
		}
		if (notificationRecorder.isRecordingComplete()) {
			if (isRecording) {
				List<AbstractOperation> ops = recordingFinished();

				// add resulting operations as suboperations to composite or
				// top-level
				// operations
				if (compositeOperation != null) {
					compositeOperation.getSubOperations().addAll(ops);
					// FIXME: ugly hack for recording of create operation cross
					// references
					if (compositeOperation.eResource() != null) {
						try {
							compositeOperation.eResource().save(Configuration.getResourceSaveOptions());
						} catch (IOException e) {
							// TODO: EM, handle exception
							e.printStackTrace();
						}
					}
				} else {
					if (ops.size() > 1) {
						CompositeOperation op = OperationsFactory.eINSTANCE.createCompositeOperation();
						op.getSubOperations().addAll(ops);
						// set the last operation as the main one for natural
						// composites
						op.setMainOperation(ops.get(ops.size() - 1));
						op.setModelElementId((ModelElementId) EcoreUtil.copy(op.getMainOperation().getModelElementId()));
						if (commandIsRunning && emitOperationsWhenCommandCompleted) {
							operations.add(op);
						} else {
							operationRecorded(op);
						}
					} else if (ops.size() == 1) {
						if (commandIsRunning && emitOperationsWhenCommandCompleted) {
							operations.add(ops.get(0));
						} else {
							operationRecorded(ops.get(0));
						}
					}
				}

			}
			// if (!commandIsRunning) {
			// saveDirtyResources();
			// }
		}
	}

	private void operationRecorded(AbstractOperation op) {
		operationsRecorded(Arrays.asList(op));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {
		// do nothing
	}

	public void setEmitOperationsWhenCommandCompleted(boolean emitOperationsImmediately) {
		this.emitOperationsWhenCommandCompleted = emitOperationsImmediately;
	}

}
