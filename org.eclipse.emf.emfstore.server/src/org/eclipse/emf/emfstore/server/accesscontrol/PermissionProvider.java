package org.eclipse.emf.emfstore.server.accesscontrol;

import java.util.Collection;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

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
		/**
		 * resolve a permission type by id
		 * 
		 * @param typeId
		 * @return
		 */
		PermissionType resolvePermissionType(String typeId);

		/**
		 * resolve the whole project history. This is only possible on the server. So by using this, the permission
		 * provider will work offline
		 * 
		 * @param projectId
		 * @return
		 */
		ProjectHistory resolveProjectHistory(String projectId);

		/**
		 * resolve a project by id and version
		 * 
		 * @param projectId
		 * @return
		 */
		Project resolveProject(String projectId, PrimaryVersionSpec version);

		/**
		 * resolve a projet id by id string, this can be used to see if a given project exists in die context
		 * 
		 * @param projectId
		 * @return
		 */
		ProjectId resolveProjectId(String projectId);

		/**
		 * resolve an org unit by string
		 * 
		 * @param orgUnitId
		 * @return
		 */
		ACOrgUnit resolveOrgUnit(String orgUnitId);
	}

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
	static class InternalPermission {
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

	/**
	 * gets the i18n name of the permission type
	 * 
	 * @return
	 */
	public String getPermissionTypeName(String type);

}
