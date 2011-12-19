/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Project Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation#isDeleteFiles <em>Delete Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getDeleteProjectOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.ProjectOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface DeleteProjectOperation extends ProjectOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Delete Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Files</em>' attribute.
	 * @see #setDeleteFiles(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getDeleteProjectOperation_DeleteFiles()
	 * @model
	 * @generated
	 */
	boolean isDeleteFiles();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation#isDeleteFiles <em>Delete Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Files</em>' attribute.
	 * @see #isDeleteFiles()
	 * @generated
	 */
	void setDeleteFiles(boolean value);

} // DeleteProjectOperation
