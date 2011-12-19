package org.eclipse.emf.emfstore.server.core.operation;

import java.io.IOException;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl;
import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.helper.Util;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;

/**
 * parent class for operation executors
 * 
 * @author boehlke
 * 
 */
public abstract class OperationExecutor extends AbstractEmfstoreInterface {

	public OperationExecutor(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
	}

	@Override
	protected void initSubInterfaces() throws FatalEmfStoreException {
	}

	protected ProjectId getProjectId(String projectId) {
		return Util.getProjectHistoryOrNull(projectId, getServerSpace()).getProjectId();
	}

	protected void save() {
		try {
			getServerSpace().save();
		} catch (IOException e) {
			ModelUtil.logWarning("server space could not be saved", e);
			throw new RuntimeException(e);
		}
	}
}
