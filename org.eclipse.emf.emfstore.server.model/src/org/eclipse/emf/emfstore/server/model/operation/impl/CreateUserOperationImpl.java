/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create User Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CreateUserOperationImpl extends CreateOrgUnitOperationImpl<Void> implements CreateUserOperation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateUserOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.CREATE_USER_OPERATION;
	}

} //CreateUserOperationImpl
