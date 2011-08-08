package org.eclipse.emf.emfstore.client.ui.commands.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractEMFStoreHandler extends AbstractHandler {

	private ExecutionEvent event;
	private ProjectSpace projectSpace;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event = event;
		setProjectSpace(UiUtil.getEventElementByClass(event, ProjectSpace.class));
		doExecute();
		return null;
	}

	public abstract Object doExecute();

	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	public Shell getShell() {
		return Display.getCurrent().getActiveShell();
	}
}