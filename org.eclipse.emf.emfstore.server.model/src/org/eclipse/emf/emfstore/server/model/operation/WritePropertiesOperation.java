/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Properties Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getWritePropertiesOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.ProjectOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface WritePropertiesOperation extends ProjectOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.common.model.EMFStoreProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getWritePropertiesOperation_Properties()
	 * @model required="true"
	 * @generated
	 */
	EList<EMFStoreProperty> getProperties();

} // WritePropertiesOperation
