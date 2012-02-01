package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractSessionProvider;
import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.client.model.util.PermissionHelper;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.RoleAssignmentData;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.OperationFactory;

/**
 * controller for the user UI views/wizards/actions
 * 
 * @author boehlke
 * 
 */
public class UserUiController {

	private static UserUiController instance;
	private PermissionSet permissionSet;
	private List<Operation<?>> permittedOperationList = new ArrayList<Operation<?>>();
	private List<Operation<?>> forbiddenOperationList = new ArrayList<Operation<?>>();

	private EditingDomain editingDomain;
	private Adapter permissionSetListenerstener;
	private boolean registered;
	private ServerInfo serverInfo;

	private class ACUserServerSyncAdapater extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			int eventType = notification.getEventType();

			if (notification.getEventType() == Notification.SET) {
				ACUser user = (ACUser) notification.getNotifier();
				Map<String, String> map = new HashMap<String, String>();
				map.put(((EAttribute) notification.getFeature()).getName(), notification.getNewStringValue());
				try {
					getEmfStoreProxy().executeOperation(
						StaticOperationFactory.createSetOrgUnitPropertiesOperation(user.getId(), map));
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
				}
			}

			else if (notification.getFeatureID(ACUser.class) == AccesscontrolPackage.AC_ORG_UNIT__ROLES) {
				Set<RoleAssignment> added = new HashSet<RoleAssignment>();
				Set<RoleAssignment> removed = new HashSet<RoleAssignment>();

				if (eventType == Notification.ADD_MANY) {
					added.addAll((Collection<? extends RoleAssignment>) notification.getNewValue());
				} else if (eventType == Notification.REMOVE) {
					removed.add((RoleAssignment) notification.getOldValue());
				} else if (eventType == Notification.REMOVE_MANY) {
					removed.addAll((Collection<? extends RoleAssignment>) notification.getOldValue());
				} else if (eventType == Notification.ADD) {
					added.add((RoleAssignment) notification.getNewValue());
				}

				for (RoleAssignment roleAssignment : removed) {
					try {
						Role role = roleAssignment.getRole();
						ACUser user = (ACUser) notification.getNotifier();
						getEmfStoreProxy().executeOperation(
							StaticOperationFactory.createRemoveRoleOperation(user.getId(), role.getIdentifier(),
								roleAssignment.getProjectId()));
					} catch (InvalidInputException e) {
					} catch (EmfStoreException e) {
						// TODO
					}
				}

				for (RoleAssignment roleAssignment : added) {
					try {
						Role role = roleAssignment.getRole();
						ACUser user = (ACUser) notification.getNotifier();
						getEmfStoreProxy().executeOperation(
							StaticOperationFactory.createAssignRoleOperation(user.getId().getId(),
								role.getIdentifier(), roleAssignment.getProjectId()));
					} catch (InvalidInputException e) {
					} catch (EmfStoreException e) {
						// TODO
					}
				}

			}
			super.notifyChanged(notification);
		}
	}

	private UserUiController() {
		editingDomain = WorkspaceManager.getInstance().getEditingDomain();
		permissionSetListenerstener = new ACUserServerSyncAdapater();
		// TODO: make server info configurable
		serverInfo = WorkspaceManager.getInstance().getCurrentWorkspace().getServerInfos().get(0);
	}

	public static UserUiController getInstance() {
		if (instance == null) {
			instance = new UserUiController();
		}
		return instance;
	}

	private EmfStoreInterface getEmfStoreProxy() {
		return UsersessionImpl.getEmfStoreProxy(getSession().getSessionId());
	}

	public void registerPermissionSetListener() {
		if (!registered) {
			if (permissionSet == null) {
				permissionSet = getSession().getPermissionSetCache();
			}
			permissionSet.eAdapters().add(permissionSetListenerstener);
		}
		registered = true;
	}

	public PermissionSet getPermissionSet() {
		if (permissionSet == null) {
			permissionSet = getSession().getPermissionSetCache();
			List<Operation<?>> operations = new ArrayList<Operation<?>>();
			for (ACUser user : permissionSet.getUsers()) {
				try {
					operations.add(StaticOperationFactory.createDeleteOrgUnitOperation(user.getId()));
				} catch (InvalidInputException e) {
				}
			}
			try {
				int i = 0;
				ACUser currentUser = getSession().getACUser();
				for (Permission[] permissions : getEmfStoreProxy().getOperationPermissions(
					operations.toArray(new Operation<?>[0]))) {
					Operation<?> op = operations.get(i);
					if (PermissionHelper.hasPermissions(currentUser, permissions, permissionSet)) {
						permittedOperationList.add(op);
					} else {
						forbiddenOperationList.add(op);
					}
					i++;
				}
			} catch (EmfStoreException e) {
			}
			registerPermissionSetListener();
		}

		return permissionSet;
	}

	public boolean canDeleteOrgUnit(ACOrgUnit object) {
		return true;
	}

	public boolean canChangeOrgUnit(ACOrgUnit object) {
		// TODO: ask permission helper
		return true;
	}

	public Collection<ProjectInfo> getProjects() {
		return getSession().getServerInfo().getProjectInfos();
	}

	public ProjectInfo getProject(ProjectId projectId) {
		EList<ProjectInfo> projectInfos = getSession().getServerInfo().getProjectInfos();
		for (ProjectInfo projectInfo : projectInfos) {
			if (projectInfo.getProjectId().equals(projectId)) {
				return projectInfo;
			}
		}
		return null;
	}

	public void createUser(ACUser newUser, Collection<RoleSelection> collection) {
		CreateUserOperation op = OperationFactory.eINSTANCE.createCreateUserOperation();
		op.setName(newUser.getName());
		try {
			getEmfStoreProxy().executeOperation(op);
		} catch (EmfStoreException e) {
			ModelUtil.logException("YOUR MESSAGE HERE", e);
			return;
		}

		updatePermissionSet();
		ACUser createdUser = (ACUser) getPermissionSet().getOrgUnit(newUser.getName());
		createdUser.setFirstName(newUser.getFirstName());
		createdUser.setLastName(newUser.getLastName());
		createdUser.setDescription(newUser.getDescription());

		for (RoleSelection roleSelection : collection) {
			try {
				getEmfStoreProxy().executeOperation(
					StaticOperationFactory.createAssignRoleOperation(createdUser.getId().getId(), roleSelection
						.getRole().getIdentifier(), roleSelection.getProject() == null ? null : roleSelection
						.getProject().getProjectId()));
			} catch (EmfStoreException e) {
				// TODO
				ModelUtil.logException("YOUR MESSAGE HERE", e);
				return;
			}
		}

		updatePermissionSet();
	}

	public Usersession getSession() {
		AbstractSessionProvider sessionProvider = new AdminUiSessionProvider();
		try {
			return sessionProvider.provideUsersession(serverInfo);
		} catch (EmfStoreException e) {
			ModelUtil.logException(e);
			return null;
		}
	}

	public boolean canExecute(Operation<?> op) {
		if (permittedOperationList.contains(op)) {
			return true;
		} else if (forbiddenOperationList.contains(op)) {
			return false;
		}

		try {
			Permission[] permissions = getEmfStoreProxy().getOperationPermissions(new Operation<?>[] { op }).get(0);
			boolean permitted = PermissionHelper.hasPermissions(getSession().getACUser(), permissions,
				getPermissionSet());
			if (permitted) {
				permittedOperationList.add(op);
			} else {
				forbiddenOperationList.add(op);
			}
			return permitted;
		} catch (EmfStoreException e) {
			// TODO: handle Input Errors
			// TODO: handle this like all other server problems if server problem
			e.printStackTrace();
		}
		return false;
	}

	public EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	public void updatePermissionSet() {
		permissionSet.eAdapters().remove(permissionSetListenerstener);
		try {
			getSession().updatePermissionSet();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
		}
		permissionSet.eAdapters().add(permissionSetListenerstener);
	}

	public void deleteOrgUnit(ACOrgUnitId id) {
		try {
			getEmfStoreProxy().executeOperation(StaticOperationFactory.createDeleteOrgUnitOperation(id));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
		}
		updatePermissionSet();
	}

	public void assignAndRemoveRoles(ProjectId projectId, Collection<RoleAssignmentData> addedAssignments,
		Collection<RoleAssignmentData> removedAssignments) {
		for (RoleAssignmentData roleAssignmentData : addedAssignments) {
			ACOrgUnit orgUnit = roleAssignmentData.getOrgUnit();
			RoleAssignment assignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();
			assignment.setRole(roleAssignmentData.getRole());
			assignment.setProjectId(projectId);
			orgUnit.getRoles().add(assignment);
		}
	}
}
