package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.emfstore.client.ui.views.users.UserUiController;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SelectRolesDialog extends SelectionDialog {

	private class TreeContentProvider implements ITreeContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof ACUser) {
				List<RoleBox> boxes = new ArrayList<RoleBox>();
				for (Role role : controller.getPermissionSet().getProjectRoles()) {
					boxes.add(new RoleBox(role));
				}
				return boxes.toArray();
			}
			if (parentElement instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) parentElement;
				return collection.toArray();
			}
			return new Object[] {};
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	private ContainerCheckedTreeViewer treeViewer;
	private UserUiController controller;
	private ACOrgUnit orgUnit;

	/**
	 * Create the wizard.
	 * 
	 * @param assignRolesWizard
	 */
	public SelectRolesDialog(Shell parentShell, ACOrgUnit orgUnit) {
		super(parentShell);
		this.orgUnit = orgUnit;
		this.controller = UserUiController.getInstance();
		// setTitle("Select Roles");
		// setDescription("Select roles which the users should have in project " + wizard.getProjectInfo().getName());
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		treeViewer = new ContainerCheckedTreeViewer(container, SWT.BORDER) {
			@Override
			public boolean getChecked(Object element) {
				if (element instanceof TreePath) {
					Widget widget = internalGetWidgetToSelect(element);
					if (widget instanceof TreeItem) {
						boolean checked = ((TreeItem) widget).getChecked();
						return checked;
					}
				}
				return super.getChecked(element);
			}
		};
		Tree tree = treeViewer.getTree();

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnRolle = treeViewerColumn.getColumn();
		trclmnRolle.setWidth(300);
		trclmnRolle.setText("Rolle");
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());

		tree.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					event.detail = SWT.NONE;
					event.type = SWT.None;

					TreeItem item = (TreeItem) event.item;
					Object obj = item.getData();

					// TODO: only change if permitted
					// event.doit = false;
					// Object obj = event.item;
					// ((TreeItem) event.item).setChecked(false);

				}
			}
		});

		List<ACOrgUnit> orgUnits = new ArrayList<ACOrgUnit>();
		orgUnits.add(orgUnit);
		treeViewer.setInput(orgUnits);
		for (ACOrgUnit orgUnit : orgUnits) {
			if (orgUnit.getRoles().size() > 0) {
				treeViewer.expandToLevel(orgUnit, 1);
				treeViewer.setGrayChecked(new TreePath(new Object[] { orgUnit }), true);
			}
			for (RoleAssignment role : orgUnit.getRoles()) {
				treeViewer.setChecked(new TreePath(new Object[] { orgUnit, new RoleBox(role.getRole()) }), true);
			}
		}

		return container;
	}

	public boolean isSelected(ACOrgUnit orgUnit, Role role) {
		return treeViewer.getChecked(new TreePath(new Object[] { orgUnit, new RoleBox(role) }));
	}

}
