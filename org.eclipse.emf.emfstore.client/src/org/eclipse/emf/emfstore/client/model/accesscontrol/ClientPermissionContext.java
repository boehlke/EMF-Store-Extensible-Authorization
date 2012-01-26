/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.accesscontrol;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionContext;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

/**
 * @author boehlke
 * 
 */
public class ClientPermissionContext implements PermissionContext {

	private ProjectSpace projectSpace;

	/**
	 * create a permission context using a session
	 * 
	 * @param session
	 */
	public ClientPermissionContext(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext#resolvePermissionType(java.lang.String)
	 */
	public PermissionType resolvePermissionType(String typeId) {
		// TODO: fail fatal if permission type not found
		return projectSpace.getUsersession().getPermissionSetCache().getPermissionType(typeId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext#resolveProjectHistory(java.lang.String)
	 */
	public ProjectHistory resolveProjectHistory(String projectId) {
		throw new UnsupportedOperationException("cannot get project history on client");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext#resolveProject(java.lang.String,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec)
	 */
	public Project resolveProject(String projectId, PrimaryVersionSpec version) {
		if (projectSpace == null) {
			throw new IllegalStateException("no project space");
		}
		if (!projectSpace.getProjectId().getId().equals(projectId) || !projectSpace.getBaseVersion().equals(version)) {
			throw new IllegalArgumentException("can only resolve context project");
		}
		return projectSpace.getProject();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext#resolveProjectId(java.lang.String)
	 */
	public ProjectId resolveProjectId(String projectId) {
		if (projectSpace == null) {
			throw new IllegalStateException("no project space");
		}
		if (!projectSpace.getProjectId().getId().equals(projectId)) {
			throw new IllegalArgumentException("can only resolve context project");
		}
		return EcoreUtil.copy(projectSpace.getProjectId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext#resolveOrgUnit(java.lang.String)
	 */
	public ACOrgUnit resolveOrgUnit(String orgUnitId) {
		throw new UnsupportedOperationException("cannot get org unit on client");
	}

}
