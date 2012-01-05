package org.eclipse.emf.emfstore.server.accesscontrol;

import java.io.Serializable;

/**
 * 
 * @author boehlke
 * 
 */
public class Permission implements Serializable {

	private static final long serialVersionUID = 8741152772777456754L;
	private String id;
	private String projectId;

	public Permission(String id) {
		this.id = id;
	}

	public Permission(String id, String projectId) {
		this(id);
		this.projectId = projectId;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getId() {
		return id;
	}

	public boolean isProjectPermission() {
		return projectId != null;
	}

	@Override
	public int hashCode() {
		return (getProjectId() == null ? getId().hashCode() : getId()
				.hashCode() + getProjectId().hashCode())
				+ (isProjectPermission() ? 1 : 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Permission) {
			Permission otherPermission = (Permission) obj;
			boolean equalProjectId = otherPermission.getProjectId() == null ? getProjectId() == null
					: otherPermission.getProjectId().equals(getProjectId());
			return equalProjectId && otherPermission.getId().equals(getId());
		}
		return super.equals(obj);
	}
}
