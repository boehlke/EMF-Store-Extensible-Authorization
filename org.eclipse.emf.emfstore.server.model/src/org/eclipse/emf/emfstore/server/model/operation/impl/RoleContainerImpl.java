/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.RoleContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleContainerImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleContainerImpl#getPermissionTypes <em>Permission Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleContainerImpl extends EObjectImpl implements RoleContainer {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected Role role;

	/**
	 * The cached value of the '{@link #getPermissionTypes() <em>Permission Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissionTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PermissionType> permissionTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.ROLE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (Role)eResolveProxy(oldRole);
			if (role != oldRole) {
				InternalEObject newRole = (InternalEObject)role;
				NotificationChain msgs = oldRole.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ROLE_CONTAINER__ROLE, null, null);
				if (newRole.eInternalContainer() == null) {
					msgs = newRole.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ROLE_CONTAINER__ROLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.ROLE_CONTAINER__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRole(Role newRole, NotificationChain msgs) {
		Role oldRole = role;
		role = newRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_CONTAINER__ROLE, oldRole, newRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(Role newRole) {
		if (newRole != role) {
			NotificationChain msgs = null;
			if (role != null)
				msgs = ((InternalEObject)role).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ROLE_CONTAINER__ROLE, null, msgs);
			if (newRole != null)
				msgs = ((InternalEObject)newRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ROLE_CONTAINER__ROLE, null, msgs);
			msgs = basicSetRole(newRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_CONTAINER__ROLE, newRole, newRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PermissionType> getPermissionTypes() {
		if (permissionTypes == null) {
			permissionTypes = new EObjectContainmentEList.Resolving<PermissionType>(PermissionType.class, this, OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES);
		}
		return permissionTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.ROLE_CONTAINER__ROLE:
				return basicSetRole(null, msgs);
			case OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES:
				return ((InternalEList<?>)getPermissionTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.ROLE_CONTAINER__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES:
				return getPermissionTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationPackage.ROLE_CONTAINER__ROLE:
				setRole((Role)newValue);
				return;
			case OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES:
				getPermissionTypes().clear();
				getPermissionTypes().addAll((Collection<? extends PermissionType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationPackage.ROLE_CONTAINER__ROLE:
				setRole((Role)null);
				return;
			case OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES:
				getPermissionTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationPackage.ROLE_CONTAINER__ROLE:
				return role != null;
			case OperationPackage.ROLE_CONTAINER__PERMISSION_TYPES:
				return permissionTypes != null && !permissionTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleContainerImpl
