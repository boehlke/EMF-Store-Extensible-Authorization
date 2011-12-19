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
package org.eclipse.emf.emfstore.client.model.connectionmanager.xmlrpc;

import java.util.List;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AdminConnectionManager;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.XmlRpcAdminConnectionHander;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * connection manager for adminemfstore.
 * 
 * @author wesendon
 */
public class XmlRpcAdminConnectionManager extends AbstractConnectionManager<XmlRpcClientManager> implements
	AdminConnectionManager {

	/**
	 * {@inheritDoc}
	 */
	public void initConnection(ServerInfo serverInfo, SessionId id) throws ConnectionException {
		XmlRpcClientManager clientManager = new XmlRpcClientManager(XmlRpcAdminConnectionHander.ADMINEMFSTORE);
		clientManager.initConnection(serverInfo);
		addConnectionProxy(id, clientManager);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getProjectInfos", ProjectInfo.class, sessionId);
	}

	@SuppressWarnings("unchecked")
	public <T> T executeOperation(SessionId sessionId, Operation<T> op) throws EmfStoreException {
		return (T) getConnectionProxy(sessionId).callWithResult("executeOperation", Object.class, sessionId, op);
	}

	public List<Permission[]> getOperationPermissions(SessionId sessionId, Operation<?>[] operations)
		throws EmfStoreException {
		return getConnectionProxy(sessionId).callWithListResult("getOperationPermissions", Permission[].class,
			sessionId, operations);
	}

}
