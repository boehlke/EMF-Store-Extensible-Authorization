/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emfstore.client.ui.views.users;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.AbstractECPMetaModelElementContext;
import org.eclipse.emf.ecp.common.model.AbstractECPModelElementContext;
import org.eclipse.emf.ecp.common.model.ECPAssociationClassElement;
import org.eclipse.emf.ecp.common.model.ECPMetaModelElementContext;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.eclipse.emf.ecp.common.utilities.ActionHelper;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.ui.views.users.UserUiController;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * @author boehlke
 * 
 */
public class EcpModelElementOpener implements ModelElementOpener {

	private UserUiController controller;

	public EcpModelElementOpener() {
		this.controller = UserUiController.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.common.util.ModelElementOpener#canOpen(org.eclipse.emf.ecore.EObject)
	 */
	public int canOpen(EObject modelElement) {
		Class<?>[] supportedClasses = new Class<?>[] { ACOrgUnit.class, Role.class };
		for (Class<?> clazz : supportedClasses) {
			if (clazz.isAssignableFrom(modelElement.getClass())) {
				return 100;
			}
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.common.util.ModelElementOpener#openModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public void openModelElement(EObject modelElement) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);

		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(ActionHelper.ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE, modelElement);

		try {
			context.addVariable(ActionHelper.MECONTEXT_EVALUATIONCONTEXT_VARIABLE,
				new AbstractECPModelElementContext() {

					private HashSet<EObject> allElements;
					private AdapterFactoryEditingDomain domain;

					public ECPMetaModelElementContext getMetaModelElementContext() {
						return new AbstractECPMetaModelElementContext() {

							public boolean isAssociationClassElement(EClass eClazz) {
								return false;
							}

							public boolean isAssociationClassElement(EObject eObject) {
								return false;
							}

							public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
								return null;
							}

							@Override
							public boolean isNonDomainElement(EClass eClass) {
								return false;
							}
						};
					}

					public EditingDomain getEditingDomain() {
						return controller.getEditingDomain();
					}

					public Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association) {
						Collection<EObject> ret = new BasicEList<EObject>();

						for (EObject element : getAllModelElements()) {
							if ((element.eClass() == clazz || clazz.isInstance(element))
								&& (association || !getMetaModelElementContext().isAssociationClassElement(element))) {
								ret.add(element);
							}
						}

						return ret;
					}

					public Collection<EObject> getAllModelElements() {
						allElements = new HashSet<EObject>();
						Iterator<EObject> iterator = controller.getPermissionSet().eAllContents();
						while (iterator.hasNext()) {
							allElements.add(iterator.next());
						}
						return allElements;
					}

					public void dispose() {
					}

					public boolean contains(EObject eObject) {
						return allElements.contains(eObject);
					}
				});
			handlerService.executeCommand(ActionHelper.MEEDITOR_OPENMODELELEMENT_COMMAND_ID, null);

		} catch (ExecutionException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotDefinedException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotEnabledException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotHandledException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

}
