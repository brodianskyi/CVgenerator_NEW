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

public class ProjekteJsonTest extends CvGeneratorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	/*
	 * "projekte":[ { "projekte_id":1, "projekte_begin":"2016-05-01",
	 * "projekte_kunde":"projekte_kunde_test", "projekte_end":"2016-05-20",
	 * "projekte_thematik":"projekte_thematik_test",
	 * "projekte_rolle":"projekte_rolle_test",
	 * "projekte_technologie":"projekte_technologie_test" } ]
	 */

	@Test
	public void findAllProjekteByUserNameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllProjekteByUserName/Brodianskyi"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..projekte_id").value(1));
		resultActions.andExpect(jsonPath("$..projekte_begin").value("2016-05-01"));
		resultActions.andExpect(jsonPath("$..projekte_kunde").value("projekte_kunde_test"));
		resultActions.andExpect(jsonPath("$..projekte_end").value("2016-05-20"));
		resultActions.andExpect(jsonPath("$..projekte_thematik").value("projekte_thematik_test"));
		resultActions.andExpect(jsonPath("$..projekte_technologie").value("projekte_technologie_test"));

	}

	@Test
	public void findAllProjekteByUserVornameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAllProjekteByUserVorname/Pavel"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..projekte_id").value(1));
		resultActions.andExpect(jsonPath("$..projekte_begin").value("2016-05-01"));
		resultActions.andExpect(jsonPath("$..projekte_kunde").value("projekte_kunde_test"));
		resultActions.andExpect(jsonPath("$..projekte_end").value("2016-05-20"));
		resultActions.andExpect(jsonPath("$..projekte_thematik").value("projekte_thematik_test"));
		resultActions.andExpect(jsonPath("$..projekte_technologie").value("projekte_technologie_test"));

	}

}
