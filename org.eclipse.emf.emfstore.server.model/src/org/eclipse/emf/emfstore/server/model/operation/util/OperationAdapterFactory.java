/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.emfstore.server.model.operation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage
 * @generated
 */
public class OperationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OperationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationSwitch<Adapter> modelSwitch =
		new OperationSwitch<Adapter>() {
			@Override
			public <T> Adapter caseOperation(Operation<T> object) {
				return createOperationAdapter();
			}
			@Override
			public <T> Adapter caseUserManagementOperation(UserManagementOperation<T> object) {
				return createUserManagementOperationAdapter();
			}
			@Override
			public <T> Adapter caseOrgUnitOperation(OrgUnitOperation<T> object) {
				return createOrgUnitOperationAdapter();
			}
			@Override
			public Adapter caseDeleteOrgUnitOperation(DeleteOrgUnitOperation object) {
				return createDeleteOrgUnitOperationAdapter();
			}
			@Override
			public Adapter caseAddGroupMemberOperation(AddGroupMemberOperation object) {
				return createAddGroupMemberOperationAdapter();
			}
			@Override
			public <T> Adapter caseProjectOperation(ProjectOperation<T> object) {
				return createProjectOperationAdapter();
			}
			@Override
			public Adapter caseAddTagOperation(AddTagOperation object) {
				return createAddTagOperationAdapter();
			}
			@Override
			public Adapter caseAssignRoleOperation(AssignRoleOperation object) {
				return createAssignRoleOperationAdapter();
			}
			@Override
			public Adapter caseCreateGroupOperation(CreateGroupOperation object) {
				return createCreateGroupOperationAdapter();
			}
			@Override
			public <T> Adapter caseCreateOrgUnitOperation(CreateOrgUnitOperation<T> object) {
				return createCreateOrgUnitOperationAdapter();
			}
			@Override
			public Adapter caseCreateOrUpdateRoleOperation(CreateOrUpdateRoleOperation object) {
				return createCreateOrUpdateRoleOperationAdapter();
			}
			@Override
			public Adapter caseCreateProjectByImportOperation(CreateProjectByImportOperation object) {
				return createCreateProjectByImportOperationAdapter();
			}
			@Override
			public Adapter caseCreateUserOperation(CreateUserOperation object) {
				return createCreateUserOperationAdapter();
			}
			@Override
			public Adapter caseCreateVersionOperation(CreateVersionOperation object) {
				return createCreateVersionOperationAdapter();
			}
			@Override
			public Adapter caseDeleteProjectOperation(DeleteProjectOperation object) {
				return createDeleteProjectOperationAdapter();
			}
			@Override
			public Adapter caseFileDownloadOperation(FileDownloadOperation object) {
				return createFileDownloadOperationAdapter();
			}
			@Override
			public Adapter caseFileUploadOperation(FileUploadOperation object) {
				return createFileUploadOperationAdapter();
			}
			@Override
			public Adapter caseReadOrgUnitOperation(ReadOrgUnitOperation object) {
				return createReadOrgUnitOperationAdapter();
			}
			@Override
			public Adapter caseReadProjectOperation(ReadProjectOperation object) {
				return createReadProjectOperationAdapter();
			}
			@Override
			public Adapter caseReadPropertiesOperation(ReadPropertiesOperation object) {
				return createReadPropertiesOperationAdapter();
			}
			@Override
			public Adapter caseRemoveGroupMemberOperation(RemoveGroupMemberOperation object) {
				return createRemoveGroupMemberOperationAdapter();
			}
			@Override
			public Adapter caseRemoveRoleOperation(RemoveRoleOperation object) {
				return createRemoveRoleOperationAdapter();
			}
			@Override
			public Adapter caseRemoveTagOperation(RemoveTagOperation object) {
				return createRemoveTagOperationAdapter();
			}
			@Override
			public Adapter caseWritePropertiesOperation(WritePropertiesOperation object) {
				return createWritePropertiesOperationAdapter();
			}
			@Override
			public Adapter caseCreateProjectOperation(CreateProjectOperation object) {
				return createCreateProjectOperationAdapter();
			}
			@Override
			public Adapter caseRoleContainer(RoleContainer object) {
				return createRoleContainerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation <em>User Management Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation
	 * @generated
	 */
	public Adapter createUserManagementOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation <em>Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation
	 * @generated
	 */
	public Adapter createOrgUnitOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation <em>Delete Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation
	 * @generated
	 */
	public Adapter createDeleteOrgUnitOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation <em>Add Group Member Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation
	 * @generated
	 */
	public Adapter createAddGroupMemberOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.ProjectOperation <em>Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ProjectOperation
	 * @generated
	 */
	public Adapter createProjectOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation <em>Add Tag Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AddTagOperation
	 * @generated
	 */
	public Adapter createAddTagOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation <em>Assign Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation
	 * @generated
	 */
	public Adapter createAssignRoleOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation <em>Create Group Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation
	 * @generated
	 */
	public Adapter createCreateGroupOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation <em>Create Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation
	 * @generated
	 */
	public Adapter createCreateOrgUnitOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation <em>Create Or Update Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation
	 * @generated
	 */
	public Adapter createCreateOrUpdateRoleOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation <em>Create Project By Import Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation
	 * @generated
	 */
	public Adapter createCreateProjectByImportOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation <em>Create User Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation
	 * @generated
	 */
	public Adapter createCreateUserOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation <em>Create Version Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation
	 * @generated
	 */
	public Adapter createCreateVersionOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation <em>Delete Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation
	 * @generated
	 */
	public Adapter createDeleteProjectOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation <em>File Download Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation
	 * @generated
	 */
	public Adapter createFileDownloadOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation <em>File Upload Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation
	 * @generated
	 */
	public Adapter createFileUploadOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation <em>Read Org Unit Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation
	 * @generated
	 */
	public Adapter createReadOrgUnitOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation <em>Read Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation
	 * @generated
	 */
	public Adapter createReadProjectOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation <em>Read Properties Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation
	 * @generated
	 */
	public Adapter createReadPropertiesOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation <em>Remove Group Member Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation
	 * @generated
	 */
	public Adapter createRemoveGroupMemberOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation <em>Remove Role Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation
	 * @generated
	 */
	public Adapter createRemoveRoleOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation <em>Remove Tag Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation
	 * @generated
	 */
	public Adapter createRemoveTagOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation <em>Write Properties Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation
	 * @generated
	 */
	public Adapter createWritePropertiesOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation <em>Create Project Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation
	 * @generated
	 */
	public Adapter createCreateProjectOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.operation.RoleContainer <em>Role Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.operation.RoleContainer
	 * @generated
	 */
	public Adapter createRoleContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OperationAdapterFactory
