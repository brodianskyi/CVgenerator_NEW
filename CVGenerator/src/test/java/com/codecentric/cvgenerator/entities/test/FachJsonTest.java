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

public class FachJsonTest extends CvGeneratorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*
	 * "fach":[ { "fach_id":1, "fach_gebiet":"fach_gebiet_test",
	 * "fach_kenntnisse":"fach_kenntnisse_test" } ]
	 */
	@Test
	public void findAllFachByUserNameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllFachByUserName/Brodianskyi"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..fach_id").value(1));
		resultActions.andExpect(jsonPath("$..fach_gebiet").value("fach_gebiet_test"));
		resultActions.andExpect(jsonPath("$..fach_kenntnisse").value("fach_kenntnisse_test"));

	}

	@Test
	public void findAllFachByUserVornameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllFachByUserVorname/Pavel"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..fach_id").value(1));
		resultActions.andExpect(jsonPath("$..fach_gebiet").value("fach_gebiet_test"));
		resultActions.andExpect(jsonPath("$..fach_kenntnisse").value("fach_kenntnisse_test"));

	}

}
