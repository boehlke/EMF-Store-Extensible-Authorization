/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;



/**
 * <!-- begin-user-doc -->
 * Creates or updates a role and returns the role id
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateOrUpdateRoleOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface CreateOrUpdateRoleOperation extends UserManagementOperation<String> {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference.
	 * @see #setRole(RoleContainer)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateOrUpdateRoleOperation_Role()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	RoleContainer getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation#getRole <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' containment reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(RoleContainer value);

} // CreateOrUpdateRoleOperation
