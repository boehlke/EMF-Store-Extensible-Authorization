package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

class RoleSelectionContentProvider implements ITreeContentProvider {

	private UserUiController controller;

	public RoleSelectionContentProvider(UserUiController controller) {
		this.controller = controller;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public boolean hasChildren(Object element) {
		return ((RoleSelection) element).getRole() == null;
	}

	public Object getParent(Object element) {
		return null;
	}

	public Object[] getElements(Object inputElement) {
		Collection<RoleAssignment> roles = (Collection<RoleAssignment>) inputElement;
		// RoleSelectionContent content = (RoleSelectionContent) inputElement;

		List<Object> elements = new ArrayList<Object>();

		for (Role roleData : controller.getPermissionSet().getRoles()) {
			if (roleData.isSystemRole()) {
				elements.add(new RoleSelection(roleData, null));
			}
		}

		for (ProjectInfo projectInfo : controller.getProjects()) {
			elements.add(new RoleSelection(null, projectInfo));
		}

		return elements.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if (((RoleSelection) parentElement).getRole() == null) {
			RoleSelection sel = (RoleSelection) parentElement;
			List<RoleSelection> roleSelections = new ArrayList<RoleSelection>();

			for (Role role : controller.getPermissionSet().getRoles()) {
				if (!role.isSystemRole()) {
					roleSelections.add(new RoleSelection(role, sel.getProject()));
				}
			}
			return roleSelections.toArray();
		}
		return null;
	}

}