package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecp.navigator.commands.AltKeyDoubleClickAction;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.client.ui.Activator;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
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
	private TreeViewer userTreeViewer;

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
		userTreeViewer = new TreeViewer(parent, SWT.BORDER);

		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		AltKeyDoubleClickAction listener = new AltKeyDoubleClickAction(userTreeViewer, UsersView.ID);

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
		// toolbarManager.add(new Action() {
		//
		// @Override
		// public boolean isEnabled() {
		// return true;
		// }
		//
		// @Override
		// public String getText() {
		// return "Create Enco Roles";
		// }
		//
		// @Override
		// public void run() {
		// contoller.createStandardEnCoRoles();
		// }
		// });

		toolbarManager.add(new Action() {

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public String getText() {
				return "Update";
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getImageDescriptor("icons/refresh.png");
			}

			@Override
			public void run() {
				contoller.updatePermissionSet();
			}
		});
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
	}

}
