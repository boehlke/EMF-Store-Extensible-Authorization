package org.eclipse.emf.emfstore.server.accesscontrol;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

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