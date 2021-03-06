/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getPermissionTypes <em>Permission Types</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getSuperUserRole <em>Super User Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet()
 * @model
 * @generated
 */
public interface PermissionSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Permission Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission Types</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission Types</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet_PermissionTypes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PermissionType> getPermissionTypes();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet_Roles()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet_Groups()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ACGroup> getGroups();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet_Users()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ACUser> getUsers();

	/**
	 * Returns the value of the '<em><b>Super User Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super User Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super User Role</em>' reference.
	 * @see #setSuperUserRole(Role)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionSet_SuperUserRole()
	 * @model
	 * @generated
	 */
	Role getSuperUserRole();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getSuperUserRole <em>Super User Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super User Role</em>' reference.
	 * @see #getSuperUserRole()
	 * @generated
	 */
	void setSuperUserRole(Role value);

	/**
	 * get an org unit by name
	 * 
	 * @param name of the org unit
	 * @return
	 * @generated NOT
	 */
	ACOrgUnit getOrgUnit(String name);

	/**
	 * get an org unit by id
	 * 
	 * @param id
	 * @return
	 * @generated NOT
	 */
	ACOrgUnit getOrgUnit(ACOrgUnitId id);

	/**
	 * get a role by name
	 * 
	 * @param roleName
	 * @return
	 * @generated NOT
	 */
	Role getRole(String roleName);

	/**
	 * get project roles, project roles are roles which contain project permissions, so they can be assigned to projects
	 * 
	 * @return readonly collection of project roles
	 * @generated NOT
	 */
	Collection<Role> getProjectRoles();

	/**
	 * convenience method to get a specific permission type, might return null
	 * 
	 * @param string
	 * @return
	 * @generated NOT
	 */
	PermissionType getPermissionType(String id);
	
} // PermissionSet
