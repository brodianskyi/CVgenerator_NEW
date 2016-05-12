package com.codecentric.cvgenerator.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloController {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 @RequestMapping("/")
	    public String index() {
		    logger.info("Bananaphone pu-pu-pi-dup-pi-dup !!!");
	       
		return "CV GENERATOR ";
	  }
	    
	   

}
