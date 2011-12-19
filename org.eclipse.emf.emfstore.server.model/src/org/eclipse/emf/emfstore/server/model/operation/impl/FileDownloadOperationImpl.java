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
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Download Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileDownloadOperationImpl#getFileInformation <em>File Information</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileDownloadOperationImpl extends ProjectOperationImpl<Void> implements FileDownloadOperation {
	/**
	 * The default value of the '{@link #getFileInformation() <em>File Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileInformation()
	 * @generated
	 * @ordered
	 */
	protected static final FileTransferInformation FILE_INFORMATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileInformation() <em>File Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileInformation()
	 * @generated
	 * @ordered
	 */
	protected FileTransferInformation fileInformation = FILE_INFORMATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileDownloadOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.FILE_DOWNLOAD_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTransferInformation getFileInformation() {
		return fileInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileInformation(FileTransferInformation newFileInformation) {
		FileTransferInformation oldFileInformation = fileInformation;
		fileInformation = newFileInformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.FILE_DOWNLOAD_OPERATION__FILE_INFORMATION, oldFileInformation, fileInformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.FILE_DOWNLOAD_OPERATION__FILE_INFORMATION:
				return getFileInformation();
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
			case OperationPackage.FILE_DOWNLOAD_OPERATION__FILE_INFORMATION:
				setFileInformation((FileTransferInformation)newValue);
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
			case OperationPackage.FILE_DOWNLOAD_OPERATION__FILE_INFORMATION:
				setFileInformation(FILE_INFORMATION_EDEFAULT);
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
			case OperationPackage.FILE_DOWNLOAD_OPERATION__FILE_INFORMATION:
				return FILE_INFORMATION_EDEFAULT == null ? fileInformation != null : !FILE_INFORMATION_EDEFAULT.equals(fileInformation);
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
		result.append(" (fileInformation: ");
		result.append(fileInformation);
		result.append(')');
		return result.toString();
	}

} // FileDownloadOperationImpl
