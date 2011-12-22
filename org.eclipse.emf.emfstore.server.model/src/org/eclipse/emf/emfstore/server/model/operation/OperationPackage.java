/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationFactory
 * @model kind="package"
 * @generated
 */
public interface OperationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/operation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.operation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.UserManagementOperationImpl <em>User Management Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.UserManagementOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getUserManagementOperation()
	 * @generated
	 */
	int USER_MANAGEMENT_OPERATION = 1;

	/**
	 * The number of structural features of the '<em>User Management Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_MANAGEMENT_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitOperationImpl <em>Org Unit Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getOrgUnitOperation()
	 * @generated
	 */
	int ORG_UNIT_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_OPERATION__ORG_UNIT_ID = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Org Unit Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_OPERATION_FEATURE_COUNT = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.DeleteOrgUnitOperationImpl <em>Delete Org Unit Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.DeleteOrgUnitOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getDeleteOrgUnitOperation()
	 * @generated
	 */
	int DELETE_ORG_UNIT_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ORG_UNIT_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The number of structural features of the '<em>Delete Org Unit Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ORG_UNIT_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddGroupMemberOperationImpl <em>Add Group Member Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AddGroupMemberOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAddGroupMemberOperation()
	 * @generated
	 */
	int ADD_GROUP_MEMBER_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_GROUP_MEMBER_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Member Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_GROUP_MEMBER_OPERATION__MEMBER_ID = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Group Member Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_GROUP_MEMBER_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ProjectOperationImpl <em>Project Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ProjectOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getProjectOperation()
	 * @generated
	 */
	int PROJECT_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION__PROJECT_ID = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl <em>Add Tag Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAddTagOperation()
	 * @generated
	 */
	int ADD_TAG_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TAG_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TAG_OPERATION__TAG = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TAG_OPERATION__VERSION_SPEC = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add Tag Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TAG_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AssignRoleOperationImpl <em>Assign Role Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AssignRoleOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAssignRoleOperation()
	 * @generated
	 */
	int ASSIGN_ROLE_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ROLE_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ROLE_OPERATION__PROJECT_ID = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ROLE_OPERATION__ROLE_ID = ORG_UNIT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assign Role Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_ROLE_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrgUnitOperationImpl <em>Create Org Unit Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrgUnitOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateOrgUnitOperation()
	 * @generated
	 */
	int CREATE_ORG_UNIT_OPERATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ORG_UNIT_OPERATION__NAME = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Org Unit Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ORG_UNIT_OPERATION_FEATURE_COUNT = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateGroupOperationImpl <em>Create Group Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateGroupOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateGroupOperation()
	 * @generated
	 */
	int CREATE_GROUP_OPERATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_GROUP_OPERATION__NAME = CREATE_ORG_UNIT_OPERATION__NAME;

	/**
	 * The number of structural features of the '<em>Create Group Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_GROUP_OPERATION_FEATURE_COUNT = CREATE_ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrUpdateRoleOperationImpl <em>Create Or Update Role Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrUpdateRoleOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateOrUpdateRoleOperation()
	 * @generated
	 */
	int CREATE_OR_UPDATE_ROLE_OPERATION = 10;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OR_UPDATE_ROLE_OPERATION__ROLE = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Or Update Role Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OR_UPDATE_ROLE_OPERATION_FEATURE_COUNT = USER_MANAGEMENT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectByImportOperationImpl <em>Create Project By Import Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectByImportOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateProjectByImportOperation()
	 * @generated
	 */
	int CREATE_PROJECT_BY_IMPORT_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Project History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Project By Import Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_BY_IMPORT_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateUserOperationImpl <em>Create User Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateUserOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateUserOperation()
	 * @generated
	 */
	int CREATE_USER_OPERATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_USER_OPERATION__NAME = CREATE_ORG_UNIT_OPERATION__NAME;

	/**
	 * The number of structural features of the '<em>Create User Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_USER_OPERATION_FEATURE_COUNT = CREATE_ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl <em>Create Version Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateVersionOperation()
	 * @generated
	 */
	int CREATE_VERSION_OPERATION = 13;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERSION_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERSION_OPERATION__BASE_VERSION = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERSION_OPERATION__LOG_MESSAGE = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Change Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERSION_OPERATION__CHANGE_PACKAGE = PROJECT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Version Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERSION_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.DeleteProjectOperationImpl <em>Delete Project Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.DeleteProjectOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getDeleteProjectOperation()
	 * @generated
	 */
	int DELETE_PROJECT_OPERATION = 14;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_PROJECT_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Delete Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_PROJECT_OPERATION__DELETE_FILES = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Project Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_PROJECT_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileDownloadOperationImpl <em>File Download Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.FileDownloadOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileDownloadOperation()
	 * @generated
	 */
	int FILE_DOWNLOAD_OPERATION = 15;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOWNLOAD_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>File Information</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOWNLOAD_OPERATION__FILE_INFORMATION = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Download Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOWNLOAD_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileUploadOperationImpl <em>File Upload Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.FileUploadOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileUploadOperation()
	 * @generated
	 */
	int FILE_UPLOAD_OPERATION = 16;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_UPLOAD_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>File Chunk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_UPLOAD_OPERATION__FILE_CHUNK = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Upload Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_UPLOAD_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadOrgUnitOperationImpl <em>Read Org Unit Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadOrgUnitOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadOrgUnitOperation()
	 * @generated
	 */
	int READ_ORG_UNIT_OPERATION = 17;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ORG_UNIT_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The number of structural features of the '<em>Read Org Unit Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_ORG_UNIT_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadProjectOperationImpl <em>Read Project Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadProjectOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadProjectOperation()
	 * @generated
	 */
	int READ_PROJECT_OPERATION = 18;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROJECT_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROJECT_OPERATION__VERSION_SPEC = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read Project Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROJECT_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadPropertiesOperationImpl <em>Read Properties Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadPropertiesOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadPropertiesOperation()
	 * @generated
	 */
	int READ_PROPERTIES_OPERATION = 19;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The number of structural features of the '<em>Read Properties Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveGroupMemberOperationImpl <em>Remove Group Member Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveGroupMemberOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveGroupMemberOperation()
	 * @generated
	 */
	int REMOVE_GROUP_MEMBER_OPERATION = 20;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_GROUP_MEMBER_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Member Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_GROUP_MEMBER_OPERATION__MEMBER_ID = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Group Member Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_GROUP_MEMBER_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveRoleOperationImpl <em>Remove Role Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveRoleOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveRoleOperation()
	 * @generated
	 */
	int REMOVE_ROLE_OPERATION = 21;

	/**
	 * The feature id for the '<em><b>Org Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_ROLE_OPERATION__ORG_UNIT_ID = ORG_UNIT_OPERATION__ORG_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_ROLE_OPERATION__ROLE_ID = ORG_UNIT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Role Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_ROLE_OPERATION_FEATURE_COUNT = ORG_UNIT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveTagOperationImpl <em>Remove Tag Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveTagOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveTagOperation()
	 * @generated
	 */
	int REMOVE_TAG_OPERATION = 22;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TAG_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TAG_OPERATION__TAG = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Tag Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TAG_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.WritePropertiesOperationImpl <em>Write Properties Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.WritePropertiesOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getWritePropertiesOperation()
	 * @generated
	 */
	int WRITE_PROPERTIES_OPERATION = 23;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_PROPERTIES_OPERATION__PROJECT_ID = PROJECT_OPERATION__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_PROPERTIES_OPERATION__PROPERTIES = PROJECT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Write Properties Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_PROPERTIES_OPERATION_FEATURE_COUNT = PROJECT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectOperationImpl <em>Create Project Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateProjectOperation()
	 * @generated
	 */
	int CREATE_PROJECT_OPERATION = 24;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_OPERATION__DESCRIPTION = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_OPERATION__PROJECT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_OPERATION__LOG_MESSAGE = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_OPERATION__NAME = OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Create Project Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_PROJECT_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '<em>Void</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Void
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getVoid()
	 * @generated
	 */
	int VOID = 25;

	/**
	 * The meta object id for the '<em>File Transfer Information</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileTransferInformation()
	 * @generated
	 */
	int FILE_TRANSFER_INFORMATION = 26;

	/**
	 * The meta object id for the '<em>File Chunk</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.common.filetransfer.FileChunk
	 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileChunk()
	 * @generated
	 */
	int FILE_CHUNK = 27;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation <em>User Management Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Management Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation
	 * @generated
	 */
	EClass getUserManagementOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation <em>Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Org Unit Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation
	 * @generated
	 */
	EClass getOrgUnitOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation#getOrgUnitId <em>Org Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Org Unit Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation#getOrgUnitId()
	 * @see #getOrgUnitOperation()
	 * @generated
	 */
	EAttribute getOrgUnitOperation_OrgUnitId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation <em>Delete Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Org Unit Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation
	 * @generated
	 */
	EClass getDeleteOrgUnitOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation <em>Add Group Member Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Group Member Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation
	 * @generated
	 */
	EClass getAddGroupMemberOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation#getMemberId <em>Member Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation#getMemberId()
	 * @see #getAddGroupMemberOperation()
	 * @generated
	 */
	EAttribute getAddGroupMemberOperation_MemberId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.ProjectOperation <em>Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ProjectOperation
	 * @generated
	 */
	EClass getProjectOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.ProjectOperation#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ProjectOperation#getProjectId()
	 * @see #getProjectOperation()
	 * @generated
	 */
	EAttribute getProjectOperation_ProjectId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation <em>Add Tag Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Tag Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddTagOperation
	 * @generated
	 */
	EClass getAddTagOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getTag()
	 * @see #getAddTagOperation()
	 * @generated
	 */
	EReference getAddTagOperation_Tag();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getVersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddTagOperation#getVersionSpec()
	 * @see #getAddTagOperation()
	 * @generated
	 */
	EReference getAddTagOperation_VersionSpec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation <em>Assign Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Role Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation
	 * @generated
	 */
	EClass getAssignRoleOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation#getProjectId()
	 * @see #getAssignRoleOperation()
	 * @generated
	 */
	EAttribute getAssignRoleOperation_ProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation#getRoleId <em>Role Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation#getRoleId()
	 * @see #getAssignRoleOperation()
	 * @generated
	 */
	EAttribute getAssignRoleOperation_RoleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation <em>Create Group Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Group Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation
	 * @generated
	 */
	EClass getCreateGroupOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation <em>Create Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Org Unit Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation
	 * @generated
	 */
	EClass getCreateOrgUnitOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation#getName()
	 * @see #getCreateOrgUnitOperation()
	 * @generated
	 */
	EAttribute getCreateOrgUnitOperation_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation <em>Create Or Update Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Or Update Role Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation
	 * @generated
	 */
	EClass getCreateOrUpdateRoleOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation#getRole()
	 * @see #getCreateOrUpdateRoleOperation()
	 * @generated
	 */
	EReference getCreateOrUpdateRoleOperation_Role();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation <em>Create Project By Import Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Project By Import Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation
	 * @generated
	 */
	EClass getCreateProjectByImportOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation#getProjectHistory <em>Project History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project History</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation#getProjectHistory()
	 * @see #getCreateProjectByImportOperation()
	 * @generated
	 */
	EReference getCreateProjectByImportOperation_ProjectHistory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation <em>Create User Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create User Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation
	 * @generated
	 */
	EClass getCreateUserOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation <em>Create Version Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Version Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation
	 * @generated
	 */
	EClass getCreateVersionOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getBaseVersion()
	 * @see #getCreateVersionOperation()
	 * @generated
	 */
	EReference getCreateVersionOperation_BaseVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getLogMessage()
	 * @see #getCreateVersionOperation()
	 * @generated
	 */
	EReference getCreateVersionOperation_LogMessage();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Change Package</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation#getChangePackage()
	 * @see #getCreateVersionOperation()
	 * @generated
	 */
	EReference getCreateVersionOperation_ChangePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation <em>Delete Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Project Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation
	 * @generated
	 */
	EClass getDeleteProjectOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation#isDeleteFiles <em>Delete Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete Files</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation#isDeleteFiles()
	 * @see #getDeleteProjectOperation()
	 * @generated
	 */
	EAttribute getDeleteProjectOperation_DeleteFiles();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation <em>File Download Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Download Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation
	 * @generated
	 */
	EClass getFileDownloadOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation#getFileInformation <em>File Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Information</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation#getFileInformation()
	 * @see #getFileDownloadOperation()
	 * @generated
	 */
	EAttribute getFileDownloadOperation_FileInformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation <em>File Upload Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Upload Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation
	 * @generated
	 */
	EClass getFileUploadOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation#getFileChunk <em>File Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Chunk</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation#getFileChunk()
	 * @see #getFileUploadOperation()
	 * @generated
	 */
	EAttribute getFileUploadOperation_FileChunk();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation <em>Read Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Org Unit Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation
	 * @generated
	 */
	EClass getReadOrgUnitOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation <em>Read Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Project Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation
	 * @generated
	 */
	EClass getReadProjectOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation#getVersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation#getVersionSpec()
	 * @see #getReadProjectOperation()
	 * @generated
	 */
	EReference getReadProjectOperation_VersionSpec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation <em>Read Properties Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Properties Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation
	 * @generated
	 */
	EClass getReadPropertiesOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation <em>Remove Group Member Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Group Member Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation
	 * @generated
	 */
	EClass getRemoveGroupMemberOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation#getMemberId <em>Member Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation#getMemberId()
	 * @see #getRemoveGroupMemberOperation()
	 * @generated
	 */
	EAttribute getRemoveGroupMemberOperation_MemberId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation <em>Remove Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Role Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation
	 * @generated
	 */
	EClass getRemoveRoleOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getRoleId <em>Role Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Id</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation#getRoleId()
	 * @see #getRemoveRoleOperation()
	 * @generated
	 */
	EAttribute getRemoveRoleOperation_RoleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation <em>Remove Tag Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Tag Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation
	 * @generated
	 */
	EClass getRemoveTagOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation#getTag()
	 * @see #getRemoveTagOperation()
	 * @generated
	 */
	EReference getRemoveTagOperation_Tag();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation <em>Write Properties Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Properties Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation
	 * @generated
	 */
	EClass getWritePropertiesOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation#getProperties()
	 * @see #getWritePropertiesOperation()
	 * @generated
	 */
	EReference getWritePropertiesOperation_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation <em>Create Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Project Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation
	 * @generated
	 */
	EClass getCreateProjectOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getDescription()
	 * @see #getCreateProjectOperation()
	 * @generated
	 */
	EAttribute getCreateProjectOperation_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getProject()
	 * @see #getCreateProjectOperation()
	 * @generated
	 */
	EReference getCreateProjectOperation_Project();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getLogMessage()
	 * @see #getCreateProjectOperation()
	 * @generated
	 */
	EReference getCreateProjectOperation_LogMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation#getName()
	 * @see #getCreateProjectOperation()
	 * @generated
	 */
	EAttribute getCreateProjectOperation_Name();

	/**
	 * Returns the meta object for data type '{@link java.lang.Void <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Void</em>'.
	 * @see java.lang.Void
	 * @model instanceClass="java.lang.Void"
	 * @generated
	 */
	EDataType getVoid();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation <em>File Transfer Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File Transfer Information</em>'.
	 * @see org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation
	 * @model instanceClass="org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation"
	 * @generated
	 */
	EDataType getFileTransferInformation();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.emfstore.common.filetransfer.FileChunk <em>File Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File Chunk</em>'.
	 * @see org.eclipse.emf.emfstore.common.filetransfer.FileChunk
	 * @model instanceClass="org.eclipse.emf.emfstore.common.filetransfer.FileChunk"
	 * @generated
	 */
	EDataType getFileChunk();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationFactory getOperationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.UserManagementOperationImpl <em>User Management Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.UserManagementOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getUserManagementOperation()
		 * @generated
		 */
		EClass USER_MANAGEMENT_OPERATION = eINSTANCE.getUserManagementOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitOperationImpl <em>Org Unit Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OrgUnitOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getOrgUnitOperation()
		 * @generated
		 */
		EClass ORG_UNIT_OPERATION = eINSTANCE.getOrgUnitOperation();

		/**
		 * The meta object literal for the '<em><b>Org Unit Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORG_UNIT_OPERATION__ORG_UNIT_ID = eINSTANCE.getOrgUnitOperation_OrgUnitId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.DeleteOrgUnitOperationImpl <em>Delete Org Unit Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.DeleteOrgUnitOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getDeleteOrgUnitOperation()
		 * @generated
		 */
		EClass DELETE_ORG_UNIT_OPERATION = eINSTANCE.getDeleteOrgUnitOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddGroupMemberOperationImpl <em>Add Group Member Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AddGroupMemberOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAddGroupMemberOperation()
		 * @generated
		 */
		EClass ADD_GROUP_MEMBER_OPERATION = eINSTANCE.getAddGroupMemberOperation();

		/**
		 * The meta object literal for the '<em><b>Member Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_GROUP_MEMBER_OPERATION__MEMBER_ID = eINSTANCE.getAddGroupMemberOperation_MemberId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ProjectOperationImpl <em>Project Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ProjectOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getProjectOperation()
		 * @generated
		 */
		EClass PROJECT_OPERATION = eINSTANCE.getProjectOperation();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_OPERATION__PROJECT_ID = eINSTANCE.getProjectOperation_ProjectId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl <em>Add Tag Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AddTagOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAddTagOperation()
		 * @generated
		 */
		EClass ADD_TAG_OPERATION = eINSTANCE.getAddTagOperation();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_TAG_OPERATION__TAG = eINSTANCE.getAddTagOperation_Tag();

		/**
		 * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_TAG_OPERATION__VERSION_SPEC = eINSTANCE.getAddTagOperation_VersionSpec();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.AssignRoleOperationImpl <em>Assign Role Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.AssignRoleOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getAssignRoleOperation()
		 * @generated
		 */
		EClass ASSIGN_ROLE_OPERATION = eINSTANCE.getAssignRoleOperation();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_ROLE_OPERATION__PROJECT_ID = eINSTANCE.getAssignRoleOperation_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Role Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_ROLE_OPERATION__ROLE_ID = eINSTANCE.getAssignRoleOperation_RoleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateGroupOperationImpl <em>Create Group Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateGroupOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateGroupOperation()
		 * @generated
		 */
		EClass CREATE_GROUP_OPERATION = eINSTANCE.getCreateGroupOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrgUnitOperationImpl <em>Create Org Unit Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrgUnitOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateOrgUnitOperation()
		 * @generated
		 */
		EClass CREATE_ORG_UNIT_OPERATION = eINSTANCE.getCreateOrgUnitOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_ORG_UNIT_OPERATION__NAME = eINSTANCE.getCreateOrgUnitOperation_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrUpdateRoleOperationImpl <em>Create Or Update Role Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateOrUpdateRoleOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateOrUpdateRoleOperation()
		 * @generated
		 */
		EClass CREATE_OR_UPDATE_ROLE_OPERATION = eINSTANCE.getCreateOrUpdateRoleOperation();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_OR_UPDATE_ROLE_OPERATION__ROLE = eINSTANCE.getCreateOrUpdateRoleOperation_Role();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectByImportOperationImpl <em>Create Project By Import Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectByImportOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateProjectByImportOperation()
		 * @generated
		 */
		EClass CREATE_PROJECT_BY_IMPORT_OPERATION = eINSTANCE.getCreateProjectByImportOperation();

		/**
		 * The meta object literal for the '<em><b>Project History</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY = eINSTANCE.getCreateProjectByImportOperation_ProjectHistory();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateUserOperationImpl <em>Create User Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateUserOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateUserOperation()
		 * @generated
		 */
		EClass CREATE_USER_OPERATION = eINSTANCE.getCreateUserOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl <em>Create Version Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateVersionOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateVersionOperation()
		 * @generated
		 */
		EClass CREATE_VERSION_OPERATION = eINSTANCE.getCreateVersionOperation();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_VERSION_OPERATION__BASE_VERSION = eINSTANCE.getCreateVersionOperation_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_VERSION_OPERATION__LOG_MESSAGE = eINSTANCE.getCreateVersionOperation_LogMessage();

		/**
		 * The meta object literal for the '<em><b>Change Package</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_VERSION_OPERATION__CHANGE_PACKAGE = eINSTANCE.getCreateVersionOperation_ChangePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.DeleteProjectOperationImpl <em>Delete Project Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.DeleteProjectOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getDeleteProjectOperation()
		 * @generated
		 */
		EClass DELETE_PROJECT_OPERATION = eINSTANCE.getDeleteProjectOperation();

		/**
		 * The meta object literal for the '<em><b>Delete Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETE_PROJECT_OPERATION__DELETE_FILES = eINSTANCE.getDeleteProjectOperation_DeleteFiles();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileDownloadOperationImpl <em>File Download Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.FileDownloadOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileDownloadOperation()
		 * @generated
		 */
		EClass FILE_DOWNLOAD_OPERATION = eINSTANCE.getFileDownloadOperation();

		/**
		 * The meta object literal for the '<em><b>File Information</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_DOWNLOAD_OPERATION__FILE_INFORMATION = eINSTANCE.getFileDownloadOperation_FileInformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.FileUploadOperationImpl <em>File Upload Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.FileUploadOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileUploadOperation()
		 * @generated
		 */
		EClass FILE_UPLOAD_OPERATION = eINSTANCE.getFileUploadOperation();

		/**
		 * The meta object literal for the '<em><b>File Chunk</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_UPLOAD_OPERATION__FILE_CHUNK = eINSTANCE.getFileUploadOperation_FileChunk();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadOrgUnitOperationImpl <em>Read Org Unit Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadOrgUnitOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadOrgUnitOperation()
		 * @generated
		 */
		EClass READ_ORG_UNIT_OPERATION = eINSTANCE.getReadOrgUnitOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadProjectOperationImpl <em>Read Project Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadProjectOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadProjectOperation()
		 * @generated
		 */
		EClass READ_PROJECT_OPERATION = eINSTANCE.getReadProjectOperation();

		/**
		 * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READ_PROJECT_OPERATION__VERSION_SPEC = eINSTANCE.getReadProjectOperation_VersionSpec();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.ReadPropertiesOperationImpl <em>Read Properties Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.ReadPropertiesOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getReadPropertiesOperation()
		 * @generated
		 */
		EClass READ_PROPERTIES_OPERATION = eINSTANCE.getReadPropertiesOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveGroupMemberOperationImpl <em>Remove Group Member Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveGroupMemberOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveGroupMemberOperation()
		 * @generated
		 */
		EClass REMOVE_GROUP_MEMBER_OPERATION = eINSTANCE.getRemoveGroupMemberOperation();

		/**
		 * The meta object literal for the '<em><b>Member Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOVE_GROUP_MEMBER_OPERATION__MEMBER_ID = eINSTANCE.getRemoveGroupMemberOperation_MemberId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveRoleOperationImpl <em>Remove Role Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveRoleOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveRoleOperation()
		 * @generated
		 */
		EClass REMOVE_ROLE_OPERATION = eINSTANCE.getRemoveRoleOperation();

		/**
		 * The meta object literal for the '<em><b>Role Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOVE_ROLE_OPERATION__ROLE_ID = eINSTANCE.getRemoveRoleOperation_RoleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.RemoveTagOperationImpl <em>Remove Tag Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.RemoveTagOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getRemoveTagOperation()
		 * @generated
		 */
		EClass REMOVE_TAG_OPERATION = eINSTANCE.getRemoveTagOperation();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_TAG_OPERATION__TAG = eINSTANCE.getRemoveTagOperation_Tag();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.WritePropertiesOperationImpl <em>Write Properties Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.WritePropertiesOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getWritePropertiesOperation()
		 * @generated
		 */
		EClass WRITE_PROPERTIES_OPERATION = eINSTANCE.getWritePropertiesOperation();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_PROPERTIES_OPERATION__PROPERTIES = eINSTANCE.getWritePropertiesOperation_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectOperationImpl <em>Create Project Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.CreateProjectOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getCreateProjectOperation()
		 * @generated
		 */
		EClass CREATE_PROJECT_OPERATION = eINSTANCE.getCreateProjectOperation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_PROJECT_OPERATION__DESCRIPTION = eINSTANCE.getCreateProjectOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_PROJECT_OPERATION__PROJECT = eINSTANCE.getCreateProjectOperation_Project();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_PROJECT_OPERATION__LOG_MESSAGE = eINSTANCE.getCreateProjectOperation_LogMessage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_PROJECT_OPERATION__NAME = eINSTANCE.getCreateProjectOperation_Name();

		/**
		 * The meta object literal for the '<em>Void</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Void
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getVoid()
		 * @generated
		 */
		EDataType VOID = eINSTANCE.getVoid();

		/**
		 * The meta object literal for the '<em>File Transfer Information</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileTransferInformation()
		 * @generated
		 */
		EDataType FILE_TRANSFER_INFORMATION = eINSTANCE.getFileTransferInformation();

		/**
		 * The meta object literal for the '<em>File Chunk</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.common.filetransfer.FileChunk
		 * @see org.eclipse.emf.emfstore.server.model.operation.impl.OperationPackageImpl#getFileChunk()
		 * @generated
		 */
		EDataType FILE_CHUNK = eINSTANCE.getFileChunk();

	}

} //OperationPackage
