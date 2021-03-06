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
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Org Unit Role Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitRoleOperationImpl#getRoleId <em>Role Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitRoleOperationImpl#isAssign <em>Assign</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitRoleOperationImpl#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrgUnitRoleOperationImpl extends OrgUnitOperationImpl<Void> implements OrgUnitRoleOperation {
	/**
	 * The default value of the '{@link #getRoleId() <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleId()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoleId() <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleId()
	 * @generated
	 * @ordered
	 */
	protected String roleId = ROLE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isAssign() <em>Assign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssign()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASSIGN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAssign() <em>Assign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssign()
	 * @generated
	 * @ordered
	 */
	protected boolean assign = ASSIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected String projectId = PROJECT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgUnitRoleOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.ORG_UNIT_ROLE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleId(String newRoleId) {
		String oldRoleId = roleId;
		roleId = newRoleId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ORG_UNIT_ROLE_OPERATION__ROLE_ID, oldRoleId, roleId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssign() {
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssign(boolean newAssign) {
		boolean oldAssign = assign;
		assign = newAssign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ORG_UNIT_ROLE_OPERATION__ASSIGN, oldAssign, assign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(String newProjectId) {
		String oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ORG_UNIT_ROLE_OPERATION__PROJECT_ID, oldProjectId, projectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ROLE_ID:
				return getRoleId();
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ASSIGN:
				return isAssign();
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__PROJECT_ID:
				return getProjectId();
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
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ROLE_ID:
				setRoleId((String)newValue);
				return;
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ASSIGN:
				setAssign((Boolean)newValue);
				return;
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__PROJECT_ID:
				setProjectId((String)newValue);
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
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ROLE_ID:
				setRoleId(ROLE_ID_EDEFAULT);
				return;
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ASSIGN:
				setAssign(ASSIGN_EDEFAULT);
				return;
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__PROJECT_ID:
				setProjectId(PROJECT_ID_EDEFAULT);
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
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ROLE_ID:
				return ROLE_ID_EDEFAULT == null ? roleId != null : !ROLE_ID_EDEFAULT.equals(roleId);
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__ASSIGN:
				return assign != ASSIGN_EDEFAULT;
			case OperationPackage.ORG_UNIT_ROLE_OPERATION__PROJECT_ID:
				return PROJECT_ID_EDEFAULT == null ? projectId != null : !PROJECT_ID_EDEFAULT.equals(projectId);
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
		result.append(" (roleId: ");
		result.append(roleId);
		result.append(", assign: ");
		result.append(assign);
		result.append(", projectId: ");
		result.append(projectId);
		result.append(')');
		return result.toString();
	}

} //OrgUnitRoleOperationImpl
