/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.OverlayImageDescriptor;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MEMultiLinkControl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author boehlke
 * 
 */
public class EcpRoleAssignmentWidget extends MEMultiLinkControl {

	private UserUiController controller;

	public EcpRoleAssignmentWidget() {
		this.controller = UserUiController.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		if (modelElement instanceof ACOrgUnit) {
			return 100;
		}
		return DO_NOT_RENDER;
	}

	@Override
	protected void createSectionToolbar(final Section section, FormToolkit toolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		final Cursor handCursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolbar.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (!handCursor.isDisposed()) {
					handCursor.dispose();
				}
			}
		});

		Image image = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(getModelElement());
		String overlayString = "icons/link_overlay.png";
		if (eReference.isContainment()) {
			overlayString = "icons/containment_overlay.png";
		}
		ImageDescriptor addOverlay = org.eclipse.emf.ecp.common.Activator.getImageDescriptor(overlayString);
		final OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(image, addOverlay,
			OverlayImageDescriptor.LOWER_RIGHT);

		toolBarManager.add(new Action() {

			@Override
			public void run() {
				CheckedTreeSelectionDialog checkedTreeSelectionDialog = new CheckedTreeRoleSelectionDialog(section
					.getShell(), controller);
				ACOrgUnit acOrgUnit = (ACOrgUnit) getModelElement();
				EList<RoleAssignment> roles = acOrgUnit.getRoles();
				checkedTreeSelectionDialog.setInput(roles);
				checkedTreeSelectionDialog.open();
				Object[] result = checkedTreeSelectionDialog.getResult();

				if (result == null) {
					return;
				}

				List<RoleAssignment> added = new ArrayList<RoleAssignment>();
				Set<RoleAssignment> removed = new HashSet<RoleAssignment>();

				removed.addAll(roles);

				RESULT: for (Object object : result) {
					RoleSelection sel = (RoleSelection) object;

					if (sel.getRole() == null) {
						continue;
					}

					ProjectId projectId = null;
					if (sel.getProject() != null) {
						projectId = sel.getProject().getProjectId();
					}
					for (RoleAssignment assignmentData : roles) {
						ProjectId projectId2 = assignmentData.getProjectId();
						if ((projectId2 == null && projectId == null)
							|| (projectId2 != null && projectId2.equals(projectId))
							&& assignmentData.getRole().getId().equals(sel.getRole().getId())) {
							removed.remove(assignmentData);
							continue RESULT;
						}
					}

					// TODO: send to server
					RoleAssignment newAssignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();

					if (projectId != null) {
						ProjectId id = ModelFactory.eINSTANCE.createProjectId();
						id.setId(projectId.getId());
						newAssignment.setProjectId(id);
					}
					newAssignment.setRole(sel.getRole());
					added.add(newAssignment);
				}

				for (RoleAssignment roleAssignment : added) {
					acOrgUnit.getRoles().add(roleAssignment);
				}

				for (RoleAssignment roleAssignment : removed) {
					acOrgUnit.getRoles().remove(roleAssignment);
				}

				// List<RoleAssignment> assignments = new ArrayList<RoleAssignment>();
				// for (Object object : result) {
				// RoleSelection sel = (RoleSelection) object;
				// if (sel.getRole() == null) {
				// continue;
				// }
				// RoleAssignment assignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();
				// assignment.setRole(sel.getRole());
				// if (sel.getProject() != null) {
				// assignment.setProjectId(sel.getProject().getProjectId());
				// }
				// assignments.add(assignment);
				// }

				// return new BasicEList<Object>(assignments);
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				return imageDescriptor;
			}

		});
		toolBarManager.update(true);
		section.setTextClient(toolbar);
	}

}
