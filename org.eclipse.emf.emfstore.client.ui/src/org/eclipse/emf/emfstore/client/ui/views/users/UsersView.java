package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecp.navigator.commands.AltKeyDoubleClickAction;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.client.ui.Activator;
import org.eclipse.emf.emfstore.client.ui.views.users.UsersView.AdministrationNavigatorRootNode.Type;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
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

	private UserUiController contoller;
	private TreeViewer userTreeViewer;

	public UsersView() {
		this.contoller = UserUiController.getInstance();
	}

	public static class AdministrationNavigatorRootNode {
		public enum Type {
			Users, Groups, SystemRoles, ProjectRoles
		}

		private Type type;
		private Object content;

		public AdministrationNavigatorRootNode(Type type, Object object) {
			this.type = type;
			this.content = object;
		}

		public Type getType() {
			return type;
		}

		public Object getContent() {
			return content;
		}
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
				return new Object[] { new AdministrationNavigatorRootNode(Type.Users, object),
					new AdministrationNavigatorRootNode(Type.Groups, object),
					new AdministrationNavigatorRootNode(Type.SystemRoles, object),
					new AdministrationNavigatorRootNode(Type.ProjectRoles, object) };
			}

			@Override
			public boolean hasChildren(Object object) {
				if (object instanceof AdministrationNavigatorRootNode) {
					return true;
				}
				return super.hasChildren(object);
			}

			@Override
			public Object[] getChildren(Object object) {
				List<Object> children = new ArrayList<Object>();
				if (object instanceof AdministrationNavigatorRootNode) {
					AdministrationNavigatorRootNode node = (AdministrationNavigatorRootNode) object;
					for (Object obj : super.getChildren(node.getContent())) {
						if (obj instanceof ACUser && node.getType() == Type.Users) {
							ACUser user = (ACUser) obj;
							children.add(user);
						}
						if (obj instanceof Role) {
							Role role = (Role) obj;
							if (role.isSystemRole() && node.getType() == Type.SystemRoles) {
								children.add(role);
							} else if (!role.isSystemRole() && node.getType() == Type.ProjectRoles) {
								children.add(role);
							}
						}
					}
					return children.toArray();
				}

				return super.getChildren(object);
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
