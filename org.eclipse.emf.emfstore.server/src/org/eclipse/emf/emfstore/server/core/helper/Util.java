package org.eclipse.emf.emfstore.server.core.helper;

import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

public class Util {
	public static ProjectHistory getProjectHistoryOrNull(String projectId, ServerSpace space) {
		for (ProjectHistory project : space.getProjects()) {
			if (project.getProjectId().getId().equals(projectId)) {
				return project;
			}
		}
		return null;
	}

	public static Role getRoleOrNull(String roleId, ServerSpace serverSpace) {
		for (Role role : serverSpace.getPermissionSet().getRoles()) {
			if (role.getId().equals(roleId)) {
				return role;
			}
		}
		return null;
	}

	public static PermissionType getPermissionTypeOrNull(String permissionTypeId, ServerSpace serverSpace) {
		for (PermissionType type : serverSpace.getPermissionSet().getPermissionTypes()) {
			if (type.getId().equals(permissionTypeId)) {
				return type;
			}
		}
		return null;
	}

}
