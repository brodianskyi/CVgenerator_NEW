package com.codecentric.cvgenerator.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 @RequestMapping("/")
	    public String index() {
		    logger.debug("HELLO FROM CV GENERATOR");
	        return "CV GENERATOR ";
	    }
	    
	    @RequestMapping("/jsontest") 
	    public @ResponseBody Map<String, String> callSomething () {
	        
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("url", "http://www.leveluplunch.com");
	        
	        return map;
	    }

}
