/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Version Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getLogMessage <em>Log Message</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getChangePackage <em>Change Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateVersionOperation()
 * @model
 * @generated
 */
public interface CreateVersionOperation extends ProjectOperation<PrimaryVersionSpec> {
	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateVersionOperation_BaseVersion()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Message</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Message</em>' containment reference.
	 * @see #setLogMessage(LogMessage)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateVersionOperation_LogMessage()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	LogMessage getLogMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getLogMessage <em>Log Message</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Message</em>' containment reference.
	 * @see #getLogMessage()
	 * @generated
	 */
	void setLogMessage(LogMessage value);

	/**
	 * Returns the value of the '<em><b>Change Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Package</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Package</em>' containment reference.
	 * @see #setChangePackage(ChangePackage)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getCreateVersionOperation_ChangePackage()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ChangePackage getChangePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getChangePackage <em>Change Package</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Package</em>' containment reference.
	 * @see #getChangePackage()
	 * @generated
	 */
	void setChangePackage(ChangePackage value);

} // CreateVersionOperation
