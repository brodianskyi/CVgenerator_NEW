package com.codecentric.cvgenerator.service;

import com.codecentric.cvgenerator.api.entities.UploadFile;

public interface FileUploadService {
	
	void save (UploadFile uploadFile);
	UploadFile getFile();

}
