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
package org.eclipse.emf.emfstore.common.filetransfer;

import java.io.Serializable;

/**
 * @author pfeifferc
 */
public class FileChunk implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean end;
	private byte[] data;
	private FileTransferInformation fileInformation;

	/**
	 * Default constructor.
	 * 
	 * @param fileInformation file information
	 * @param end flag reserved for last chunk
	 * @param data the actual data
	 */
	public FileChunk(FileTransferInformation fileInformation, boolean end, byte[] data) {
		this.fileInformation = fileInformation;
		this.end = end;
		this.data = data;
	}

	/**
	 * @return data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * @return chunk number
	 */
	public int getChunkNumber() {
		return fileInformation.getChunkNumber();
	}

	/**
	 * @return true if last chunk
	 */
	public boolean isLast() {
		return end;
	}

	/**
	 * @return file identifier
	 */
	public String getFileIdentifier() {
		return fileInformation.getFileIdentifier();
	}

	/**
	 * @return the file information
	 */
	public FileTransferInformation getFileInformation() {
		return fileInformation;
	}

	/**
	 * @param fileInformation file information
	 */
	public void setFileInformation(FileTransferInformation fileInformation) {
		this.fileInformation = fileInformation;
	}

	/**
	 * @return file size
	 */
	public int getFileSize() {
		return fileInformation.getFileSize();
	}

}
