package com.codecentric.cvgenerator.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.service.AusbildungService;
import com.codecentric.cvgenerator.service.UserService;

@Service
@Validated
public class AusbildungServiceImpl implements AusbildungService{
	private static final Logger logger = LoggerFactory.getLogger(AusbildungServiceImpl.class);
	private final AusbildungDao repository;
	
	@Inject
	public AusbildungServiceImpl(final AusbildungDao repository) {
	   	
       this.repository = repository;
	}

	

	@Override
	@Transactional
	public void save(@NotNull @Valid List<Ausbildung> list) {
		  
		  repository.save(list);
	}
	
	
	
	

}
