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
package org.eclipse.emf.emfstore.client.model.accesscontrol;

import java.util.Arrays;

import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider;
import org.eclipse.emf.emfstore.server.accesscontrol.util.PermissionUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * Helper class for access control checks.
 * 
 * @author koegel
 */
public class AccessControlHelper {

	private ACUser user;
	private Usersession usersession;
	private PermissionProvider permissionProvider;

	/**
	 * Default constructor.
	 * 
	 * @param usersession the user session that needs to be checked
	 */
	public AccessControlHelper(Usersession usersession) {
		this.usersession = usersession;
		this.user = usersession.getACUser();
		try {
			this.permissionProvider = ServerConfiguration.getPermissionSetConfiguration().getPermissionProvider();
		} catch (FatalEmfStoreException e) {
			throw new RuntimeException(e);
		}
	}

	private void hasPermission() {
		this.permissionProvider.setPermissionContext(new ClientPermissionContext(null));
	}

	public boolean isServerAdmin() {
		// TODO: this is not nice, relying on user contained in a permission set
		PermissionSet permissionSet = (PermissionSet) user.eContainer();
		for (RoleAssignment role : user.getRoles()) {
			if (role.getRole() == permissionSet.getSuperUserRole()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check the server admin access.
	 * 
	 * @throws AccessControlException if access is denied.
	 */
	public void checkServerAdminAccess() throws AccessControlException {
		if (!isServerAdmin()) {
			throw new AccessControlException();
		}
	}

	/**
	 * @return usersession
	 */
	public Usersession getUsersession() {
		return usersession;
	}

	public boolean hasPermission(Operation<?> op) throws AccessControlException, EmfStoreException {
		Permission[] permissions = usersession.getEmfStoreProxy().getOperationPermissions(new Operation<?>[] { op })
			.get(0);
		return PermissionUtil.hasPermissions(user, Arrays.asList(permissions));
	}
}
