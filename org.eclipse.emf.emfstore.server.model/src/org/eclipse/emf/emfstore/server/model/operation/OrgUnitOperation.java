/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Org Unit Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation#getOrgUnitId <em>Org Unit Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitOperation()
 * @model
 * @generated
 */
public interface OrgUnitOperation<T> extends UserManagementOperation<T> {
	/**
	 * Returns the value of the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Unit Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Org Unit Id</em>' attribute.
	 * @see #setOrgUnitId(String)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getOrgUnitOperation_OrgUnitId()
	 * @model required="true"
	 * @generated
	 */
	String getOrgUnitId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation#getOrgUnitId <em>Org Unit Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Org Unit Id</em>' attribute.
	 * @see #getOrgUnitId()
	 * @generated
	 */
	void setOrgUnitId(String value);

} // OrgUnitOperation
