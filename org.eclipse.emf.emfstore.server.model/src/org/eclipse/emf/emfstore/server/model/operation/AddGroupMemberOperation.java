/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Group Member Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation#getMemberId <em>Member Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getAddGroupMemberOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface AddGroupMemberOperation extends OrgUnitOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Member Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Id</em>' attribute.
	 * @see #setMemberId(String)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getAddGroupMemberOperation_MemberId()
	 * @model required="true"
	 * @generated
	 */
	String getMemberId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation#getMemberId <em>Member Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Id</em>' attribute.
	 * @see #getMemberId()
	 * @generated
	 */
	void setMemberId(String value);

} // AddGroupMemberOperation
