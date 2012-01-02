package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

public class ChooseUsersPage extends WizardPage {
	private static class ViewerLabelProvider extends LabelProvider {
		@Override
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof ACUser) {
				ACUser user = (ACUser) element;
				return user.getName();
			}
			return super.getText(element);
		}
	}

	private static class TreeContentProvider implements ITreeContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof PermissionSet) {
				PermissionSet permSet = (PermissionSet) inputElement;
				return permSet.getUsers().toArray();
			}
			return null;
		}

		public Object[] getChildren(Object parentElement) {
			return new Object[] {};
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	private AssignRolesWizard wizard;

	/**
	 * Create the wizard.
	 * 
	 * @param assignRolesWizard
	 */
	public ChooseUsersPage(AssignRolesWizard assignRolesWizard) {
		super("wizardPage");
		setTitle("Choose Users");
		setDescription("Choose Users which roles will be assigned to");
		this.wizard = assignRolesWizard;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		CheckboxTreeViewer treeViewer = new ContainerCheckedTreeViewer(container, SWT.BORDER);
		Tree tree = treeViewer.getTree();

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnUser = treeViewerColumn.getColumn();
		trclmnUser.setWidth(200);
		trclmnUser.setText("User");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnRoles = treeViewerColumn_1.getColumn();
		trclmnRoles.setWidth(200);
		trclmnRoles.setText("Roles");
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		TreeContentProvider contentProvider = new TreeContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setInput(wizard.getPermissionSet());
		treeViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					wizard.getSelectedUsers().add((ACUser) event.getElement());
				} else {
					wizard.getSelectedUsers().remove(event.getElement());
				}
			}
		});
	}

	@Override
	public boolean canFlipToNextPage() {
		return wizard.getSelectedUsers().size() > 0;
	}
}
