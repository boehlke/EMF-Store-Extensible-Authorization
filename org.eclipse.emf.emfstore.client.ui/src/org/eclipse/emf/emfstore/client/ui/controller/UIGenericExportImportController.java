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
package org.eclipse.emf.emfstore.client.ui.controller;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.emfstore.client.model.importexport.ExportImportControllerExecutor;
import org.eclipse.emf.emfstore.client.model.importexport.IExportImportController;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.ui.handlers.AbstractEMFStoreUIController;
import org.eclipse.emf.emfstore.client.ui.util.EMFStoreMessageDialog;
import org.eclipse.emf.emfstore.client.ui.util.EMFStorePreferenceHelper;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Generic and UI-specific controller class that is capable of executing
 * both import and export controller classes.
 * 
 * @author emueller
 * 
 */
public class UIGenericExportImportController extends AbstractEMFStoreUIController {

	/**
	 * Constructor.
	 * 
	 * @param shell
	 *            the parent {@link Shell}
	 * @param controller
	 *            the {@link IExportImportController} to be executed
	 */
	public UIGenericExportImportController(Shell shell) {
		super(shell);
	}

	/**
	 * Executes the controller.
	 */
	protected void execute(final IExportImportController controller) {

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
			controller.isExport() ? SWT.SAVE : SWT.OPEN);
		dialog.setFilterNames(controller.getFilteredNames());
		dialog.setFilterExtensions(controller.getFilteredExtensions());
		dialog.setOverwrite(true);

		if (controller.getParentFolderPropertyKey() != null) {
			String initialPath = EMFStorePreferenceHelper.getPreference(controller.getParentFolderPropertyKey(),
				System.getProperty("user.home"));
			dialog.setFilterPath(initialPath);
		}

		dialog.setFileName(controller.getFilename());
		String fn = dialog.open();
		if (fn == null) {
			return;
		}

		final File file = new File(dialog.getFilterPath(), dialog.getFileName());
		EMFStorePreferenceHelper.setPreference(controller.getParentFolderPropertyKey(), file.getParent());

		final ProgressMonitorDialog progress = openProgress();
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				try {
					progress.open();
					progress.getProgressMonitor().beginTask("Import " + controller.getLabel() + " ...", 100);
					progress.getProgressMonitor().worked(10);
					new ExportImportControllerExecutor(file, getProgressMonitor()).execute(controller);
				} catch (IOException e) {
					EMFStoreMessageDialog.showExceptionDialog(e);
				} finally {
					progress.getProgressMonitor().done();
					progress.close();
				}

			}
		}.run();

		// TODO: include confirmation dialog messages in interface
		// MessageDialog.openInformation(null, "Import", "Imported changes from file " + file.getAbsolutePath());
	}
}
