/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictContext;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictDescription;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Container for {@link MultiReferenceConflict} and {@link SingleReferenceConflict}.
 * 
 * @author wesendon
 */
public class ReferenceConflict extends Conflict {

	private final Conflict conflict;

	/**
	 * Default constructor.
	 * 
	 * @param conflict underlying conflict, {@link MultiReferenceConflict} or {@link SingleReferenceConflict}
	 * @param myOps list of my operations
	 * @param theirOps list of their operations
	 */
	public ReferenceConflict(Conflict conflict, List<AbstractOperation> myOps, List<AbstractOperation> theirOps) {
		super(myOps, theirOps, conflict.getDecisionManager(), conflict.isLeftMy(), false);
		if (!(conflict instanceof SingleReferenceConflict || conflict instanceof MultiReferenceConflict)) {
			throw new IllegalStateException("Only reference conflicts allowed.");
		}
		this.conflict = conflict;
		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean allowOtherOptions() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return conflict.getConflictContext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription desc) {
		return conflict.getConflictDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		for (ConflictOption option : conflict.getOptions()) {
			if (option.getType() == OptionType.MyOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(getLeftOperations());
			} else if (option.getType() == OptionType.TheirOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(getRightOperations());
			}
			options.add(option);
		}
	}

}
