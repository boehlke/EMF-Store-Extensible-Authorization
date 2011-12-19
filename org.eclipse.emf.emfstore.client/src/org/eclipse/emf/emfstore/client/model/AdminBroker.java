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
package org.eclipse.emf.emfstore.client.model;

import java.util.List;

import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * Interface for administrative services of the EMFStore. The Adminbroker
 * delegates the method calls to the server ( {@link org.eclipse.emf.emfstore.server.AdminEmfStore}) via
 * {@link org.eclipse.emf.emfstore.client.model.connectionmanager.AdminConnectionManager} .
 * 
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminBroker {

	/**
	 * Delegates call to method in {@link org.eclipse.emf.emfstore.server.AdminEmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.AdminEmfStore#getProjectInfos(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @return list of project infos
	 * @throws EmfStoreException
	 *             if an exceptions occurs on the server or on transport
	 */
	List<ProjectInfo> getProjectInfos() throws EmfStoreException;

	/**
	 * executes a user management operation
	 * 
	 * @param op
	 * @return
	 * @throws EmfStoreException
	 * @throws FatalEmfStoreException
	 */
	<T> T executeOperation(Operation<T> op) throws EmfStoreException;

	/**
	 * get permissions required to execute given operations on server
	 * 
	 * @param sessionId (ignored)
	 * @param operations
	 * @return
	 * @throws EmfStoreException
	 */
	List<Permission[]> getOperationPermissions(Operation<?>[] operations) throws EmfStoreException;

}
