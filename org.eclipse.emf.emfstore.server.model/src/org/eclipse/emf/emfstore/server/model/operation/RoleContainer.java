/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.RoleContainer#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.RoleContainer#getPermissionTypes <em>Permission Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRoleContainer()
 * @model
 * @generated
 */
public interface RoleContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference.
	 * @see #setRole(Role)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRoleContainer_Role()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.RoleContainer#getRole <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' containment reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(Role value);

	/**
	 * Returns the value of the '<em><b>Permission Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission Types</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRoleContainer_PermissionTypes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PermissionType> getPermissionTypes();

} // RoleContainer
