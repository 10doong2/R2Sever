package com.doongis.r2.server;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileVO {

	private CommonsMultipartFile upFile;

	public CommonsMultipartFile getUpFile() {
		return upFile;
	}
	
	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}
}
