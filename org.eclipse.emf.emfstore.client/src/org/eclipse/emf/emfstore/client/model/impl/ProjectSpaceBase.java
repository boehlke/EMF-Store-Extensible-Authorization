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
package org.eclipse.emf.emfstore.client.model.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.client.model.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ModifiedModelElementsCache;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.recording.NotificationRecorder;
import org.eclipse.emf.emfstore.client.model.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.model.controller.CommitController;
import org.eclipse.emf.emfstore.client.model.controller.ShareController;
import org.eclipse.emf.emfstore.client.model.controller.UpdateController;
import org.eclipse.emf.emfstore.client.model.controller.callbacks.CommitCallback;
import org.eclipse.emf.emfstore.client.model.controller.callbacks.UpdateCallback;
import org.eclipse.emf.emfstore.client.model.exceptions.IllegalProjectSpaceStateException;
import org.eclipse.emf.emfstore.client.model.exceptions.MEUrlResolutionException;
import org.eclipse.emf.emfstore.client.model.exceptions.PropertyNotFoundException;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileDownloadStatus;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileInformation;
import org.eclipse.emf.emfstore.client.model.filetransfer.FileTransferManager;
import org.eclipse.emf.emfstore.client.model.importexport.impl.ExportChangesController;
import org.eclipse.emf.emfstore.client.model.importexport.impl.ExportProjectController;
import org.eclipse.emf.emfstore.client.model.observers.ConflictResolver;
import org.eclipse.emf.emfstore.client.model.observers.LoginObserver;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.eclipse.emf.emfstore.common.model.util.AutoSplitAndSaveResourceContainmentList;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

/**
 * Project space base class that contains custom user methods.
 * 
 * @author emueller
 * 
 */
public abstract class ProjectSpaceBase extends IdentifiableElementImpl implements ProjectSpace, LoginObserver {

	private FileTransferManager fileTransferManager;

	private boolean initCompleted;

	private boolean isTransient;

	private ModifiedModelElementsCache modifiedModelElementsCache;

	private AutoSplitAndSaveResourceContainmentList<AbstractOperation> operationsList;

	private OperationManager operationManager;

	private OperationRecorder operationRecorder;

	private PropertyManager propertyManager;

	private HashMap<String, OrgUnitProperty> propertyMap;

	private StatePersister statePersister;

	/**
	 * Constructor.
	 */
	public ProjectSpaceBase() {
		this.propertyMap = new HashMap<String, OrgUnitProperty>();
		modifiedModelElementsCache = new ModifiedModelElementsCache(this);
		WorkspaceManager.getObserverBus().register(modifiedModelElementsCache);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#addFile(java.io.File)
	 */
	public FileIdentifier addFile(File file) throws FileTransferException {
		return fileTransferManager.addFile(file);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#addOperations(java.util.List)
	 */
	public void addOperations(List<? extends AbstractOperation> operations) {
		getOperations().addAll(operations);
		updateDirtyState();

		for (AbstractOperation op : operations) {
			// do not notify on composite start, wait until completion
			if (op instanceof CompositeOperation) {
				// check of automatic composite if yes then continue
				if (((CompositeOperation) op).getMainOperation() == null) {
					return;
				}
			}

			operationManager.notifyOperationExecuted(op);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#addTag(org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec,
	 *      org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec)
	 */
	public void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance().getConnectionManager();
		cm.addTag(getUsersession().getSessionId(), getProjectId(), versionSpec, tag);
	}

	/**
	 * Applies a list of operations to the project. The change tracking will be
	 * stopped meanwhile and the operations are added to the project space.
	 * 
	 * @param operations
	 *            the list of operations to be applied upon the project space
	 */
	public void applyOperations(List<AbstractOperation> operations) {
		applyOperations(operations, true);
	}

	/**
	 * Applies a list of operations to the project. The change tracking will be
	 * stopped meanwhile.
	 * 
	 * 
	 * @param operations
	 *            the list of operations to be applied upon the project space
	 * @param addOperations
	 *            whether the operations should be saved in project space
	 * 
	 * @see #applyOperationsWithRecording(List, boolean)
	 */
	public void applyOperations(List<AbstractOperation> operations, boolean addOperations) {
		stopChangeRecording();

		try {
			for (AbstractOperation operation : operations) {
				try {
					operation.apply(getProject());
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (RuntimeException e) {
					WorkspaceUtil.handleException(e);
				}
				// END SUPRESS CATCH EXCEPTION
			}

			if (addOperations) {
				addOperations(operations);
			}
		} finally {
			startChangeRecording();
		}
	}

	/**
	 * Applies a list of operations to the project. This method is used by {@link #importLocalChanges(String)}. This
	 * method redirects to {@link #applyOperationsWithRecording(List, boolean, boolean)}, using
	 * false for semantic apply.
	 * 
	 * @param operations
	 *            the list of operations to be applied upon the project space
	 * @param force
	 *            if true, no exception is thrown if
	 *            {@link AbstractOperation#apply(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)} fails
	 */
	public void applyOperationsWithRecording(List<AbstractOperation> operations, boolean force) {
		applyOperationsWithRecording(operations, force, false);
	}

	/**
	 * Applies a list of operations to the project. It is possible to force
	 * import operations. Change tracking is not stopped while applying the
	 * changes.
	 * 
	 * @param operations
	 *            the list of operations to be applied upon the project space
	 * @param force
	 *            if true, no exception is thrown if
	 *            {@link AbstractOperation#apply(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)} fails
	 * @param semanticApply
	 *            if true, performs a semanticApply, if possible (see {@link SemanticCompositeOperation})
	 */
	public void applyOperationsWithRecording(List<AbstractOperation> operations, boolean force, boolean semanticApply) {
		for (AbstractOperation operation : operations) {
			try {
				if (semanticApply && operation instanceof SemanticCompositeOperation) {
					((SemanticCompositeOperation) operation).semanticApply(getProject());
				} else {
					operation.apply(getProject());
				}
			} catch (IllegalStateException e) {
				if (!force) {
					throw e;
				}
			}
		}
	}

	private void assignElementToResource(Resource resource, EObject modelElement) {
		resource.getContents().add(modelElement);
		// FIXME: this is not nice!
		((XMIResource) resource).setID(modelElement, getProject().getModelElementId(modelElement).getId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#beginCompositeOperation()
	 */
	public CompositeOperationHandle beginCompositeOperation() {
		return this.operationManager.beginCompositeOperation();
	}

	public void cleanCutElements() {
		for (EObject cutElement : getProject().getCutElements()) {
			getProject().deleteModelElement(cutElement);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#commit(org.eclipse.emf.emfstore.server.model.versioning.LogMessage,
	 *      org.eclipse.emf.emfstore.client.model.controller.callbacks.CommitCallback,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public PrimaryVersionSpec commit(LogMessage logMessage, CommitCallback callback, IProgressMonitor monitor)
		throws EmfStoreException {
		return new CommitController(this, logMessage, callback, monitor).execute();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#exportLocalChanges(java.io.File,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void exportLocalChanges(File file, IProgressMonitor progressMonitor) throws IOException {
		new ExportChangesController(this).execute(file, progressMonitor);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#exportLocalChanges(java.io.File)
	 */
	public void exportLocalChanges(File file) throws IOException {
		new ExportChangesController(this).execute(file, new NullProgressMonitor());
	}

	public void exportProject(File file, IProgressMonitor progressMonitor) throws IOException {
		new ExportProjectController(this).execute(file, progressMonitor);
	}

	public void exportProject(File file) throws IOException {
		new ExportProjectController(this).execute(file, new NullProgressMonitor());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public List<ChangePackage> getChanges(VersionSpec sourceVersion, VersionSpec targetVersion)
		throws EmfStoreException {
		final ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		List<ChangePackage> changes = connectionManager.getChanges(getUsersession().getSessionId(), getProjectId(),
			sourceVersion, targetVersion);
		return changes;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getFile(org.eclipse.emf.emfstore.server.model.FileIdentifier,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public FileDownloadStatus getFile(FileIdentifier fileIdentifier) throws FileTransferException {
		return fileTransferManager.getFile(fileIdentifier);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getFileInfo(org.eclipse.emf.emfstore.server.model.FileIdentifier)
	 */
	public FileInformation getFileInfo(FileIdentifier fileIdentifier) {
		return fileTransferManager.getFileInfo(fileIdentifier);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getHistoryInfo(org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery)
	 */
	public List<HistoryInfo> getHistoryInfo(HistoryQuery query) throws EmfStoreException {
		return getWorkspace().getHistoryInfo(getUsersession(), getProjectId(), query);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getLocalChangePackage()
	 */
	public ChangePackage getLocalChangePackage(boolean canonize) {
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// copy operations from ProjectSpace
		for (AbstractOperation abstractOperation : getOperations()) {
			AbstractOperation copy = EcoreUtil.copy(abstractOperation);
			changePackage.getOperations().add(copy);
		}

		return changePackage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getModifiedModelElementsCache()
	 */
	public ModifiedModelElementsCache getModifiedModelElementsCache() {
		return modifiedModelElementsCache;
	}

	/**
	 * Get the current notification recorder.
	 * 
	 * @return the recorder
	 */
	public NotificationRecorder getNotificationRecorder() {
		return this.operationRecorder.getNotificationRecorder();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getOperationManager()
	 */
	public OperationManager getOperationManager() {
		return operationManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getOperations()
	 */
	public List<AbstractOperation> getOperations() {
		// check if operation composite exists
		OperationComposite operationComposite = this.getLocalOperations();
		if (operationComposite == null) {
			this.setLocalOperations(ModelFactory.eINSTANCE.createOperationComposite());
			operationComposite = getLocalOperations();
		}
		if (isTransient) {
			return operationComposite.getOperations();
		}
		if (operationsList == null) {
			operationsList = new AutoSplitAndSaveResourceContainmentList<AbstractOperation>(operationComposite,
				operationComposite.getOperations(), this.eResource().getResourceSet(),
				Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier() + File.separatorChar + "operations",
				".off");
		}
		return operationsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getProjectInfo()
	 * @generated NOT
	 */
	public ProjectInfo getProjectInfo() {
		ProjectInfo projectInfo = org.eclipse.emf.emfstore.server.model.ModelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setProjectId(ModelUtil.clone(getProjectId()));
		projectInfo.setName(getProjectName());
		projectInfo.setDescription(getProjectDescription());
		projectInfo.setVersion(ModelUtil.clone(getBaseVersion()));
		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#getPropertyManager()
	 */
	public PropertyManager getPropertyManager() {
		if (this.propertyManager == null) {
			this.propertyManager = new PropertyManager(this);
		}

		return this.propertyManager;
	}

	/**
	 * getter for a string argument - see {@link #setProperty(OrgUnitProperty)}.
	 */
	private OrgUnitProperty getProperty(String name) throws PropertyNotFoundException {
		// sanity checks
		if (getUsersession() != null && getUsersession().getACUser() != null) {
			OrgUnitProperty orgUnitProperty = propertyMap.get(name);
			if (orgUnitProperty != null) {
				return orgUnitProperty;
			}
		}
		throw new PropertyNotFoundException();
	}

	/**
	 * Returns the {@link StatePersister}.
	 * 
	 * @return persister
	 */
	public StatePersister getStatePersister() {
		return statePersister;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#importLocalChanges(java.lang.String)
	 */
	public void importLocalChanges(String fileName) throws IOException {

		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(fileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1 && (!(directContents.get(0) instanceof ChangePackage))) {
			throw new IOException("File is corrupt, does not contain Changes.");
		}

		ChangePackage changePackage = (ChangePackage) directContents.get(0);
		applyOperationsWithRecording(changePackage.getOperations(), true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#init()
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		initCompleted = true;

		// getProject().initCaches();

		this.fileTransferManager = new FileTransferManager(this);
		// EObjectChangeNotifier changeNotifier = new EObjectChangeNotifier(
		// this.getProject());
		this.operationRecorder = new OperationRecorder(this.getProject(),
			((ProjectImpl) this.getProject()).getChangeNotifier());
		this.operationManager = new OperationManager(operationRecorder, this);
		this.operationManager.addOperationListener(modifiedModelElementsCache);
		statePersister = new StatePersister(((ProjectImpl) this.getProject()).getChangeNotifier(),
			((EMFStoreCommandStack) Configuration.getEditingDomain().getCommandStack()), this.getProject());
		// TODO: initialization order important
		this.getProject().addIdEObjectCollectionChangeObserver(this.operationRecorder);
		this.getProject().addIdEObjectCollectionChangeObserver(statePersister);

		if (getProject() instanceof ProjectImpl) {
			((ProjectImpl) this.getProject()).setUndetachable(operationRecorder);
			((ProjectImpl) this.getProject()).setUndetachable(statePersister);
		}
		if (getUsersession() != null) {
			WorkspaceManager.getObserverBus().register(this, LoginObserver.class);
			ACUser acUser = getUsersession().getACUser();
			if (acUser != null) {
				for (OrgUnitProperty p : acUser.getProperties()) {
					if (p.getProject() != null && p.getProject().equals(getProjectId())) {
						propertyMap.put(p.getName(), p);
					}
				}
			}
		}
		modifiedModelElementsCache.initializeCache();
		startChangeRecording();
		cleanCutElements();
	}

	public FileTransferManager getFileTransferManager() {
		return fileTransferManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#initResources(org.eclipse.emf.ecore.resource.ResourceSet)
	 * @generated NOT
	 */
	public void initResources(ResourceSet resourceSet) {
		initCompleted = true;
		String projectSpaceFileNamePrefix = Configuration.getWorkspaceDirectory()
			+ Configuration.getProjectSpaceDirectoryPrefix() + getIdentifier() + File.separatorChar;
		String projectSpaceFileName = projectSpaceFileNamePrefix + this.getIdentifier()
			+ Configuration.getProjectSpaceFileExtension();
		String operationsCompositeFileName = projectSpaceFileNamePrefix + this.getIdentifier()
			+ Configuration.getOperationCompositeFileExtension();
		String projectFragementsFileNamePrefix = projectSpaceFileNamePrefix + Configuration.getProjectFolderName()
			+ File.separatorChar;
		URI projectSpaceURI = URI.createFileURI(projectSpaceFileName);
		URI operationCompositeURI = URI.createFileURI(operationsCompositeFileName);

		setResourceCount(0);
		String fileName = projectFragementsFileNamePrefix + getResourceCount()
			+ Configuration.getProjectFragmentFileExtension();
		URI fileURI = URI.createFileURI(fileName);

		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = resourceSet.createResource(fileURI);
		// if resource splitting fails, we need a reference to the old resource
		resource.getContents().add(this.getProject());
		resources.add(resource);
		setResourceCount(getResourceCount() + 1);

		if (Configuration.isResourceSplittingEnabled()) {
			splitResources(resourceSet, projectFragementsFileNamePrefix, resources, this.getProject());
		} else {
			for (EObject modelElement : getProject().getAllModelElements()) {
				((XMIResource) resource).setID(modelElement, getProject().getModelElementId(modelElement).getId());
			}
		}

		Resource operationCompositeResource = resourceSet.createResource(operationCompositeURI);
		if (this.getLocalOperations() == null) {
			this.setLocalOperations(ModelFactory.eINSTANCE.createOperationComposite());
		}
		operationCompositeResource.getContents().add(this.getLocalOperations());
		resources.add(operationCompositeResource);

		Resource projectSpaceResource = resourceSet.createResource(projectSpaceURI);
		projectSpaceResource.getContents().add(this);
		resources.add(projectSpaceResource);

		// save all resources that have been created
		for (Resource currentResource : resources) {
			try {
				currentResource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				WorkspaceUtil.logException("Project Space resource init failed!", e);
			}
		}

		init();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#isTransient()
	 */
	public boolean isTransient() {
		return isTransient;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#isUpdated()
	 */
	public boolean isUpdated() throws EmfStoreException {
		PrimaryVersionSpec headVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);
		return getBaseVersion().equals(headVersion);
	}

	/**
	 * {@inheritDoc}
	 */
	public void loginCompleted(Usersession session) {
		// TODO Implement possibility in observerbus to register only for
		// certain notifier
		if (getUsersession() == null || !getUsersession().equals(session)) {
			return;
		}
		try {
			transmitProperties();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			WorkspaceUtil.logException("Resuming file transfers or transmitting properties failed!", e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#makeTransient()
	 */
	public void makeTransient() {
		if (initCompleted) {
			throw new IllegalAccessError("Project Space cannot be set to transient after init.");
		}
		isTransient = true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean merge(PrimaryVersionSpec target, ConflictResolver conflictResolver) throws EmfStoreException {
		// merge the conflicts
		ChangePackage myCp = this.getLocalChangePackage(true);
		List<ChangePackage> theirCps = this.getChanges(getBaseVersion(), target);
		if (conflictResolver.resolveConflicts(getProject(), theirCps, myCp, getBaseVersion(), target)) {

			// revert the local operations and apply all their operations
			this.revert();

			for (ChangePackage changePackage : theirCps) {
				applyOperations(changePackage.getOperations(), false);
			}

			// generate merge result and apply to local workspace
			List<AbstractOperation> acceptedMine = conflictResolver.getAcceptedMine();
			List<AbstractOperation> rejectedTheirs = conflictResolver.getRejectedTheirs();
			List<AbstractOperation> mergeResult = new ArrayList<AbstractOperation>();
			for (AbstractOperation operationToReverse : rejectedTheirs) {
				mergeResult.add(0, operationToReverse.reverse());
			}
			mergeResult.addAll(acceptedMine);

			applyOperations(mergeResult, true);

			this.setBaseVersion(target);

			saveProjectSpaceOnly();
			return true;
		} else {
			// merge could not proceed
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance().getConnectionManager();
		cm.removeTag(getUsersession().getSessionId(), getProjectId(), versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#resolve(org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment)
	 */
	public EObject resolve(ModelElementUrlFragment modelElementUrlFragment) throws MEUrlResolutionException {
		ModelElementId modelElementId = modelElementUrlFragment.getModelElementId();
		EObject modelElement = getProject().getModelElement(modelElementId);
		if (modelElement == null) {
			throw new MEUrlResolutionException();
		}
		return modelElement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#resolveVersionSpec(org.eclipse.emf.emfstore.server.model.versioning.VersionSpec)
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec) throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		return connectionManager.resolveVersionSpec(getUsersession().getSessionId(), getProjectId(), versionSpec);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void revert() {
		while (!getOperations().isEmpty()) {
			undoLastOperation();
		}
		updateDirtyState();
	}

	/**
	 * Saves the project space itself only, no containment children.
	 */
	public void saveProjectSpaceOnly() {
		saveResource(this.eResource());
	}

	/**
	 * Save the given resource that is part of the project space resource set.
	 * 
	 * @param resource
	 *            the resource
	 */
	public void saveResource(Resource resource) {
		try {
			if (resource == null) {
				if (!isTransient) {
					WorkspaceUtil.logException("Resources of project space are not properly initialized!",
						new IllegalProjectSpaceStateException("Resource to save is null"));
				}
				return;
			}
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			WorkspaceUtil.logException("An error in the data was detected during save!"
				+ " The safest way to deal with this problem is to delete this project and checkout again.", e);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#setProperty(org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty)
	 */
	public void setProperty(OrgUnitProperty property) {
		// sanity checks
		if (getUsersession() != null && getUsersession().getACUser() != null) {
			try {
				if (property.getProject() == null) {
					property.setProject(ModelUtil.clone(getProjectId()));
				} else if (!property.getProject().equals(getProjectId())) {
					return;
				}
				OrgUnitProperty prop = getProperty(property.getName());
				prop.setValue(property.getValue());
			} catch (PropertyNotFoundException e) {
				getUsersession().getACUser().getProperties().add(property);
				propertyMap.put(property.getName(), property);
			}
			// the properties that have been altered are retained in a separate
			// list
			for (OrgUnitProperty changedProperty : getUsersession().getChangedProperties()) {
				if (changedProperty.getName().equals(property.getName())
					&& changedProperty.getProject().equals(getProjectId())) {
					changedProperty.setValue(property.getValue());
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
					return;
				}
			}
			getUsersession().getChangedProperties().add(property);
			WorkspaceManager.getInstance().getCurrentWorkspace().save();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#shareProject()
	 */
	public void shareProject() throws EmfStoreException {
		shareProject(null, null);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#shareProject(org.eclipse.emf.emfstore.client.model.Usersession,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void shareProject(Usersession session, IProgressMonitor monitor) throws EmfStoreException {
		new ShareController(this, session, monitor).execute();
	}

	private void splitResources(ResourceSet resourceSet, String projectFragementsFileNamePrefix,
		List<Resource> resources, Project project) {
		String fileName;
		URI fileURI;

		Resource resource = project.eResource();
		int counter = 0;
		for (EObject modelElement : project.getAllModelElements()) {

			// never split maps
			if (modelElement instanceof BasicEMap.Entry) {
				((XMIResource) modelElement.eContainer().eResource()).setID(modelElement, getProject()
					.getModelElementId(modelElement).getId());
				continue;
			}

			if (counter > Configuration.getMaxMECountPerResource()) {
				fileName = projectFragementsFileNamePrefix + getResourceCount()
					+ Configuration.getProjectFragmentFileExtension();
				fileURI = URI.createFileURI(fileName);
				resource = resourceSet.createResource(fileURI);
				setResourceCount(getResourceCount() + 1);
				resources.add(resource);
				counter = 0;
			}
			counter++;

			assignElementToResource(resource, modelElement);
		}
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		this.operationRecorder.startChangeRecording();
		updateDirtyState();
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.operationRecorder.stopChangeRecording();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#transmitProperties()
	 */
	public void transmitProperties() {
		List<OrgUnitProperty> temp = new ArrayList<OrgUnitProperty>();
		for (OrgUnitProperty changedProperty : getUsersession().getChangedProperties()) {
			if (changedProperty.getProject() != null && changedProperty.getProject().equals(getProjectId())) {
				temp.add(changedProperty);
			}
		}
		ListIterator<OrgUnitProperty> iterator = temp.listIterator();
		while (iterator.hasNext()) {
			try {
				WorkspaceManager
					.getInstance()
					.getConnectionManager()
					.transmitProperty(getUsersession().getSessionId(), iterator.next(), getUsersession().getACUser(),
						getProjectId());
				iterator.remove();
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Transmission of properties failed with exception", e);
			}
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#undoLastOperation()
	 */
	public void undoLastOperation() {
		if (!this.getOperations().isEmpty()) {
			List<AbstractOperation> operations = this.getOperations();
			AbstractOperation lastOperation = operations.get(operations.size() - 1);
			stopChangeRecording();
			try {
				lastOperation.reverse().apply(getProject());
				operationManager.notifyOperationUndone(lastOperation);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.handleException(exception);
			} finally {
				startChangeRecording();
			}
			operations.remove(lastOperation);
		}
		updateDirtyState();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#update()
	 */
	public PrimaryVersionSpec update() throws EmfStoreException {
		return update(VersionSpec.HEAD_VERSION);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#update(org.eclipse.emf.emfstore.server.model.versioning.VersionSpec)
	 */
	public PrimaryVersionSpec update(final VersionSpec version) throws EmfStoreException {
		return update(version, null, null);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpace#update(org.eclipse.emf.emfstore.server.model.versioning.VersionSpec,
	 *      org.eclipse.emf.emfstore.client.model.controller.callbacks.UpdateCallback,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public PrimaryVersionSpec update(VersionSpec version, UpdateCallback callback, IProgressMonitor progress)
		throws EmfStoreException {
		return new UpdateController(this, version, callback, progress).execute();
	}

	/**
	 * Updates the dirty state of the project space.
	 */
	public void updateDirtyState() {
		setDirty(!getOperations().isEmpty());
	}

}
