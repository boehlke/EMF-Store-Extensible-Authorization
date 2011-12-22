/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.emfstore.common.model.IdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getReferingRoles <em>Refering Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#isProjectPermission <em>Project Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionType()
 * @model
 * @generated
 */
public interface PermissionType extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionType_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Refering Roles</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getPermissionTypes <em>Permission Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refering Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refering Roles</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionType_ReferingRoles()
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getPermissionTypes
	 * @model opposite="permissionTypes"
	 * @generated
	 */
	EList<Role> getReferingRoles();

	/**
	 * Returns the value of the '<em><b>Project Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Permission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Permission</em>' attribute.
	 * @see #setProjectPermission(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getPermissionType_ProjectPermission()
	 * @model
	 * @generated
	 */
	boolean isProjectPermission();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#isProjectPermission <em>Project Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Permission</em>' attribute.
	 * @see #isProjectPermission()
	 * @generated
	 */
	void setProjectPermission(boolean value);

} // PermissionType
