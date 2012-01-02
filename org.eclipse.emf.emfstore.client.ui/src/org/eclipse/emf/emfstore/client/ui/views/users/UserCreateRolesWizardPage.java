package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class UserCreateRolesWizardPage extends WizardPage {

	private ContainerCheckedTreeViewer treeViewer;

	/**
	 * Create the wizard.
	 */
	public UserCreateRolesWizardPage() {
		super("wizardPage");
		setTitle("User roles");
		setDescription("please select role which the user will have");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
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

		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new RoleSelectionContentProvider(UserUiController.getInstance()));

		treeViewer.setInput(Collections.EMPTY_LIST);

		Util.configureRoleSelectionTreeViewer(treeViewer);

		setControl(container);
	}

	public Collection<RoleSelection> getRoleSelection() {
		List<RoleSelection> selection = new ArrayList<RoleSelection>();
		for (Object object : ((ITreeSelection) treeViewer.getSelection()).toList()) {
			if (((RoleSelection) object).getRole() != null) {
				selection.add((RoleSelection) object);
			}
		}
		return selection;
	}

}
