/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.emfstore.server.model.ProjectHistory;

import org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Project By Import Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectByImportOperationImpl#getProjectHistory <em>Project History</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateProjectByImportOperationImpl extends OperationImpl<Void> implements CreateProjectByImportOperation {
	/**
	 * The cached value of the '{@link #getProjectHistory() <em>Project History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectHistory()
	 * @generated
	 * @ordered
	 */
	protected ProjectHistory projectHistory;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateProjectByImportOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.CREATE_PROJECT_BY_IMPORT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectHistory getProjectHistory() {
		if (projectHistory != null && projectHistory.eIsProxy()) {
			InternalEObject oldProjectHistory = (InternalEObject)projectHistory;
			projectHistory = (ProjectHistory)eResolveProxy(oldProjectHistory);
			if (projectHistory != oldProjectHistory) {
				InternalEObject newProjectHistory = (InternalEObject)projectHistory;
				NotificationChain msgs = oldProjectHistory.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, null, null);
				if (newProjectHistory.eInternalContainer() == null) {
					msgs = newProjectHistory.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, oldProjectHistory, projectHistory));
			}
		}
		return projectHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectHistory basicGetProjectHistory() {
		return projectHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectHistory(ProjectHistory newProjectHistory, NotificationChain msgs) {
		ProjectHistory oldProjectHistory = projectHistory;
		projectHistory = newProjectHistory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, oldProjectHistory, newProjectHistory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectHistory(ProjectHistory newProjectHistory) {
		if (newProjectHistory != projectHistory) {
			NotificationChain msgs = null;
			if (projectHistory != null)
				msgs = ((InternalEObject)projectHistory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, null, msgs);
			if (newProjectHistory != null)
				msgs = ((InternalEObject)newProjectHistory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, null, msgs);
			msgs = basicSetProjectHistory(newProjectHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY, newProjectHistory, newProjectHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY:
				return basicSetProjectHistory(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY:
				if (resolve) return getProjectHistory();
				return basicGetProjectHistory();
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
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY:
				setProjectHistory((ProjectHistory)newValue);
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
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY:
				setProjectHistory((ProjectHistory)null);
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
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY:
				return projectHistory != null;
		}
		return super.eIsSet(featureID);
	}

} //CreateProjectByImportOperationImpl
