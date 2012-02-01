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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.InternalPermission;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.AbstractAuthenticationControl;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.factory.AuthenticationControlFactory;
import org.eclipse.emf.emfstore.server.accesscontrol.authentication.factory.AuthenticationControlFactoryImpl;
import org.eclipse.emf.emfstore.server.core.MonitorProvider;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.SessionTimedOutException;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * A simple implementation of Authentication and Authorization Control.
 * 
 * @author koegel
 * @author wesendonk
 */
public class AccessControlImpl implements AuthenticationControl, AuthorizationControl {

	private Map<SessionId, ACUserContainer> sessionUserMap;
	private ServerSpace serverSpace;
	private AbstractAuthenticationControl authenticationControl;
	private PermissionProvider permissionProvider;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the server space to work on
	 * @throws FatalEmfStoreException
	 *             an exception
	 */
	public AccessControlImpl(ServerSpace serverSpace, PermissionProvider permissionProvider)
		throws FatalEmfStoreException {
		this.sessionUserMap = new HashMap<SessionId, ACUserContainer>();
		this.serverSpace = serverSpace;
		this.permissionProvider = permissionProvider;

		authenticationControl = getAuthenticationFactory().createAuthenticationControl();
	}

	private AuthenticationControlFactory getAuthenticationFactory() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.emfstore.server.authenticationfactory");

		// get all providers from the extension points
		for (IConfigurationElement e : config) {
			try {
				Object o = e.createExecutableExtension("class");
				if (o instanceof AuthenticationControlFactory) {
					return (AuthenticationControlFactory) o;
				}
			} catch (CoreException e1) {
				// fail silently
				// e1.printStackTrace();
			}
		}

		// fallback in case that no factory was registered
		return new AuthenticationControlFactoryImpl();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl#logIn(java.lang.String,
	 *      java.lang.String)
	 */
	public SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor("authentication")) {
			ACUser user = resolveUser(username);
			SessionId sessionId = authenticationControl.logIn(user.getName(), password, clientVersionInfo);
			sessionUserMap.put(sessionId, new ACUserContainer(user));
			return sessionId;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl#logout(org.eclipse.emf.emfstore.server.model.SessionId)
	 */
	public void logout(SessionId sessionId) throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor("authentication")) {
			if (sessionId == null) {
				throw new AccessControlException("SessionId is null.");
			}
			sessionUserMap.remove(sessionId);
		}
	}

	/**
	 * Resolve a String to a user.
	 * 
	 * @param username
	 * @return the ACuser instance with the given name
	 * @throws AccessControlException
	 *             if there is no such user
	 */
	private ACUser resolveUser(String username) throws AccessControlException {

		Boolean ignoreCase = Boolean.parseBoolean(ServerConfiguration.getProperties().getProperty(
			ServerConfiguration.AUTHENTICATION_MATCH_USERS_IGNORE_CASE, "false"));

		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (ignoreCase) {
					if (user.getName().equalsIgnoreCase(username)) {
						return user;
					}
				} else {
					if (user.getName().equals(username)) {
						return user;
					}
				}
			}
			throw new AccessControlException();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl#checkSession(org.eclipse.emf.emfstore.server.model.SessionId)
	 */
	public void checkSession(SessionId sessionId) throws AccessControlException {
		if (!sessionUserMap.containsKey(sessionId)) {
			throw new SessionTimedOutException("Session ID unkown.");
		}
		sessionUserMap.get(sessionId).checkLastActive();
	}

	private ACUser getUser(ACOrgUnitId orgUnitId) throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (user.getId().equals(orgUnitId)) {
					return user;
				}
			}
			throw new AccessControlException("Given User doesn't exist.");
		}
	}

	public PermissionProvider getPermissionProvider() {
		return permissionProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId) throws AccessControlException {
		checkSession(sessionId);
		return sessionUserMap.get(sessionId).getRawUser();
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(ACOrgUnitId id) throws AccessControlException {
		return getUser(id);
	}

	// extract to normal class
	/**
	 * @author wesendonk
	 */
	private class ACUserContainer {
		private ACUser acUser;
		// private long firstActive;
		private long lastActive;

		public ACUserContainer(ACUser acUser) {
			this.acUser = acUser;
			// firstActive = System.currentTimeMillis();
			active();
		}

		/**
		 * Get the ACUser.
		 * 
		 * @return
		 * @throws AccessControlException
		 */
		public ACUser getUser() {
			active();
			return getRawUser();
		}

		public ACUser getRawUser() {
			return acUser;
		}

		public void checkLastActive() throws AccessControlException {
			// OW finish implementing this method
			String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SESSION_TIMEOUT,
				ServerConfiguration.SESSION_TIMEOUT_DEFAULT);
			if (System.currentTimeMillis() - lastActive > Integer.parseInt(property)
			/*
			 * || System.currentTimeMillis() - firstActive >
			 * Integer.parseInt(property)
			 */) {
				// OW: delete from map
				throw new SessionTimedOutException("Usersession timed out.");
			}
		}

		private void active() {
			lastActive = System.currentTimeMillis();
		}
	}

	public void checkPermission(SessionId sessionId, InternalPermission permission) throws AccessControlException {
		Collection<InternalPermission> permissions = new ArrayList<InternalPermission>();
		permissions.add(permission);
		checkPermissions(sessionId, permissions);
	}

	public void checkPermissions(SessionId sessionId, Collection<InternalPermission> permissions)
		throws AccessControlException {
		if (!hasPermissions(sessionId, permissions)) {
			List<Permission> missingPermissions = new ArrayList<Permission>();
			for (InternalPermission permission : getMissingPermissions(sessionId, permissions)) {
				ProjectId projectId = permission.getProjectId();
				missingPermissions.add(new Permission(permission.getType().getId(), projectId == null ? null
					: projectId.getId()));
			}
			throw new AccessControlException(missingPermissions.toArray(new Permission[0]));
		}
	}

	public boolean hasPermissions(SessionId sessionId, Collection<InternalPermission> permissions)
		throws AccessControlException {
		InternalPermission[] missingPermissions = getMissingPermissions(sessionId, permissions);
		if (missingPermissions.length == 0) {
			return true;
		}
		return false;
	}

	public InternalPermission[] getMissingPermissions(SessionId sessionId, Collection<InternalPermission> permissions)
		throws AccessControlException {
		checkSession(sessionId);
		ACUserContainer userContainer = sessionUserMap.get(sessionId);
		ACUser user = userContainer.getUser();

		Set<InternalPermission> requiredPermissions = new HashSet<PermissionProvider.InternalPermission>();
		requiredPermissions.addAll(permissions);

		for (InternalPermission permission : getPermissions(user)) {
			ProjectId projectId = permission.getProjectId();
			Iterator<InternalPermission> iterator = requiredPermissions.iterator();
			while (iterator.hasNext()) {
				InternalPermission requiredPermission = iterator.next();
				if (requiredPermission.getType().equals(permission.getType())
					&& (projectId == null || projectId.equals(requiredPermission.getProjectId()))) {
					iterator.remove();
				}
			}

			if (requiredPermissions.size() == 0) {
				return new InternalPermission[] {};
			}
		}

		return requiredPermissions.toArray(new InternalPermission[0]);

	}

	private Set<InternalPermission> getPermissions(ACOrgUnit orgUnit) {
		Set<InternalPermission> permissions = new HashSet<InternalPermission>();

		for (RoleAssignment assignment : orgUnit.getRoles()) {
			for (PermissionType permissionType : assignment.getRole().getPermissionTypes()) {
				permissions.add(new InternalPermission(permissionType, assignment.getProjectId()));
			}
		}

		for (ACGroup group : orgUnit.getGroups()) {
			permissions.addAll(getPermissions(group));
		}

		return permissions;
	}

	public boolean hasPermissions(SessionId sessionId, Operation<?> operation) throws AccessControlException {
		return hasPermissions(sessionId, getPermissions(sessionId, operation));
	}

	public Collection<InternalPermission> getPermissions(SessionId sessionId, Operation<?> op)
		throws AccessControlException {
		checkSession(sessionId);
		ACUserContainer userContainer = sessionUserMap.get(sessionId);
		if (userContainer == null) {
			throw new RuntimeException();
		}
		ACUser user = userContainer.getUser();
		return getPermissionProvider().getPermissions(op, user);
	}

	public void checkPermissions(SessionId sessionId, Operation<?> op) throws AccessControlException {
		checkPermissions(sessionId, getPermissions(sessionId, op));
	}
}
