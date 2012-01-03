/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.users.command;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
import org.eclipse.emf.emfstore.client.ui.views.users.UserUiController;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.jface.viewers.TreeNode;

/**
 * 
 * @author boehlke
 * 
 */
public class CanDeleteOrgUnitTester extends PropertyTester {

	private UserUiController controller;

	/**
	 * 
	 */
	public CanDeleteOrgUnitTester() {
		this.controller = UserUiController.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		ACOrgUnit orgUnit = null;
		if (receiver instanceof TreeNode && ((TreeNode) receiver).getValue() instanceof ACOrgUnit) {
			orgUnit = (ACOrgUnit) ((TreeNode) receiver).getValue();
		} else if (receiver instanceof ACOrgUnit) {
			orgUnit = (ACOrgUnit) receiver;
		}
		if (orgUnit != null && expectedValue instanceof Boolean) {
			final ACOrgUnit orgUnitFinal = orgUnit;
			EMFStoreCommandWithResult<Boolean> command = new EMFStoreCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					try {
						return controller.canExecute(StaticOperationFactory.createDeleteOrgUnitOperation(orgUnitFinal
							.getId()));
					} catch (InvalidInputException e) {
						// we cannot do anything about this here
						throw new RuntimeException(e);
					}
				}
			};
			Boolean result = command.run(false);
			return result;
		}
		return false;
	}
}
