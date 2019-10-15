package com.hackathon.controllers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.hackathon.application.HackathonApplication;
import com.hackathon.exceptions.AuthException;
import com.hackathon.models.UserRequest;
import com.hackathon.service.LoginService;
import com.hackathon.serviceimpl.LoginServiceImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes={LoginControllerTest.class})
@ContextConfiguration(classes = {HackathonApplication.class})
public class LoginControllerTest {
	
//	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@LocalServerPort
    String randomServerPort;
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	@Autowired
	LoginService loginService;
	
	String baseUrl = "http://localhost:" + randomServerPort + "/login";

	@Test
	public void testEmptyPassword() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("kiran");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, userRequest, String.class, uriVariables);
		} catch(AuthException auth) {
			Assert.assertEquals("Password should not be empty.", auth.getMessage());
		}
	}
	
	@Test
	public void testEmptyUsername() {
		UserRequest userRequest = new UserRequest();
		userRequest.setPassword("kiran");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, userRequest, String.class, uriVariables);
		} catch(AuthException auth) {
			Assert.assertEquals("Username should not be empty.", auth.getMessage());
		}
	}
	
	@Test
	public void testInvalidPassword() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("kiran");
		userRequest.setPassword("kiran123");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, userRequest, String.class, uriVariables);
		} catch(AuthException auth) {
			Assert.assertEquals("Username should not be empty.", auth.getMessage());
		}
	}
	
	@Test
	public void testInvalidUserName() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("kiran123");
		userRequest.setPassword("avk");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, userRequest, String.class, uriVariables);
		} catch(AuthException auth) {
			Assert.assertEquals("Username should not be empty.", auth.getMessage());
		}
	}
	
	@Test
	public void testValidUserAndPassword() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("kiran");
		userRequest.setPassword("avk");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, userRequest, String.class, uriVariables);
			Assert.assertEquals("success", response);
		} catch(AuthException auth) {
			Assert.assertEquals("Username should not be empty.", auth.getMessage());
		}
	}
}
