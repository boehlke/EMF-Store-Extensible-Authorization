package org.eclipse.emf.emfstore.client.ui.views.users;

import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

/**
 * instances of this class can be selected in the role selection dialog
 * 
 * @author boehlke
 * 
 */
public class RoleSelection {
	private Role role;
	private ProjectInfo projectInfo;

	public RoleSelection(Role role, ProjectInfo projectInfo) {
		this.role = role;
		this.projectInfo = projectInfo;
	}

	public Role getRole() {
		return role;
	}

	public ProjectInfo getProject() {
		return projectInfo;
	}

	@Override
	public int hashCode() {
		int roleHash = role == null ? 0 : role.getId().hashCode();
		int projectHash = projectInfo == null ? 0 : projectInfo.getProjectId() == null ? 0 : projectInfo.getProjectId()
			.getId().hashCode();
		return roleHash + projectHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleSelection) {
			RoleSelection sel = (RoleSelection) obj;

			boolean roleEquals = sel.getRole() == null ? getRole() == null : sel.getRole().getId()
				.equals(getRole() == null ? null : getRole().getId());
			boolean projectEquals = sel.getProject() == null ? getProject() == null : sel.getProject().getProjectId()
				.getId().equals(getProject() == null ? null : getProject().getProjectId().getId());

			return roleEquals && projectEquals;
		}
		return super.equals(obj);
	}
}