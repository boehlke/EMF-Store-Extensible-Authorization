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

import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Tag Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddTagOperationImpl extends ProjectOperationImpl<Void> implements AddTagOperation {
	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected TagVersionSpec tag;

	/**
	 * The cached value of the '{@link #getVersionSpec() <em>Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionSpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec versionSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddTagOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.ADD_TAG_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagVersionSpec getTag() {
		if (tag != null && tag.eIsProxy()) {
			InternalEObject oldTag = (InternalEObject)tag;
			tag = (TagVersionSpec)eResolveProxy(oldTag);
			if (tag != oldTag) {
				InternalEObject newTag = (InternalEObject)tag;
				NotificationChain msgs = oldTag.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__TAG, null, null);
				if (newTag.eInternalContainer() == null) {
					msgs = newTag.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__TAG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.ADD_TAG_OPERATION__TAG, oldTag, tag));
			}
		}
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagVersionSpec basicGetTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTag(TagVersionSpec newTag, NotificationChain msgs) {
		TagVersionSpec oldTag = tag;
		tag = newTag;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.ADD_TAG_OPERATION__TAG, oldTag, newTag);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(TagVersionSpec newTag) {
		if (newTag != tag) {
			NotificationChain msgs = null;
			if (tag != null)
				msgs = ((InternalEObject)tag).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__TAG, null, msgs);
			if (newTag != null)
				msgs = ((InternalEObject)newTag).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__TAG, null, msgs);
			msgs = basicSetTag(newTag, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ADD_TAG_OPERATION__TAG, newTag, newTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getVersionSpec() {
		if (versionSpec != null && versionSpec.eIsProxy()) {
			InternalEObject oldVersionSpec = (InternalEObject)versionSpec;
			versionSpec = (PrimaryVersionSpec)eResolveProxy(oldVersionSpec);
			if (versionSpec != oldVersionSpec) {
				InternalEObject newVersionSpec = (InternalEObject)versionSpec;
				NotificationChain msgs = oldVersionSpec.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, null, null);
				if (newVersionSpec.eInternalContainer() == null) {
					msgs = newVersionSpec.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, oldVersionSpec, versionSpec));
			}
		}
		return versionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetVersionSpec() {
		return versionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionSpec(PrimaryVersionSpec newVersionSpec, NotificationChain msgs) {
		PrimaryVersionSpec oldVersionSpec = versionSpec;
		versionSpec = newVersionSpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, oldVersionSpec, newVersionSpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionSpec(PrimaryVersionSpec newVersionSpec) {
		if (newVersionSpec != versionSpec) {
			NotificationChain msgs = null;
			if (versionSpec != null)
				msgs = ((InternalEObject)versionSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, null, msgs);
			if (newVersionSpec != null)
				msgs = ((InternalEObject)newVersionSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, null, msgs);
			msgs = basicSetVersionSpec(newVersionSpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC, newVersionSpec, newVersionSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.ADD_TAG_OPERATION__TAG:
				return basicSetTag(null, msgs);
			case OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC:
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
			case OperationPackage.ADD_TAG_OPERATION__TAG:
				if (resolve) return getTag();
				return basicGetTag();
			case OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC:
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
			case OperationPackage.ADD_TAG_OPERATION__TAG:
				setTag((TagVersionSpec)newValue);
				return;
			case OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC:
				setVersionSpec((PrimaryVersionSpec)newValue);
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
			case OperationPackage.ADD_TAG_OPERATION__TAG:
				setTag((TagVersionSpec)null);
				return;
			case OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC:
				setVersionSpec((PrimaryVersionSpec)null);
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
			case OperationPackage.ADD_TAG_OPERATION__TAG:
				return tag != null;
			case OperationPackage.ADD_TAG_OPERATION__VERSION_SPEC:
				return versionSpec != null;
		}
		return super.eIsSet(featureID);
	}

} //AddTagOperationImpl
