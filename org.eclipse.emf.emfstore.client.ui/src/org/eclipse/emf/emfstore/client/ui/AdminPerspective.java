package org.eclipse.emf.emfstore.client.ui;

import org.eclipse.emf.emfstore.client.ui.views.users.UsersView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The admin perspective shows views for adminstration tasks like managing users and roles
 * 
 * @author boehlke
 * 
 */
public class AdminPerspective implements IPerspectiveFactory {

	public static final String ID = "org.eclipse.emf.emfstore.client.ui.AdminPerspective";

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
		// Creates the overall folder layout.
		// Note that each new Folder uses a percentage of the remaining
		// EditorArea.

		layout.setEditorAreaVisible(true);
		IFolderLayout topLeft = layout.createFolder("topLeft", // NON-NLS-1
			IPageLayout.LEFT, 0.25f, layout.getEditorArea());

		topLeft.addView(UsersView.ID); // NON-NLS-1

		// IFolderLayout bottom = layout.createFolder("bottomRight", // NON-NLS-1
		// IPageLayout.BOTTOM, 0.5f, layout.getEditorArea());

		// bottom.addView(UserPropertiesView.ID);
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
