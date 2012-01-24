package org.eclipse.emf.emfstore.server.accesscontrol.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;

public class PermissionUtil {

	public static boolean hasPermissions(ACUser user, Collection<Permission> permissions) {
		return getPermissions(user).containsAll(permissions);
	}

	private static Collection<Permission> getPermissions(ACOrgUnit orgUnit) {
		Set<Permission> permissions = new HashSet<Permission>();

		for (RoleAssignment assignment : orgUnit.getRoles()) {
			for (PermissionType permissionType : assignment.getRole().getPermissionTypes()) {
				permissions.add(new Permission(permissionType.getId(), assignment.getProjectId() == null ? null
					: assignment.getProjectId().getId()));
			}
		}

		for (ACGroup group : orgUnit.getGroups()) {
			permissions.addAll(getPermissions(group));
		}

		return permissions;
	}

}
