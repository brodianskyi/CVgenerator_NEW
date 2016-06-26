package com.codecentric.cvgenerator.service.impl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.codecentric.cvgenerator.api.entities.UploadFile;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.FileUploadDao;
import com.codecentric.cvgenerator.service.FileUploadService;

@Service
@Validated
public class FileUploadServiceImpl implements FileUploadService{
	 private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
	 private FileUploadDao  fileUploadDao;
	 
	 @Inject
	 public FileUploadServiceImpl(FileUploadDao fileUploadDao){
		 this.fileUploadDao = fileUploadDao;
	 }
	 

	@Override
	@Transactional
	public void save(@NotNull UploadFile uploadFile) {
		
		fileUploadDao.save(uploadFile);
		
	}
	@Override
	@Transactional
	 public UploadFile getFile(){
	   	
		 UploadFile upFile = fileUploadDao.findOne(1L);
		
		return upFile;
		
	}

}
