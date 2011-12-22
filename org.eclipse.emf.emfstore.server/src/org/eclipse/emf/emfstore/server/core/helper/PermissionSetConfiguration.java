package org.eclipse.emf.emfstore.server.core.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;

public class PermissionSetConfiguration {
	private PermissionProvider permissionProvider;
	private PermissionSet permissionSet;

	private static IConfigurationElement[] getByName(IConfigurationElement[] pool, String name) {
		List<IConfigurationElement> list = new ArrayList<IConfigurationElement>();
		for (IConfigurationElement iConfigurationElement : pool) {
			if (iConfigurationElement.getName().equals(name)) {
				list.add(iConfigurationElement);
			}
		}
		return list.toArray(new IConfigurationElement[0]);
	}

	public PermissionSetConfiguration(IConfigurationElement[] iConfigurationElements) throws CoreException {
		permissionSet = AccesscontrolFactory.eINSTANCE.createPermissionSet();

		IConfigurationElement[] permissionProviderConfigs = getByName(iConfigurationElements, "permissionProvider");
		IConfigurationElement[] permissionTypeConfigs = getByName(iConfigurationElements, "permissionType");

		for (IConfigurationElement iConfigurationElement : permissionTypeConfigs) {
			PermissionType type = AccesscontrolFactory.eINSTANCE.createPermissionType();
			type.setId(iConfigurationElement.getAttribute("id"));
			type.setProjectPermission(Boolean.valueOf(iConfigurationElement.getAttribute("projectPermission")));
			permissionSet.getPermissionTypes().add(type);
		}

		permissionProvider = (PermissionProvider) permissionProviderConfigs[0]
			.createExecutableExtension("providerClass");
	}

	public PermissionSet getPermissionSet() {
		return permissionSet;
	}

	public PermissionProvider getPermissionProvider() {
		return permissionProvider;
	}
}
