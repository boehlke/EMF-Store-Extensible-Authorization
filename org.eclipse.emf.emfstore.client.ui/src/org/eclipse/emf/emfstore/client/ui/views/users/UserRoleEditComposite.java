package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.model.util.EmfStoreInterface;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.PermissionSet;
import org.eclipse.emf.emfstore.server.model.accesscontrol.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.RoleAssignment;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class UserRoleEditComposite extends Composite {

	private ACUser userData;
	private Table table;
	private TableViewer tableViewer;

	private Map<String, Role> roleMap = new HashMap<String, Role>();
	private Map<String, ProjectInfo> projectInfoMap = new HashMap<String, ProjectInfo>();

	private MyViewerComparator comparator;
	private Composite rolesComposite;
	private EmfStoreInterface adminBroker;
	private PermissionSet permissionSet;

	public class MyViewerComparator extends ViewerComparator {
		private int propertyIndex;
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public MyViewerComparator() {
			this.propertyIndex = 0;
			direction = DESCENDING;
		}

		public int getDirection() {
			return direction == 1 ? SWT.DOWN : SWT.UP;
		}

		public void setColumn(int column) {
			if (column == this.propertyIndex) {
				// Same column as last sort; toggle the direction
				direction = 1 - direction;
			} else {
				// New column; do an ascending sort
				this.propertyIndex = column;
				direction = DESCENDING;
			}
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			RoleAssignment RoleAssignment1 = (RoleAssignment) e1;
			RoleAssignment RoleAssignment2 = (RoleAssignment) e2;
			int rc = 0;

			Role role1 = RoleAssignment1.getRole();
			Role role2 = RoleAssignment2.getRole();

			ProjectInfo info1 = projectInfoMap.get(RoleAssignment1.getProjectId());
			ProjectInfo info2 = projectInfoMap.get(RoleAssignment2.getProjectId());

			switch (propertyIndex) {
			case 0:
				rc = role1.getName().compareTo(role2.getName());
				break;
			case 1:
				rc = 0;
				break;
			case 2:
				String name1 = info1 == null ? "" : info1.getName();
				String name2 = info2 == null ? "" : info2.getName();
				rc = name1.compareTo(name2);
				break;
			default:
				rc = 0;
			}
			// If descending order, flip the direction
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param dummyAdminBroker
	 * @param projectInfoMap2
	 * @param roleMap2
	 */
	public UserRoleEditComposite(final Composite parent, int style, ACUser user, final PermissionSet permissionSet,
		final Map<String, ProjectInfo> projectInfoMap, final EmfStoreInterface adminBroker) {
		super(parent, style);

		this.userData = user;

		this.adminBroker = adminBroker;
		this.permissionSet = permissionSet;
		this.projectInfoMap = projectInfoMap;

		for (Role role : permissionSet.getRoles()) {
			roleMap.put(role.getId(), role);
		}

		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite rolesComposite = new Composite(parent, SWT.NONE);

		// Registry registry = ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
		rolesComposite.setLayout(new GridLayout(1, false));

		Button addRoleButton = new Button(rolesComposite, SWT.NONE);
		addRoleButton.setText("Rollen zuordnen");
		addRoleButton.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {

				CheckedTreeSelectionDialog checkedTreeSelectionDialog = new CheckedTreeRoleSelectionDialog(getShell(),
					UserUiController.getInstance());
				checkedTreeSelectionDialog.setInput(userData.getRoles());
				checkedTreeSelectionDialog.open();
				Object[] result = checkedTreeSelectionDialog.getResult();

				if (result == null) {
					return;
				}

				List<RoleAssignment> added = new ArrayList<RoleAssignment>();
				Set<RoleAssignment> removed = new HashSet<RoleAssignment>();

				removed.addAll(userData.getRoles());

				RESULT: for (Object object : result) {
					RoleSelection sel = (RoleSelection) object;

					if (sel.getRole() == null) {
						continue;
					}

					String projectId = null;
					if (sel.getProject() != null) {
						projectId = sel.getProject().getProjectId().getId();
					}
					for (RoleAssignment assignmentData : userData.getRoles()) {
						ProjectId projectId2 = assignmentData.getProjectId();
						if (projectId2 != null && projectId2.equals(projectId)
							&& assignmentData.getRole().equals(sel.getRole())) {
							removed.remove(assignmentData);
							continue RESULT;
						}
					}

					// TODO: send to server
					RoleAssignment newAssignment = AccesscontrolFactory.eINSTANCE.createRoleAssignment();

					if (projectId != null) {
						ProjectId id = ModelFactory.eINSTANCE.createProjectId();
						id.setId(projectId);
						newAssignment.setProjectId(id);
					}
					newAssignment.setRole(sel.getRole());
					added.add(newAssignment);
				}

				for (RoleAssignment RoleAssignment : added) {
					userData.getRoles().add(RoleAssignment);
				}

				for (RoleAssignment roleAssignment : removed) {
					userData.getRoles().remove(roleAssignment);
				}

				tableViewer.refresh();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		this.rolesComposite = rolesComposite;

		Composite tabComposite = new Composite(rolesComposite, SWT.NONE);
		GridData gd_tabComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_tabComposite.heightHint = 300;
		gd_tabComposite.minimumHeight = 200;
		tabComposite.setLayoutData(gd_tabComposite);
		tabComposite.setLayout(new FillLayout(SWT.VERTICAL));

		tableViewer = new TableViewer(tabComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		this.comparator = new MyViewerComparator();

		tableViewer.setLabelProvider(new WorkbenchLabelProvider());
		tableViewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				viewer.refresh();
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				EList<RoleAssignment> roles = (EList<RoleAssignment>) inputElement;
				return roles.toArray();
			}
		});

		createColumns(tabComposite, tableViewer);

		// table.getColumn(3).pack();
		tableViewer.setInput(userData.getRoles());
		tableViewer.setComparator(comparator);

	}

	private Role getRole(String roleId) {
		return roleMap.get(roleId);
	}

	private String getRoleName(String roleId) {
		Role role = getRole(roleId);
		return role.getName();
	}

	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Rolle", "Rollentyp", "Projekt" };
		int[] bounds = { 200, 200, 250 };

		TableViewerColumn nameColumn = createTableViewerColumn(titles[0], bounds[0], 0, viewer, true);
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RoleAssignment assignment = (RoleAssignment) element;
				return getRoleName(assignment.getRole().getId());
			}
		});

		TableViewerColumn typeColumn = createTableViewerColumn(titles[1], bounds[1], 1, viewer, true);
		typeColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RoleAssignment assignment = (RoleAssignment) element;
				String type = assignment.getRole().isSystemRole() ? "Systemrolle" : "Projektrolle";
				return type;
			}
		});

		TableViewerColumn detailsColumn = createTableViewerColumn(titles[2], bounds[2], 2, viewer, true);
		detailsColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				RoleAssignment assignment = (RoleAssignment) element;

				String projectId = assignment.getProjectId().getId();
				if (!projectId.equals("")) {
					ProjectInfo info = projectInfoMap.get(projectId);
					return info.getName();
				}
				return "";
			}
		});
	}

	private SelectionAdapter getSelectionAdapter(final TableColumn column, final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				tableViewer.getTable().setSortDirection(dir);
				tableViewer.refresh();
			}
		};
		return selectionAdapter;
	}

	protected String paramNameToString(String key) {
		if (key.equals("projectId")) {
			return "Projekt";
		}
		return "";
	}

	private static String join(Iterable<? extends Object> pColl, String separator) {
		Iterator<? extends Object> oIter;
		if (pColl == null || (!(oIter = pColl.iterator()).hasNext()))
			return "";
		StringBuilder oBuilder = new StringBuilder(String.valueOf(oIter.next()));
		while (oIter.hasNext())
			oBuilder.append(separator).append(oIter.next());
		return oBuilder.toString();
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber,
		final TableViewer viewer, boolean sortable) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		if (sortable) {
			column.addSelectionListener(getSelectionAdapter(column, colNumber));
		}
		return viewerColumn;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}

	public void setUser(ACUser user) {
		this.userData = user;
		tableViewer.setInput(user.getRoles());
	}
}
