/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;

/**
 * This property tester checks if current user is ACUser.
 * 
 * @author weiglt
 */
public class IsACUserTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {

		if (receiver instanceof ProjectSpace && expectedValue instanceof Boolean) {
			final ProjectSpace projectSpace = (ProjectSpace) receiver;
			EMFStoreCommandWithResult<Boolean> command = new EMFStoreCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					Usersession usersession = projectSpace.getUsersession();
					boolean isACUser = false;
					if (usersession != null) {
						AccessControlHelper accessControlHelper = new AccessControlHelper(usersession);
						try {
							accessControlHelper.checkWriteAccess(projectSpace.getProjectId());
							isACUser = true;
						} catch (AccessControlException e) {
							isACUser = false;
						}
					}

					return new Boolean(isACUser).equals(expectedValue);
				}
			};
			return command.run(false);
		}
		return false;
	}

}
