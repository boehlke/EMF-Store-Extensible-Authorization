package org.eclipse.emf.emfstore.server;

import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.operation.Operation;

public class OperationExecution<T, O extends Operation<T>> {

	public interface OperationExecutionContext {
		SessionId getSessionId();
	}

	private T result;
	private O operation;
	private OperationExecutionContext context;

	public OperationExecution(O operation, OperationExecutionContext ctx) {
		this.operation = operation;
		this.context = ctx;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public O getOperation() {
		return operation;
	}

	public OperationExecutionContext getContext() {
		return context;
	}

}
