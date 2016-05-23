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

public class AusbildungJsonTest extends CvGeneratorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*
	 * "ausbildung":[ { "ausbildung_id":1, "ausbildung_begin":"2015-01-15",
	 * "ausbildung_end":"2016-01-28", "ausbildung_ort":"ausbildung_ort_test",
	 * "ausbildung_stelle":"ausbildung_studiumsstelle_test" } ]
	 */
	@Test
	public void ausbildungenByUserNameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAusbildungenByUserName/Brodianskyi"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..ausbildung_id").value(1));
		resultActions.andExpect(jsonPath("$..ausbildung_begin").value("2015-01-15"));
		resultActions.andExpect(jsonPath("$..ausbildung_end").value("2016-01-28"));
		resultActions.andExpect(jsonPath("$..ausbildung_ort").value("ausbildung_ort_test"));
		resultActions.andExpect(jsonPath("$..ausbildung_stelle").value("ausbildung_studiumsstelle_test"));

	}

	@Test
	public void findAusbildungenByUserVornameTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findAusbildungenByUserVorname/Pavel"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		resultActions.andExpect(jsonPath("$..ausbildung_id").value(1));
		resultActions.andExpect(jsonPath("$..ausbildung_begin").value("2015-01-15"));
		resultActions.andExpect(jsonPath("$..ausbildung_end").value("2016-01-28"));
		resultActions.andExpect(jsonPath("$..ausbildung_ort").value("ausbildung_ort_test"));
		resultActions.andExpect(jsonPath("$..ausbildung_stelle").value("ausbildung_studiumsstelle_test"));

	}

}
