package org.eclipse.emf.emfstore.client.model.util;

import java.util.List;

import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidVersionSpecException;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * EMF store interface
 * 
 * @author boehlke
 * 
 */
public interface EmfStoreInterface {

	List<ProjectInfo> getProjectList() throws EmfStoreException;

	Project getProject(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException;

	PrimaryVersionSpec createVersion(ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
		ChangePackage changePackage, LogMessage logMessage) throws EmfStoreException, InvalidVersionSpecException;

	PrimaryVersionSpec resolveVersionSpec(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException;

	List<ChangePackage> getChanges(ProjectId projectId, VersionSpec source, VersionSpec target)
		throws EmfStoreException;

	List<HistoryInfo> getHistoryInfo(ProjectId projectId, HistoryQuery historyQuery) throws EmfStoreException;

	void addTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException;

	void removeTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException;

	ProjectInfo createEmptyProject(String name, String description, LogMessage logMessage) throws EmfStoreException;

	ProjectInfo createProject(String name, String description, LogMessage logMessage, Project project)
		throws EmfStoreException;

	void deleteProject(ProjectId projectId, boolean deleteFiles) throws EmfStoreException;

	ACUser resolveUser(ACOrgUnitId id) throws EmfStoreException;

	ProjectId importProjectHistoryToServer(ProjectHistory projectHistory) throws EmfStoreException;

	ProjectHistory exportProjectHistoryFromServer(ProjectId projectId) throws EmfStoreException;

	FileTransferInformation uploadFileChunk(ProjectId projectId, FileChunk fileChunk) throws EmfStoreException;

	FileChunk downloadFileChunk(ProjectId projectId, FileTransferInformation fileInformation) throws EmfStoreException;

	void transmitProperty(OrgUnitProperty changedProperty, ACUser tmpUser, ProjectId projectId)
		throws EmfStoreException;

	void transmitEMFProperties(List<EMFStoreProperty> property, ProjectId projectId) throws EmfStoreException;

	List<EMFStoreProperty> getEMFProperties(ProjectId projectId) throws EmfStoreException;

	PermissionSet getPermissionSet() throws EmfStoreException;

	<T> T executeOperation(Operation<T> op) throws EmfStoreException;

	List<Permission[]> getOperationPermissions(Operation<?>[] operations) throws EmfStoreException;

}
