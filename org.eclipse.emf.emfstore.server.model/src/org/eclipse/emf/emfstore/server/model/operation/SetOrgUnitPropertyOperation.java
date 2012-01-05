/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import java.util.Map;
import java.util.HashMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Org Unit Property Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.operation.SetOrgUnitPropertyOperation#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getSetOrgUnitPropertyOperation()
 * @model superTypes="org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation<org.eclipse.emf.emfstore.server.model.operation.Void>"
 * @generated
 */
public interface SetOrgUnitPropertyOperation extends OrgUnitOperation<Void> {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(Map)
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#getSetOrgUnitPropertyOperation_Properties()
	 * @model dataType="org.eclipse.emf.emfstore.server.model.operation.Map<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	Map<String, String> getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.operation.SetOrgUnitPropertyOperation#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Map<String, String> value);

} // SetOrgUnitPropertyOperation
