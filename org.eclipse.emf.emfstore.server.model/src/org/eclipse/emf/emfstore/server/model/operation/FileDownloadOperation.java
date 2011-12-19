/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Download Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation#getFileInformation <em>File Information</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getFileDownloadOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.ProjectOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface FileDownloadOperation extends ProjectOperation<Void> {
	/**
	 * Returns the value of the '<em><b>File Information</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Information</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Information</em>' attribute.
	 * @see #setFileInformation(FileTransferInformation)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getFileDownloadOperation_FileInformation()
	 * @model dataType="org.eclipse.emf.emfstore.server.model.operation.FileTransferInformation" required="true"
	 * @generated
	 */
	FileTransferInformation getFileInformation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation#getFileInformation <em>File Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Information</em>' attribute.
	 * @see #getFileInformation()
	 * @generated
	 */
	void setFileInformation(FileTransferInformation value);

} // FileDownloadOperation
