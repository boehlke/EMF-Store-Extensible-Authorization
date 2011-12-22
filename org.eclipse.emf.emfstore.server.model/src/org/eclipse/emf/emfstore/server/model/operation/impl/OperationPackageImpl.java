/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 * 
 * 
 */
package org.eclipse.emf.emfstore.server.model.operation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.emfstore.common.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.common.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.common.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl;
import org.eclipse.emf.emfstore.server.model.impl.ModelPackageImpl;
import org.eclipse.emf.emfstore.server.model.notification.NotificationPackage;
import org.eclipse.emf.emfstore.server.model.notification.impl.NotificationPackageImpl;
import org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.OperationFactory;
import org.eclipse.emf.emfstore.server.model.operation.OperationPackage;
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.ProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation;
import org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;
import org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.impl.EventsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.impl.ServerPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationPackageImpl extends EPackageImpl implements OperationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userManagementOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orgUnitOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteOrgUnitOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addGroupMemberOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addTagOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignRoleOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createGroupOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createOrgUnitOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createOrUpdateRoleOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createProjectByImportOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createUserOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createVersionOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteProjectOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileDownloadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileUploadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readOrgUnitOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readProjectOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readPropertiesOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeGroupMemberOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeRoleOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeTagOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writePropertiesOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createProjectOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType voidEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fileTransferInformationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fileChunkEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.emfstore.server.model.operation.OperationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationPackageImpl() {
		super(eNS_URI, OperationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OperationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperationPackage init() {
		if (isInited) return (OperationPackage)EPackage.Registry.INSTANCE.getEPackage(OperationPackage.eNS_URI);

		// Obtain or create and register package
		OperationPackageImpl theOperationPackage = (OperationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage_1 = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) : org.eclipse.emf.emfstore.server.model.ModelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		ServerPackageImpl theServerPackage = (ServerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) : ServerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) : UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theOperationPackage.createPackageContents();
		theModelPackage_1.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theOperationPackage.initializePackageContents();
		theModelPackage_1.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, theOperationPackage);
		return theOperationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserManagementOperation() {
		return userManagementOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrgUnitOperation() {
		return orgUnitOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrgUnitOperation_OrgUnitId() {
		return (EAttribute)orgUnitOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteOrgUnitOperation() {
		return deleteOrgUnitOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddGroupMemberOperation() {
		return addGroupMemberOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddGroupMemberOperation_MemberId() {
		return (EAttribute)addGroupMemberOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectOperation() {
		return projectOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectOperation_ProjectId() {
		return (EAttribute)projectOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddTagOperation() {
		return addTagOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddTagOperation_Tag() {
		return (EReference)addTagOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddTagOperation_VersionSpec() {
		return (EReference)addTagOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignRoleOperation() {
		return assignRoleOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignRoleOperation_ProjectId() {
		return (EAttribute)assignRoleOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignRoleOperation_RoleId() {
		return (EAttribute)assignRoleOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateGroupOperation() {
		return createGroupOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateOrgUnitOperation() {
		return createOrgUnitOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateOrgUnitOperation_Name() {
		return (EAttribute)createOrgUnitOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateOrUpdateRoleOperation() {
		return createOrUpdateRoleOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateOrUpdateRoleOperation_Role() {
		return (EReference)createOrUpdateRoleOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateProjectByImportOperation() {
		return createProjectByImportOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateProjectByImportOperation_ProjectHistory() {
		return (EReference)createProjectByImportOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateUserOperation() {
		return createUserOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateVersionOperation() {
		return createVersionOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateVersionOperation_BaseVersion() {
		return (EReference)createVersionOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateVersionOperation_LogMessage() {
		return (EReference)createVersionOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateVersionOperation_ChangePackage() {
		return (EReference)createVersionOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteProjectOperation() {
		return deleteProjectOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeleteProjectOperation_DeleteFiles() {
		return (EAttribute)deleteProjectOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileDownloadOperation() {
		return fileDownloadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileDownloadOperation_FileInformation() {
		return (EAttribute)fileDownloadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileUploadOperation() {
		return fileUploadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileUploadOperation_FileChunk() {
		return (EAttribute)fileUploadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadOrgUnitOperation() {
		return readOrgUnitOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadProjectOperation() {
		return readProjectOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadProjectOperation_VersionSpec() {
		return (EReference)readProjectOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadPropertiesOperation() {
		return readPropertiesOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveGroupMemberOperation() {
		return removeGroupMemberOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoveGroupMemberOperation_MemberId() {
		return (EAttribute)removeGroupMemberOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveRoleOperation() {
		return removeRoleOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoveRoleOperation_RoleId() {
		return (EAttribute)removeRoleOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveTagOperation() {
		return removeTagOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveTagOperation_Tag() {
		return (EReference)removeTagOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWritePropertiesOperation() {
		return writePropertiesOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWritePropertiesOperation_Properties() {
		return (EReference)writePropertiesOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateProjectOperation() {
		return createProjectOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateProjectOperation_Description() {
		return (EAttribute)createProjectOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateProjectOperation_Project() {
		return (EReference)createProjectOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateProjectOperation_LogMessage() {
		return (EReference)createProjectOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateProjectOperation_Name() {
		return (EAttribute)createProjectOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVoid() {
		return voidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFileTransferInformation() {
		return fileTransferInformationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFileChunk() {
		return fileChunkEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationFactory getOperationFactory() {
		return (OperationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		operationEClass = createEClass(OPERATION);

		userManagementOperationEClass = createEClass(USER_MANAGEMENT_OPERATION);

		orgUnitOperationEClass = createEClass(ORG_UNIT_OPERATION);
		createEAttribute(orgUnitOperationEClass, ORG_UNIT_OPERATION__ORG_UNIT_ID);

		deleteOrgUnitOperationEClass = createEClass(DELETE_ORG_UNIT_OPERATION);

		addGroupMemberOperationEClass = createEClass(ADD_GROUP_MEMBER_OPERATION);
		createEAttribute(addGroupMemberOperationEClass, ADD_GROUP_MEMBER_OPERATION__MEMBER_ID);

		projectOperationEClass = createEClass(PROJECT_OPERATION);
		createEAttribute(projectOperationEClass, PROJECT_OPERATION__PROJECT_ID);

		addTagOperationEClass = createEClass(ADD_TAG_OPERATION);
		createEReference(addTagOperationEClass, ADD_TAG_OPERATION__TAG);
		createEReference(addTagOperationEClass, ADD_TAG_OPERATION__VERSION_SPEC);

		assignRoleOperationEClass = createEClass(ASSIGN_ROLE_OPERATION);
		createEAttribute(assignRoleOperationEClass, ASSIGN_ROLE_OPERATION__PROJECT_ID);
		createEAttribute(assignRoleOperationEClass, ASSIGN_ROLE_OPERATION__ROLE_ID);

		createGroupOperationEClass = createEClass(CREATE_GROUP_OPERATION);

		createOrgUnitOperationEClass = createEClass(CREATE_ORG_UNIT_OPERATION);
		createEAttribute(createOrgUnitOperationEClass, CREATE_ORG_UNIT_OPERATION__NAME);

		createOrUpdateRoleOperationEClass = createEClass(CREATE_OR_UPDATE_ROLE_OPERATION);
		createEReference(createOrUpdateRoleOperationEClass, CREATE_OR_UPDATE_ROLE_OPERATION__ROLE);

		createProjectByImportOperationEClass = createEClass(CREATE_PROJECT_BY_IMPORT_OPERATION);
		createEReference(createProjectByImportOperationEClass, CREATE_PROJECT_BY_IMPORT_OPERATION__PROJECT_HISTORY);

		createUserOperationEClass = createEClass(CREATE_USER_OPERATION);

		createVersionOperationEClass = createEClass(CREATE_VERSION_OPERATION);
		createEReference(createVersionOperationEClass, CREATE_VERSION_OPERATION__BASE_VERSION);
		createEReference(createVersionOperationEClass, CREATE_VERSION_OPERATION__LOG_MESSAGE);
		createEReference(createVersionOperationEClass, CREATE_VERSION_OPERATION__CHANGE_PACKAGE);

		deleteProjectOperationEClass = createEClass(DELETE_PROJECT_OPERATION);
		createEAttribute(deleteProjectOperationEClass, DELETE_PROJECT_OPERATION__DELETE_FILES);

		fileDownloadOperationEClass = createEClass(FILE_DOWNLOAD_OPERATION);
		createEAttribute(fileDownloadOperationEClass, FILE_DOWNLOAD_OPERATION__FILE_INFORMATION);

		fileUploadOperationEClass = createEClass(FILE_UPLOAD_OPERATION);
		createEAttribute(fileUploadOperationEClass, FILE_UPLOAD_OPERATION__FILE_CHUNK);

		readOrgUnitOperationEClass = createEClass(READ_ORG_UNIT_OPERATION);

		readProjectOperationEClass = createEClass(READ_PROJECT_OPERATION);
		createEReference(readProjectOperationEClass, READ_PROJECT_OPERATION__VERSION_SPEC);

		readPropertiesOperationEClass = createEClass(READ_PROPERTIES_OPERATION);

		removeGroupMemberOperationEClass = createEClass(REMOVE_GROUP_MEMBER_OPERATION);
		createEAttribute(removeGroupMemberOperationEClass, REMOVE_GROUP_MEMBER_OPERATION__MEMBER_ID);

		removeRoleOperationEClass = createEClass(REMOVE_ROLE_OPERATION);
		createEAttribute(removeRoleOperationEClass, REMOVE_ROLE_OPERATION__ROLE_ID);

		removeTagOperationEClass = createEClass(REMOVE_TAG_OPERATION);
		createEReference(removeTagOperationEClass, REMOVE_TAG_OPERATION__TAG);

		writePropertiesOperationEClass = createEClass(WRITE_PROPERTIES_OPERATION);
		createEReference(writePropertiesOperationEClass, WRITE_PROPERTIES_OPERATION__PROPERTIES);

		createProjectOperationEClass = createEClass(CREATE_PROJECT_OPERATION);
		createEAttribute(createProjectOperationEClass, CREATE_PROJECT_OPERATION__DESCRIPTION);
		createEReference(createProjectOperationEClass, CREATE_PROJECT_OPERATION__PROJECT);
		createEReference(createProjectOperationEClass, CREATE_PROJECT_OPERATION__LOG_MESSAGE);
		createEAttribute(createProjectOperationEClass, CREATE_PROJECT_OPERATION__NAME);

		// Create data types
		voidEDataType = createEDataType(VOID);
		fileTransferInformationEDataType = createEDataType(FILE_TRANSFER_INFORMATION);
		fileChunkEDataType = createEDataType(FILE_CHUNK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VersioningPackage theVersioningPackage = (VersioningPackage)EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI);
		AccesscontrolPackage theAccesscontrolPackage = (AccesscontrolPackage)EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI);
		org.eclipse.emf.emfstore.server.model.ModelPackage theModelPackage_1 = (org.eclipse.emf.emfstore.server.model.ModelPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(operationEClass, "T");
		ETypeParameter userManagementOperationEClass_T = addETypeParameter(userManagementOperationEClass, "T");
		ETypeParameter orgUnitOperationEClass_T = addETypeParameter(orgUnitOperationEClass, "T");
		ETypeParameter projectOperationEClass_T = addETypeParameter(projectOperationEClass, "T");
		ETypeParameter createOrgUnitOperationEClass_T = addETypeParameter(createOrgUnitOperationEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getOperation());
		EGenericType g2 = createEGenericType(userManagementOperationEClass_T);
		g1.getETypeArguments().add(g2);
		userManagementOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getUserManagementOperation());
		g2 = createEGenericType(orgUnitOperationEClass_T);
		g1.getETypeArguments().add(g2);
		orgUnitOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		deleteOrgUnitOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		addGroupMemberOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOperation());
		g2 = createEGenericType(projectOperationEClass_T);
		g1.getETypeArguments().add(g2);
		projectOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		addTagOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		assignRoleOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCreateOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		createGroupOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getUserManagementOperation());
		g2 = createEGenericType(createOrgUnitOperationEClass_T);
		g1.getETypeArguments().add(g2);
		createOrgUnitOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getUserManagementOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		createOrUpdateRoleOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		createProjectByImportOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCreateOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		createUserOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(theVersioningPackage.getPrimaryVersionSpec());
		g1.getETypeArguments().add(g2);
		createVersionOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		deleteProjectOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		fileDownloadOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getFileTransferInformation());
		g1.getETypeArguments().add(g2);
		fileUploadOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		readOrgUnitOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(theModelPackage_1.getProjectInfo());
		g1.getETypeArguments().add(g2);
		readProjectOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(ecorePackage.getEEList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theModelPackage.getEMFStoreProperty());
		g2.getETypeArguments().add(g3);
		readPropertiesOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		removeGroupMemberOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOrgUnitOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		removeRoleOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		removeTagOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getProjectOperation());
		g2 = createEGenericType(this.getVoid());
		g1.getETypeArguments().add(g2);
		writePropertiesOperationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOperation());
		g2 = createEGenericType(theModelPackage_1.getProjectInfo());
		g1.getETypeArguments().add(g2);
		createProjectOperationEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userManagementOperationEClass, UserManagementOperation.class, "UserManagementOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orgUnitOperationEClass, OrgUnitOperation.class, "OrgUnitOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrgUnitOperation_OrgUnitId(), ecorePackage.getEString(), "orgUnitId", null, 1, 1, OrgUnitOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteOrgUnitOperationEClass, DeleteOrgUnitOperation.class, "DeleteOrgUnitOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addGroupMemberOperationEClass, AddGroupMemberOperation.class, "AddGroupMemberOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddGroupMemberOperation_MemberId(), ecorePackage.getEString(), "memberId", null, 1, 1, AddGroupMemberOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectOperationEClass, ProjectOperation.class, "ProjectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectOperation_ProjectId(), ecorePackage.getEString(), "projectId", null, 1, 1, ProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addTagOperationEClass, AddTagOperation.class, "AddTagOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddTagOperation_Tag(), theVersioningPackage.getTagVersionSpec(), null, "tag", null, 1, 1, AddTagOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddTagOperation_VersionSpec(), theVersioningPackage.getPrimaryVersionSpec(), null, "versionSpec", null, 1, 1, AddTagOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignRoleOperationEClass, AssignRoleOperation.class, "AssignRoleOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignRoleOperation_ProjectId(), ecorePackage.getEString(), "projectId", null, 1, 1, AssignRoleOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignRoleOperation_RoleId(), ecorePackage.getEString(), "roleId", null, 1, 1, AssignRoleOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createGroupOperationEClass, CreateGroupOperation.class, "CreateGroupOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createOrgUnitOperationEClass, CreateOrgUnitOperation.class, "CreateOrgUnitOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateOrgUnitOperation_Name(), ecorePackage.getEString(), "name", null, 1, 1, CreateOrgUnitOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createOrUpdateRoleOperationEClass, CreateOrUpdateRoleOperation.class, "CreateOrUpdateRoleOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateOrUpdateRoleOperation_Role(), theAccesscontrolPackage.getRole(), null, "role", null, 1, 1, CreateOrUpdateRoleOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createProjectByImportOperationEClass, CreateProjectByImportOperation.class, "CreateProjectByImportOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateProjectByImportOperation_ProjectHistory(), theModelPackage_1.getProjectHistory(), null, "projectHistory", null, 1, 1, CreateProjectByImportOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createUserOperationEClass, CreateUserOperation.class, "CreateUserOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createVersionOperationEClass, CreateVersionOperation.class, "CreateVersionOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateVersionOperation_BaseVersion(), theVersioningPackage.getPrimaryVersionSpec(), null, "baseVersion", null, 1, 1, CreateVersionOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateVersionOperation_LogMessage(), theVersioningPackage.getLogMessage(), null, "logMessage", null, 1, 1, CreateVersionOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateVersionOperation_ChangePackage(), theVersioningPackage.getChangePackage(), null, "changePackage", null, 1, 1, CreateVersionOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteProjectOperationEClass, DeleteProjectOperation.class, "DeleteProjectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeleteProjectOperation_DeleteFiles(), ecorePackage.getEBoolean(), "deleteFiles", null, 0, 1, DeleteProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileDownloadOperationEClass, FileDownloadOperation.class, "FileDownloadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileDownloadOperation_FileInformation(), this.getFileTransferInformation(), "fileInformation", null, 1, 1, FileDownloadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileUploadOperationEClass, FileUploadOperation.class, "FileUploadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileUploadOperation_FileChunk(), this.getFileChunk(), "fileChunk", null, 1, 1, FileUploadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readOrgUnitOperationEClass, ReadOrgUnitOperation.class, "ReadOrgUnitOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(readProjectOperationEClass, ReadProjectOperation.class, "ReadProjectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadProjectOperation_VersionSpec(), theVersioningPackage.getVersionSpec(), null, "versionSpec", null, 0, 1, ReadProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readPropertiesOperationEClass, ReadPropertiesOperation.class, "ReadPropertiesOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeGroupMemberOperationEClass, RemoveGroupMemberOperation.class, "RemoveGroupMemberOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRemoveGroupMemberOperation_MemberId(), ecorePackage.getEString(), "memberId", null, 1, 1, RemoveGroupMemberOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeRoleOperationEClass, RemoveRoleOperation.class, "RemoveRoleOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRemoveRoleOperation_RoleId(), ecorePackage.getEString(), "roleId", null, 1, 1, RemoveRoleOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeTagOperationEClass, RemoveTagOperation.class, "RemoveTagOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveTagOperation_Tag(), theVersioningPackage.getTagVersionSpec(), null, "tag", null, 1, 1, RemoveTagOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writePropertiesOperationEClass, WritePropertiesOperation.class, "WritePropertiesOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWritePropertiesOperation_Properties(), theModelPackage.getEMFStoreProperty(), null, "properties", null, 1, -1, WritePropertiesOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createProjectOperationEClass, CreateProjectOperation.class, "CreateProjectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateProjectOperation_Description(), ecorePackage.getEString(), "description", null, 0, 1, CreateProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateProjectOperation_Project(), theModelPackage.getProject(), null, "project", null, 0, 1, CreateProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateProjectOperation_LogMessage(), theVersioningPackage.getLogMessage(), null, "logMessage", null, 0, 1, CreateProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateProjectOperation_Name(), ecorePackage.getEString(), "name", null, 1, 1, CreateProjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(voidEDataType, Void.class, "Void", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fileTransferInformationEDataType, FileTransferInformation.class, "FileTransferInformation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fileChunkEDataType, FileChunk.class, "FileChunk", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} // OperationPackageImpl
