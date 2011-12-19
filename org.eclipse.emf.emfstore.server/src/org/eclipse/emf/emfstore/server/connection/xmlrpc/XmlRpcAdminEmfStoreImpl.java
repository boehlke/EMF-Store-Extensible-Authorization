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
package org.eclipse.emf.emfstore.server.connection.xmlrpc;

import java.util.List;

import org.eclipse.emf.emfstore.server.AdminEmfStore;
import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * XML RPC connection interface for adminemfstore.
 * 
 * @author wesendon
 * @author boehlke
 */
public class XmlRpcAdminEmfStoreImpl implements AdminEmfStore {

	private AdminEmfStore getAdminEmfStore() {
		return XmlRpcAdminConnectionHander.getAdminEmfStore();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		return getAdminEmfStore().getProjectInfos(sessionId);
	}

	public <T> T executeOperation(SessionId sessionId, Operation<T> op) throws EmfStoreException {
		return getAdminEmfStore().executeOperation(sessionId, op);
	}

	public List<Permission[]> getOperationPermissions(SessionId sessionId, Operation<?>[] operations)
		throws EmfStoreException {
		return getAdminEmfStore().getOperationPermissions(sessionId, operations);
	}

}
