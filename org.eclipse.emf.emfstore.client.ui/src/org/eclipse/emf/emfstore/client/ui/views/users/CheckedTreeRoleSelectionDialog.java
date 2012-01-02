package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class CheckedTreeRoleSelectionDialog extends CheckedTreeSelectionDialog {

	private UserUiController controller;;

	//
	// private class CheckStateProvider implements ICheckStateProvider {
	//
	// public boolean isChecked(Object element) {
	// Object[] sel = getTreeViewer().getCheckedElements();
	// if (((RoleSelection) element).getRoleId().equals("")) {
	// RoleSelection selection = (RoleSelection) element;
	//
	// for (Object obj : sel) {
	// RoleSelection roleSelection = (RoleSelection) obj;
	// if (selection.getProjectId().equals(roleSelection.getProjectId()) && selection != roleSelection) {
	// return true;
	// }
	// }
	// return false;
	// }
	// return Arrays.asList(sel).contains(element);
	// }
	//
	// public boolean isGrayed(Object element) {
	// if (((RoleSelection) element).getRoleId().equals("")) {
	// return true;
	// }
	// return false;
	// }
	// }

	public CheckedTreeRoleSelectionDialog(Shell shell, UserUiController controller) {
		super(shell, new WorkbenchLabelProvider(), new RoleSelectionContentProvider(controller));
		this.controller = controller;
		setContainerMode(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getInitialElementSelections() {
		List<RoleSelection> list = super.getInitialElementSelections();
		Collection<RoleAssignment> assignments = (Collection<RoleAssignment>) getTreeViewer().getInput();
		for (RoleAssignment roleAssignment : assignments) {
			ProjectId projectId = roleAssignment.getProjectId();
			ProjectInfo info = null;
			if (projectId != null) {
				// list.add(new RoleSelection(null, projectId.getId()));
				info = controller.getProject(projectId);
			}
			list.add(new RoleSelection(roleAssignment.getRole(), info));
		}

		for (RoleSelection sel : list) {
			getTreeViewer().expandToLevel(new RoleSelection(null, sel.getProject()), TreeViewer.ALL_LEVELS);
			getTreeViewer().expandToLevel(sel, TreeViewer.ALL_LEVELS);
		}
		return list;
	}

	@Override
	protected CheckboxTreeViewer createTreeViewer(Composite parent) {
		final CheckboxTreeViewer viewer = super.createTreeViewer(parent);

		Util.configureRoleSelectionTreeViewer(viewer);
		return viewer;
	}

}