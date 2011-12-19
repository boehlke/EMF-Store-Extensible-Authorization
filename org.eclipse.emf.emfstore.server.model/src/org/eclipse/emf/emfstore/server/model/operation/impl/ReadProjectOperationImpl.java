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

import org.eclipse.emf.emfstore.server.model.ProjectInfo;

import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation;

import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Read Project Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadProjectOperationImpl#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReadProjectOperationImpl extends ProjectOperationImpl<ProjectInfo> implements ReadProjectOperation {
	/**
	 * The cached value of the '{@link #getVersionSpec() <em>Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionSpec()
	 * @generated
	 * @ordered
	 */
	protected VersionSpec versionSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadProjectOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.READ_PROJECT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec getVersionSpec() {
		if (versionSpec != null && versionSpec.eIsProxy()) {
			InternalEObject oldVersionSpec = (InternalEObject)versionSpec;
			versionSpec = (VersionSpec)eResolveProxy(oldVersionSpec);
			if (versionSpec != oldVersionSpec) {
				InternalEObject newVersionSpec = (InternalEObject)versionSpec;
				NotificationChain msgs = oldVersionSpec.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, null, null);
				if (newVersionSpec.eInternalContainer() == null) {
					msgs = newVersionSpec.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, oldVersionSpec, versionSpec));
			}
		}
		return versionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec basicGetVersionSpec() {
		return versionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionSpec(VersionSpec newVersionSpec, NotificationChain msgs) {
		VersionSpec oldVersionSpec = versionSpec;
		versionSpec = newVersionSpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, oldVersionSpec, newVersionSpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionSpec(VersionSpec newVersionSpec) {
		if (newVersionSpec != versionSpec) {
			NotificationChain msgs = null;
			if (versionSpec != null)
				msgs = ((InternalEObject)versionSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, null, msgs);
			if (newVersionSpec != null)
				msgs = ((InternalEObject)newVersionSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, null, msgs);
			msgs = basicSetVersionSpec(newVersionSpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC, newVersionSpec, newVersionSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC:
				return basicSetVersionSpec(null, msgs);
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
			case OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC:
				if (resolve) return getVersionSpec();
				return basicGetVersionSpec();
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
			case OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC:
				setVersionSpec((VersionSpec)newValue);
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
			case OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC:
				setVersionSpec((VersionSpec)null);
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
			case OperationPackage.READ_PROJECT_OPERATION__VERSION_SPEC:
				return versionSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //ReadProjectOperationImpl
