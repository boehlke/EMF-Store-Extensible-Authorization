package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

/**
 * Hack: Tree Path logic cannot handle equivalence, so we need to box the roles
 * 
 * @author boehlke
 */
public class RoleBox {
	private Role role;

	public RoleBox(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		return getRole().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleBox) {
			RoleBox box = (RoleBox) obj;
			return box.getRole().equals(getRole());
		}
		return super.equals(obj);
	}
}