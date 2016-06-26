package com.codecentric.cvgenerator.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codecentric.cvgenerator.api.entities.UploadFile;
import com.codecentric.cvgenerator.api.entities.User;

@Repository
public interface FileUploadDao  extends CrudRepository<UploadFile, Long>{
	
	

}
