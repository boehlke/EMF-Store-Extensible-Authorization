/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Tag Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getTag <em>Tag</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getAddTagOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.ProjectOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface AddTagOperation extends ProjectOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference.
	 * @see #setTag(TagVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getAddTagOperation_Tag()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	TagVersionSpec getTag();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getTag <em>Tag</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' containment reference.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(TagVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Spec</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Spec</em>' containment reference.
	 * @see #setVersionSpec(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getAddTagOperation_VersionSpec()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getVersionSpec();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getVersionSpec <em>Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Spec</em>' containment reference.
	 * @see #getVersionSpec()
	 * @generated
	 */
	void setVersionSpec(PrimaryVersionSpec value);

} // AddTagOperation
