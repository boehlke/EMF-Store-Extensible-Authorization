package org.eclipse.emf.emfstore.server.model.operation.provider;


import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.emfstore.server.model.operation.util.OperationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationItemProviderAdapterFactory extends OperationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.Operation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationItemProvider operationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationAdapter() {
		if (operationItemProvider == null) {
			operationItemProvider = new OperationItemProvider(this);
		}

		return operationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserManagementOperationItemProvider userManagementOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.UserManagementOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUserManagementOperationAdapter() {
		if (userManagementOperationItemProvider == null) {
			userManagementOperationItemProvider = new UserManagementOperationItemProvider(this);
		}

		return userManagementOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgUnitOperationItemProvider orgUnitOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.OrgUnitOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOrgUnitOperationAdapter() {
		if (orgUnitOperationItemProvider == null) {
			orgUnitOperationItemProvider = new OrgUnitOperationItemProvider(this);
		}

		return orgUnitOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteOrgUnitOperationItemProvider deleteOrgUnitOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeleteOrgUnitOperationAdapter() {
		if (deleteOrgUnitOperationItemProvider == null) {
			deleteOrgUnitOperationItemProvider = new DeleteOrgUnitOperationItemProvider(this);
		}

		return deleteOrgUnitOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddGroupMemberOperationItemProvider addGroupMemberOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddGroupMemberOperationAdapter() {
		if (addGroupMemberOperationItemProvider == null) {
			addGroupMemberOperationItemProvider = new AddGroupMemberOperationItemProvider(this);
		}

		return addGroupMemberOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.ProjectOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectOperationItemProvider projectOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.ProjectOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProjectOperationAdapter() {
		if (projectOperationItemProvider == null) {
			projectOperationItemProvider = new ProjectOperationItemProvider(this);
		}

		return projectOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddTagOperationItemProvider addTagOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.AddTagOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddTagOperationAdapter() {
		if (addTagOperationItemProvider == null) {
			addTagOperationItemProvider = new AddTagOperationItemProvider(this);
		}

		return addTagOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignRoleOperationItemProvider assignRoleOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.AssignRoleOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssignRoleOperationAdapter() {
		if (assignRoleOperationItemProvider == null) {
			assignRoleOperationItemProvider = new AssignRoleOperationItemProvider(this);
		}

		return assignRoleOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateGroupOperationItemProvider createGroupOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateGroupOperationAdapter() {
		if (createGroupOperationItemProvider == null) {
			createGroupOperationItemProvider = new CreateGroupOperationItemProvider(this);
		}

		return createGroupOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateOrgUnitOperationItemProvider createOrgUnitOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateOrgUnitOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateOrgUnitOperationAdapter() {
		if (createOrgUnitOperationItemProvider == null) {
			createOrgUnitOperationItemProvider = new CreateOrgUnitOperationItemProvider(this);
		}

		return createOrgUnitOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateOrUpdateRoleOperationItemProvider createOrUpdateRoleOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateOrUpdateRoleOperationAdapter() {
		if (createOrUpdateRoleOperationItemProvider == null) {
			createOrUpdateRoleOperationItemProvider = new CreateOrUpdateRoleOperationItemProvider(this);
		}

		return createOrUpdateRoleOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateProjectByImportOperationItemProvider createProjectByImportOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectByImportOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateProjectByImportOperationAdapter() {
		if (createProjectByImportOperationItemProvider == null) {
			createProjectByImportOperationItemProvider = new CreateProjectByImportOperationItemProvider(this);
		}

		return createProjectByImportOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateUserOperationItemProvider createUserOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateUserOperationAdapter() {
		if (createUserOperationItemProvider == null) {
			createUserOperationItemProvider = new CreateUserOperationItemProvider(this);
		}

		return createUserOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateVersionOperationItemProvider createVersionOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateVersionOperationAdapter() {
		if (createVersionOperationItemProvider == null) {
			createVersionOperationItemProvider = new CreateVersionOperationItemProvider(this);
		}

		return createVersionOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteProjectOperationItemProvider deleteProjectOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.DeleteProjectOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeleteProjectOperationAdapter() {
		if (deleteProjectOperationItemProvider == null) {
			deleteProjectOperationItemProvider = new DeleteProjectOperationItemProvider(this);
		}

		return deleteProjectOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileDownloadOperationItemProvider fileDownloadOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileDownloadOperationAdapter() {
		if (fileDownloadOperationItemProvider == null) {
			fileDownloadOperationItemProvider = new FileDownloadOperationItemProvider(this);
		}

		return fileDownloadOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileUploadOperationItemProvider fileUploadOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileUploadOperationAdapter() {
		if (fileUploadOperationItemProvider == null) {
			fileUploadOperationItemProvider = new FileUploadOperationItemProvider(this);
		}

		return fileUploadOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadOrgUnitOperationItemProvider readOrgUnitOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReadOrgUnitOperationAdapter() {
		if (readOrgUnitOperationItemProvider == null) {
			readOrgUnitOperationItemProvider = new ReadOrgUnitOperationItemProvider(this);
		}

		return readOrgUnitOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadProjectOperationItemProvider readProjectOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReadProjectOperationAdapter() {
		if (readProjectOperationItemProvider == null) {
			readProjectOperationItemProvider = new ReadProjectOperationItemProvider(this);
		}

		return readProjectOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadPropertiesOperationItemProvider readPropertiesOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReadPropertiesOperationAdapter() {
		if (readPropertiesOperationItemProvider == null) {
			readPropertiesOperationItemProvider = new ReadPropertiesOperationItemProvider(this);
		}

		return readPropertiesOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveGroupMemberOperationItemProvider removeGroupMemberOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRemoveGroupMemberOperationAdapter() {
		if (removeGroupMemberOperationItemProvider == null) {
			removeGroupMemberOperationItemProvider = new RemoveGroupMemberOperationItemProvider(this);
		}

		return removeGroupMemberOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveRoleOperationItemProvider removeRoleOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.RemoveRoleOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRemoveRoleOperationAdapter() {
		if (removeRoleOperationItemProvider == null) {
			removeRoleOperationItemProvider = new RemoveRoleOperationItemProvider(this);
		}

		return removeRoleOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveTagOperationItemProvider removeTagOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRemoveTagOperationAdapter() {
		if (removeTagOperationItemProvider == null) {
			removeTagOperationItemProvider = new RemoveTagOperationItemProvider(this);
		}

		return removeTagOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WritePropertiesOperationItemProvider writePropertiesOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWritePropertiesOperationAdapter() {
		if (writePropertiesOperationItemProvider == null) {
			writePropertiesOperationItemProvider = new WritePropertiesOperationItemProvider(this);
		}

		return writePropertiesOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateProjectOperationItemProvider createProjectOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.operation.CreateProjectOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateProjectOperationAdapter() {
		if (createProjectOperationItemProvider == null) {
			createProjectOperationItemProvider = new CreateProjectOperationItemProvider(this);
		}

		return createProjectOperationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (operationItemProvider != null) operationItemProvider.dispose();
		if (userManagementOperationItemProvider != null) userManagementOperationItemProvider.dispose();
		if (orgUnitOperationItemProvider != null) orgUnitOperationItemProvider.dispose();
		if (deleteOrgUnitOperationItemProvider != null) deleteOrgUnitOperationItemProvider.dispose();
		if (addGroupMemberOperationItemProvider != null) addGroupMemberOperationItemProvider.dispose();
		if (projectOperationItemProvider != null) projectOperationItemProvider.dispose();
		if (addTagOperationItemProvider != null) addTagOperationItemProvider.dispose();
		if (assignRoleOperationItemProvider != null) assignRoleOperationItemProvider.dispose();
		if (createGroupOperationItemProvider != null) createGroupOperationItemProvider.dispose();
		if (createOrgUnitOperationItemProvider != null) createOrgUnitOperationItemProvider.dispose();
		if (createOrUpdateRoleOperationItemProvider != null) createOrUpdateRoleOperationItemProvider.dispose();
		if (createProjectByImportOperationItemProvider != null) createProjectByImportOperationItemProvider.dispose();
		if (createUserOperationItemProvider != null) createUserOperationItemProvider.dispose();
		if (createVersionOperationItemProvider != null) createVersionOperationItemProvider.dispose();
		if (deleteProjectOperationItemProvider != null) deleteProjectOperationItemProvider.dispose();
		if (fileDownloadOperationItemProvider != null) fileDownloadOperationItemProvider.dispose();
		if (fileUploadOperationItemProvider != null) fileUploadOperationItemProvider.dispose();
		if (readOrgUnitOperationItemProvider != null) readOrgUnitOperationItemProvider.dispose();
		if (readProjectOperationItemProvider != null) readProjectOperationItemProvider.dispose();
		if (readPropertiesOperationItemProvider != null) readPropertiesOperationItemProvider.dispose();
		if (removeGroupMemberOperationItemProvider != null) removeGroupMemberOperationItemProvider.dispose();
		if (removeRoleOperationItemProvider != null) removeRoleOperationItemProvider.dispose();
		if (removeTagOperationItemProvider != null) removeTagOperationItemProvider.dispose();
		if (writePropertiesOperationItemProvider != null) writePropertiesOperationItemProvider.dispose();
		if (createProjectOperationItemProvider != null) createProjectOperationItemProvider.dispose();
	}

}