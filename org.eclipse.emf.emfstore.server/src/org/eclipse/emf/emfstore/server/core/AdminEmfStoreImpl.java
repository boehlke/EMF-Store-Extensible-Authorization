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
import org.eclipse.emf.emfstore.server.AdminEmfStore;
import org.eclipse.emf.emfstore.server.OperationExecution;
import org.eclipse.emf.emfstore.server.OperationExecution.OperationExecutionContext;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.InternalPermission;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.core.operation.OperationExecutor;
import org.eclipse.emf.emfstore.server.core.operation.OperationHandler;
import org.eclipse.emf.emfstore.server.core.operation.OrgUnitOperationExecutor;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * Implementation of {@link AdminEmfStore} interface.
 * 
 * @author Wesendonk
 * @author boehlke
 */
public class AdminEmfStoreImpl extends AbstractEmfstoreInterface implements AdminEmfStore {

	private List<OperationExecutor> executors = new ArrayList<OperationExecutor>();

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the serverspace
	 * @param authorizationControl
	 *            the authoriazationcontrol
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public AdminEmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
		executors.add(new OrgUnitOperationExecutor(serverSpace, authorizationControl));
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

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface#initSubInterfaces()
	 */
	@Override
	protected void initSubInterfaces() throws FatalEmfStoreException {
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

	// public RoleData[] getRoles(SessionId sessionId) throws EmfStoreException {
	// List<RoleData> roles = new ArrayList<RoleData>();
	// for (Role role : getServerSpace().getRoles()) {
	// RoleData roleData = AuthFactory.eINSTANCE.createRoleData();
	// roleData.setId(role.getId());
	// roleData.setName(role.getName());
	// roleData.setDescription(role.getDescription());
	//
	// for (PermissionType permissionType : role.getPermissionTypes()) {
	// roleData.getPermissionTypeIds().add(permissionType.getId());
	// }
	// roles.add(roleData);
	// }
	// return roles.toArray(new RoleData[0]);
	// }
}
