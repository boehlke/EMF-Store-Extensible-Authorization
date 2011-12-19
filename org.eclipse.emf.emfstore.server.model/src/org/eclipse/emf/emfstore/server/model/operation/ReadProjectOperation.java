/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.server.model.ProjectInfo;

import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Project Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getReadProjectOperation()
 * @model
 * @generated
 */
public interface ReadProjectOperation extends ProjectOperation<ProjectInfo> {
	/**
	 * Returns the value of the '<em><b>Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Spec</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Spec</em>' containment reference.
	 * @see #setVersionSpec(VersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getReadProjectOperation_VersionSpec()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	VersionSpec getVersionSpec();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation#getVersionSpec <em>Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Spec</em>' containment reference.
	 * @see #getVersionSpec()
	 * @generated
	 */
	void setVersionSpec(VersionSpec value);

} // ReadProjectOperation
