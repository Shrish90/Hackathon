package com.hackathon.controllers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoanControllerTest.class)
@WebAppConfiguration
public class LoanControllerTest {
	 protected MockMvc mvc;
	  @Autowired
	   WebApplicationContext webApplicationContext;
	 protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	 
	 protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	   
	@Test
	public void Loans() throws Exception {
		String uri = "/api/loans";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content("{\r\n" + 
			      		"	\"loanDetails\":{\r\n" + 
			      		"		\"amount\":\"100000\",\r\n" + 
			      		"		\"term\":7,\r\n" + 
			      		"		\"usage\":\"current assets\"\r\n" + 
			      		"	},\r\n" + 
			      		"	\"corporateDetails\":{\r\n" + 
			      		"		 \"name\":\"ABC\",\r\n" + 
			      		"		 \"corporateAddress\":\"XYZ Street\",\r\n" + 
			      		"		 \"revenue\":1475608.00,\r\n" + 
			      		"		 \"regNo\":\"545554\",\r\n" + 
			      		"		 \"companyAge\":\"50\"\r\n" + 
			      		"	},\r\n" + 
			      		"	\"userDetails\":{\r\n" + 
			      		"		\"firstName\":\"Shrish\",\r\n" + 
			      		"		\"lastName\":\"Tiwari\",\r\n" + 
			      		"		\"address\":\"ABC\",\r\n" + 
			      		"		\"citizenship\":\"INDIAN\",\r\n" + 
			      		"		\"dateOfBirth\":\"1990-07-22T00:00:00\",\r\n" + 
			      		"		\"phoneNumber\":\"8884423450\",\r\n" + 
			      		"		\"emailId\":\"shrish.tiwari90@gmail.com\",\r\n" + 
			      		"		\"passport\":\"M7691801DB\"\r\n" + 
			      		"	}\r\n" + 
			      		"	\r\n" + 
			      		"}")).andReturn();
		
		 int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
	}
		
}
