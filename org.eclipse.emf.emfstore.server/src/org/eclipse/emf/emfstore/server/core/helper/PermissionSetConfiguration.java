package org.eclipse.emf.emfstore.server.core.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider;
import org.eclipse.emf.emfstore.server.accesscontrol.PermissionProvider.PermissionTypeData;
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

		if (permissionProviderConfigs.length > 1) {
			for (IConfigurationElement config : permissionProviderConfigs) {
				String name = config.getContributor().getName();
				if (!name.equals("org.eclipse.emf.emfstore.server")) {
					permissionProvider = (PermissionProvider) config.createExecutableExtension("providerClass");
					break;
				}
			}
		} else {
			permissionProvider = (PermissionProvider) permissionProviderConfigs[0]
				.createExecutableExtension("providerClass");
		}

		for (PermissionTypeData permissionType : permissionProvider.getAllPermissionTypes()) {
			PermissionType type = AccesscontrolFactory.eINSTANCE.createPermissionType();
			type.setId(permissionType.getId());
			type.setProjectPermission(permissionType.isProjectPermission());
			permissionSet.getPermissionTypes().add(type);
		}

	}

	public PermissionSet getPermissionSet() {
		return permissionSet;
	}

	public PermissionProvider getPermissionProvider() {
		return permissionProvider;
	}
}
