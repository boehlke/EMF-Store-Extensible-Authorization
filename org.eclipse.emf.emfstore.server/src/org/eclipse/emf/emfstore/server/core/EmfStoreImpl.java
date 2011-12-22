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
package org.eclipse.emf.emfstore.server.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.OperationExecution;
import org.eclipse.emf.emfstore.server.OperationExecution.OperationExecutionContext;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.InternalPermission;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.core.operation.OperationExecutor;
import org.eclipse.emf.emfstore.server.core.operation.OperationHandler;
import org.eclipse.emf.emfstore.server.core.operation.OrgUnitOperationExecutor;
import org.eclipse.emf.emfstore.server.core.subinterfaces.EMFStorePropertiesSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.FileTransferSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.HistorySubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.ProjectPropertiesSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.ProjectSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.UserSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.core.subinterfaces.VersionSubInterfaceImpl;
import org.eclipse.emf.emfstore.server.eventmanager.EventHelper;
import org.eclipse.emf.emfstore.server.eventmanager.EventManager;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidVersionSpecException;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * This is the main implementation of {@link EmfStore}.
 * 
 * @author wesendon
 * @see EmfStore
 */
public class EmfStoreImpl extends AbstractEmfstoreInterface implements EmfStore {

	/**
	 * list of operation executors
	 */
	private List<OperationExecutor> executors = new ArrayList<OperationExecutor>();

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the serverspace
	 * @param authorizationControl
	 *            the accesscontrol
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public EmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);

		executors.add(new OrgUnitOperationExecutor(serverSpace, authorizationControl));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initSubInterfaces() throws FatalEmfStoreException {
		addSubInterface(new HistorySubInterfaceImpl(this));
		addSubInterface(new ProjectSubInterfaceImpl(this));
		addSubInterface(new UserSubInterfaceImpl(this));
		addSubInterface(new VersionSubInterfaceImpl(this));
		addSubInterface(new FileTransferSubInterfaceImpl(this));
		addSubInterface(new ProjectPropertiesSubInterfaceImpl(this));
		addSubInterface(new EMFStorePropertiesSubInterfaceImpl(this));
	}

	private void checkOperationPermissions(SessionId sessionId, Operation<?> op) throws AccessControlException {
		getAuthorizationControl().checkPermissions(sessionId, op);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId, HistoryQuery historyQuery)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, historyQuery);

		checkOperationPermissions(sessionId,
			StaticOperationFactory.createReadProjectOperation(projectId, historyQuery.getTarget()));

		return getSubInterface(HistorySubInterfaceImpl.class).getHistoryInfo(projectId, historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec, tag, tag == null ? null : tag.getName());

		AddTagOperation operation = StaticOperationFactory.createAddTagOperation(projectId, versionSpec, tag);
		checkOperationPermissions(sessionId, operation);

		getSubInterface(HistorySubInterfaceImpl.class).addTag(projectId, versionSpec, tag);

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec, tag);

		RemoveTagOperation operation = StaticOperationFactory.createRemoveTagOperation(projectId, versionSpec, tag);
		checkOperationPermissions(sessionId, operation);

		getSubInterface(HistorySubInterfaceImpl.class).removeTag(projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionId, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, name, description, logMessage);

		CreateProjectOperation operation = StaticOperationFactory.createCreateProjectOperation(name, description,
			logMessage, null);
		checkOperationPermissions(sessionId, operation);

		ProjectInfo projectInfo = getSubInterface(ProjectSubInterfaceImpl.class).createProject(name, description,
			logMessage);

		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name, String description, LogMessage logMessage,
		Project project) throws EmfStoreException {
		sanityCheckObjects(sessionId, name, description, logMessage, project);

		CreateProjectOperation operation = StaticOperationFactory.createCreateProjectOperation(name, description,
			logMessage, project);
		checkOperationPermissions(sessionId, operation);

		ProjectInfo projectInfo = getSubInterface(ProjectSubInterfaceImpl.class).createProject(name, description,
			logMessage, project);

		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId, boolean deleteFiles) throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId);

		DeleteProjectOperation operation = StaticOperationFactory.createDeleteProjectOperation(projectId, deleteFiles);
		checkOperationPermissions(sessionId, operation);

		getSubInterface(ProjectSubInterfaceImpl.class).deleteProject(projectId, deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException, InvalidVersionSpecException {
		sanityCheckObjects(sessionId, projectId, baseVersionSpec, changePackage, logMessage);

		CreateVersionOperation operation = StaticOperationFactory.createCreateVersionOperation(projectId,
			baseVersionSpec, changePackage, logMessage);
		checkOperationPermissions(sessionId, operation);

		ACUser user = getAuthorizationControl().resolveUser(sessionId);
		PrimaryVersionSpec newVersion = getSubInterface(VersionSubInterfaceImpl.class).createVersion(projectId,
			baseVersionSpec, changePackage, logMessage, user);
		EventManager.getInstance().sendEvent(EventHelper.createUpdatedProjectEvent(projectId, newVersion));

		return newVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId, VersionSpec source,
		VersionSpec target) throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, source, target);

		checkOperationPermissions(sessionId, StaticOperationFactory.createReadProjectOperation(projectId, target));

		return getSubInterface(VersionSubInterfaceImpl.class).getChanges(projectId, source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec);

		checkOperationPermissions(sessionId, StaticOperationFactory.createReadProjectOperation(projectId, versionSpec));

		return getSubInterface(VersionSubInterfaceImpl.class).resolveVersionSpec(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, versionSpec);

		checkOperationPermissions(sessionId, StaticOperationFactory.createReadProjectOperation(projectId, versionSpec));

		return getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		sanityCheckObjects(sessionId);
		return getSubInterface(ProjectSubInterfaceImpl.class).getProjectList(sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId, ProjectHistory projectHistory)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectHistory);

		CreateProjectByImportOperation operation = StaticOperationFactory
			.createCreateProjectByImportOperation(projectHistory);
		checkOperationPermissions(sessionId, operation);

		ProjectId projectId = getSubInterface(ProjectSubInterfaceImpl.class).importProjectHistoryToServer(
			projectHistory);

		return projectId;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId);

		checkOperationPermissions(sessionId, StaticOperationFactory.createReadProjectOperation(projectId, null));

		return getSubInterface(ProjectSubInterfaceImpl.class).exportProjectHistoryFromServer(projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		sanityCheckObjects(sessionId);
		return getSubInterface(UserSubInterfaceImpl.class).resolveUser(sessionId, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId, FileTransferInformation fileInformation)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, fileInformation);

		checkOperationPermissions(sessionId,
			StaticOperationFactory.createFileDownloadOperation(projectId, fileInformation));

		return getSubInterface(FileTransferSubInterfaceImpl.class).readChunk(projectId, fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileTransferInformation uploadFileChunk(SessionId sessionId, ProjectId projectId, FileChunk fileChunk)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId, fileChunk, fileChunk.getFileInformation());

		FileUploadOperation operation = StaticOperationFactory.createFileUploadOperation(projectId, fileChunk);
		checkOperationPermissions(sessionId, operation);

		FileTransferInformation chunk = getSubInterface(FileTransferSubInterfaceImpl.class).writeChunk(fileChunk,
			projectId);

		return chunk;
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId, OrgUnitProperty changedProperty, ACUser user, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(projectId, user, changedProperty);

		WritePropertiesOperation operation = StaticOperationFactory.createWritePropertiesOperation(projectId, null);
		checkOperationPermissions(sessionId, operation);

		getSubInterface(ProjectPropertiesSubInterfaceImpl.class).setProperty(changedProperty, user, projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<EMFStoreProperty> getEMFProperties(SessionId sessionId, ProjectId projectId) throws EmfStoreException {
		sanityCheckObjects(sessionId, projectId);

		checkOperationPermissions(sessionId, StaticOperationFactory.createReadPropertiesOperation(projectId));

		return getSubInterface(EMFStorePropertiesSubInterfaceImpl.class).getProperties(projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitEMFProperties(SessionId sessionId, List<EMFStoreProperty> properties, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(projectId, properties);

		WritePropertiesOperation operation = StaticOperationFactory.createWritePropertiesOperation(projectId,
			properties);
		checkOperationPermissions(sessionId, operation);

		EMFStorePropertiesSubInterfaceImpl temp = getSubInterface(EMFStorePropertiesSubInterfaceImpl.class);

		temp.setProperties(properties, projectId);
	}

	public PermissionSet getPermissionSet(SessionId sessionId) throws EmfStoreException {
		// TODO
		return getServerSpace().getPermissionSet();
	}

	private void checkOperationPermission(SessionId sessionId, Operation<?> op) throws AccessControlException {
		getAuthorizationControl().checkSession(sessionId);
		getAuthorizationControl().checkPermissions(sessionId, op);
	}

	private ProjectId getProjectId(ProjectId projectId) throws EmfStoreException {
		for (ProjectHistory projectHistory : getServerSpace().getProjects()) {
			if (projectHistory.getProjectId().equals(projectId)) {
				return projectHistory.getProjectId();
			}
		}
		throw new EmfStoreException("Unknown ProjectId.");
	}

	private boolean canReadOrgUnit(SessionId sessionId, ACOrgUnitId id) throws InvalidInputException {
		return getAuthorizationControl().hasPermissions(sessionId,
			StaticOperationFactory.createReadOrgUnitOperation(id.getId()));
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkSession(sessionId);
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory ph : getServerSpace().getProjects()) {
			if (getAuthorizationControl().hasPermissions(sessionId,
				StaticOperationFactory.createReadProjectOperation(ph.getProjectId(), null))) {
				result.add(getProjectInfo(ph));
			}
		}
		return result;
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = ModelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(EcoreUtil.copy(project.getProjectId()));
		info.setVersion(project.getLastVersion().getPrimarySpec());
		return info;
	}

	public <T> T executeOperation(final SessionId sessionId, Operation<T> op) throws EmfStoreException {
		checkOperationPermission(sessionId, op);

		OperationExecution<T, Operation<T>> execution = new OperationExecution<T, Operation<T>>(op,
			new OperationExecutionContext() {

				public SessionId getSessionId() {
					return sessionId;
				}
			});

		findAndExecuteExecutionMethod(op.getClass(), execution);
		return execution.getResult();
	}

	/**
	 * 
	 * @param type
	 * @param execution
	 * @throws EmfStoreException
	 * @throws FatalEmfStoreException
	 */
	private <O extends Operation<?>, E extends OperationExecution<?, O>> void findAndExecuteExecutionMethod(
		Class<O> type, E execution) throws EmfStoreException {
		for (OperationExecutor executor : executors) {
			for (Method method : executor.getClass().getMethods()) {
				OperationHandler annotation = method.getAnnotation(OperationHandler.class);
				if (annotation != null && annotation.operationClass().isAssignableFrom(type)) {
					try {
						method.invoke(executor, execution);
					} catch (InvocationTargetException e) {
						if (e.getTargetException() instanceof EmfStoreException) {
							throw (EmfStoreException) e.getTargetException();
						}
					} catch (Exception e) {
						// this is fatal, because execution method signature is wrong
						// TODO: report in more detail, perhaps decicated Exception
						throw new RuntimeException(e);
					}
					return;
				}
			}
		}
		throw new EmfStoreException("no handler for operation:" + execution.getOperation().getClass().getName());
	}

	public List<Permission[]> getOperationPermissions(SessionId sessionId, Operation<?>[] operations) {
		List<Permission[]> permissions = new ArrayList<Permission[]>();

		for (Operation<?> op : operations) {
			permissions
				.add(convert(getAuthorizationControl().getPermissions(sessionId, op)).toArray(new Permission[0]));
		}

		return permissions;
	}

	private List<Permission> convert(Collection<InternalPermission> permissions) {
		List<Permission> list = new ArrayList<Permission>();
		for (InternalPermission internalPermission : permissions) {
			ProjectId projectId = internalPermission.getProjectId();
			list.add(new Permission(internalPermission.getType().getId(), projectId == null ? null : projectId.getId()));
		}
		return list;
	}

}
