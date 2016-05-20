package com.codecentric.cvgenerator.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.codecentric.cvgenerator.CvGeneratorApplicationTests;
import com.jayway.jsonpath.JsonPath;

public class DataControllerTest extends CvGeneratorApplicationTests {
   
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

   /* 
    "ausbildung":
	[{  
	         "ausbildung_id":43,
	         "ausbildung_begin":"2016-02-03",
	         "ausbildung_end":"2016-04-22",
	         "ausbildung_ort":"ausbildung ort test",
	         "ausbildung_stelle":"ausbildung test"
	 }]
	 */ 
	@Test
	public void validate_get_user() throws Exception {
		
		mockMvc.perform(get("/data/findAusbildungenByUserName/Brodianskyi"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(jsonPath("$..ausbildung_id").value(43)); 
		
		  
		
	}
	

}
