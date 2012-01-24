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
		int roleHash = role == null ? 0 : role.getIdentifier().hashCode();
		int projectHash = projectInfo == null ? 0 : projectInfo.getProjectId() == null ? 0 : projectInfo.getProjectId()
			.getId().hashCode();
		return roleHash + projectHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleSelection) {
			RoleSelection sel = (RoleSelection) obj;

			boolean roleEquals = sel.getRole() == null ? getRole() == null : sel.getRole().getIdentifier()
				.equals(getRole() == null ? null : getRole().getIdentifier());
			boolean projectEquals = false;
			if (sel.getProject() != null && sel.getProject().getProjectId() != null) {
				if (getProject() != null && getProject().getProjectId() != null) {
					projectEquals = sel.getProject().getProjectId().equals(getProject().getProjectId());
				}
			} else if (sel.getProject() == null) {
				projectEquals = getProject() == null;
			} else if (sel.getProject().getProjectId() == null) {
				projectEquals = getProject() == null || getProject().getProjectId() == null;
			}

			return roleEquals && projectEquals;
		}
		return super.equals(obj);
	}
}