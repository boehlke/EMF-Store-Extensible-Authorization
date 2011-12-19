/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Project Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.DeleteProjectOperationImpl#isDeleteFiles <em>Delete Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeleteProjectOperationImpl extends ProjectOperationImpl<Void> implements DeleteProjectOperation {
	/**
	 * The default value of the '{@link #isDeleteFiles() <em>Delete Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteFiles()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_FILES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleteFiles() <em>Delete Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteFiles()
	 * @generated
	 * @ordered
	 */
	protected boolean deleteFiles = DELETE_FILES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteProjectOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.DELETE_PROJECT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeleteFiles() {
		return deleteFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleteFiles(boolean newDeleteFiles) {
		boolean oldDeleteFiles = deleteFiles;
		deleteFiles = newDeleteFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.DELETE_PROJECT_OPERATION__DELETE_FILES, oldDeleteFiles, deleteFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.DELETE_PROJECT_OPERATION__DELETE_FILES:
				return isDeleteFiles();
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
			case OperationPackage.DELETE_PROJECT_OPERATION__DELETE_FILES:
				setDeleteFiles((Boolean)newValue);
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
			case OperationPackage.DELETE_PROJECT_OPERATION__DELETE_FILES:
				setDeleteFiles(DELETE_FILES_EDEFAULT);
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
			case OperationPackage.DELETE_PROJECT_OPERATION__DELETE_FILES:
				return deleteFiles != DELETE_FILES_EDEFAULT;
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
		result.append(" (deleteFiles: ");
		result.append(deleteFiles);
		result.append(')');
		return result.toString();
	}

} //DeleteProjectOperationImpl
