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
package org.eclipse.emf.emfstore.server;

import java.util.List;

import org.eclipse.emf.emfstore.server.accesscontrol.Permission;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

/**
 * AdminEmfStore offers an interface for administrating the users and their rights.
 * 
 * @author Hodaie
 * @author Wesendonk
 * @author boehlke
 */
public interface AdminEmfStore extends EmfStoreInterface {

	/**
	 * executes a user management operation
	 * 
	 * @param op
	 * @return
	 * @throws EmfStoreException
	 * @throws FatalEmfStoreException
	 */
	<T> T executeOperation(final SessionId sessionId, Operation<T> op) throws EmfStoreException;

	/**
	 * get permissions required to execute given operations on server
	 * 
	 * @param sessionId (ignored)
	 * @param operations
	 * @return
	 * @throws EmfStoreException
	 */
	List<Permission[]> getOperationPermissions(SessionId sessionId, Operation<?>[] operations) throws EmfStoreException;

	/**
	 * Returns a list of available project.
	 * 
	 * @param sessionId the session id for authentication
	 * @return list of project infos
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException;

}
