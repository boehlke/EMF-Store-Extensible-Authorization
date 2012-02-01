/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.test.server;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.test.SetupHelper;
import org.eclipse.emf.emfstore.client.test.WorkspaceTest;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.accesscontrol.simple.SimplePermissionProvider;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Superclass for server tests.
 * 
 * @author wesendon
 */

public class ServerTests extends WorkspaceTest {

	private static SessionId sessionId;
	private static ConnectionManager connectionManager;
	private int projectsOnServerBeforeTest;
	private String writerRoleId;
	private String readerRoleId;
	private String adminRoleId;
	private static HashMap<Class<?>, Object> arguments;
	private static ServerInfo serverInfo;

	public static void setServerInfo(ServerInfo server_Info) {
		serverInfo = server_Info;
	}

	public static ServerInfo getServerInfo() {
		return serverInfo;
	}

	/**
	 * @return the sessionId
	 */
	public static SessionId getSessionId() {
		return sessionId;
	}

	public static void setSessionId(SessionId session_id) {
		sessionId = session_id;
	}

	/**
	 * @return the connectionManager
	 */
	public static ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public ProjectInfo getProjectInfo() {
		return getProjectSpace().getProjectInfo();
	}

	public ProjectId getProjectId() {
		return getProjectSpace().getProjectId();
	}

	public PrimaryVersionSpec getProjectVersion() {
		return getProjectInfo().getVersion();
	}

	/**
	 * @return the projectsOnServerBeforeTest
	 */
	public int getProjectsOnServerBeforeTest() {
		return projectsOnServerBeforeTest;
	}

	/**
	 * Start server and gain sessionid.
	 * 
	 * @throws EmfStoreException in case of failure
	 * @throws IOException
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws EmfStoreException, IOException {
		ServerConfiguration.setTesting(true);
		Configuration.setTesting(true);

		// delete all data before test start
		SetupHelper.removeServerTestProfile();

		SetupHelper.addUserFileToServer(false);
		SetupHelper.startSever();
		setConnectionManager(WorkspaceManager.getInstance().getConnectionManager());
		setServerInfo(SetupHelper.getServerInfo());
		// login();
		initArguments();
	}

	/**
	 * sets users on server.
	 * 
	 * @throws EmfStoreException in case of failure
	 */

	public void setupUsersAndRoles() throws EmfStoreException {
		PermissionSet set = SetupHelper.updatePermissionSet(getSessionId());
		if (set.getRole("Project Reader") == null) {
			writerRoleId = SetupHelper.addRole(getSessionId(), set, "Project Writer",
				SimplePermissionProvider.PROJECT_WRITER_PERMISSION, SimplePermissionProvider.PROJECT_READER_PERMISSION);
			readerRoleId = SetupHelper.addRole(getSessionId(), set, "Project Reader",
				SimplePermissionProvider.PROJECT_READER_PERMISSION);
			adminRoleId = SetupHelper.addRole(getSessionId(), set, "Project Admin",
				SimplePermissionProvider.PROJECT_WRITER_PERMISSION, SimplePermissionProvider.PROJECT_READER_PERMISSION,
				SimplePermissionProvider.PROJECT_ADMIN_PERMISSION);
			ACOrgUnitId orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "reader").getId();
			SetupHelper.addUsersRole(getSessionId(), orgUnitId.getId(), readerRoleId, getProjectId());

			orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "writer1").getId();
			SetupHelper.addUsersRole(getSessionId(), orgUnitId.getId(), writerRoleId, getProjectId());

			orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "writer2").getId();
			SetupHelper.addUsersRole(getSessionId(), orgUnitId.getId(), writerRoleId, getProjectId());

			orgUnitId = SetupHelper.createUserOnServer(getSessionId(), "projectadmin").getId();
			SetupHelper.addUsersRole(getSessionId(), orgUnitId.getId(), adminRoleId, getProjectId());

		}
	}

	/**
	 * Sets the connection manager.
	 * 
	 * @param cm connection manager
	 */
	protected static void setConnectionManager(ConnectionManager cm) {
		connectionManager = cm;
	}

	/**
	 * @param serverInfo serverinfo
	 * @throws EmfStoreException in case of failure
	 */
	protected static void login() throws EmfStoreException {
		SessionId sessionId = login(getServerInfo(), "super", "super");
		setSessionId(sessionId);
	}

	/**
	 * @param serverInfo serverinfo
	 * @param username username
	 * @param password password
	 * @return sessionId
	 * @throws EmfStoreException in case of failure
	 */
	protected static SessionId login(ServerInfo serverInfo, String username, String password) throws EmfStoreException {
		return getConnectionManager().logIn(username, KeyStoreManager.getInstance().encrypt(password, serverInfo),
			serverInfo, Configuration.getClientVersion());
	}

	private static void initArguments() {
		arguments = new HashMap<Class<?>, Object>();
		arguments.put(boolean.class, false);
		arguments.put(String.class, new String());
		arguments.put(SessionId.class, EcoreUtil.copy(getSessionId()));
		arguments.put(ProjectId.class, org.eclipse.emf.emfstore.server.model.ModelFactory.eINSTANCE.createProjectId());
		arguments.put(PrimaryVersionSpec.class, VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		arguments.put(VersionSpec.class, VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		arguments.put(TagVersionSpec.class, VersioningFactory.eINSTANCE.createTagVersionSpec());
		arguments.put(LogMessage.class, VersioningFactory.eINSTANCE.createLogMessage());
		arguments.put(Project.class, ModelFactory.eINSTANCE.createProject());
		arguments.put(ChangePackage.class, VersioningFactory.eINSTANCE.createChangePackage());
		arguments.put(HistoryQuery.class, VersioningFactory.eINSTANCE.createHistoryQuery());
		arguments.put(ChangePackage.class, VersioningFactory.eINSTANCE.createChangePackage());
		arguments.put(ACOrgUnitId.class, AccesscontrolFactory.eINSTANCE.createACOrgUnitId());
	}

	/**
	 * Shuts down server after testing.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		SetupHelper.stopServer();

	}

	/**
	 * Adds a project to the server before test.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Before
	public void beforeTest() throws EmfStoreException {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				try {
					getProjectSpace().shareProject(TestSessionProvider.getInstance().getDefaultUsersession(), null);
					// setupUsersAndRoles();
				} catch (EmfStoreException e) {
					Assert.fail(e.getMessage());
				}
			}
		}.run(false);
		// setProjectInfo(getConnectionManager().createProject(getSessionId(), "initialProject", "TestProject",
		// SetupHelper.createLogMessage("super", "a logmessage"), getProject()));
		this.projectsOnServerBeforeTest = 1;
	}

	/**
	 * Removes all projects from server after test.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@After
	public void afterTest() throws EmfStoreException {
		for (ProjectInfo info : WorkspaceManager.getInstance().getCurrentWorkspace()
			.getRemoteProjectList(getServerInfo())) {
			WorkspaceManager.getInstance().getCurrentWorkspace()
				.deleteRemoteProject(getServerInfo(), info.getProjectId(), true);
		}
		SetupHelper.cleanupServer();
	}

	/**
	 * Sets up user on server.
	 * 
	 * @param name name of the user (must be specified in users.properties)
	 * @param role of type RolesPackage.eINSTANCE.getWriterRole() or RolesPackage.eINSTANCE.getReaderRole() ....
	 * @throws EmfStoreException in case of failure
	 */

	/**
	 * Sets up usersession.
	 * 
	 * @param name of the user (must be specified in users.properties)
	 * @param password of the user (must be specified in users.properties)
	 * @return established usersession
	 */
	public Usersession setUpUsersession(String username, String password) {
		Usersession usersession = org.eclipse.emf.emfstore.client.model.ModelFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(getServerInfo());
		usersession.setUsername(username);
		usersession.setPassword(password);
		return usersession;
	}

	/**
	 * Compares two projects.
	 * 
	 * @param expected expected
	 * @param compare to be compared
	 */
	public static void assertEqual(Project expected, Project compare) {
		try {
			if (!ModelUtil.eObjectToString(expected).equals(ModelUtil.eObjectToString(compare))) {
				throw new AssertionError("Projects are not equal.");
			}
		} catch (SerializationException e) {
			throw new AssertionError("Couldn't compare projects.");
		}
	}

	/**
	 * Creates a historyquery.
	 * 
	 * @param ver1 source
	 * @param ver2 target
	 * @return historyquery
	 */
	public static HistoryQuery createHistoryQuery(PrimaryVersionSpec ver1, PrimaryVersionSpec ver2) {
		HistoryQuery historyQuery = VersioningFactory.eINSTANCE.createHistoryQuery();
		historyQuery.setSource(EcoreUtil.copy(ver1));
		historyQuery.setTarget(EcoreUtil.copy(ver2));
		return historyQuery;
	}

	/**
	 * Get a default Parameter.
	 * 
	 * @param clazz parameter type
	 * @param b if false, null is returned
	 * @return parameter
	 */
	protected static Object getParameter(Class<?> clazz, boolean b) {
		if (clazz.equals(boolean.class)) {
			return false;
		}
		return (b) ? arguments.get(clazz) : null;
	}

	public String getReaderRoleId() {
		return readerRoleId;
	}

	public String getWriterRoleId() {
		return writerRoleId;
	}

	public String getAdminRoleId() {
		return adminRoleId;
	}
}