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
package org.eclipse.emf.emfstore.client.model.impl;

import java.util.List;

import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * Implementation of the AdminBroker.
 * 
 * @author Wesendonk
 */
/**
 * @author koegel
 */
/**
 * @author koegel
 */
public class AdminBrokerImpl implements AdminBroker {

	private SessionId sessionId;

	/**
	 * Constructor.
	 * 
	 * @param serverInfo server info
	 * @param sessionId session id, must be an admin session
	 * @throws ConnectionException if connection init fails
	 */
	public AdminBrokerImpl(ServerInfo serverInfo, SessionId sessionId) throws ConnectionException {
		this.sessionId = sessionId;
		WorkspaceManager.getInstance().getAdminConnectionManager().initConnection(serverInfo, sessionId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.AdminBroker#getProjectInfos()
	 */
	public List<ProjectInfo> getProjectInfos() throws EmfStoreException {

		return WorkspaceManager.getInstance().getAdminConnectionManager().getProjectInfos(getSessionId());
	}

	private SessionId getSessionId() {
		return sessionId;
	}

	public <T> T executeOperation(Operation<T> op) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager().executeOperation(sessionId, op);
	}

	public List<Permission[]> getOperationPermissions(Operation<?>[] operations) throws EmfStoreException {
		return WorkspaceManager.getInstance().getAdminConnectionManager()
			.getOperationPermissions(sessionId, operations);
	}

}
