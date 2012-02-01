/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.users.command;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.ui.handlers.AbstractEMFStoreHandler;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.AssignRolesWizard;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author boehlke
 * 
 */
public class AssignProjectRolesCommandHandler extends AbstractEMFStoreHandler {

	@Override
	public void handle() throws EmfStoreException {
		ProjectInfo projectInfo = requireSelection(ProjectInfo.class);
		AssignRolesWizard wizard = new AssignRolesWizard(projectInfo, ((ServerInfo) projectInfo.eContainer())
			.getLastUsersession().getPermissionSetCache());
		Shell shell = getShell();
		Dialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
	}

}
