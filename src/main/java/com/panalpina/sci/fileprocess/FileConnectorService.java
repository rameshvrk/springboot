package com.panalpina.sci.fileprocess;

import java.util.List;

public interface FileConnectorService {
	public List<String> getFile(String prefix);

	public void archiveFiles(List<String> fileNames);
}
