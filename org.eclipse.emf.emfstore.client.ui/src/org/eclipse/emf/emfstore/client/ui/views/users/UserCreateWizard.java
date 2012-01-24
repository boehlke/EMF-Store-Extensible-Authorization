package org.eclipse.emf.emfstore.client.ui.views.users;

import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.jface.wizard.Wizard;

public class UserCreateWizard extends Wizard {

	private UserCreateDataWizardPage dataPage;
	private UserCreateRolesWizardPage rolePage;
	private UserUiController controller;

	public UserCreateWizard() {
		setWindowTitle("Create user wizard");
		this.controller = UserUiController.getInstance();
	}

	@Override
	public void addPages() {
		dataPage = new UserCreateDataWizardPage();
		addPage(dataPage);
		rolePage = new UserCreateRolesWizardPage();
		addPage(rolePage);
	}

	@Override
	public boolean performFinish() {
		ACUser newUser = AccesscontrolFactory.eINSTANCE.createACUser();
		newUser.setLastName(dataPage.getLastName());
		newUser.setFirstName(dataPage.getFirstName());
		newUser.setDescription(dataPage.getUserDescription());
		newUser.setName(dataPage.getLogin());

		controller.createUser(newUser, rolePage.getRoleSelection());

		return true;
	}

}
