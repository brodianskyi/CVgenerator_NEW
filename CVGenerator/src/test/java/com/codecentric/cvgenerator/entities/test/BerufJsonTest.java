package com.codecentric.cvgenerator.entities.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.codecentric.cvgenerator.CvGeneratorApplicationTests;

public class BerufJsonTest extends CvGeneratorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	/*
	 * "beruf":[ { "beruf_id":1, "beruf_begin":"2016-02-01",
	 * "beruf_end":"2016-03-25", "beruf_position":"beruf_position_test",
	 * "beruf_stelle":"arbeitsstelle_test" } ],
	 */

	@Test
	public void findAllBerufByUserNameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllBerufByUserName/Brodianskyi"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

	
		resultActions.andExpect(jsonPath("$..beruf_position").value("beruf_position_test"));
		resultActions.andExpect(jsonPath("$..beruf_stelle").value("arbeitsstelle_test"));

	}

	@Test
	public void findAllBerufByUserVornameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllBerufByUserVorname/Pavel"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		
		resultActions.andExpect(jsonPath("$..beruf_position").value("beruf_position_test"));
		resultActions.andExpect(jsonPath("$..beruf_stelle").value("arbeitsstelle_test"));

	}

}
