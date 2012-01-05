/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Org Unit Role Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#getRoleId <em>Role Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#isAssign <em>Assign</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitRoleOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface OrgUnitRoleOperation extends OrgUnitOperation<Void> {
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
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitRoleOperation_RoleId()
	 * @model required="true"
	 * @generated
	 */
	String getRoleId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#getRoleId <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Id</em>' attribute.
	 * @see #getRoleId()
	 * @generated
	 */
	void setRoleId(String value);

	/**
	 * Returns the value of the '<em><b>Assign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign</em>' attribute.
	 * @see #setAssign(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitRoleOperation_Assign()
	 * @model required="true"
	 * @generated
	 */
	boolean isAssign();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#isAssign <em>Assign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assign</em>' attribute.
	 * @see #isAssign()
	 * @generated
	 */
	void setAssign(boolean value);

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
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitRoleOperation_ProjectId()
	 * @model
	 * @generated
	 */
	String getProjectId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(String value);

} // OrgUnitRoleOperation
