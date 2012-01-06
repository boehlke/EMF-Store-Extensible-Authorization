package org.eclipse.emf.emfstore.client.model.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;

/**
 * helps when checking if the current user has permissions for an operation
 * 
 * @author boehlke
 * 
 */
public class PermissionHelper {

	private EmfStoreInterface emfStore;

	/**
	 * creates a new helper for the given server
	 * 
	 * @param sessionId session to use
	 */
	public PermissionHelper(SessionId sessionId) {
		this.emfStore = UsersessionImpl.getEmfStoreProxy(sessionId);
	}

	public static boolean hasPermissions(ACUser user, Permission[] permissions, PermissionSet permissionSet) {

		Set<Permission> requiredPermissions = new HashSet<Permission>();
		requiredPermissions.addAll(Arrays.asList(permissions));

		for (Permission permission : getPermissions(user)) {
			String projectId = permission.getProjectId();
			Iterator<Permission> iterator = requiredPermissions.iterator();
			while (iterator.hasNext()) {
				Permission requiredPermission = iterator.next();
				if (requiredPermission.getId().equals(permission.getId())
					&& (projectId == null || projectId.equals(requiredPermission.getProjectId()))) {
					iterator.remove();
				}
			}

			if (requiredPermissions.size() == 0) {
				break;
			}
		}

		if (requiredPermissions.size() == 0) {
			return true;
		}

		return false;
	}

	private static Collection<Permission> getPermissions(ACOrgUnit orgUnit) {
		Set<Permission> permissions = new HashSet<Permission>();

		for (RoleAssignment assignment : orgUnit.getRoles()) {
			for (PermissionType permissionType : assignment.getRole().getPermissionTypes()) {
				String projectId = assignment.getProjectId() == null ? null : assignment.getProjectId().getId();
				permissions.add(new Permission(permissionType.getId(), projectId));
			}
		}

		for (ACGroup group : orgUnit.getGroups()) {
			permissions.addAll(getPermissions(group));
		}

		return permissions;
	}

}
