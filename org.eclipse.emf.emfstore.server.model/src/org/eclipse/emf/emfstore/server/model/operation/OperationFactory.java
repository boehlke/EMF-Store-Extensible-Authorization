/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage
 * @generated
 */
public interface OperationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationFactory eINSTANCE = org.eclipse.emf.emfstore.server.model.operation.impl.OperationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	<T> Operation<T> createOperation();

	/**
	 * Returns a new object of class '<em>User Management Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Management Operation</em>'.
	 * @generated
	 */
	<T> UserManagementOperation<T> createUserManagementOperation();

	/**
	 * Returns a new object of class '<em>Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Org Unit Operation</em>'.
	 * @generated
	 */
	<T> OrgUnitOperation<T> createOrgUnitOperation();

	/**
	 * Returns a new object of class '<em>Delete Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Org Unit Operation</em>'.
	 * @generated
	 */
	DeleteOrgUnitOperation createDeleteOrgUnitOperation();

	/**
	 * Returns a new object of class '<em>Add Group Member Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Group Member Operation</em>'.
	 * @generated
	 */
	AddGroupMemberOperation createAddGroupMemberOperation();

	/**
	 * Returns a new object of class '<em>Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Operation</em>'.
	 * @generated
	 */
	<T> ProjectOperation<T> createProjectOperation();

	/**
	 * Returns a new object of class '<em>Add Tag Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Tag Operation</em>'.
	 * @generated
	 */
	AddTagOperation createAddTagOperation();

	/**
	 * Returns a new object of class '<em>Assign Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Role Operation</em>'.
	 * @generated
	 */
	AssignRoleOperation createAssignRoleOperation();

	/**
	 * Returns a new object of class '<em>Create Group Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Group Operation</em>'.
	 * @generated
	 */
	CreateGroupOperation createCreateGroupOperation();

	/**
	 * Returns a new object of class '<em>Create Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Org Unit Operation</em>'.
	 * @generated
	 */
	<T> CreateOrgUnitOperation<T> createCreateOrgUnitOperation();

	/**
	 * Returns a new object of class '<em>Create Or Update Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Or Update Role Operation</em>'.
	 * @generated
	 */
	CreateOrUpdateRoleOperation createCreateOrUpdateRoleOperation();

	/**
	 * Returns a new object of class '<em>Create Project By Import Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Project By Import Operation</em>'.
	 * @generated
	 */
	CreateProjectByImportOperation createCreateProjectByImportOperation();

	/**
	 * Returns a new object of class '<em>Create User Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create User Operation</em>'.
	 * @generated
	 */
	CreateUserOperation createCreateUserOperation();

	/**
	 * Returns a new object of class '<em>Create Version Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Version Operation</em>'.
	 * @generated
	 */
	CreateVersionOperation createCreateVersionOperation();

	/**
	 * Returns a new object of class '<em>Delete Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Project Operation</em>'.
	 * @generated
	 */
	DeleteProjectOperation createDeleteProjectOperation();

	/**
	 * Returns a new object of class '<em>File Download Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Download Operation</em>'.
	 * @generated
	 */
	FileDownloadOperation createFileDownloadOperation();

	/**
	 * Returns a new object of class '<em>File Upload Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Upload Operation</em>'.
	 * @generated
	 */
	FileUploadOperation createFileUploadOperation();

	/**
	 * Returns a new object of class '<em>Read Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Org Unit Operation</em>'.
	 * @generated
	 */
	ReadOrgUnitOperation createReadOrgUnitOperation();

	/**
	 * Returns a new object of class '<em>Read Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Project Operation</em>'.
	 * @generated
	 */
	ReadProjectOperation createReadProjectOperation();

	/**
	 * Returns a new object of class '<em>Read Properties Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Properties Operation</em>'.
	 * @generated
	 */
	ReadPropertiesOperation createReadPropertiesOperation();

	/**
	 * Returns a new object of class '<em>Remove Group Member Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Group Member Operation</em>'.
	 * @generated
	 */
	RemoveGroupMemberOperation createRemoveGroupMemberOperation();

	/**
	 * Returns a new object of class '<em>Remove Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Role Operation</em>'.
	 * @generated
	 */
	RemoveRoleOperation createRemoveRoleOperation();

	/**
	 * Returns a new object of class '<em>Remove Tag Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Tag Operation</em>'.
	 * @generated
	 */
	RemoveTagOperation createRemoveTagOperation();

	/**
	 * Returns a new object of class '<em>Write Properties Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Properties Operation</em>'.
	 * @generated
	 */
	WritePropertiesOperation createWritePropertiesOperation();

	/**
	 * Returns a new object of class '<em>Create Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Project Operation</em>'.
	 * @generated
	 */
	CreateProjectOperation createCreateProjectOperation();

	/**
	 * Returns a new object of class '<em>Role Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Data</em>'.
	 * @generated
	 */
	RoleData createRoleData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationPackage getOperationPackage();

} //OperationFactory
