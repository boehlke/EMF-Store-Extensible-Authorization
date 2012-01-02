package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreClientUtil;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationFactory;

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

	private UserUiController() {
		projectInfoMap = new HashMap<String, ProjectInfo>();

		ProjectInfo projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("Testprojekt");
		projectInfoMap.put("test", projectInfo);

		projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("Testprojekt 1");
		projectInfoMap.put("p1", projectInfo);

		projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("Testprojekt 2");
		projectInfoMap.put("p2", projectInfo);

		projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("Testprojekt 3");
		projectInfoMap.put("p3", projectInfo);

		projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("Testprojekt 4");
		projectInfoMap.put("p4", projectInfo);

		for (Map.Entry<String, ProjectInfo> entry : projectInfoMap.entrySet()) {
			ProjectInfo info = entry.getValue();

			ProjectId projectId = ModelFactory.eINSTANCE.createProjectId();
			projectId.setId(entry.getKey());
			info.setProjectId(projectId);
		}

	}

	public static UserUiController getInstance() {
		if (instance == null) {
			instance = new UserUiController();
		}
		return instance;
	}

	private EmfStoreInterface getEmfStoreProxy() {
		try {
			Usersession session = EMFStoreClientUtil.createUsersession("super", "super", "localhost", 8080);
			session.logIn();
			return UsersessionImpl.getEmfStoreProxy(session.getSessionId());
		} catch (EmfStoreException e) {
			ModelUtil.logException(e);
		}
		return null;
	}

	public PermissionSet getNewPermissionSet() {
		try {
			return getEmfStoreProxy().getPermissionSet();
		} catch (EmfStoreException e) {
			ModelUtil.logException(e);
		}
		return null;
	}

	public PermissionSet getPermissionSet() {
		if (permissionSet == null) {
			permissionSet = getNewPermissionSet();
		}
		return permissionSet;

		// final PermissionSet permissionSet = AccesscontrolFactory.eINSTANCE.createPermissionSet();
		//
		// Role systemAdminRole = AccesscontrolFactory.eINSTANCE.createRole();
		// systemAdminRole.setDescription("test");
		// systemAdminRole.setName("Systemadministrator");
		// systemAdminRole.setId("systemadmin");
		// systemAdminRole.setSystemRole(true);
		// permissionSet.getRoles().add(systemAdminRole);
		//
		// Role catalogAdminRole = AccesscontrolFactory.eINSTANCE.createRole();
		// catalogAdminRole.setDescription("");
		// catalogAdminRole.setName("Catalog Admin");
		// catalogAdminRole.setId("catalogadmin");
		// catalogAdminRole.setSystemRole(true);
		// permissionSet.getRoles().add(catalogAdminRole);
		//
		// PermissionType type = AccesscontrolFactory.eINSTANCE.createPermissionType();
		// type.setId("test");
		// type.setProjectPermission(true);
		//
		// Role projectMemberRole = AccesscontrolFactory.eINSTANCE.createRole();
		// projectMemberRole.setDescription("member");
		// projectMemberRole.setName("Projektteilnehmer");
		// projectMemberRole.setId("projectmember");
		// projectMemberRole.getPermissionTypes().add(type);
		// permissionSet.getRoles().add(projectMemberRole);
		//
		// Role projectAdminRole = AccesscontrolFactory.eINSTANCE.createRole();
		// projectAdminRole.setDescription("admin");
		// projectAdminRole.setName("Projektadmin");
		// projectAdminRole.setId("projectadmin");
		// projectAdminRole.getPermissionTypes().add(type);
		// permissionSet.getRoles().add(projectAdminRole);
		//
		// Role reviewerRole = AccesscontrolFactory.eINSTANCE.createRole();
		// reviewerRole.setDescription("reviwer...");
		// reviewerRole.setName("Reviewer");
		// reviewerRole.setId("reviewer");
		// reviewerRole.getPermissionTypes().add(type);
		// permissionSet.getRoles().add(reviewerRole);
		//
		// // RoleAssignment roleAssignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();
		// // roleAssignment.setRole(systemAdminRole);
		// // userData.getRoles().add(roleAssignment);
		//
		// permissionSet.getUsers().add(createUser("aboehlke", "André", "Böhlke", projectMemberRole, systemAdminRole));
		// permissionSet.getUsers().add(createUser("rrose", "Rudolf", "Rose", projectAdminRole));
		// permissionSet.getUsers().add(createUser("mmuse", "Manuela", "Muse", reviewerRole, projectMemberRole));
		//
		// return permissionSet;
	}

	// private ACUser createUser(String name, String first, String last, Role... roles) {
	// ACUser user = AccesscontrolFactory.eINSTANCE.createACUser();
	//
	// user.setName(name);
	// user.setLastName(last);
	// user.setFirstName(first);
	//
	// for (Role role : roles) {
	// RoleAssignment assignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();
	// user.getRoles().add(assignment);
	// assignment.setRole(role);
	// if (!role.isSystemRole()) {
	// assignment.setProjectId(projectInfoMap.get("test").getProjectId());
	// }
	// }
	//
	// return user;
	// }

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

		PermissionSet newPermissionSet = getNewPermissionSet();
		newUser = (ACUser) newPermissionSet.getOrgUnit(newUser.getName());

		for (RoleAssignment assignment : newUser.getRoles()) {
			AssignRoleOperation assignRoleOperation = OperationFactory.eINSTANCE.createAssignRoleOperation();
			assignRoleOperation.setOrgUnitId(newPermissionSet.getOrgUnit(newUser.getName()).getId().getId());
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

}
