package org.eclipse.emf.emfstore.server.connection.xmlrpc.util;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
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
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.RoleContainer;
import org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

public class StaticOperationFactory {

	private static void checkNotNull(Object... params) throws InvalidInputException {
		for (Object object : params) {
			if (object == null) {
				throw new InvalidInputException();
			}
		}
	}

	public static Operation<?> createReadProjectOperation(ProjectId projectId, PrimaryVersionSpec target)
		throws InvalidInputException {
		checkNotNull(projectId);
		ReadProjectOperation op = OperationFactory.eINSTANCE.createReadProjectOperation();
		op.setProjectId(projectId.getId());
		op.setVersionSpec(EcoreUtil.copy(target));
		return op;
	}

	public static AddTagOperation createAddTagOperation(ProjectId projectId, PrimaryVersionSpec versionSpec,
		TagVersionSpec tag) throws InvalidInputException {
		checkNotNull(versionSpec, tag);
		AddTagOperation op = OperationFactory.eINSTANCE.createAddTagOperation();
		op.setProjectId(projectId.getId());
		op.setTag(tag);
		op.setVersionSpec(versionSpec);
		return op;
	}

	public static RemoveTagOperation createRemoveTagOperation(ProjectId projectId, PrimaryVersionSpec versionSpec,
		TagVersionSpec tag) throws InvalidInputException {
		checkNotNull(tag, projectId);
		RemoveTagOperation op = OperationFactory.eINSTANCE.createRemoveTagOperation();
		op.setTag(EcoreUtil.copy(tag));
		op.setProjectId(projectId.getId());
		return op;
	}

	public static CreateProjectOperation createCreateProjectOperation(String name, String description,
		LogMessage logMessage, Project project) throws InvalidInputException {
		checkNotNull(logMessage, name);
		CreateProjectOperation op = OperationFactory.eINSTANCE.createCreateProjectOperation();
		op.setProject(project);
		op.setLogMessage(logMessage);
		op.setDescription(description);
		op.setName(name);
		return op;
	}

	public static DeleteProjectOperation createDeleteProjectOperation(ProjectId projectId, boolean deleteFiles)
		throws InvalidInputException {
		checkNotNull(projectId);
		DeleteProjectOperation op = OperationFactory.eINSTANCE.createDeleteProjectOperation();
		op.setProjectId(projectId.getId());
		op.setDeleteFiles(deleteFiles);
		return op;
	}

	public static Operation<?> createReadProjectOperation(ProjectId projectId, VersionSpec target)
		throws InvalidInputException {
		checkNotNull(target, projectId);
		ReadProjectOperation op = OperationFactory.eINSTANCE.createReadProjectOperation();
		op.setProjectId(projectId.getId());
		return op;
	}

	public static CreateVersionOperation createCreateVersionOperation(ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws InvalidInputException {
		checkNotNull(baseVersionSpec, changePackage, logMessage, projectId);
		CreateVersionOperation op = OperationFactory.eINSTANCE.createCreateVersionOperation();
		op.setBaseVersion(baseVersionSpec);
		op.setChangePackage(changePackage);
		op.setLogMessage(logMessage);
		op.setProjectId(projectId.getId());
		return op;
	}

	public static CreateProjectByImportOperation createCreateProjectByImportOperation(ProjectHistory projectHistory)
		throws InvalidInputException {
		checkNotNull(projectHistory);
		CreateProjectByImportOperation op = OperationFactory.eINSTANCE.createCreateProjectByImportOperation();
		op.setProjectHistory(projectHistory);
		return op;
	}

	public static ReadOrgUnitOperation createReadOrgUnitOperation(String id) throws InvalidInputException {
		checkNotNull(id);
		ReadOrgUnitOperation op = OperationFactory.eINSTANCE.createReadOrgUnitOperation();
		op.setOrgUnitId(id);
		return op;
	}

	public static Operation<?> createFileDownloadOperation(ProjectId projectId, FileTransferInformation fileInformation)
		throws InvalidInputException {
		checkNotNull(projectId, fileInformation);
		FileDownloadOperation op = OperationFactory.eINSTANCE.createFileDownloadOperation();
		op.setFileInformation(fileInformation);
		op.setProjectId(projectId.getId());
		return op;
	}

	public static FileUploadOperation createFileUploadOperation(ProjectId projectId, FileChunk fileChunk)
		throws InvalidInputException {
		checkNotNull(fileChunk, projectId);
		FileUploadOperation op = OperationFactory.eINSTANCE.createFileUploadOperation();
		op.setProjectId(projectId.getId());
		op.setFileChunk(fileChunk);
		return op;
	}

	public static Operation<?> createReadPropertiesOperation(ProjectId projectId) throws InvalidInputException {
		checkNotNull(projectId);
		ReadPropertiesOperation op = OperationFactory.eINSTANCE.createReadPropertiesOperation();
		op.setProjectId(projectId.getId());
		return op;
	}

	public static WritePropertiesOperation createWritePropertiesOperation(ProjectId projectId,
		List<EMFStoreProperty> properties) throws InvalidInputException {
		checkNotNull(projectId, properties);
		WritePropertiesOperation op = OperationFactory.eINSTANCE.createWritePropertiesOperation();
		op.setProjectId(projectId.getId());
		op.getProperties().addAll(properties);
		return op;
	}

	public static OrgUnitRoleOperation createAssignRoleOperation(String orgUnitId, String roleId, String id)
		throws InvalidInputException {
		checkNotNull(orgUnitId, roleId, id);
		OrgUnitRoleOperation op = OperationFactory.eINSTANCE.createOrgUnitRoleOperation();
		op.setAssign(true);
		op.setOrgUnitId(orgUnitId);
		op.setProjectId(id);
		op.setRoleId(roleId);
		return op;
	}

	public static CreateOrUpdateRoleOperation createCreateOrUpdateRoleOperation(String roleId, String roleName,
		String roleDescription, PermissionSet permissionSet, String... permissionTypeIds) throws InvalidInputException {
		checkNotNull(roleId, roleName, permissionSet);

		RoleContainer container = OperationFactory.eINSTANCE.createRoleContainer();

		for (String pType : permissionTypeIds) {
			PermissionType permissionType = permissionSet.getPermissionType(pType);
			if (permissionType == null) {
				throw new RuntimeException("no such permission type '" + pType + "'");
			}
			container.getPermissionTypes().add(EcoreUtil.copy(permissionType));
		}

		Role role = AccesscontrolFactory.eINSTANCE.createRole();
		container.setRole(role);
		role.setDescription(roleDescription);
		role.setName(roleName);
		role.setId(roleId);
		role.getPermissionTypes().addAll(container.getPermissionTypes());

		CreateOrUpdateRoleOperation op = OperationFactory.eINSTANCE.createCreateOrUpdateRoleOperation();
		op.setRole(container);
		return op;
	}

	public static CreateUserOperation createCreateUserOperation(String username) throws InvalidInputException {
		checkNotNull(username);
		CreateUserOperation op = OperationFactory.eINSTANCE.createCreateUserOperation();
		op.setName(username);
		return op;
	}

	public static CreateGroupOperation createCreateGroupOperation(String name) throws InvalidInputException {
		checkNotNull(name);
		CreateGroupOperation op = OperationFactory.eINSTANCE.createCreateGroupOperation();
		op.setName(name);
		return op;
	}

	public static DeleteOrgUnitOperation createDeleteOrgUnitOperation(ACOrgUnitId id) throws InvalidInputException {
		checkNotNull(id);
		DeleteOrgUnitOperation op = OperationFactory.eINSTANCE.createDeleteOrgUnitOperation();
		op.setOrgUnitId(id.getId());
		return op;
	}

	public static OrgUnitRoleOperation createRemoveRoleOperation(ACOrgUnitId orgUnitId, String roleId,
		ProjectId projectId) throws InvalidInputException {
		checkNotNull(roleId);
		OrgUnitRoleOperation op = OperationFactory.eINSTANCE.createOrgUnitRoleOperation();
		op.setAssign(false);
		op.setOrgUnitId(orgUnitId.getId());
		op.setRoleId(roleId);
		if (projectId != null) {
			op.setProjectId(projectId.getId());
		}
		return null;
	}
}
