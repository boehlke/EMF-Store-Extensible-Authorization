/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.emf.emfstore.server.model.operation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage
 * @generated
 */
public class OperationSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OperationPackage.OPERATION: {
				Operation<?> operation = (Operation<?>)theEObject;
				T1 result = caseOperation(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.USER_MANAGEMENT_OPERATION: {
				UserManagementOperation<?> userManagementOperation = (UserManagementOperation<?>)theEObject;
				T1 result = caseUserManagementOperation(userManagementOperation);
				if (result == null) result = caseOperation(userManagementOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.ORG_UNIT_OPERATION: {
				OrgUnitOperation<?> orgUnitOperation = (OrgUnitOperation<?>)theEObject;
				T1 result = caseOrgUnitOperation(orgUnitOperation);
				if (result == null) result = caseUserManagementOperation(orgUnitOperation);
				if (result == null) result = caseOperation(orgUnitOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.DELETE_ORG_UNIT_OPERATION: {
				DeleteOrgUnitOperation deleteOrgUnitOperation = (DeleteOrgUnitOperation)theEObject;
				T1 result = caseDeleteOrgUnitOperation(deleteOrgUnitOperation);
				if (result == null) result = caseOrgUnitOperation(deleteOrgUnitOperation);
				if (result == null) result = caseUserManagementOperation(deleteOrgUnitOperation);
				if (result == null) result = caseOperation(deleteOrgUnitOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.ADD_GROUP_MEMBER_OPERATION: {
				AddGroupMemberOperation addGroupMemberOperation = (AddGroupMemberOperation)theEObject;
				T1 result = caseAddGroupMemberOperation(addGroupMemberOperation);
				if (result == null) result = caseOrgUnitOperation(addGroupMemberOperation);
				if (result == null) result = caseUserManagementOperation(addGroupMemberOperation);
				if (result == null) result = caseOperation(addGroupMemberOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.PROJECT_OPERATION: {
				ProjectOperation<?> projectOperation = (ProjectOperation<?>)theEObject;
				T1 result = caseProjectOperation(projectOperation);
				if (result == null) result = caseOperation(projectOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.ADD_TAG_OPERATION: {
				AddTagOperation addTagOperation = (AddTagOperation)theEObject;
				T1 result = caseAddTagOperation(addTagOperation);
				if (result == null) result = caseProjectOperation(addTagOperation);
				if (result == null) result = caseOperation(addTagOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.ASSIGN_ROLE_OPERATION: {
				AssignRoleOperation assignRoleOperation = (AssignRoleOperation)theEObject;
				T1 result = caseAssignRoleOperation(assignRoleOperation);
				if (result == null) result = caseOrgUnitOperation(assignRoleOperation);
				if (result == null) result = caseUserManagementOperation(assignRoleOperation);
				if (result == null) result = caseOperation(assignRoleOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_GROUP_OPERATION: {
				CreateGroupOperation createGroupOperation = (CreateGroupOperation)theEObject;
				T1 result = caseCreateGroupOperation(createGroupOperation);
				if (result == null) result = caseCreateOrgUnitOperation(createGroupOperation);
				if (result == null) result = caseUserManagementOperation(createGroupOperation);
				if (result == null) result = caseOperation(createGroupOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_ORG_UNIT_OPERATION: {
				CreateOrgUnitOperation<?> createOrgUnitOperation = (CreateOrgUnitOperation<?>)theEObject;
				T1 result = caseCreateOrgUnitOperation(createOrgUnitOperation);
				if (result == null) result = caseUserManagementOperation(createOrgUnitOperation);
				if (result == null) result = caseOperation(createOrgUnitOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION: {
				CreateOrUpdateRoleOperation createOrUpdateRoleOperation = (CreateOrUpdateRoleOperation)theEObject;
				T1 result = caseCreateOrUpdateRoleOperation(createOrUpdateRoleOperation);
				if (result == null) result = caseUserManagementOperation(createOrUpdateRoleOperation);
				if (result == null) result = caseOperation(createOrUpdateRoleOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION: {
				CreateProjectByImportOperation createProjectByImportOperation = (CreateProjectByImportOperation)theEObject;
				T1 result = caseCreateProjectByImportOperation(createProjectByImportOperation);
				if (result == null) result = caseOperation(createProjectByImportOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_USER_OPERATION: {
				CreateUserOperation createUserOperation = (CreateUserOperation)theEObject;
				T1 result = caseCreateUserOperation(createUserOperation);
				if (result == null) result = caseCreateOrgUnitOperation(createUserOperation);
				if (result == null) result = caseUserManagementOperation(createUserOperation);
				if (result == null) result = caseOperation(createUserOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_VERSION_OPERATION: {
				CreateVersionOperation createVersionOperation = (CreateVersionOperation)theEObject;
				T1 result = caseCreateVersionOperation(createVersionOperation);
				if (result == null) result = caseProjectOperation(createVersionOperation);
				if (result == null) result = caseOperation(createVersionOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.DELETE_PROJECT_OPERATION: {
				DeleteProjectOperation deleteProjectOperation = (DeleteProjectOperation)theEObject;
				T1 result = caseDeleteProjectOperation(deleteProjectOperation);
				if (result == null) result = caseProjectOperation(deleteProjectOperation);
				if (result == null) result = caseOperation(deleteProjectOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.FILE_DOWNLOAD_OPERATION: {
				FileDownloadOperation fileDownloadOperation = (FileDownloadOperation)theEObject;
				T1 result = caseFileDownloadOperation(fileDownloadOperation);
				if (result == null) result = caseProjectOperation(fileDownloadOperation);
				if (result == null) result = caseOperation(fileDownloadOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.FILE_UPLOAD_OPERATION: {
				FileUploadOperation fileUploadOperation = (FileUploadOperation)theEObject;
				T1 result = caseFileUploadOperation(fileUploadOperation);
				if (result == null) result = caseProjectOperation(fileUploadOperation);
				if (result == null) result = caseOperation(fileUploadOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.READ_ORG_UNIT_OPERATION: {
				ReadOrgUnitOperation readOrgUnitOperation = (ReadOrgUnitOperation)theEObject;
				T1 result = caseReadOrgUnitOperation(readOrgUnitOperation);
				if (result == null) result = caseOrgUnitOperation(readOrgUnitOperation);
				if (result == null) result = caseUserManagementOperation(readOrgUnitOperation);
				if (result == null) result = caseOperation(readOrgUnitOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.READ_PROJECT_OPERATION: {
				ReadProjectOperation readProjectOperation = (ReadProjectOperation)theEObject;
				T1 result = caseReadProjectOperation(readProjectOperation);
				if (result == null) result = caseProjectOperation(readProjectOperation);
				if (result == null) result = caseOperation(readProjectOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.READ_PROPERTIES_OPERATION: {
				ReadPropertiesOperation readPropertiesOperation = (ReadPropertiesOperation)theEObject;
				T1 result = caseReadPropertiesOperation(readPropertiesOperation);
				if (result == null) result = caseProjectOperation(readPropertiesOperation);
				if (result == null) result = caseOperation(readPropertiesOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.REMOVE_GROUP_MEMBER_OPERATION: {
				RemoveGroupMemberOperation removeGroupMemberOperation = (RemoveGroupMemberOperation)theEObject;
				T1 result = caseRemoveGroupMemberOperation(removeGroupMemberOperation);
				if (result == null) result = caseOrgUnitOperation(removeGroupMemberOperation);
				if (result == null) result = caseUserManagementOperation(removeGroupMemberOperation);
				if (result == null) result = caseOperation(removeGroupMemberOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.REMOVE_ROLE_OPERATION: {
				RemoveRoleOperation removeRoleOperation = (RemoveRoleOperation)theEObject;
				T1 result = caseRemoveRoleOperation(removeRoleOperation);
				if (result == null) result = caseOrgUnitOperation(removeRoleOperation);
				if (result == null) result = caseUserManagementOperation(removeRoleOperation);
				if (result == null) result = caseOperation(removeRoleOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.REMOVE_TAG_OPERATION: {
				RemoveTagOperation removeTagOperation = (RemoveTagOperation)theEObject;
				T1 result = caseRemoveTagOperation(removeTagOperation);
				if (result == null) result = caseProjectOperation(removeTagOperation);
				if (result == null) result = caseOperation(removeTagOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.WRITE_PROPERTIES_OPERATION: {
				WritePropertiesOperation writePropertiesOperation = (WritePropertiesOperation)theEObject;
				T1 result = caseWritePropertiesOperation(writePropertiesOperation);
				if (result == null) result = caseProjectOperation(writePropertiesOperation);
				if (result == null) result = caseOperation(writePropertiesOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CREATE_PROJECT_OPERATION: {
				CreateProjectOperation createProjectOperation = (CreateProjectOperation)theEObject;
				T1 result = caseCreateProjectOperation(createProjectOperation);
				if (result == null) result = caseOperation(createProjectOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.ROLE_CONTAINER: {
				RoleContainer roleContainer = (RoleContainer)theEObject;
				T1 result = caseRoleContainer(roleContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseOperation(Operation<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Management Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Management Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseUserManagementOperation(UserManagementOperation<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Org Unit Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseOrgUnitOperation(OrgUnitOperation<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Org Unit Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDeleteOrgUnitOperation(DeleteOrgUnitOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Group Member Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Group Member Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAddGroupMemberOperation(AddGroupMemberOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseProjectOperation(ProjectOperation<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Tag Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Tag Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAddTagOperation(AddTagOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Role Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssignRoleOperation(AssignRoleOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Group Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Group Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateGroupOperation(CreateGroupOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Org Unit Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseCreateOrgUnitOperation(CreateOrgUnitOperation<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Or Update Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Or Update Role Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateOrUpdateRoleOperation(CreateOrUpdateRoleOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Project By Import Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Project By Import Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateProjectByImportOperation(CreateProjectByImportOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create User Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create User Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateUserOperation(CreateUserOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Version Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Version Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateVersionOperation(CreateVersionOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Project Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDeleteProjectOperation(DeleteProjectOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Download Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Download Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFileDownloadOperation(FileDownloadOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Upload Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Upload Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFileUploadOperation(FileUploadOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Org Unit Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Org Unit Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReadOrgUnitOperation(ReadOrgUnitOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Project Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReadProjectOperation(ReadProjectOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Properties Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Properties Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReadPropertiesOperation(ReadPropertiesOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Group Member Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Group Member Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRemoveGroupMemberOperation(RemoveGroupMemberOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Role Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Role Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRemoveRoleOperation(RemoveRoleOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Tag Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Tag Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRemoveTagOperation(RemoveTagOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write Properties Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write Properties Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWritePropertiesOperation(WritePropertiesOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Project Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Project Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCreateProjectOperation(CreateProjectOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRoleContainer(RoleContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //OperationSwitch
