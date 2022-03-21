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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentConsumerController {

	@PostMapping("/registerCourseToStudent")
	public String registerCourseToStudent(@RequestBody Map<String, Object> registeredCourseMap)
			throws RestClientException, IOException {
		String baseUrl = "http://localhost:8084/student/registerCourseToStudent";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(registeredCourseMap), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}

	@GetMapping("/viewRegisteredCourses")
	public String viewRegisteredCourses(@RequestParam("studentId") int studentId)
			throws RestClientException, IOException {
		String baseUrl = "http://localhost:8084/student/viewRegisteredCourses?studentId=" + studentId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}

	@GetMapping("/viewGradeCard")
	public String viewGradeCard(@RequestParam("studentId") int studentId) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8084/student/viewGradeCard?studentId=" + studentId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

	private static HttpEntity<?> getHeaders(Map<String, Object> requestBody) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(requestBody, headers);
	}
}
