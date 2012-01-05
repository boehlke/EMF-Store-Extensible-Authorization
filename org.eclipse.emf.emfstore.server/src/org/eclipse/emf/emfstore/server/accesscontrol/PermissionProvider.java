package org.eclipse.emf.emfstore.server.accesscontrol;

import java.util.Collection;

import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * provides permissions for operations
 * 
 * @author boehlke
 * 
 */
public interface PermissionProvider {

	/**
	 * resolves permission type id to permission type objects
	 * 
	 * @author boehlke
	 * 
	 */
	public interface PermissionContext {
		PermissionType resolvePermissionType(String typeId);

		ProjectHistory resolveProjectHistory(String projectId);

		ProjectId resolveProjectId(String projectId);

		ACOrgUnit resolveOrgUnit(String orgUnitId);
	}

	public static class PermissionTypeData {
		private boolean projectPermission;
		private String name;
		private String id;

		public PermissionTypeData(String id, String name, boolean projectPermission) {
			this.id = id;
			this.name = name;
			this.projectPermission = projectPermission;
		}

		public String getId() {
			return id;
		}

		public boolean isProjectPermission() {
			return projectPermission;
		}

		public String getName() {
			return name;
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
	}

	/**
	 * returns the permission types used by the permission provider
	 * 
	 * @return
	 */
	public PermissionTypeData[] getAllPermissionTypes();

	/**
	 * get the permissions needed by the user to execute the operation
	 * 
	 * @param op
	 * @return
	 */
	public Collection<InternalPermission> getPermissions(Operation<?> op, ACUser user, PermissionContext resolver);
}
