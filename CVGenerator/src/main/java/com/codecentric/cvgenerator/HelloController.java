package com.codecentric.cvgenerator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	 @RequestMapping("/")
	    public String index() {
	        return "SV GENERATOR ";
	    }
	    
	    @RequestMapping("/jsontest") 
	    public @ResponseBody Map<String, String> callSomething () {
	        
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("url", "http://www.leveluplunch.com");
	        
	        return map;
	    }

}
