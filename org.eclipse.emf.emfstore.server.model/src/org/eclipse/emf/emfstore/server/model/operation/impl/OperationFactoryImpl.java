/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import java.util.Map;
import java.util.HashMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.operation.*;
import org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.OperationFactory;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.ProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.RoleContainer;
import org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation;
import org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationFactoryImpl extends EFactoryImpl implements OperationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperationFactory init() {
		try {
			OperationFactory theOperationFactory = (OperationFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/emf/emfstore/server/model/operation"); 
			if (theOperationFactory != null) {
				return theOperationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OperationPackage.OPERATION: return createOperation();
			case OperationPackage.USER_MANAGEMENT_OPERATION: return createUserManagementOperation();
			case OperationPackage.ORG_UNIT_OPERATION: return createOrgUnitOperation();
			case OperationPackage.DELETE_ORG_UNIT_OPERATION: return createDeleteOrgUnitOperation();
			case OperationPackage.ADD_GROUP_MEMBER_OPERATION: return createAddGroupMemberOperation();
			case OperationPackage.PROJECT_OPERATION: return createProjectOperation();
			case OperationPackage.ADD_TAG_OPERATION: return createAddTagOperation();
			case OperationPackage.CREATE_GROUP_OPERATION: return createCreateGroupOperation();
			case OperationPackage.CREATE_ORG_UNIT_OPERATION: return createCreateOrgUnitOperation();
			case OperationPackage.CREATE_OR_UPDATE_ROLE_OPERATION: return createCreateOrUpdateRoleOperation();
			case OperationPackage.CREATE_PROJECT_BY_IMPORT_OPERATION: return createCreateProjectByImportOperation();
			case OperationPackage.CREATE_USER_OPERATION: return createCreateUserOperation();
			case OperationPackage.CREATE_VERSION_OPERATION: return createCreateVersionOperation();
			case OperationPackage.DELETE_PROJECT_OPERATION: return createDeleteProjectOperation();
			case OperationPackage.FILE_DOWNLOAD_OPERATION: return createFileDownloadOperation();
			case OperationPackage.FILE_UPLOAD_OPERATION: return createFileUploadOperation();
			case OperationPackage.READ_ORG_UNIT_OPERATION: return createReadOrgUnitOperation();
			case OperationPackage.READ_PROJECT_OPERATION: return createReadProjectOperation();
			case OperationPackage.READ_PROPERTIES_OPERATION: return createReadPropertiesOperation();
			case OperationPackage.REMOVE_GROUP_MEMBER_OPERATION: return createRemoveGroupMemberOperation();
			case OperationPackage.REMOVE_TAG_OPERATION: return createRemoveTagOperation();
			case OperationPackage.WRITE_PROPERTIES_OPERATION: return createWritePropertiesOperation();
			case OperationPackage.CREATE_PROJECT_OPERATION: return createCreateProjectOperation();
			case OperationPackage.ROLE_CONTAINER: return createRoleContainer();
			case OperationPackage.ORG_UNIT_ROLE_OPERATION: return createOrgUnitRoleOperation();
			case OperationPackage.SET_ORG_UNIT_PROPERTY_OPERATION: return createSetOrgUnitPropertyOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OperationPackage.VOID:
				return createVoidFromString(eDataType, initialValue);
			case OperationPackage.FILE_TRANSFER_INFORMATION:
				return createFileTransferInformationFromString(eDataType, initialValue);
			case OperationPackage.FILE_CHUNK:
				return createFileChunkFromString(eDataType, initialValue);
			case OperationPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OperationPackage.VOID:
				return convertVoidToString(eDataType, instanceValue);
			case OperationPackage.FILE_TRANSFER_INFORMATION:
				return convertFileTransferInformationToString(eDataType, instanceValue);
			case OperationPackage.FILE_CHUNK:
				return convertFileChunkToString(eDataType, instanceValue);
			case OperationPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> Operation<T> createOperation() {
		OperationImpl<T> operation = new OperationImpl<T>();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> UserManagementOperation<T> createUserManagementOperation() {
		UserManagementOperationImpl<T> userManagementOperation = new UserManagementOperationImpl<T>();
		return userManagementOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> OrgUnitOperation<T> createOrgUnitOperation() {
		OrgUnitOperationImpl<T> orgUnitOperation = new OrgUnitOperationImpl<T>();
		return orgUnitOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteOrgUnitOperation createDeleteOrgUnitOperation() {
		DeleteOrgUnitOperationImpl deleteOrgUnitOperation = new DeleteOrgUnitOperationImpl();
		return deleteOrgUnitOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddGroupMemberOperation createAddGroupMemberOperation() {
		AddGroupMemberOperationImpl addGroupMemberOperation = new AddGroupMemberOperationImpl();
		return addGroupMemberOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ProjectOperation<T> createProjectOperation() {
		ProjectOperationImpl<T> projectOperation = new ProjectOperationImpl<T>();
		return projectOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddTagOperation createAddTagOperation() {
		AddTagOperationImpl addTagOperation = new AddTagOperationImpl();
		return addTagOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateGroupOperation createCreateGroupOperation() {
		CreateGroupOperationImpl createGroupOperation = new CreateGroupOperationImpl();
		return createGroupOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> CreateOrgUnitOperation<T> createCreateOrgUnitOperation() {
		CreateOrgUnitOperationImpl<T> createOrgUnitOperation = new CreateOrgUnitOperationImpl<T>();
		return createOrgUnitOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateOrUpdateRoleOperation createCreateOrUpdateRoleOperation() {
		CreateOrUpdateRoleOperationImpl createOrUpdateRoleOperation = new CreateOrUpdateRoleOperationImpl();
		return createOrUpdateRoleOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateProjectByImportOperation createCreateProjectByImportOperation() {
		CreateProjectByImportOperationImpl createProjectByImportOperation = new CreateProjectByImportOperationImpl();
		return createProjectByImportOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateUserOperation createCreateUserOperation() {
		CreateUserOperationImpl createUserOperation = new CreateUserOperationImpl();
		return createUserOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateVersionOperation createCreateVersionOperation() {
		CreateVersionOperationImpl createVersionOperation = new CreateVersionOperationImpl();
		return createVersionOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteProjectOperation createDeleteProjectOperation() {
		DeleteProjectOperationImpl deleteProjectOperation = new DeleteProjectOperationImpl();
		return deleteProjectOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileDownloadOperation createFileDownloadOperation() {
		FileDownloadOperationImpl fileDownloadOperation = new FileDownloadOperationImpl();
		return fileDownloadOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileUploadOperation createFileUploadOperation() {
		FileUploadOperationImpl fileUploadOperation = new FileUploadOperationImpl();
		return fileUploadOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadOrgUnitOperation createReadOrgUnitOperation() {
		ReadOrgUnitOperationImpl readOrgUnitOperation = new ReadOrgUnitOperationImpl();
		return readOrgUnitOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadProjectOperation createReadProjectOperation() {
		ReadProjectOperationImpl readProjectOperation = new ReadProjectOperationImpl();
		return readProjectOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadPropertiesOperation createReadPropertiesOperation() {
		ReadPropertiesOperationImpl readPropertiesOperation = new ReadPropertiesOperationImpl();
		return readPropertiesOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveGroupMemberOperation createRemoveGroupMemberOperation() {
		RemoveGroupMemberOperationImpl removeGroupMemberOperation = new RemoveGroupMemberOperationImpl();
		return removeGroupMemberOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveTagOperation createRemoveTagOperation() {
		RemoveTagOperationImpl removeTagOperation = new RemoveTagOperationImpl();
		return removeTagOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WritePropertiesOperation createWritePropertiesOperation() {
		WritePropertiesOperationImpl writePropertiesOperation = new WritePropertiesOperationImpl();
		return writePropertiesOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateProjectOperation createCreateProjectOperation() {
		CreateProjectOperationImpl createProjectOperation = new CreateProjectOperationImpl();
		return createProjectOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleContainer createRoleContainer() {
		RoleContainerImpl roleContainer = new RoleContainerImpl();
		return roleContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnitRoleOperation createOrgUnitRoleOperation() {
		OrgUnitRoleOperationImpl orgUnitRoleOperation = new OrgUnitRoleOperationImpl();
		return orgUnitRoleOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetOrgUnitPropertyOperation createSetOrgUnitPropertyOperation() {
		SetOrgUnitPropertyOperationImpl setOrgUnitPropertyOperation = new SetOrgUnitPropertyOperationImpl();
		return setOrgUnitPropertyOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Void createVoidFromString(EDataType eDataType, String initialValue) {
		return (Void)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVoidToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTransferInformation createFileTransferInformationFromString(EDataType eDataType, String initialValue) {
		return (FileTransferInformation)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileTransferInformationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileChunk createFileChunkFromString(EDataType eDataType, String initialValue) {
		return (FileChunk)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileChunkToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationPackage getOperationPackage() {
		return (OperationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationPackage getPackage() {
		return OperationPackage.eINSTANCE;
	}

} // OperationFactoryImpl
