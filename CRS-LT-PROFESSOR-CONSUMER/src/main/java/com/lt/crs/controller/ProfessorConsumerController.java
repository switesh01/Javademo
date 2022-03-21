package com.lt.crs.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorConsumerController {

	@GetMapping("/getEnrolledStudents")
	public String viewEnrolledStudents(@RequestParam("professorId") int profId) throws RestClientException, IOException {
		System.out.println("viewEnrolledStudents");
		String baseUrl = "http://localhost:8083/professor/getEnrolledStudents?professorId="+profId;
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
	
	@GetMapping("/getCourses")
	public String getCourses(@RequestParam("professorId") int profId) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8083/professor/getCourses?professorId="+profId;
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
	
	@PutMapping("/addGrade")
	public ResponseEntity<String> addGrade(@RequestParam("professorId") int profId, @RequestParam("studentId") int studentId, @RequestParam("courseCode") String courseCode, @RequestParam("grade") String grade) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8083/professor/addGrade?professorId="+profId+"&studentId="+studentId+"&courseCode="+courseCode+"&grade="+grade;
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

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
