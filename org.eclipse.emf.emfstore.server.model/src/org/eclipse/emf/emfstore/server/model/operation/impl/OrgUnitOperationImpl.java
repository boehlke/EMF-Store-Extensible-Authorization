/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Org Unit Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitOperationImpl#getOrgUnitId <em>Org Unit Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrgUnitOperationImpl<T> extends UserManagementOperationImpl<T> implements OrgUnitOperation<T> {
	/**
	 * The default value of the '{@link #getOrgUnitId() <em>Org Unit Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgUnitId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORG_UNIT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrgUnitId() <em>Org Unit Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgUnitId()
	 * @generated
	 * @ordered
	 */
	protected String orgUnitId = ORG_UNIT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgUnitOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.ORG_UNIT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrgUnitId() {
		return orgUnitId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrgUnitId(String newOrgUnitId) {
		String oldOrgUnitId = orgUnitId;
		orgUnitId = newOrgUnitId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ORG_UNIT_OPERATION__ORG_UNIT_ID, oldOrgUnitId, orgUnitId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.ORG_UNIT_OPERATION__ORG_UNIT_ID:
				return getOrgUnitId();
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
			case OperationPackage.ORG_UNIT_OPERATION__ORG_UNIT_ID:
				setOrgUnitId((String)newValue);
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
			case OperationPackage.ORG_UNIT_OPERATION__ORG_UNIT_ID:
				setOrgUnitId(ORG_UNIT_ID_EDEFAULT);
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
			case OperationPackage.ORG_UNIT_OPERATION__ORG_UNIT_ID:
				return ORG_UNIT_ID_EDEFAULT == null ? orgUnitId != null : !ORG_UNIT_ID_EDEFAULT.equals(orgUnitId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (orgUnitId: ");
		result.append(orgUnitId);
		result.append(')');
		return result.toString();
	}

} //OrgUnitOperationImpl
