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
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getPermissionTypes <em>Permission Types</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#isSystemRole <em>System Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Permission Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getReferingRoles <em>Refering Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission Types</em>' reference list.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getRole_PermissionTypes()
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getReferingRoles
	 * @model opposite="referingRoles"
	 * @generated
	 */
	EList<PermissionType> getPermissionTypes();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getRole_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getRole_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>System Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Role</em>' attribute.
	 * @see #setSystemRole(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage#getRole_SystemRole()
	 * @model
	 * @generated
	 */
	boolean isSystemRole();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#isSystemRole <em>System Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Role</em>' attribute.
	 * @see #isSystemRole()
	 * @generated
	 */
	void setSystemRole(boolean value);

} // Role
