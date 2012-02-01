package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class AssignRoleSummaryPage extends WizardPage {
	private static class ContentProvider implements ITreeContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			return ((Collection<RoleAssignmentData>) inputElement).toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			viewer.refresh();
		}

		public Object[] getChildren(Object parentElement) {
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}
	}

	private AssignRolesWizard wizard;
	private TreeViewer removedRolesViewer;
	private TreeViewer newRolesViewer;

	/**
	 * Create the wizard.
	 */
	public AssignRoleSummaryPage(final AssignRolesWizard wizard) {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
		this.wizard = wizard;
		final Object test = this;
		if (wizard.getContainer() instanceof WizardDialog) {
			WizardDialog dialog = (WizardDialog) wizard.getContainer();
			dialog.addPageChangingListener(new IPageChangingListener() {

				public void handlePageChanging(PageChangingEvent event) {
					if (event.getTargetPage() == test) {
						removedRolesViewer.setInput(wizard.getRemovedRoles());
						newRolesViewer.setInput(wizard.getAddedRoles());
					}
				}
			});
		} else {
			throw new RuntimeException("wizard MUST run in a dialog");
		}
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("New Role Assignments");

		newRolesViewer = new TreeViewer(container, SWT.BORDER | SWT.V_SCROLL);
		Tree newRoles = newRolesViewer.getTree();
		GridData gd_newRoles = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		newRoles.setLayoutData(gd_newRoles);
		ContentProvider contentProvider = new ContentProvider();
		newRolesViewer.setContentProvider(contentProvider);
		ILabelProvider labelProvider = new WorkbenchLabelProvider();
		newRolesViewer.setLabelProvider(labelProvider);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Role Assignments to be deleted");

		removedRolesViewer = new TreeViewer(container, SWT.BORDER | SWT.V_SCROLL);
		Tree removedRoles = removedRolesViewer.getTree();
		GridData gd_removedRoles = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		removedRoles.setLayoutData(gd_removedRoles);
		removedRolesViewer.setLabelProvider(labelProvider);
		removedRolesViewer.setContentProvider(contentProvider);
	}

}
