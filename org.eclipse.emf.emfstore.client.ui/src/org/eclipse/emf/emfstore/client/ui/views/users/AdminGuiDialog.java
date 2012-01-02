package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class AdminGuiDialog extends TitleAreaDialog {

	private static class ProjectsTreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Collection<?>) {
				Collection<?> projects = (Collection<?>) parentElement;
				return projects.toArray();
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

	private PermissionSet permissionSet;
	private Collection<ProjectInfo> projects;
	private Map<String, ProjectInfo> projectInfoMap;
	private Composite editorComposite;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AdminGuiDialog(Shell parentShell, PermissionSet permissionSet, Map<String, ProjectInfo> projectInfoMap) {
		super(parentShell);
		this.permissionSet = permissionSet;
		this.projectInfoMap = projectInfoMap;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("User Administration");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		SashForm sashForm = new SashForm(container, SWT.BORDER | SWT.SMOOTH);

		TabFolder tabFolder = new TabFolder(sashForm, SWT.NONE);

		TabItem tbtmUsers = new TabItem(tabFolder, SWT.NONE);
		tbtmUsers.setText("Users");

		Menu menu = new Menu(tabFolder);
		tabFolder.setMenu(menu);

		editorComposite = new Composite(sashForm, SWT.NONE);
		editorComposite.setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm.setWeights(new int[] { 1, 2 });

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(788, 716);
	}
}
