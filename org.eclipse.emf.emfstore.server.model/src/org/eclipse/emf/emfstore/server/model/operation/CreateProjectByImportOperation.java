/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.server.model.ProjectHistory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Project By Import Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation#getProjectHistory <em>Project History</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateProjectByImportOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.Operation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface CreateProjectByImportOperation extends Operation<Void> {
	/**
	 * Returns the value of the '<em><b>Project History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project History</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project History</em>' containment reference.
	 * @see #setProjectHistory(ProjectHistory)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateProjectByImportOperation_ProjectHistory()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ProjectHistory getProjectHistory();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation#getProjectHistory <em>Project History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project History</em>' containment reference.
	 * @see #getProjectHistory()
	 * @generated
	 */
	void setProjectHistory(ProjectHistory value);

} // CreateProjectByImportOperation
