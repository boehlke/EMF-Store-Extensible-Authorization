/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.users;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractSessionProvider;
import org.eclipse.emf.emfstore.client.ui.dialogs.login.LoginDialogController;
import org.eclipse.emf.emfstore.client.ui.dialogs.login.ServerInfoSelectionDialog;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;

/**
 * @author boehlke
 * 
 */
public class AdminUiSessionProvider extends AbstractSessionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractSessionProvider#provideUsersession(org.eclipse.emf.emfstore.client.model.ServerInfo)
	 */
	@Override
	public Usersession provideUsersession(ServerInfo serverInfo) throws EmfStoreException {
		if (serverInfo == null) {
			// try to retrieve a server info by showing a server info selection dialog
			ServerInfoSelectionDialog dialog = new ServerInfoSelectionDialog(Display.getCurrent().getActiveShell(),
				WorkspaceManager.getInstance().getCurrentWorkspace().getServerInfos());
			if (dialog.open() == Dialog.OK) {
				serverInfo = dialog.getResult();
			}
		}
		if (serverInfo == null) {
			throw new AccessControlException("Couldn't determine which server to connect.");
		}

		if (serverInfo.getLastUsersession() != null && serverInfo.getLastUsersession().isLoggedIn()) {
			return serverInfo.getLastUsersession();
		}

		return new LoginDialogController().login(serverInfo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractSessionProvider#login(org.eclipse.emf.emfstore.client.model.Usersession)
	 */
	@Override
	public void login(Usersession usersession) throws EmfStoreException {
		if (usersession != null) {
			new LoginDialogController().login(usersession);
		}
	}

}
