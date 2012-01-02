package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

/**
 * shows users/ groups in a tree, has a toolbar with add/delete user buttons and a refresh button
 * 
 * @author boehlke
 * 
 */
public class UsersView extends ViewPart {

	public static final String COMMANDID_DELETEUSER = "org.eclipse.emf.emfstore.client.ui.admin.DeleteUser";
	public static final String COMMANDID_CREATEUSER = "org.eclipse.emf.emfstore.client.ui.admin.CreateUser";

	public static final String ID = "org.eclipse.emf.emfstore.client.ui.views.users.UsersView"; //$NON-NLS-1$

	private static class UsersTreeContentProvider extends BaseWorkbenchContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PermissionSet) {
				PermissionSet set = (PermissionSet) parentElement;
				return set.getUsers().toArray();
			}
			return new Object[] {};
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	private UserUiController contoller;

	public UsersView() {
		this.contoller = UserUiController.getInstance();
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		createContols(container);
		initializeToolBar();
		initializeMenu();
	}

	private void createContols(Composite parent) {
		TreeViewer userTreeViewer = new TreeViewer(parent, SWT.BORDER);

		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		userTreeViewer.setLabelProvider(new WorkbenchLabelProvider());
		userTreeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {

			@Override
			public Object[] getElements(Object object) {
				List<ACUser> users = new ArrayList<ACUser>();
				for (Object obj : super.getChildren(object)) {
					if (obj instanceof ACUser) {
						ACUser user = (ACUser) obj;
						users.add(user);
					}
				}
				return users.toArray();
			}

		});
		userTreeViewer.setInput(contoller.getPermissionSet());
		getSite().setSelectionProvider(userTreeViewer);
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();

		toolbarManager.add(createCommandContributionItem(COMMANDID_CREATEUSER));
		toolbarManager.add(createCommandContributionItem(COMMANDID_DELETEUSER));
	}

	private ContributionItem createCommandContributionItem(String commandId) {
		CommandContributionItemParameter parm = new CommandContributionItemParameter(getSite(), null, commandId,
			CommandContributionItem.STYLE_PUSH);
		parm.iconStyle = ICommandImageService.IMAGE_STYLE_TOOLBAR;
		return new CommandContributionItem(parm);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}