package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreClientUtil;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.client.model.util.PermissionHelper;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.OperationFactory;
import org.eclipse.emf.emfstore.server.model.operation.RoleContainer;

/**
 * controller for the user UI views/wizards/actions
 * 
 * @author boehlke
 * 
 */
public class UserUiController {

	private static UserUiController instance;
	private Map<String, ProjectInfo> projectInfoMap = new HashMap<String, ProjectInfo>();
	private PermissionSet permissionSet;
	private List<Operation<?>> permittedOperationList = new ArrayList<Operation<?>>();
	private List<Operation<?>> forbiddenOperationList = new ArrayList<Operation<?>>();

	private AdapterFactoryEditingDomain editingDomain;

	private UserUiController() {
		try {
			for (ProjectInfo project : getEmfStoreProxy().getProjectList()) {
				projectInfoMap.put(project.getProjectId().getId(), project);
			}
		} catch (EmfStoreException e) {
			// TODO: handle Input Errors
			// TODO: handle this like all other server problems if server problem
			e.printStackTrace();
		}

		editingDomain = new AdapterFactoryEditingDomain(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE), new BasicCommandStack());
	}

	public static UserUiController getInstance() {
		if (instance == null) {
			instance = new UserUiController();
		}
		return instance;
	}

	public void createRole(Role role) {
		CreateOrUpdateRoleOperation op = OperationFactory.eINSTANCE.createCreateOrUpdateRoleOperation();
		RoleContainer containter = OperationFactory.eINSTANCE.createRoleContainer();
		op.setRole(containter);
		containter.getPermissionTypes().addAll(EcoreUtil.copyAll(role.getPermissionTypes()));
		Role copy = EcoreUtil.copy(role);
		containter.setRole(copy);
		copy.getPermissionTypes().clear();
		copy.getPermissionTypes().addAll(containter.getPermissionTypes());

		EmfStoreInterface emfStore = getEmfStoreProxy();
		try {
			emfStore.executeOperation(op);
		} catch (EmfStoreException e) {
			// TODO: handle auth exception
			throw new RuntimeException(e);
		}
	}

	public void createStandardEnCoRoles() {

		PermissionSet set = getPermissionSet();

		Role catalogAdminRole = AccesscontrolFactory.eINSTANCE.createRole();
		catalogAdminRole.setDescription("");
		catalogAdminRole.setName("Catalog Admin");
		catalogAdminRole.setId("catalogadmin");
		catalogAdminRole.setSystemRole(true);
		createRole(catalogAdminRole);

		Role projectMemberRole = AccesscontrolFactory.eINSTANCE.createRole();
		projectMemberRole.setDescription("member");
		projectMemberRole.setName("Projektteilnehmer");
		projectMemberRole.setId("projectmember");
		createRole(projectMemberRole);

		Role projectAdminRole = AccesscontrolFactory.eINSTANCE.createRole();
		projectAdminRole.setDescription("admin");
		projectAdminRole.setName("Projektadmin");
		projectAdminRole.setId("projectadmin");
		createRole(projectAdminRole);

		Role reviewerRole = AccesscontrolFactory.eINSTANCE.createRole();
		reviewerRole.setDescription("reviwer...");
		reviewerRole.setName("Reviewer");
		reviewerRole.setId("reviewer");
		createRole(reviewerRole);

	}

	private EmfStoreInterface getEmfStoreProxy() {
		return UsersessionImpl.getEmfStoreProxy(getSession().getSessionId());
	}

	public PermissionSet getPermissionSetFromServer() {
		try {
			return getEmfStoreProxy().getPermissionSet();
		} catch (EmfStoreException e) {
			ModelUtil.logException(e);
		}
		return null;
	}

	public PermissionSet getPermissionSet() {
		if (permissionSet == null) {
			Resource resource = editingDomain.getResourceSet().createResource(URI.createURI("dummy"));
			permissionSet = getPermissionSetFromServer();
			resource.getContents().add(permissionSet);
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
		}
		permissionSet.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				int eventType = notification.getEventType();
				if (notification.getFeatureID(ACUser.class) == AccesscontrolPackage.AC_ORG_UNIT__ROLES) {
					Set<RoleAssignment> added = new HashSet<RoleAssignment>();
					Set<RoleAssignment> removed = new HashSet<RoleAssignment>();

					if (eventType == Notification.ADD_MANY) {
						added.addAll((Collection<? extends RoleAssignment>) notification.getNewValue());
					} else if (eventType == Notification.REMOVE) {
						removed.add((RoleAssignment) notification.getOldValue());
					} else if (eventType == Notification.ADD) {
						added.add((RoleAssignment) notification.getNewValue());
					}

					for (RoleAssignment roleAssignment : removed) {
						try {
							Role role = roleAssignment.getRole();
							ACUser user = (ACUser) notification.getNotifier();
							getEmfStoreProxy().executeOperation(
								StaticOperationFactory.createRemoveRoleOperation(user.getId(), role.getId(),
									roleAssignment.getProjectId()));
						} catch (InvalidInputException e) {
						} catch (EmfStoreException e) {
						}
					}

					for (RoleAssignment roleAssignment : added) {
						try {
							Role role = roleAssignment.getRole();
							ACUser user = (ACUser) notification.getNotifier();
							getEmfStoreProxy().executeOperation(
								StaticOperationFactory.createAssignRoleOperation(user.getId().getId(), role.getId(),
									roleAssignment.getProjectId()));
						} catch (InvalidInputException e) {
						} catch (EmfStoreException e) {
						}
					}

				}
				super.notifyChanged(notification);
			}
		});
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
		return projectInfoMap.values();
	}

	public ProjectInfo getProject(ProjectId projectId) {
		return projectInfoMap.get(projectId.getId());
	}

	public void createUser(ACUser newUser) {
		CreateUserOperation op = OperationFactory.eINSTANCE.createCreateUserOperation();
		op.setName(newUser.getName());
		try {
			getEmfStoreProxy().executeOperation(op);
		} catch (EmfStoreException e) {
			ModelUtil.logException("YOUR MESSAGE HERE", e);
			return;
		}

		PermissionSet newPermissionSet = getPermissionSetFromServer();
		ACUser createdUser = (ACUser) newPermissionSet.getOrgUnit(newUser.getName());

		for (RoleAssignment assignment : newUser.getRoles()) {
			try {
				getEmfStoreProxy().executeOperation(
					StaticOperationFactory.createAssignRoleOperation(createdUser.getId().getId(), assignment.getRole()
						.getId(), assignment.getProjectId()));
			} catch (EmfStoreException e) {
				ModelUtil.logException("YOUR MESSAGE HERE", e);
				return;
			}
		}

		permissionSet.getUsers().add(newUser);
	}

	public Usersession getSession() {
		try {
			Usersession session = EMFStoreClientUtil.createUsersession("super", "super", "localhost", 8080);
			session.logIn();
			return session;
		} catch (EmfStoreException e) {
			ModelUtil.logException(e);
		}
		return null;
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

	public AdapterFactoryEditingDomain getEditingDomain() {
		return this.editingDomain;
	}
}
