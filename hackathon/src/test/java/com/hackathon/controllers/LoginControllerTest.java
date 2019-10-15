package com.hackathon.controllers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.hackathon.exceptions.AuthException;
import com.hackathon.models.UserRequest;
import com.hackathon.service.LoginService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={LoginController.class})
public class LoginControllerTest {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoginService loginService;

	@Test
	public void testEmptyPassword() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("kiran");
		try {
			Map<String, Object> uriVariables = new HashMap<>();
			ResponseEntity<String> response = restTemplate.postForEntity("localhost:9090/login", userRequest, String.class, uriVariables);
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
			ResponseEntity<String> response = restTemplate.postForEntity("localhost:9090/login", userRequest, String.class, uriVariables);
		} catch(AuthException auth) {
			Assert.assertEquals("Username should not be empty.", auth.getMessage());
		}
	}
}
