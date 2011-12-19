/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Upload Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileUploadOperationImpl#getFileChunk <em>File Chunk</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileUploadOperationImpl extends ProjectOperationImpl<FileTransferInformation> implements
	FileUploadOperation {
	/**
	 * The default value of the '{@link #getFileChunk() <em>File Chunk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileChunk()
	 * @generated
	 * @ordered
	 */
	protected static final FileChunk FILE_CHUNK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileChunk() <em>File Chunk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileChunk()
	 * @generated
	 * @ordered
	 */
	protected FileChunk fileChunk = FILE_CHUNK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileUploadOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.FILE_UPLOAD_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileChunk getFileChunk() {
		return fileChunk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileChunk(FileChunk newFileChunk) {
		FileChunk oldFileChunk = fileChunk;
		fileChunk = newFileChunk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.FILE_UPLOAD_OPERATION__FILE_CHUNK, oldFileChunk, fileChunk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.FILE_UPLOAD_OPERATION__FILE_CHUNK:
				return getFileChunk();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationPackage.FILE_UPLOAD_OPERATION__FILE_CHUNK:
				setFileChunk((FileChunk)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationPackage.FILE_UPLOAD_OPERATION__FILE_CHUNK:
				setFileChunk(FILE_CHUNK_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationPackage.FILE_UPLOAD_OPERATION__FILE_CHUNK:
				return FILE_CHUNK_EDEFAULT == null ? fileChunk != null : !FILE_CHUNK_EDEFAULT.equals(fileChunk);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileChunk: ");
		result.append(fileChunk);
		result.append(')');
		return result.toString();
	}

} // FileUploadOperationImpl
