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
}
