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

import org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Version Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl#getLogMessage <em>Log Message</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl#getChangePackage <em>Change Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateVersionOperationImpl extends ProjectOperationImpl<PrimaryVersionSpec> implements CreateVersionOperation {
	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The cached value of the '{@link #getLogMessage() <em>Log Message</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogMessage()
	 * @generated
	 * @ordered
	 */
	protected LogMessage logMessage;

	/**
	 * The cached value of the '{@link #getChangePackage() <em>Change Package</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangePackage()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage changePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateVersionOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.CREATE_VERSION_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject)baseVersion;
			baseVersion = (PrimaryVersionSpec)eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject)baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, oldBaseVersion, newBaseVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject)baseVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject)newBaseVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION, newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage getLogMessage() {
		if (logMessage != null && logMessage.eIsProxy()) {
			InternalEObject oldLogMessage = (InternalEObject)logMessage;
			logMessage = (LogMessage)eResolveProxy(oldLogMessage);
			if (logMessage != oldLogMessage) {
				InternalEObject newLogMessage = (InternalEObject)logMessage;
				NotificationChain msgs = oldLogMessage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, null, null);
				if (newLogMessage.eInternalContainer() == null) {
					msgs = newLogMessage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, oldLogMessage, logMessage));
			}
		}
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage basicGetLogMessage() {
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogMessage(LogMessage newLogMessage, NotificationChain msgs) {
		LogMessage oldLogMessage = logMessage;
		logMessage = newLogMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, oldLogMessage, newLogMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogMessage(LogMessage newLogMessage) {
		if (newLogMessage != logMessage) {
			NotificationChain msgs = null;
			if (logMessage != null)
				msgs = ((InternalEObject)logMessage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, null, msgs);
			if (newLogMessage != null)
				msgs = ((InternalEObject)newLogMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, null, msgs);
			msgs = basicSetLogMessage(newLogMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE, newLogMessage, newLogMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage getChangePackage() {
		if (changePackage != null && changePackage.eIsProxy()) {
			InternalEObject oldChangePackage = (InternalEObject)changePackage;
			changePackage = (ChangePackage)eResolveProxy(oldChangePackage);
			if (changePackage != oldChangePackage) {
				InternalEObject newChangePackage = (InternalEObject)changePackage;
				NotificationChain msgs = oldChangePackage.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, null, null);
				if (newChangePackage.eInternalContainer() == null) {
					msgs = newChangePackage.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, oldChangePackage, changePackage));
			}
		}
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage basicGetChangePackage() {
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangePackage(ChangePackage newChangePackage, NotificationChain msgs) {
		ChangePackage oldChangePackage = changePackage;
		changePackage = newChangePackage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, oldChangePackage, newChangePackage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangePackage(ChangePackage newChangePackage) {
		if (newChangePackage != changePackage) {
			NotificationChain msgs = null;
			if (changePackage != null)
				msgs = ((InternalEObject)changePackage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, null, msgs);
			if (newChangePackage != null)
				msgs = ((InternalEObject)newChangePackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, null, msgs);
			msgs = basicSetChangePackage(newChangePackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE, newChangePackage, newChangePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION:
				return basicSetBaseVersion(null, msgs);
			case OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE:
				return basicSetLogMessage(null, msgs);
			case OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE:
				return basicSetChangePackage(null, msgs);
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
			case OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION:
				if (resolve) return getBaseVersion();
				return basicGetBaseVersion();
			case OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE:
				if (resolve) return getLogMessage();
				return basicGetLogMessage();
			case OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE:
				if (resolve) return getChangePackage();
				return basicGetChangePackage();
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
			case OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION:
				setBaseVersion((PrimaryVersionSpec)newValue);
				return;
			case OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE:
				setLogMessage((LogMessage)newValue);
				return;
			case OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE:
				setChangePackage((ChangePackage)newValue);
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
			case OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION:
				setBaseVersion((PrimaryVersionSpec)null);
				return;
			case OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE:
				setLogMessage((LogMessage)null);
				return;
			case OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE:
				setChangePackage((ChangePackage)null);
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
			case OperationPackage.CREATE_VERSION_OPERATION__BASE_VERSION:
				return baseVersion != null;
			case OperationPackage.CREATE_VERSION_OPERATION__LOG_MESSAGE:
				return logMessage != null;
			case OperationPackage.CREATE_VERSION_OPERATION__CHANGE_PACKAGE:
				return changePackage != null;
		}
		return super.eIsSet(featureID);
	}

} //CreateVersionOperationImpl
