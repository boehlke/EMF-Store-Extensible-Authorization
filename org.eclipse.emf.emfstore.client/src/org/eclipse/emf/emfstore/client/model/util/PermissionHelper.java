package org.eclipse.emf.emfstore.client.model.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.model.SessionId;

/**
 * helps when checking if the current user has permissions for an operation
 * 
 * @author boehlke
 * 
 */
public class PermissionHelper {

	public static class Handler implements InvocationHandler {
		private SessionId sessionId;
		private EmfStore emfStore;

		public Handler(EmfStore emfStore, SessionId sessionId) {
			this.emfStore = emfStore;
			this.sessionId = sessionId;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			String methodName = method.getName();
			List<Class<?>> argTypes = new ArrayList<Class<?>>();
			argTypes.add(SessionId.class);

			List<Object> allArgs = new ArrayList<Object>();
			allArgs.add(sessionId);

			if (args != null) {
				for (Object object : args) {
					argTypes.add(object.getClass());
					allArgs.add(object);
				}
			}

			M: for (Method m : emfStore.getClass().getMethods()) {
				if (!m.getName().equals(methodName)) {
					continue;
				}
				int i = 0;
				for (Class<?> clazz : m.getParameterTypes()) {
					if (!clazz.isAssignableFrom(argTypes.get(i))) {
						continue M;
					}
					i++;
				}
				return m.invoke(emfStore, allArgs.toArray());
			}
			return null;
		}
	}

	private EmfStoreInterface emfStore;

	/**
	 * creates a new helper for the given server
	 * 
	 * @param sessionId session to use
	 */
	public PermissionHelper(SessionId sessionId) {
		this.emfStore = UsersessionImpl.getEmfStoreProxy(sessionId);
	}

}
