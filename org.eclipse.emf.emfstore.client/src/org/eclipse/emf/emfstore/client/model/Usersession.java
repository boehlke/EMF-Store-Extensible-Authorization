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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.observers.LoginObserver;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Usersession</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getSessionId <em>Session Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getPersistentPassword <em>Persistent Password</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getServerInfo <em>Server Info</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#isSavePassword <em>Save Password</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getACUser <em>AC User</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getChangedProperties <em>Changed Properties</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getPermissionSetCache <em>Permission Set Cache</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.Usersession#getProjectListCache <em>Project List Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession()
 * @model
 * @generated
 */
public interface Usersession extends EObject {
	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_Password()
	 * @model transient="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Session Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Id</em>' reference.
	 * @see #setSessionId(SessionId)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_SessionId()
	 * @model transient="true"
	 * @generated
	 */
	SessionId getSessionId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getSessionId <em>Session Id</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Id</em>' reference.
	 * @see #getSessionId()
	 * @generated
	 */
	void setSessionId(SessionId value);

	/**
	 * Returns the value of the '<em><b>Persistent Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent Password</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Password</em>' attribute.
	 * @see #setPersistentPassword(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_PersistentPassword()
	 * @model
	 * @generated
	 */
	String getPersistentPassword();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getPersistentPassword <em>Persistent Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistent Password</em>' attribute.
	 * @see #getPersistentPassword()
	 * @generated
	 */
	void setPersistentPassword(String value);

	/**
	 * Returns the value of the '<em><b>Server Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Info</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Info</em>' reference.
	 * @see #setServerInfo(ServerInfo)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_ServerInfo()
	 * @model
	 * @generated
	 */
	ServerInfo getServerInfo();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getServerInfo <em>Server Info</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Info</em>' reference.
	 * @see #getServerInfo()
	 * @generated
	 */
	void setServerInfo(ServerInfo value);

	/**
	 * Returns the value of the '<em><b>Save Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Save Password</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Save Password</em>' attribute.
	 * @see #setSavePassword(boolean)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_SavePassword()
	 * @model
	 * @generated
	 */
	boolean isSavePassword();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#isSavePassword <em>Save Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Save Password</em>' attribute.
	 * @see #isSavePassword()
	 * @generated
	 */
	void setSavePassword(boolean value);

	/**
	 * Returns the value of the '<em><b>AC User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AC User</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AC User</em>' containment reference.
	 * @see #setACUser(ACUser)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_ACUser()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ACUser getACUser();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getACUser <em>AC User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>AC User</em>' containment reference.
	 * @see #getACUser()
	 * @generated
	 */
	void setACUser(ACUser value);

	/**
	 * Returns the value of the '<em><b>Changed Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed Properties</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Properties</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_ChangedProperties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OrgUnitProperty> getChangedProperties();

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Log in.
	 * 
	 * @throws AccessControlException if login fails.
	 * @throws EmfStoreException if anything else fails. <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	void logIn() throws AccessControlException, EmfStoreException;

	/**
	 * Check if the user session is currently logged into a server.
	 * 
	 * @return true if it is.
	 */
	boolean isLoggedIn();
	
	/**
	 * Sends a logout call to the server.
	 * 
	 * @throws EmfStoreException forwards any exception.
	 */
	void logout() throws EmfStoreException;

	/**
	 * Returns the value of the '<em><b>Permission Set Cache</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission Set Cache</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission Set Cache</em>' containment reference.
	 * @see #setPermissionSetCache(PermissionSet)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_PermissionSetCache()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PermissionSet getPermissionSetCache();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.Usersession#getPermissionSetCache <em>Permission Set Cache</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permission Set Cache</em>' containment reference.
	 * @see #getPermissionSetCache()
	 * @generated
	 */
	void setPermissionSetCache(PermissionSet value);

	/**
	 * Returns the value of the '<em><b>Project List Cache</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.ProjectInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project List Cache</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project List Cache</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getUsersession_ProjectListCache()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ProjectInfo> getProjectListCache();

	/**
	 * Returns a {@link EmfStoreInterface} related to the user session.
	 * 
	 * @return {@link EmfStoreInterface}
	 * @throws EmfStoreException if no connection can be established
	 * @throws AccessControlException if access is denied
	 * @generated NOT
	 */
	EmfStoreInterface getEmfStoreProxy() throws EmfStoreException, AccessControlException;
	
	/**
	 * Updates the ProjectInfos for the current ServerInfo.
	 */
	void updateProjectInfos();

	/**
	 * Updates the ACUser and it roles.
	 * 
	 * @throws EmfStoreException forwards any exception.
	 */
	void updatePermissionSet() throws EmfStoreException;
	// end of custom code
} // Usersession
