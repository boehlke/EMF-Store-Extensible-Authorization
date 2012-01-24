/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.SelectRolesDialog.RoleBox;
import org.eclipse.emf.emfstore.client.ui.views.users.RoleSelection;
import org.eclipse.emf.emfstore.client.ui.views.users.UsersView.AdministrationNavigatorRootNode;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.provider.AccesscontrolItemProviderAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * this adapter factory knows objects used in the UI views
 * 
 * @author boehlke
 * 
 */
public class LabelProviderAdpaterFactory implements IAdapterFactory {

	private class WorkbenchAdapter implements IWorkbenchAdapter {

		private AdapterFactoryLabelProvider roleLabelProvider;

		public WorkbenchAdapter() {
			roleLabelProvider = new AdapterFactoryLabelProvider(new AccesscontrolItemProviderAdapterFactory());
		}

		ILabelProvider labelProvider = new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof RoleBox) {
					RoleBox role = (RoleBox) element;
					return role.getRole().getName();
				}
				if (element instanceof RoleSelection) {
					RoleSelection roleSelection = (RoleSelection) element;
					Role role = roleSelection.getRole();
					if (role == null) {
						return roleSelection.getProject().getName();
					}
					return role.getName();
				}
				if (element instanceof AdministrationNavigatorRootNode) {
					AdministrationNavigatorRootNode node = (AdministrationNavigatorRootNode) element;
					switch (node.getType()) {
					case Users:
						return "Users";
					case Groups:
						return "Groups";
					case SystemRoles:
						return "System roles";
					case ProjectRoles:
						return "Project roles";
					}
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof RoleSelection) {
					RoleSelection sel = (RoleSelection) element;
					if (sel.getRole() != null) {
						return roleLabelProvider.getImage(((RoleSelection) element).getRole());
					}
				}

				return super.getImage(element);
			}
		};

		public Object[] getChildren(Object o) {
			// TODO Auto-generated method stub
			return null;
		}

		public ImageDescriptor getImageDescriptor(Object object) {
			Image image = labelProvider.getImage(object);
			if (image != null) {
				return ImageDescriptor.createFromImage(image);
			}
			return null;
		}

		public String getLabel(Object o) {
			return labelProvider.getText(o);
		}

		public Object getParent(Object o) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IWorkbenchAdapter.class) {
			return new WorkbenchAdapter();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		return new Class[] { IWorkbenchAdapter.class };
	}

}
