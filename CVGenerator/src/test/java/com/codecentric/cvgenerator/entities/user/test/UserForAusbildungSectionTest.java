package com.codecentric.cvgenerator.entities.user.test;

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

public class UserForAusbildungSectionTest extends CvGeneratorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	/*
	 * "user_id":1, "name":"Brodianskyi", "vorname":"Pavel",
	 * "geburtsdatum":"1992-05-06", "wohnort":"Karlsruhe",
	 * "nationalitaet":"Ukrainisch",
	 * "sprachen":"Russisch,Deutsch,Englisch,Ukrainisch",
	 * "telefon":"034102393132", "email":"brodianskyi@gmail.com",
	 * 
	 */

	@Test
	public void findUserByAusbildungOrtTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/data/findUserByAusbildungOrt/ausbildung_ort_test"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		
		resultActions.andExpect(jsonPath("$.name").value("Brodianskyi"));
		resultActions.andExpect(jsonPath("$.vorname").value("Pavel"));
		resultActions.andExpect(jsonPath("$.nationalitaet").value("Ukrainisch"));
		resultActions.andExpect(jsonPath("$.sprachen").value("Russisch,Deutsch,Englisch,Ukrainisch"));
		resultActions.andExpect(jsonPath("$.email").value("brodianskyi@gmail.com"));

	}

	@Test
	public void findUserByAusbildungStelleTest() throws Exception {

		ResultActions resultActions = mockMvc
				.perform(get("/data/findUserByAusbildungStelle/ausbildung_studiumsstelle_test"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")));

		
		resultActions.andExpect(jsonPath("$.name").value("Brodianskyi"));
		resultActions.andExpect(jsonPath("$.vorname").value("Pavel"));
		resultActions.andExpect(jsonPath("$.nationalitaet").value("Ukrainisch"));
		resultActions.andExpect(jsonPath("$.sprachen").value("Russisch,Deutsch,Englisch,Ukrainisch"));
		resultActions.andExpect(jsonPath("$.email").value("brodianskyi@gmail.com"));

	}


}
