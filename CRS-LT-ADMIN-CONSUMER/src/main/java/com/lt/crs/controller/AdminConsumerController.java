package com.lt.crs.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.lt.crs.component.DiscoveryClass;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminConsumerController {

	@Autowired
	private DiscoveryClass discoveryClass;
	
	@GetMapping("/getPendingAdmissions")
	public String getCustomer() throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/viewPendingAdmissions";
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
	
//	@GetMapping("/viewCoursesInCatalog")
//	public String viewCoursesInCatalog(@RequestParam("catalogId") int catalogId) throws RestClientException, IOException {
//		String baseUrl = "http://localhost:8081/admin/viewCoursesInCatalog?catalogId="+catalogId;
//		return discoveryClass.discoveryResult("admin-producer", baseUrl, HttpMethod.GET).getBody();
//	}
	
	@GetMapping("/viewCoursesInCatalog")
	public String viewCoursesInCatalog(@RequestParam("catalogId") int catalogId) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/viewCoursesInCatalog?catalogId="+catalogId;
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
	
	@PostMapping("/registerProfessor")
	public String addProfessor(@RequestBody Map<String, Object> professorDtoMap) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/registerProfessor";
		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(mapObj, headers);
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(professorDtoMap), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Map<String, Object> courseMap) throws RestClientException, IOException {
		System.out.println(courseMap.entrySet());
		String baseUrl = "http://localhost:8081/admin/addCourse";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(courseMap), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	
	@PutMapping("/assignCourseToProfessor")
	public String assignCourseToProfessor(@RequestParam("professorId") int professorId, @RequestParam("courseCode") String courseCode) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/assignCourseToProfessor?professorId="+professorId+"&courseCode="+courseCode;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.PUT, getHeaders(), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	
	@PutMapping("/approveStudent")
	public String approveStudent(@RequestParam("studentId") int studentId) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/approveStudent?studentId="+studentId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.PUT, getHeaders(), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	
	@DeleteMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseCode") String courseCode) throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/deleteCourse?courseCode="+courseCode;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
		}catch (Exception ex)
		{
			response.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	
	@GetMapping("/viewAllProfessors")
	public String viewAllProfessors() throws RestClientException, IOException {
		String baseUrl = "http://localhost:8081/admin/viewAllProfessors";
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
