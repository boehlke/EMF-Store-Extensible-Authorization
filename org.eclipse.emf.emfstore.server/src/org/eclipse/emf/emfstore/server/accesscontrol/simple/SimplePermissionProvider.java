/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.accesscontrol.simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.operation.AddTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateVersionOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileDownloadOperation;
import org.eclipse.emf.emfstore.server.model.operation.FileUploadOperation;
import org.eclipse.emf.emfstore.server.model.operation.Operation;
import org.eclipse.emf.emfstore.server.model.operation.ProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadProjectOperation;
import org.eclipse.emf.emfstore.server.model.operation.ReadPropertiesOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveTagOperation;
import org.eclipse.emf.emfstore.server.model.operation.WritePropertiesOperation;

/**
 * @author boehlke
 * 
 */
public class SimplePermissionProvider implements PermissionProvider {

	public final static String PROJECT_ADMIN_PERMISSION = "org.eclipse.emf.emfstore.server.simple.projectadmin";
	public final static String PROJECT_READER_PERMISSION = "org.eclipse.emf.emfstore.server.simple.projectread";
	public final static String PROJECT_WRITER_PERMISSION = "org.eclipse.emf.emfstore.server.simple.projectwrite";

	public final static String SYSTEM_PERMISSION = "org.eclipse.emf.emfstore.server.simple.globaladmin";

	private Collection<InternalPermission> getProjectPermission(ProjectId projectId, String type,
		PermissionContext resolver) {
		PermissionType permissionType = resolver.resolvePermissionType(type);
		if (permissionType == null) {
			throw new RuntimeException();
		}
		return toCollection(new InternalPermission(permissionType, projectId));
	}

	private Collection<InternalPermission> toCollection(InternalPermission permission) {
		List<InternalPermission> collection = new ArrayList<InternalPermission>();
		collection.add(permission);
		return collection;
	}

	private Collection<InternalPermission> getReaderPermissions(ProjectId projectId, PermissionContext resolver) {
		return getProjectPermission(projectId, PROJECT_READER_PERMISSION, resolver);
	}

	private Collection<InternalPermission> getWriterPermissions(ProjectId projectId, PermissionContext resolver) {
		return getProjectPermission(projectId, PROJECT_WRITER_PERMISSION, resolver);
	}

	private Collection<InternalPermission> getProjectAdminPermissions(ProjectId projectId, PermissionContext resolver) {
		return getProjectPermission(projectId, PROJECT_ADMIN_PERMISSION, resolver);
	}

	private Collection<InternalPermission> getServerAdminPermissions(PermissionContext resolver) {
		return getProjectPermission(null, SYSTEM_PERMISSION, resolver);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider#getPermissions(org.eclipse.emf.emfstore.server.model.operation.Operation,
	 *      org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser,
	 *      org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionContext)
	 */
	public Collection<InternalPermission> getPermissions(Operation<?> op, ACUser user, PermissionContext resolver) {

		if (op instanceof ProjectOperation) {
			ProjectOperation<?> projectOperation = (ProjectOperation<?>) op;
			ProjectId projectId = resolver.resolveProjectId(projectOperation.getProjectId());

			Class<?>[] readerClasses = new Class<?>[] { FileDownloadOperation.class, ReadProjectOperation.class,
				ReadPropertiesOperation.class };
			for (Class<?> clazz : readerClasses) {
				if (clazz.isAssignableFrom(op.getClass())) {
					return getReaderPermissions(projectId, resolver);
				}
			}

			Class<?>[] adminClasses = new Class<?>[] { AddTagOperation.class, RemoveTagOperation.class };
			for (Class<?> clazz : adminClasses) {
				if (clazz.isAssignableFrom(op.getClass())) {
					return getProjectAdminPermissions(projectId, resolver);
				}
			}

			Class<?>[] writerClasses = new Class<?>[] { FileUploadOperation.class, CreateVersionOperation.class,
				WritePropertiesOperation.class };
			for (Class<?> clazz : writerClasses) {
				if (clazz.isAssignableFrom(op.getClass())) {
					return getWriterPermissions(projectId, resolver);
				}
			}

		}

		if (op instanceof ReadOrgUnitOperation) {
			ReadOrgUnitOperation readOrgUnitOperation = (ReadOrgUnitOperation) op;
			if (readOrgUnitOperation.getOrgUnitId().equals(user.getId().getId())) {
				return new ArrayList<PermissionProvider.InternalPermission>();
			}
		}

		return getServerAdminPermissions(resolver);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider#getAllPermissionTypes()
	 */
	public PermissionTypeData[] getAllPermissionTypes() {
		return new PermissionTypeData[] { new PermissionTypeData(PROJECT_READER_PERMISSION, "project read", true),
			new PermissionTypeData(PROJECT_WRITER_PERMISSION, "project write", true),
			new PermissionTypeData(PROJECT_ADMIN_PERMISSION, "project administrate", true),
			new PermissionTypeData(SYSTEM_PERMISSION, "system administrate", false) };
	}
}
