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
package org.eclipse.emf.emfstore.server.core.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.StorageException;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.Version;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CreateDeleteOperationImpl;

/**
 * Helper for creating resources etc.
 * 
 * @author wesendon
 */
public class ResourceHelper {

	private final ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            serverspace
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public ResourceHelper(ServerSpace serverSpace) throws FatalEmfStoreException {
		this.serverSpace = serverSpace;
	}

	/**
	 * Creates a resource for project history.
	 * 
	 * @param projectHistory
	 *            project history
	 * @throws FatalEmfStoreException
	 *             if saving fails
	 */
	public void createResourceForProjectHistory(ProjectHistory projectHistory) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectHistory.getProjectId()) + "projectHistory"
			+ ServerConfiguration.FILE_EXTENSION_PROJECTHISTORY;
		saveInResource(projectHistory, fileName);
	}

	/**
	 * Creates a resource for a new version.
	 * 
	 * @param version
	 *            version
	 * @param projectId
	 *            project id
	 * @throws FatalEmfStoreException
	 *             if saving fails
	 */
	public void createResourceForVersion(Version version, ProjectId projectId) throws FatalEmfStoreException {
		String fileName = getProjectFolder(projectId) + ServerConfiguration.FILE_PREFIX_VERSION
			+ version.getPrimarySpec().getIdentifier() + ServerConfiguration.FILE_EXTENSION_VERSION;
		saveInResource(version, fileName);
	}

	/**
	 * Creates a resource for a new project.
	 * 
	 * @param project
	 *            project
	 * @param projectId
	 *            projectid
	 * @param versionId
	 *            versionid
	 * @throws FatalEmfStoreException
	 *             if saving fails
	 */
	public void createResourceForProject(Project project, PrimaryVersionSpec versionId, ProjectId projectId)
		throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getProjectFile(versionId.getIdentifier());
		saveInResourceWithProject(project, filename, project);
	}

	/**
	 * Creates a resource for a changepackage.
	 * 
	 * @param changePackage
	 *            changepackage
	 * @param versionId
	 *            versionId
	 * @param projectId
	 *            projectId
	 * @throws FatalEmfStoreException
	 *             if saving fails
	 */
	public void createResourceForChangePackage(ChangePackage changePackage, PrimaryVersionSpec versionId,
		ProjectId projectId) throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getChangePackageFile(versionId.getIdentifier());
		List<Map.Entry<EObject, ModelElementId>> ignoredDatatypes = new ArrayList<Map.Entry<EObject, ModelElementId>>();

		for (AbstractOperation op : changePackage.getOperations()) {
			if (op instanceof CreateDeleteOperation) {
				CreateDeleteOperation createDeleteOp = (CreateDeleteOperation) op;

				for (Map.Entry<EObject, ModelElementId> e : ((CreateDeleteOperationImpl) createDeleteOp)
					.getEObjectToIdMap().entrySet()) {
					XMIResource res = (XMIResource) e.getKey().eResource();

					EObject modelElement = e.getKey();

					if (ModelUtil.isIgnoredDatatype(modelElement)) {
						ignoredDatatypes.add(e);
						continue;
					}

					if (res != null) {
						res.setID(e.getKey(), e.getValue().getId());
					}
				}

				// remove types to be ignored from mapping
				createDeleteOp.getEObjectToIdMap().removeAll(ignoredDatatypes);
			}
		}

		saveInResource(changePackage, filename);
	}

	/**
	 * Deletes a projectstate. The {@link Resource} the project is contained in
	 * will be unloaded as well as deleted.
	 * 
	 * @param version
	 *            the version to be deleted
	 * @param projectId
	 *            the ID of the project to be deleted
	 */
	public void deleteProjectState(Version version, ProjectId projectId) {
		int lastVersion = version.getPrimarySpec().getIdentifier();
		Resource projectResource = version.getProjectState().eResource();

		File file = new File(getProjectFolder(projectId) + getProjectFile(lastVersion));
		version.setProjectState(null);
		file.delete();

		if (projectResource.isLoaded()) {
			projectResource.unload();
		}

		projectResource.getResourceSet().getResources().remove(projectResource);
	}

	/**
	 * Gets and checks a number from a given server property. This number -
	 * referred as x - describes the size of an interval between projectstates.
	 * It's needed to determine whether a projectstate should be saved or be
	 * backuped.
	 * 
	 * @see ServerConfiguration#PROJECTSTATE_VERSION_BACKUP_PERSISTENCE_EVERYXVERSIONS_X
	 * @see ServerConfiguration#PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X
	 * @param policy
	 *            policy name from server configuration
	 * @param defaultPolicy
	 *            default policy name from server configuration
	 * @param allowZero
	 *            allow zero for x
	 * @return x
	 */
	public int getXFromPolicy(String policy, String defaultPolicy, boolean allowZero) {
		int x;
		try {
			x = Integer.parseInt(ServerConfiguration.getProperties().getProperty(policy, defaultPolicy));
		} catch (NumberFormatException e) {
			x = 1;
			ModelUtil.logWarning("Couldn't read property: " + policy + " , x set to 1", e);
		}
		if (x < 0) {
			x = 1;
			ModelUtil.logWarning("Policy " + policy + " with x < 0 not possible, x set to 1.");
		}
		if (!allowZero && x == 0) {
			x = 1;
			ModelUtil.logWarning("Policy " + policy + " with x = 0 not possible, x set to 1.");
		}
		return x;
	}

	/**
	 * Returns the file path to a given project.
	 * 
	 * @param projectId
	 *            the project id
	 * @return file path
	 */
	public String getProjectFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separatorChar;
	}

	private String getProjectFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_PROJECTSTATE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_PROJECTSTATE;
	}

	private String getChangePackageFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_CHANGEPACKAGE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_CHANGEPACKAGE;
	}

	private void saveInResource(EObject obj, String fileName) throws FatalEmfStoreException {
		Resource resource = serverSpace.eResource().getResourceSet().createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);
		save(obj);
	}

	private void saveInResourceWithProject(EObject obj, String fileName, Project project) throws FatalEmfStoreException {
		Resource resource = serverSpace.eResource().getResourceSet().createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);

		if (resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;
			for (EObject modelElement : project.getAllModelElements()) {
				ModelElementId modelElementId = project.getModelElementId(modelElement);
				xmiResource.setID(modelElement, modelElementId.getId());
			}
		}

		save(obj);
	}

	/**
	 * Saves the given EObject and sets the IDs on the eObject's resource for
	 * all model elements contained in the given project.
	 * 
	 * @param eObject
	 *            the EObject to be saved
	 * @param project
	 *            the project, that is used to set the IDs of all model elements
	 *            within the project on the resource
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public void saveWithProject(EObject eObject, Project project) throws FatalEmfStoreException {
		Resource resource = eObject.eResource();

		if (resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;
			for (EObject modelElement : project.getAllModelElements()) {
				ModelElementId modelElementId = project.getModelElementId(modelElement);
				xmiResource.setID(modelElement, modelElementId.getId());
			}
		}

		save(eObject);
	}

	/**
	 * Saves an eObject.
	 * 
	 * @param object
	 *            the object
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public void save(EObject object) throws FatalEmfStoreException {
		try {
			object.eResource().save(ModelUtil.getResourceSaveOptions());
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * Saves all modified resources in the serverspace's resource set.
	 * 
	 * @throws FatalEmfStoreException
	 *             in case of failure
	 */
	public void saveAll() throws FatalEmfStoreException {
		for (Resource res : serverSpace.eResource().getResourceSet().getResources()) {
			if (res.isLoaded() && res.isModified()) {
				try {
					res.save(ModelUtil.getResourceSaveOptions());
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (Exception e) {
					throw new FatalEmfStoreException(StorageException.NOSAVE, e);
				}
				// END SUPRESS CATCH EXCEPTION
			}
		}

	}
}
