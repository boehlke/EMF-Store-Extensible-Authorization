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
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.views.scm.SCMTreeNode;
import org.eclipse.emf.emfstore.client.ui.views.users.UserUiController;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.StaticOperationFactory;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;

/**
 * Tests if the user has admin permissions based on a HistoryInfo node.
 * 
 * @author shterev
 */
public class HistoryBrowserAdminTester extends PropertyTester {

	private static final Object PROP_CAN_REMOVE_TAG = "canRemoveTag";
	private static final Object PROP_CAN_ADD_TAG = "canAddTag";
	private static final Object PROP_CAN_REVERT = "canRevert";
	private static final Object PROP_CAN_FORCE_REVERT = "canForceRevert";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof SCMTreeNode && expectedValue instanceof Boolean) {
			SCMTreeNode node = (SCMTreeNode) receiver;
			final ProjectSpace projectSpace = node.getProjectSpace();
			if (projectSpace == null) {
				return false;
			}

			if (property.equals(PROP_CAN_REMOVE_TAG)) {
				TagVersionSpec tag = VersioningFactory.eINSTANCE.createTagVersionSpec();
				try {
					// TODO: this should be called with the real tag which would be removed
					return UserUiController.getInstance().canExecute(
						StaticOperationFactory.createRemoveTagOperation(projectSpace.getProjectId(), projectSpace
							.getProjectInfo().getVersion(), tag));
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					return false;
				}
			} else if (property.equals(PROP_CAN_ADD_TAG)) {
				TagVersionSpec tag = VersioningFactory.eINSTANCE.createTagVersionSpec();
				try {
					return UserUiController.getInstance().canExecute(
						StaticOperationFactory.createAddTagOperation(projectSpace.getProjectId(), projectSpace
							.getProjectInfo().getVersion(), tag));
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					return false;
				}
			} else if (property.equals(PROP_CAN_FORCE_REVERT)) {
				// TODO
				return true;
			} else if (property.equals(PROP_CAN_REVERT)) {
				// TODO
				return true;
			}
		}
		return false;
	}

}
