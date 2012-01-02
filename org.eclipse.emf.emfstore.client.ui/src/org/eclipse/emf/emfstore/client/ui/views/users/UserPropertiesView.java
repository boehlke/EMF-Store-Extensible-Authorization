package org.eclipse.emf.emfstore.client.ui.views.users;

import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PinPropertySheetAction;
import org.eclipse.ui.views.properties.PropertySheet;

/**
 * this properties view only listens to user selections
 * 
 * @author boehlke
 * 
 */
public class UserPropertiesView extends PropertySheet {

	public static final String ID = "org.eclipse.emf.emfstore.client.ui.views.users.UserPropertiesView"; //$NON-NLS-1$

	public UserPropertiesView() {
	}

	/**
	 * only listen to relevant selection {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.PropertySheet#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection sel) {
		if (((IStructuredSelection) sel).getFirstElement() instanceof ACUser) {
			super.selectionChanged(part, sel);
		}
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		initializeToolBar();
		initializeMenu();
	}

	@Override
	public boolean isPinned() {
		return false;
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
		IContributionItem[] items = menuManager.getItems();
		for (IContributionItem iContributionItem : items) {
			if (iContributionItem instanceof ActionContributionItem) {
				if (((ActionContributionItem) iContributionItem).getAction() instanceof PinPropertySheetAction) {
					menuManager.remove(iContributionItem);
					break;
				}
			}
		}
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
