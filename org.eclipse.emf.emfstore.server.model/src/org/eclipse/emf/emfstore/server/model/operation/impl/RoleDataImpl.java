/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.RoleData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleDataImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleDataImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleDataImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleDataImpl#getPermissionTypeIds <em>Permission Type Ids</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.RoleDataImpl#isSystemRole <em>System Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleDataImpl extends EObjectImpl implements RoleData {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPermissionTypeIds() <em>Permission Type Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissionTypeIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> permissionTypeIds;

	/**
	 * The default value of the '{@link #isSystemRole() <em>System Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSystemRole()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYSTEM_ROLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSystemRole() <em>System Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSystemRole()
	 * @generated
	 * @ordered
	 */
	protected boolean systemRole = SYSTEM_ROLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.ROLE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_DATA__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_DATA__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_DATA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPermissionTypeIds() {
		if (permissionTypeIds == null) {
			permissionTypeIds = new EDataTypeUniqueEList<String>(String.class, this, OperationPackage.ROLE_DATA__PERMISSION_TYPE_IDS);
		}
		return permissionTypeIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSystemRole() {
		return systemRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemRole(boolean newSystemRole) {
		boolean oldSystemRole = systemRole;
		systemRole = newSystemRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ROLE_DATA__SYSTEM_ROLE, oldSystemRole, systemRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.ROLE_DATA__DESCRIPTION:
				return getDescription();
			case OperationPackage.ROLE_DATA__ID:
				return getId();
			case OperationPackage.ROLE_DATA__NAME:
				return getName();
			case OperationPackage.ROLE_DATA__PERMISSION_TYPE_IDS:
				return getPermissionTypeIds();
			case OperationPackage.ROLE_DATA__SYSTEM_ROLE:
				return isSystemRole();
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
			case OperationPackage.ROLE_DATA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OperationPackage.ROLE_DATA__ID:
				setId((String)newValue);
				return;
			case OperationPackage.ROLE_DATA__NAME:
				setName((String)newValue);
				return;
			case OperationPackage.ROLE_DATA__PERMISSION_TYPE_IDS:
				getPermissionTypeIds().clear();
				getPermissionTypeIds().addAll((Collection<? extends String>)newValue);
				return;
			case OperationPackage.ROLE_DATA__SYSTEM_ROLE:
				setSystemRole((Boolean)newValue);
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
			case OperationPackage.ROLE_DATA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OperationPackage.ROLE_DATA__ID:
				setId(ID_EDEFAULT);
				return;
			case OperationPackage.ROLE_DATA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OperationPackage.ROLE_DATA__PERMISSION_TYPE_IDS:
				getPermissionTypeIds().clear();
				return;
			case OperationPackage.ROLE_DATA__SYSTEM_ROLE:
				setSystemRole(SYSTEM_ROLE_EDEFAULT);
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
			case OperationPackage.ROLE_DATA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OperationPackage.ROLE_DATA__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case OperationPackage.ROLE_DATA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OperationPackage.ROLE_DATA__PERMISSION_TYPE_IDS:
				return permissionTypeIds != null && !permissionTypeIds.isEmpty();
			case OperationPackage.ROLE_DATA__SYSTEM_ROLE:
				return systemRole != SYSTEM_ROLE_EDEFAULT;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", permissionTypeIds: ");
		result.append(permissionTypeIds);
		result.append(", systemRole: ");
		result.append(systemRole);
		result.append(')');
		return result.toString();
	}

} //RoleDataImpl
