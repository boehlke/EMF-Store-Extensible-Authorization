/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.accesscontrol;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.core.helper.Util;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.Version;

/**
 * @author boehlke
 * 
 */
public class ServerPermissionContext implements PermissionContext {

	private ServerSpace serverSpace;

	public ServerPermissionContext(ServerSpace serverSpace) {
		this.serverSpace = serverSpace;
	}

	public PermissionType resolvePermissionType(String typeId) {
		for (PermissionType type : getPermissionSet().getPermissionTypes()) {
			if (type.getId().equals(typeId)) {
				return type;
			}
		}
		return null;
	}

	private PermissionSet getPermissionSet() {
		return serverSpace.getPermissionSet();
	}

	public ProjectHistory resolveProjectHistory(String projectId) {
		return Util.getProjectHistoryOrNull(projectId, serverSpace);
	}

	public ProjectId resolveProjectId(String projectId) {
		ProjectHistory projectHistoryOrNull = Util.getProjectHistoryOrNull(projectId, serverSpace);
		if (projectHistoryOrNull == null) {
			return null;
		}
		return projectHistoryOrNull.getProjectId();
	}

	public ACOrgUnit resolveOrgUnit(String orgUnitId) {
		ACOrgUnitId id = AccesscontrolFactory.eINSTANCE.createACOrgUnitId();
		id.setId(orgUnitId);
		return getPermissionSet().getOrgUnit(id);
	}

	public Project resolveProject(String projectId, PrimaryVersionSpec version) {
		ProjectHistory projectHistoryOrNull = Util.getProjectHistoryOrNull(projectId, serverSpace);
		if (projectHistoryOrNull == null) {
			return null;
		}
		for (Version _version : projectHistoryOrNull.getVersions()) {
			if (version.getIdentifier() == _version.getPrimarySpec().getIdentifier()) {
				return _version.getProjectState();
			}
		}
		return null;
	}
}
