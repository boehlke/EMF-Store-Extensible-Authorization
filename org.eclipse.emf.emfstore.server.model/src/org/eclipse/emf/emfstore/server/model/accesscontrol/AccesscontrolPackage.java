/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.accesscontrol;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.common.model.ModelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory
 * @model kind="package"
 * @generated
 */
public interface AccesscontrolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "accesscontrol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/accesscontrol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.accesscontrol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	AccesscontrolPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACUserImpl <em>AC User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACUserImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACUser()
	 * @generated
	 */
	int AC_USER = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitImpl <em>AC Org Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACOrgUnit()
	 * @generated
	 */
	int AC_ORG_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__NAME = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__DESCRIPTION = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__PROPERTIES = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__ROLES = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT__GROUPS = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>AC Org Unit</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__IDENTIFIER = AC_ORG_UNIT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__NAME = AC_ORG_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__DESCRIPTION = AC_ORG_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__PROPERTIES = AC_ORG_UNIT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__ROLES = AC_ORG_UNIT__ROLES;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__GROUPS = AC_ORG_UNIT__GROUPS;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__FIRST_NAME = AC_ORG_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER__LAST_NAME = AC_ORG_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>AC User</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_USER_FEATURE_COUNT = AC_ORG_UNIT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACGroupImpl <em>AC Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACGroupImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACGroup()
	 * @generated
	 */
	int AC_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__IDENTIFIER = AC_ORG_UNIT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__NAME = AC_ORG_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__DESCRIPTION = AC_ORG_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__PROPERTIES = AC_ORG_UNIT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__ROLES = AC_ORG_UNIT__ROLES;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__GROUPS = AC_ORG_UNIT__GROUPS;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP__MEMBERS = AC_ORG_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>AC Group</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_GROUP_FEATURE_COUNT = AC_ORG_UNIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitIdImpl <em>AC Org Unit Id</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitIdImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACOrgUnitId()
	 * @generated
	 */
	int AC_ORG_UNIT_ID = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT_ID__ID = ModelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>AC Org Unit Id</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_ORG_UNIT_ID_FEATURE_COUNT = ModelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.OrgUnitPropertyImpl <em>Org Unit Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.OrgUnitPropertyImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getOrgUnitProperty()
	 * @generated
	 */
	int ORG_UNIT_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_PROPERTY__PROJECT = 2;

	/**
	 * The number of structural features of the '<em>Org Unit Property</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleAssignmentImpl <em>Role Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleAssignmentImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getRoleAssignment()
	 * @generated
	 */
	int ROLE_ASSIGNMENT = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSIGNMENT__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSIGNMENT__ROLE = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSIGNMENT__PROJECT_ID = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_ASSIGNMENT_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Permission Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PERMISSION_TYPES = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>System Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SYSTEM_ROLE = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getPermissionType()
	 * @generated
	 */
	int PERMISSION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__IDENTIFIER = ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__ID = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refering Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__REFERING_ROLES = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__PROJECT_PERMISSION = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Permission Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE_FEATURE_COUNT = ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl <em>Permission Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getPermissionSet()
	 * @generated
	 */
	int PERMISSION_SET = 8;

	/**
	 * The feature id for the '<em><b>Permission Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET__PERMISSION_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET__ROLES = 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET__GROUPS = 2;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET__USERS = 3;

	/**
	 * The feature id for the '<em><b>Super User Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET__SUPER_USER_ROLE = 4;

	/**
	 * The number of structural features of the '<em>Permission Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_SET_FEATURE_COUNT = 5;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser <em>AC User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC User</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser
	 * @generated
	 */
	EClass getACUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getFirstName()
	 * @see #getACUser()
	 * @generated
	 */
	EAttribute getACUser_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser#getLastName()
	 * @see #getACUser()
	 * @generated
	 */
	EAttribute getACUser_LastName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit <em>AC Org Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC Org Unit</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit
	 * @generated
	 */
	EClass getACOrgUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getName()
	 * @see #getACOrgUnit()
	 * @generated
	 */
	EAttribute getACOrgUnit_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getRoles()
	 * @see #getACOrgUnit()
	 * @generated
	 */
	EReference getACOrgUnit_Roles();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Groups</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getGroups()
	 * @see #getACOrgUnit()
	 * @generated
	 */
	EReference getACOrgUnit_Groups();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getDescription <em>Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getDescription()
	 * @see #getACOrgUnit()
	 * @generated
	 */
	EAttribute getACOrgUnit_Description();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getProperties <em>Properties</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit#getProperties()
	 * @see #getACOrgUnit()
	 * @generated
	 */
	EReference getACOrgUnit_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup <em>AC Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC Group</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup
	 * @generated
	 */
	EClass getACGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup#getMembers()
	 * @see #getACGroup()
	 * @generated
	 */
	EReference getACGroup_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId <em>AC Org Unit Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC Org Unit Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId
	 * @generated
	 */
	EClass getACOrgUnitId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty <em>Org Unit Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Org Unit Property</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty
	 * @generated
	 */
	EClass getOrgUnitProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getName()
	 * @see #getOrgUnitProperty()
	 * @generated
	 */
	EAttribute getOrgUnitProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getValue()
	 * @see #getOrgUnitProperty()
	 * @generated
	 */
	EAttribute getOrgUnitProperty_Value();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getProject <em>Project</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty#getProject()
	 * @see #getOrgUnitProperty()
	 * @generated
	 */
	EReference getOrgUnitProperty_Project();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment <em>Role Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Assignment</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment
	 * @generated
	 */
	EClass getRoleAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment#getRole()
	 * @see #getRoleAssignment()
	 * @generated
	 */
	EReference getRoleAssignment_Role();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment#getProjectId()
	 * @see #getRoleAssignment()
	 * @generated
	 */
	EReference getRoleAssignment_ProjectId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getPermissionTypes <em>Permission Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permission Types</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getPermissionTypes()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_PermissionTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getDescription()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.Role#isSystemRole <em>System Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Role</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.Role#isSystemRole()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_SystemRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType <em>Permission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission Type</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType
	 * @generated
	 */
	EClass getPermissionType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getId()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Id();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getReferingRoles <em>Refering Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refering Roles</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#getReferingRoles()
	 * @see #getPermissionType()
	 * @generated
	 */
	EReference getPermissionType_ReferingRoles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#isProjectPermission <em>Project Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Permission</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType#isProjectPermission()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_ProjectPermission();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet <em>Permission Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission Set</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet
	 * @generated
	 */
	EClass getPermissionSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getPermissionTypes <em>Permission Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permission Types</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getPermissionTypes()
	 * @see #getPermissionSet()
	 * @generated
	 */
	EReference getPermissionSet_PermissionTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getRoles()
	 * @see #getPermissionSet()
	 * @generated
	 */
	EReference getPermissionSet_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getGroups()
	 * @see #getPermissionSet()
	 * @generated
	 */
	EReference getPermissionSet_Groups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getUsers()
	 * @see #getPermissionSet()
	 * @generated
	 */
	EReference getPermissionSet_Users();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getSuperUserRole <em>Super User Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super User Role</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet#getSuperUserRole()
	 * @see #getPermissionSet()
	 * @generated
	 */
	EReference getPermissionSet_SuperUserRole();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AccesscontrolFactory getAccesscontrolFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACUserImpl <em>AC User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACUserImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACUser()
		 * @generated
		 */
		EClass AC_USER = eINSTANCE.getACUser();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute AC_USER__FIRST_NAME = eINSTANCE.getACUser_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute AC_USER__LAST_NAME = eINSTANCE.getACUser_LastName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitImpl <em>AC Org Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACOrgUnit()
		 * @generated
		 */
		EClass AC_ORG_UNIT = eINSTANCE.getACOrgUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute AC_ORG_UNIT__NAME = eINSTANCE.getACOrgUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AC_ORG_UNIT__ROLES = eINSTANCE.getACOrgUnit_Roles();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC_ORG_UNIT__GROUPS = eINSTANCE.getACOrgUnit_Groups();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute AC_ORG_UNIT__DESCRIPTION = eINSTANCE.getACOrgUnit_Description();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AC_ORG_UNIT__PROPERTIES = eINSTANCE.getACOrgUnit_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACGroupImpl <em>AC Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACGroupImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACGroup()
		 * @generated
		 */
		EClass AC_GROUP = eINSTANCE.getACGroup();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC_GROUP__MEMBERS = eINSTANCE.getACGroup_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitIdImpl <em>AC Org Unit Id</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACOrgUnitIdImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getACOrgUnitId()
		 * @generated
		 */
		EClass AC_ORG_UNIT_ID = eINSTANCE.getACOrgUnitId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.OrgUnitPropertyImpl <em>Org Unit Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.OrgUnitPropertyImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getOrgUnitProperty()
		 * @generated
		 */
		EClass ORG_UNIT_PROPERTY = eINSTANCE.getOrgUnitProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ORG_UNIT_PROPERTY__NAME = eINSTANCE.getOrgUnitProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ORG_UNIT_PROPERTY__VALUE = eINSTANCE.getOrgUnitProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORG_UNIT_PROPERTY__PROJECT = eINSTANCE.getOrgUnitProperty_Project();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleAssignmentImpl <em>Role Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleAssignmentImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getRoleAssignment()
		 * @generated
		 */
		EClass ROLE_ASSIGNMENT = eINSTANCE.getRoleAssignment();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_ASSIGNMENT__ROLE = eINSTANCE.getRoleAssignment_Role();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_ASSIGNMENT__PROJECT_ID = eINSTANCE.getRoleAssignment_ProjectId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.RoleImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Permission Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__PERMISSION_TYPES = eINSTANCE.getRole_PermissionTypes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__DESCRIPTION = eINSTANCE.getRole_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '<em><b>System Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__SYSTEM_ROLE = eINSTANCE.getRole_SystemRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getPermissionType()
		 * @generated
		 */
		EClass PERMISSION_TYPE = eINSTANCE.getPermissionType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__ID = eINSTANCE.getPermissionType_Id();

		/**
		 * The meta object literal for the '<em><b>Refering Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_TYPE__REFERING_ROLES = eINSTANCE.getPermissionType_ReferingRoles();

		/**
		 * The meta object literal for the '<em><b>Project Permission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__PROJECT_PERMISSION = eINSTANCE.getPermissionType_ProjectPermission();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl <em>Permission Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionSetImpl
		 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl#getPermissionSet()
		 * @generated
		 */
		EClass PERMISSION_SET = eINSTANCE.getPermissionSet();

		/**
		 * The meta object literal for the '<em><b>Permission Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_SET__PERMISSION_TYPES = eINSTANCE.getPermissionSet_PermissionTypes();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_SET__ROLES = eINSTANCE.getPermissionSet_Roles();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_SET__GROUPS = eINSTANCE.getPermissionSet_Groups();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_SET__USERS = eINSTANCE.getPermissionSet_Users();

		/**
		 * The meta object literal for the '<em><b>Super User Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION_SET__SUPER_USER_ROLE = eINSTANCE.getPermissionSet_SuperUserRole();

	}

} // AccesscontrolPackage
