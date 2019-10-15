package com.hackathon.controllers;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.hackathon.models.UserRequest;

@SpringBootTest
public class LoginControllerTest {
	
	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testEmptyUsername() {
//		UserRequest userRequest = new UserRequest();
//		userRequest.
//		restTemplate.postForEntity("localhost:9090/login", request, responseType)
	}
}
