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
package org.eclipse.emf.emfstore.server.model.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.server.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Server Space</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getGroups <em>Groups</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getProjects <em>Projects</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getOpenSessions <em>Open Sessions</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getUsers <em>Users</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getPermissionSet <em>Permission Set</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ServerSpaceImpl extends EObjectImpl implements ServerSpace {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectHistory> projects;

	/**
	 * The cached value of the '{@link #getOpenSessions() <em>Open Sessions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOpenSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<SessionId> openSessions;

	/**
	 * The cached value of the '{@link #getPermissionSet() <em>Permission Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPermissionSet()
	 * @generated
	 * @ordered
	 */
	protected PermissionSet permissionSet;

	private Resource resource;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServerSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SERVER_SPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ACGroup> getGroups() {
		return getPermissionSet().getGroups();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ProjectHistory> getProjects() {
		if (projects == null) {
			projects = new EObjectResolvingEList<ProjectHistory>(ProjectHistory.class, this,
				ModelPackage.SERVER_SPACE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SessionId> getOpenSessions() {
		if (openSessions == null) {
			openSessions = new EObjectContainmentEList.Resolving<SessionId>(SessionId.class, this,
				ModelPackage.SERVER_SPACE__OPEN_SESSIONS);
		}
		return openSessions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ACUser> getUsers() {
		return getPermissionSet().getUsers();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PermissionSet getPermissionSet() {
		if (permissionSet != null && permissionSet.eIsProxy()) {
			InternalEObject oldPermissionSet = (InternalEObject) permissionSet;
			permissionSet = (PermissionSet) eResolveProxy(oldPermissionSet);
			if (permissionSet != oldPermissionSet) {
				InternalEObject newPermissionSet = (InternalEObject) permissionSet;
				NotificationChain msgs = oldPermissionSet.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.SERVER_SPACE__PERMISSION_SET, null, null);
				if (newPermissionSet.eInternalContainer() == null) {
					msgs = newPermissionSet.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- ModelPackage.SERVER_SPACE__PERMISSION_SET, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						ModelPackage.SERVER_SPACE__PERMISSION_SET, oldPermissionSet, permissionSet));
			}
		}
		return permissionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PermissionSet basicGetPermissionSet() {
		return permissionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPermissionSet(PermissionSet newPermissionSet, NotificationChain msgs) {
		PermissionSet oldPermissionSet = permissionSet;
		permissionSet = newPermissionSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ModelPackage.SERVER_SPACE__PERMISSION_SET, oldPermissionSet, newPermissionSet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPermissionSet(PermissionSet newPermissionSet) {
		if (newPermissionSet != permissionSet) {
			NotificationChain msgs = null;
			if (permissionSet != null)
				msgs = ((InternalEObject) permissionSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.SERVER_SPACE__PERMISSION_SET, null, msgs);
			if (newPermissionSet != null)
				msgs = ((InternalEObject) newPermissionSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- ModelPackage.SERVER_SPACE__PERMISSION_SET, null, msgs);
			msgs = basicSetPermissionSet(newPermissionSet, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SERVER_SPACE__PERMISSION_SET,
				newPermissionSet, newPermissionSet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return ((InternalEList<?>) getOpenSessions()).basicRemove(otherEnd, msgs);
		case ModelPackage.SERVER_SPACE__PERMISSION_SET:
			return basicSetPermissionSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			return getGroups();
		case ModelPackage.SERVER_SPACE__PROJECTS:
			return getProjects();
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return getOpenSessions();
		case ModelPackage.SERVER_SPACE__USERS:
			return getUsers();
		case ModelPackage.SERVER_SPACE__PERMISSION_SET:
			if (resolve)
				return getPermissionSet();
			return basicGetPermissionSet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			getGroups().clear();
			getGroups().addAll((Collection<? extends ACGroup>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__PROJECTS:
			getProjects().clear();
			getProjects().addAll((Collection<? extends ProjectHistory>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			getOpenSessions().clear();
			getOpenSessions().addAll((Collection<? extends SessionId>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__USERS:
			getUsers().clear();
			getUsers().addAll((Collection<? extends ACUser>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__PERMISSION_SET:
			setPermissionSet((PermissionSet) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			getGroups().clear();
			return;
		case ModelPackage.SERVER_SPACE__PROJECTS:
			getProjects().clear();
			return;
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			getOpenSessions().clear();
			return;
		case ModelPackage.SERVER_SPACE__USERS:
			getUsers().clear();
			return;
		case ModelPackage.SERVER_SPACE__PERMISSION_SET:
			setPermissionSet((PermissionSet) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			return !getGroups().isEmpty();
		case ModelPackage.SERVER_SPACE__PROJECTS:
			return projects != null && !projects.isEmpty();
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return openSessions != null && !openSessions.isEmpty();
		case ModelPackage.SERVER_SPACE__USERS:
			return !getUsers().isEmpty();
		case ModelPackage.SERVER_SPACE__PERMISSION_SET:
			return permissionSet != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		this.resource.save(null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

} // ServerSpaceImpl
