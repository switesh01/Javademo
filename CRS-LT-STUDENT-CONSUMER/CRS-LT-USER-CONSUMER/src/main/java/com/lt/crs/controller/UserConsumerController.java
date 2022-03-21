package com.lt.crs.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserConsumerController {

	@PostMapping("/registerStudent")
	public String registerStudent(@RequestBody Map<String, Object> studentDtoMap) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8082/user/registerStudent";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(studentDtoMap), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody();
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestParam("userId") int userId, @RequestParam("newPassword") String newPassword) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8082/user/updatePassword?userId="+userId+"&newPassword="+newPassword;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.PUT, getHeaders(), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	@GetMapping("/verifyCreds")
	public String verifyCreds(@RequestParam("userId") int userId,@RequestParam("password") String password) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8082/user/verifyCreds?userId="+userId+"&password="+password;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody();
	}
	
	@GetMapping("/checkRole")
	public String checkRole(@RequestParam("userId") int userId) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8082/user/checkRole?userId="+userId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	private static HttpEntity<?> getHeaders(Map<String,Object> requestBody) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(requestBody, headers);
	}
}
