/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Role Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getRoleId <em>Role Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRemoveRoleOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface RemoveRoleOperation extends OrgUnitOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Id</em>' attribute.
	 * @see #setRoleId(String)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRemoveRoleOperation_RoleId()
	 * @model required="true"
	 * @generated
	 */
	String getRoleId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getRoleId <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Id</em>' attribute.
	 * @see #getRoleId()
	 * @generated
	 */
	void setRoleId(String value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' attribute.
	 * @see #setProjectId(String)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRemoveRoleOperation_ProjectId()
	 * @model
	 * @generated
	 */
	String getProjectId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(String value);

} // RemoveRoleOperation
