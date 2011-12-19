/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.RoleData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Or Update Role Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrUpdateRoleOperationImpl#getRoleData <em>Role Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateOrUpdateRoleOperationImpl extends UserManagementOperationImpl<Void> implements CreateOrUpdateRoleOperation {
	/**
	 * The cached value of the '{@link #getRoleData() <em>Role Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleData()
	 * @generated
	 * @ordered
	 */
	protected RoleData roleData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateOrUpdateRoleOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.CREATE_OR_UPDATE_ROLE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleData getRoleData() {
		if (roleData != null && roleData.eIsProxy()) {
			InternalEObject oldRoleData = (InternalEObject)roleData;
			roleData = (RoleData)eResolveProxy(oldRoleData);
			if (roleData != oldRoleData) {
				InternalEObject newRoleData = (InternalEObject)roleData;
				NotificationChain msgs = oldRoleData.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, null, null);
				if (newRoleData.eInternalContainer() == null) {
					msgs = newRoleData.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, oldRoleData, roleData));
			}
		}
		return roleData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleData basicGetRoleData() {
		return roleData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleData(RoleData newRoleData, NotificationChain msgs) {
		RoleData oldRoleData = roleData;
		roleData = newRoleData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, oldRoleData, newRoleData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleData(RoleData newRoleData) {
		if (newRoleData != roleData) {
			NotificationChain msgs = null;
			if (roleData != null)
				msgs = ((InternalEObject)roleData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, null, msgs);
			if (newRoleData != null)
				msgs = ((InternalEObject)newRoleData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, null, msgs);
			msgs = basicSetRoleData(newRoleData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA, newRoleData, newRoleData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA:
				return basicSetRoleData(null, msgs);
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
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA:
				if (resolve) return getRoleData();
				return basicGetRoleData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA:
				setRoleData((RoleData)newValue);
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
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA:
				setRoleData((RoleData)null);
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
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION__ROLE_DATA:
				return roleData != null;
		}
		return super.eIsSet(featureID);
	}

} //CreateOrUpdateRoleOperationImpl
