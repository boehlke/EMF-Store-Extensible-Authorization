package org.eclipse.emf.emfstore.server.core.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.server.OperationExecution;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl;
import org.eclipse.emf.emfstore.server.core.helper.Util;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionType;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.emf.emfstore.server.model.operation.AddGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateGroupOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateOrUpdateRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.CreateUserOperation;
import org.eclipse.emf.emfstore.server.model.operation.DeleteOrgUnitOperation;
import org.eclipse.emf.emfstore.server.model.operation.OrgUnitRoleOperation;
import org.eclipse.emf.emfstore.server.model.operation.RemoveGroupMemberOperation;
import org.eclipse.emf.emfstore.server.model.operation.SetOrgUnitPropertyOperation;

public class OrgUnitOperationExecutor extends OperationExecutor {

	public OrgUnitOperationExecutor(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
	}

	@OperationHandler(operationClass = CreateGroupOperation.class)
	public void createGroup(OperationExecution<Void, CreateGroupOperation> execution) throws EmfStoreException {
		CreateGroupOperation operation = execution.getOperation();
		String name = operation.getName();

		if (groupExists(name)) {
			throw new InvalidInputException("group already exists.");
		}

		ACGroup acGroup = AccesscontrolFactory.eINSTANCE.createACGroup();
		acGroup.setName(name);
		getServerSpace().getPermissionSet().getGroups().add(acGroup);
		save();
	}

	private boolean groupExists(String name) {
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@OperationHandler(operationClass = DeleteOrgUnitOperation.class)
	public void deleteOrgUnit(OperationExecution<Void, DeleteOrgUnitOperation> execution) throws EmfStoreException {
		DeleteOrgUnitOperation op = execution.getOperation();
		String orgUnitId = op.getOrgUnitId();

		for (Iterator<ACGroup> iter = getServerSpace().getGroups().iterator(); iter.hasNext();) {
			ACGroup next = iter.next();
			if (next.getId().getId().equals(orgUnitId)) {
				EcoreUtil.delete(next);
				save();
				return;
			}
		}
		for (Iterator<ACUser> iter = getServerSpace().getUsers().iterator(); iter.hasNext();) {
			ACUser next = iter.next();
			if (next.getId().getId().equals(orgUnitId)) {
				EcoreUtil.delete(next);
				save();
				return;
			}
		}

	}

	@OperationHandler(operationClass = AddGroupMemberOperation.class)
	public void addMember(OperationExecution<Void, AddGroupMemberOperation> execution) throws EmfStoreException {
		AddGroupMemberOperation op = execution.getOperation();
		String group = op.getOrgUnitId();
		ACGroup acGroup = getGroup(group);
		ACOrgUnit acMember = getOrgUnit(op.getMemberId());
		acGroup.getMembers().add(acMember);
		save();
	}

	@OperationHandler(operationClass = RemoveGroupMemberOperation.class)
	public void removeMember(OperationExecution<Void, RemoveGroupMemberOperation> execution) throws EmfStoreException {
		RemoveGroupMemberOperation operation = execution.getOperation();
		ACGroup acGroup = getGroup(operation.getOrgUnitId());
		ACOrgUnit acMember = getOrgUnit(operation.getMemberId());
		if (acGroup.getMembers().contains(acMember)) {
			acGroup.getMembers().remove(acMember);
			save();
		}
	}

	@OperationHandler(operationClass = CreateUserOperation.class)
	public void createUser(OperationExecution<Void, CreateUserOperation> execution) throws EmfStoreException {
		String name = execution.getOperation().getName();
		if (userExists(name)) {
			throw new InvalidInputException("username '" + name + "' already exists.");
		}
		ACUser acUser = AccesscontrolFactory.eINSTANCE.createACUser();
		acUser.setName(name);
		getServerSpace().getPermissionSet().getUsers().add(acUser);
		save();
	}

	private boolean userExists(String name) {
		for (ACUser user : getServerSpace().getUsers()) {
			if (user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@OperationHandler(operationClass = OrgUnitRoleOperation.class)
	public void assignOrRemoveRole(OperationExecution<Void, OrgUnitRoleOperation> execution) throws EmfStoreException {
		OrgUnitRoleOperation op = execution.getOperation();
		ACOrgUnit unit = getOrgUnit(op.getOrgUnitId());

		Role role = Util.getRoleOrNull(op.getRoleId(), getServerSpace());

		if (role == null) {
			throw new InvalidInputException("role " + op.getRoleId() + " does not exist");
		}

		String projectId = op.getProjectId();

		ProjectHistory projectHistory = Util.getProjectHistoryOrNull(projectId, getServerSpace());
		if (projectId != null && projectHistory == null) {
			throw new InvalidInputException("invalid project");
		}

		if (op.isAssign()) {
			RoleAssignment assignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();
			if (projectHistory != null) {
				assignment.setProjectId(EcoreUtil.copy(projectHistory.getProjectId()));
			}
			assignment.setRole(role);

			unit.getRoles().add(assignment);
		} else {
			Iterator<RoleAssignment> i = unit.getRoles().iterator();
			while (i.hasNext()) {
				RoleAssignment assignment = i.next();
				if (assignment.getRole() == role
					&& ((projectId == null && assignment.getProjectId() == null) || assignment.getProjectId() != null
						&& assignment.getProjectId().getId().equals(projectId))) {
					i.remove();
				}
			}
		}
		save();
	}

	@OperationHandler(operationClass = CreateOrUpdateRoleOperation.class)
	public void changeOrCreateRole(OperationExecution<String, CreateOrUpdateRoleOperation> execution)
		throws EmfStoreException {
		Role roleData = execution.getOperation().getRole().getRole();
		Role role = Util.getRoleOrNull(roleData.getIdentifier(), getServerSpace());

		List<PermissionType> permissionTypes = new ArrayList<PermissionType>();
		for (PermissionType permissionType : roleData.getPermissionTypes()) {
			PermissionType resolvedPermissionType = getServerSpace().getPermissionSet().getPermissionType(
				permissionType.getId());
			if (resolvedPermissionType == null) {
				throw new InvalidInputException("invalid permission type: " + permissionType.getId());
			}
			permissionTypes.add(resolvedPermissionType);
		}

		if (role != null) {
			role.getPermissionTypes().clear();
			permissionTypes.clear();
			role.getPermissionTypes().addAll(permissionTypes);
			role.setDescription(roleData.getDescription());
			role.setName(roleData.getName());
		} else {
			role = AccesscontrolFactory.eINSTANCE.createRole();
			role.setDescription(roleData.getDescription());
			role.setName(roleData.getName());
			role.setSystemRole(roleData.isSystemRole());
			role.getPermissionTypes().addAll(permissionTypes);
			getServerSpace().getPermissionSet().getRoles().add(role);
		}
		save();
		execution.setResult(role.getIdentifier());
	}

	@OperationHandler(operationClass = SetOrgUnitPropertyOperation.class)
	public void setOrgUnitProperties(OperationExecution<Void, SetOrgUnitPropertyOperation> execution)
		throws EmfStoreException {
		SetOrgUnitPropertyOperation op = execution.getOperation();
		Map<String, String> properties = op.getProperties();
		if (properties == null) {
			throw new InvalidInputException("properties must be set");
		}

		ACOrgUnit unit = getOrgUnit(op.getOrgUnitId());

		Map<String, EAttribute> attributeMap = new HashMap<String, EAttribute>();
		for (EAttribute attr : unit.eClass().getEAllAttributes()) {
			attributeMap.put(attr.getName(), attr);
		}

		Map<EAttribute, String> attributesToSet = new HashMap<EAttribute, String>();

		for (Map.Entry<String, String> e : properties.entrySet()) {
			if (attributeMap.containsKey(e.getKey())) {
				attributesToSet.put(attributeMap.get(e.getKey()), e.getValue());
			} else if (e.getKey().equals("password")) {
				// TODO: if SPFV is configured, write password to file
			} else {
				throw new InvalidInputException("invalid attribute: " + e.getKey());
			}
		}

		for (Map.Entry<EAttribute, String> e : attributesToSet.entrySet()) {
			unit.eSet(e.getKey(), e.getValue());
		}

		save();
	}

	private ACGroup getGroup(String orgUnitId) throws EmfStoreException {
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.getId().equals(orgUnitId)) {
				return group;
			}
		}
		throw new EmfStoreException("Given group doesn't exist.");
	}

	private ACOrgUnit getOrgUnit(String orgUnitId) throws EmfStoreException {
		for (ACOrgUnit unit : getServerSpace().getUsers()) {
			if (unit.getId().getId().equals(orgUnitId)) {
				return unit;
			}
		}
		for (ACOrgUnit unit : getServerSpace().getGroups()) {
			if (unit.getId().getId().equals(orgUnitId)) {
				return unit;
			}
		}
		throw new InvalidInputException("org unit does not exist");
	}

}
