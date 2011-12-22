/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl;

import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl#getReferingRoles <em>Refering Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.PermissionTypeImpl#isProjectPermission <em>Project Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionTypeImpl extends IdentifiableElementImpl implements PermissionType {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferingRoles() <em>Refering Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferingRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> referingRoles;

	/**
	 * The default value of the '{@link #isProjectPermission() <em>Project Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjectPermission()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROJECT_PERMISSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProjectPermission() <em>Project Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjectPermission()
	 * @generated
	 * @ordered
	 */
	protected boolean projectPermission = PROJECT_PERMISSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PermissionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.PERMISSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.PERMISSION_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getReferingRoles() {
		if (referingRoles == null) {
			referingRoles = new EObjectWithInverseResolvingEList.ManyInverse<Role>(Role.class, this, AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES, AccesscontrolPackage.ROLE__PERMISSION_TYPES);
		}
		return referingRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProjectPermission() {
		return projectPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectPermission(boolean newProjectPermission) {
		boolean oldProjectPermission = projectPermission;
		projectPermission = newProjectPermission;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccesscontrolPackage.PERMISSION_TYPE__PROJECT_PERMISSION, oldProjectPermission, projectPermission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferingRoles()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				return ((InternalEList<?>)getReferingRoles()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__ID:
				return getId();
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				return getReferingRoles();
			case AccesscontrolPackage.PERMISSION_TYPE__PROJECT_PERMISSION:
				return isProjectPermission();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__ID:
				setId((String)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				getReferingRoles().clear();
				getReferingRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case AccesscontrolPackage.PERMISSION_TYPE__PROJECT_PERMISSION:
				setProjectPermission((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				getReferingRoles().clear();
				return;
			case AccesscontrolPackage.PERMISSION_TYPE__PROJECT_PERMISSION:
				setProjectPermission(PROJECT_PERMISSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AccesscontrolPackage.PERMISSION_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case AccesscontrolPackage.PERMISSION_TYPE__REFERING_ROLES:
				return referingRoles != null && !referingRoles.isEmpty();
			case AccesscontrolPackage.PERMISSION_TYPE__PROJECT_PERMISSION:
				return projectPermission != PROJECT_PERMISSION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", projectPermission: ");
		result.append(projectPermission);
		result.append(')');
		return result.toString();
	}

} //PermissionTypeImpl
