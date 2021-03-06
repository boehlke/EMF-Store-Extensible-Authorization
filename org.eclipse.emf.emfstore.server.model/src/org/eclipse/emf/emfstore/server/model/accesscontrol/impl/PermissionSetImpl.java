/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl#getPermissionTypes <em>Permission Types</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl#getSuperUserRole <em>Super User Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionSetImpl extends EObjectImpl implements PermissionSet {
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
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ACGroup> groups;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<ACUser> users;

	/**
	 * The cached value of the '{@link #getSuperUserRole() <em>Super User Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperUserRole()
	 * @generated
	 * @ordered
	 */
	protected Role superUserRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PermissionSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.PERMISSION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PermissionType> getPermissionTypes() {
		if (permissionTypes == null) {
			permissionTypes = new EObjectContainmentEList.Resolving<PermissionType>(PermissionType.class, this, AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES);
		}
		return permissionTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList.Resolving<Role>(Role.class, this, AccesscontrolPackage.PERMISSION_SET__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ACGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList.Resolving<ACGroup>(ACGroup.class, this, AccesscontrolPackage.PERMISSION_SET__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ACUser> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList.Resolving<ACUser>(ACUser.class, this, AccesscontrolPackage.PERMISSION_SET__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getSuperUserRole() {
		if (superUserRole != null && superUserRole.eIsProxy()) {
			InternalEObject oldSuperUserRole = (InternalEObject)superUserRole;
			superUserRole = (Role)eResolveProxy(oldSuperUserRole);
			if (superUserRole != oldSuperUserRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE, oldSuperUserRole, superUserRole));
			}
		}
		return superUserRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetSuperUserRole() {
		return superUserRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperUserRole(Role newSuperUserRole) {
		Role oldSuperUserRole = superUserRole;
		superUserRole = newSuperUserRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE, oldSuperUserRole, superUserRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES:
				return ((InternalEList<?>)getPermissionTypes()).basicRemove(otherEnd, msgs);
			case AccesscontrolPackage.PERMISSION_SET__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case AccesscontrolPackage.PERMISSION_SET__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
			case AccesscontrolPackage.PERMISSION_SET__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
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
			case AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES:
				return getPermissionTypes();
			case AccesscontrolPackage.PERMISSION_SET__ROLES:
				return getRoles();
			case AccesscontrolPackage.PERMISSION_SET__GROUPS:
				return getGroups();
			case AccesscontrolPackage.PERMISSION_SET__USERS:
				return getUsers();
			case AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE:
				if (resolve) return getSuperUserRole();
				return basicGetSuperUserRole();
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
			case AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES:
				getPermissionTypes().clear();
				getPermissionTypes().addAll((Collection<? extends PermissionType>)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_SET__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_SET__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends ACGroup>)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_SET__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends ACUser>)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE:
				setSuperUserRole((Role)newValue);
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
			case AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES:
				getPermissionTypes().clear();
				return;
			case AccesscontrolPackage.PERMISSION_SET__ROLES:
				getRoles().clear();
				return;
			case AccesscontrolPackage.PERMISSION_SET__GROUPS:
				getGroups().clear();
				return;
			case AccesscontrolPackage.PERMISSION_SET__USERS:
				getUsers().clear();
				return;
			case AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE:
				setSuperUserRole((Role)null);
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
			case AccesscontrolPackage.PERMISSION_SET__PERMISSION_TYPES:
				return permissionTypes != null && !permissionTypes.isEmpty();
			case AccesscontrolPackage.PERMISSION_SET__ROLES:
				return roles != null && !roles.isEmpty();
			case AccesscontrolPackage.PERMISSION_SET__GROUPS:
				return groups != null && !groups.isEmpty();
			case AccesscontrolPackage.PERMISSION_SET__USERS:
				return users != null && !users.isEmpty();
			case AccesscontrolPackage.PERMISSION_SET__SUPER_USER_ROLE:
				return superUserRole != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getOrgUnit(java.lang.String)
	 * @generated NOT
	 */
	public ACOrgUnit getOrgUnit(String name) {
		for (ACUser user : getUsers()) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		for (ACGroup group : getGroups()) {
			if (group.getName().equals(name)) {
				return group;
			}
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getRole(java.lang.String)
	 * @generated NOT
	 */
	public Role getRole(String roleId) {
		for (Role role : getRoles()) {
			if (role.getIdentifier().equals(roleId)) {
				return role;
			}
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getProjectRoles()
	 * @generated NOT
	 */
	public Collection<Role> getProjectRoles() {
		List<Role> projectRoles = new ArrayList<Role>();

		ROLES: for (Role role : getRoles()) {
			if (role.isSystemRole()) {
				continue;
			}
			for (PermissionType type : role.getPermissionTypes()) {
				if (type.isProjectPermission()) {
					projectRoles.add(role);
					continue ROLES;
				}
			}
		}

		return Collections.unmodifiableList(projectRoles);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getPermissionType(java.lang.String)
	 * @generated NOT
	 */
	public PermissionType getPermissionType(String id) {
		for (PermissionType type : getPermissionTypes()) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getOrgUnit(org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId)
	 */
	public ACOrgUnit getOrgUnit(ACOrgUnitId id) {
		for (ACOrgUnit orgUnit : getUsers()) {
			if (orgUnit.getId().equals(id)) {
				return orgUnit;
			}
		}
		for (ACOrgUnit orgUnit : getGroups()) {
			if (orgUnit.getId().equals(id)) {
				return orgUnit;
			}
		}
		return null;
	}
} // PermissionSetImpl
