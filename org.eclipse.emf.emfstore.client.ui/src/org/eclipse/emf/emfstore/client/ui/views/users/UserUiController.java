package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreClientUtil;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.client.model.util.PermissionHelper;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation;
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
	private Map<String, ProjectInfo> projectInfoMap;
	private PermissionSet permissionSet;
	private Map<Operation<?>, Permission[]> operationPermissionCache = new HashMap<Operation<?>, Permission[]>();

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
			permissionSet = getPermissionSetFromServer();
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
			AssignRoleOperation assignRoleOperation = OperationFactory.eINSTANCE.createAssignRoleOperation();
			assignRoleOperation.setOrgUnitId(createdUser.getId().getId());
			ProjectId projectId = assignment.getProjectId();
			if (projectId != null) {
				assignRoleOperation.setProjectId(projectId.getId());
			}
			assignRoleOperation.setRoleId(assignment.getRole().getId());
			try {
				getEmfStoreProxy().executeOperation(assignRoleOperation);
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
		try {
			Permission[] permissions = getEmfStoreProxy().getOperationPermissions(new Operation<?>[] { op }).get(0);
			return PermissionHelper.hasPermissions(getSession().getACUser(), permissions, getPermissionSet());
		} catch (EmfStoreException e) {
			// TODO: handle Input Errors
			// TODO: handle this like all other server problems if server problem
			e.printStackTrace();
		}
		return false;
	}
}
