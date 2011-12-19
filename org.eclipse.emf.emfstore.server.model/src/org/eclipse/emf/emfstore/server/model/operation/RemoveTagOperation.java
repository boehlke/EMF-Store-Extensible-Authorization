/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Tag Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRemoveTagOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.ProjectOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface RemoveTagOperation extends ProjectOperation<Void> {
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
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getRemoveTagOperation_Tag()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	TagVersionSpec getTag();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation#getTag <em>Tag</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' containment reference.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(TagVersionSpec value);

} // RemoveTagOperation
