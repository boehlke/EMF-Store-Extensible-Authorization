package org.eclipse.emf.emfstore.client.ui.views.users;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class Util {
	public static void configureRoleSelectionTreeViewer(final CheckboxTreeViewer viewer) {
		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				// viewer.refresh();
			}
		});

		final Tree tree = viewer.getTree();

		tree.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					event.detail = SWT.NONE;
					event.type = SWT.None;

					TreeItem item = (TreeItem) event.item;
					Object obj = item.getData();

					// TODO: only change if permitted
					// event.doit = false;
					// Object obj = event.item;
					// ((TreeItem) event.item).setChecked(false);

				}
			}
		});

		// final TreeCursor cursor = new TreeCursor(tree, SWT.NONE);
		// tree.addKeyListener(new KeyListener() {
		// public void keyReleased(KeyEvent e) {
		// if (e.keyCode == SWT.MOD1 && (e.stateMask & SWT.MOD2) != 0)
		// return;
		// if (e.keyCode == SWT.MOD2 && (e.stateMask & SWT.MOD1) != 0)
		// return;
		// if (e.keyCode != SWT.MOD1 && (e.stateMask & SWT.MOD1) != 0)
		// return;
		// if (e.keyCode != SWT.MOD2 && (e.stateMask & SWT.MOD2) != 0)
		// return;
		//
		// TreeItem[] selection = tree.getSelection();
		// TreeItem row = (selection.length == 0) ? tree.getItem(tree.indexOf(tree.getTopItem())) : selection[0];
		// tree.showItem(row);
		// cursor.setSelection(row, cursor.getColumn());
		// cursor.setVisible(true);
		// cursor.setFocus();
		// }
		//
		// public void keyPressed(KeyEvent e) {
		// switch (e.keyCode) {
		// case SWT.ARROW_LEFT:
		// case SWT.ARROW_RIGHT: {
		// if ((e.stateMask & SWT.MOD1) != 0) {
		// TreeItem[] selection = tree.getSelection();
		// if (selection.length > 0) {
		// selection[0].setExpanded(e.keyCode == SWT.ARROW_RIGHT);
		// }
		// break;
		// }
		// }
		// }
		// }
		// });
	}
}
