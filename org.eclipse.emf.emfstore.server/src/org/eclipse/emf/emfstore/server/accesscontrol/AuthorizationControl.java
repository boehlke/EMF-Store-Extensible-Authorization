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
package org.eclipse.emf.emfstore.server.accesscontrol;

import java.util.Collection;

import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.InternalPermission;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * Control for the authorization of users.
 * 
 * @author koegel
 * @author boehlke
 */
public interface AuthorizationControl {

	/**
	 * Check if the given session is valid.
	 * 
	 * @param sessionId
	 *            the session id
	 * @throws AccessControlException
	 *             if the session is invalid
	 */
	void checkSession(SessionId sessionId) throws AccessControlException;

	void checkPermission(SessionId sessionId, InternalPermission permission) throws AccessControlException;

	void checkPermissions(SessionId sessionId, Collection<InternalPermission> permissions)
		throws AccessControlException;

	/**
	 * This method looks up the session id on the server and returns the
	 * relating user. Please notice that the returned user also contains roles
	 * which are not contained in the original user. These extra roles come from
	 * the user's groups.
	 * 
	 * @param sessionId
	 *            session id
	 * @return ACUser user with roles from resolved user and it's groups
	 * @throws AccessControlException
	 *             exception
	 */
	ACUser resolveUser(SessionId sessionId) throws AccessControlException;

	/**
	 * This method looks up the orgUnit id the server and returns the relating
	 * user. Please notice that the returned user also contains roles which are
	 * not contained in the original user. These extra roles come from the
	 * user's groups.
	 * 
	 * @param orgUnitId
	 *            OrgUnit id
	 * @return ACUser user with roles from resolved user and it's groups
	 * @throws AccessControlException
	 *             exception
	 */
	ACUser resolveUser(ACOrgUnitId orgUnitId) throws AccessControlException;

	boolean hasPermissions(SessionId sessionId, Collection<InternalPermission> readOperationPermissions)
		throws AccessControlException;

	boolean hasPermissions(SessionId sessionId, Operation<?> operation) throws AccessControlException;

	Collection<InternalPermission> getPermissions(SessionId sessionId, Operation<?> op) throws AccessControlException;

	void checkPermissions(SessionId sessionId, Operation<?> op) throws AccessControlException;
}
