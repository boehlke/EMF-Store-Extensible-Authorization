package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

public class RoleAssignmentData {
	private Role role;
	private ACOrgUnit orgUnit;

	public RoleAssignmentData(Role role, ACOrgUnit orgUnit) {
		this.role = role;
		this.orgUnit = orgUnit;
	}

	public ACOrgUnit getOrgUnit() {
		return orgUnit;
	}

	public Role getRole() {
		return role;
	}
}