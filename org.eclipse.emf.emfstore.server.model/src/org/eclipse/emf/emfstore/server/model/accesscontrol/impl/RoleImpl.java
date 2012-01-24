/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl#getPermissionTypes <em>Permission Types</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl#isSystemRole <em>System Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleImpl extends IdentifiableElementImpl implements Role {
	/**
	 * The cached value of the '{@link #getPermissionTypes() <em>Permission Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissionTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PermissionType> permissionTypes;

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
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PermissionType> getPermissionTypes() {
		if (permissionTypes == null) {
			permissionTypes = new EObjectWithInverseResolvingEList.ManyInverse<PermissionType>(PermissionType.class, this, AccesscontrolPackage.ROLE__PERMISSION_TYPES, AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES);
		}
		return permissionTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ROLE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ROLE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.ROLE__SYSTEM_ROLE, oldSystemRole, systemRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPermissionTypes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
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
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
				return getPermissionTypes();
			case AccesscontrolPackage.ROLE__DESCRIPTION:
				return getDescription();
			case AccesscontrolPackage.ROLE__NAME:
				return getName();
			case AccesscontrolPackage.ROLE__SYSTEM_ROLE:
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
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
				getPermissionTypes().clear();
				getPermissionTypes().addAll((Collection<? extends PermissionType>)newValue);
				return;
			case AccesscontrolPackage.ROLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AccesscontrolPackage.ROLE__NAME:
				setName((String)newValue);
				return;
			case AccesscontrolPackage.ROLE__SYSTEM_ROLE:
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
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
				getPermissionTypes().clear();
				return;
			case AccesscontrolPackage.ROLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AccesscontrolPackage.ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AccesscontrolPackage.ROLE__SYSTEM_ROLE:
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
			case AccesscontrolPackage.ROLE__PERMISSION_TYPES:
				return permissionTypes != null && !permissionTypes.isEmpty();
			case AccesscontrolPackage.ROLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AccesscontrolPackage.ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AccesscontrolPackage.ROLE__SYSTEM_ROLE:
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
		result.append(", name: ");
		result.append(name);
		result.append(", systemRole: ");
		result.append(systemRole);
		result.append(')');
		return result.toString();
	}

} // RoleImpl
