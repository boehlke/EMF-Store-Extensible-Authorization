package org.eclipse.emf.emfstore.server.accesscontrol;

import java.util.Collection;

import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * provides permissions for operations
 * 
 * @author boehlke
 * 
 */
public abstract class PermissionProvider {

	public static class PermissionTypeData {
		private boolean projectPermission;
		private String id;

		public PermissionTypeData(String id, boolean projectPermission) {
			this.id = id;
			this.projectPermission = projectPermission;
		}

		public String getId() {
			return id;
		}

		public boolean isProjectPermission() {
			return projectPermission;
		}
	}

	/**
	 * internal representation of a permission, it holds references instead of ids, see {@see Permission}
	 * 
	 * @author boehlke
	 * 
	 */
	public static class InternalPermission {
		private PermissionType type;
		private ProjectId projectId;

		public InternalPermission(PermissionType type, ProjectId projectId) {
			this.projectId = projectId;
			this.type = type;
		}

		public ProjectId getProjectId() {
			return projectId;
		}

		public PermissionType getType() {
			return type;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof InternalPermission) {
				InternalPermission perm = (InternalPermission) obj;
				ProjectId otherProjectId = perm.getProjectId();
				return perm.getType().equals(getType())
					&& (otherProjectId == null ? getProjectId() == null : otherProjectId.equals(getProjectId()));
			}
			return false;
		}

		@Override
		public int hashCode() {
			return type.hashCode() + (projectId == null ? 0 : projectId.hashCode());
		}

		@Override
		public String toString() {
			return type.getId() + (projectId == null ? "" : " in " + projectId.getId());
		}
	}

	private PermissionContext permissionContext;

	public PermissionContext getPermissionContext() {
		if (permissionContext == null) {
			throw new IllegalStateException("permission context must be set");
		}
		return this.permissionContext;
	}

	public void setPermissionContext(PermissionContext permissionContext) {
		this.permissionContext = permissionContext;
	}

	/**
	 * returns the permission types used by the permission provider
	 * 
	 * @return
	 */
	public abstract PermissionTypeData[] getAllPermissionTypes();

	/**
	 * get the permissions needed by the user to execute the operation
	 * 
	 * @param op
	 * @return
	 */
	public abstract Collection<InternalPermission> getPermissions(Operation<?> op, ACUser user);

	/**
	 * gets the i18n name of the permission type
	 * 
	 * @return
	 */
	public abstract String getPermissionTypeName(String type);

}
