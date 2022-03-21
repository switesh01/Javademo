package com.lt.crs.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DiscoveryClass {

	/**
	 * 
	 * This is used to autowire discoveryClient
	 * 
	 */

	@Autowired
	DiscoveryClient discoveryClient;

	public ResponseEntity<String> discoveryResult(String clientName, String producerUrl, HttpMethod http,
			Map<String, Object> requestBody) {

		List<ServiceInstance> instances = discoveryClient.getInstances(clientName);

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + producerUrl;

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = null;

		try {

			response = restTemplate.exchange(baseUrl, http, getHeaders(requestBody), String.class);

		} catch (Exception ex) {

		}

		return response;

	}

	private static HttpEntity<?> getHeaders(Map<String, Object> requestBody) throws IOException {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		return new HttpEntity<>(requestBody, headers);

	}

	public ResponseEntity<String> discoveryResult(String clientName, String producerUrl, HttpMethod http) {

		List<ServiceInstance> instances = discoveryClient.getInstances(clientName);

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + producerUrl;

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = null;

		try {

			response = restTemplate.exchange(baseUrl, http, getHeaders(), String.class);

		} catch (Exception ex) {

			// TODO

		}

		return response;

	}

	private static HttpEntity<?> getHeaders() throws IOException {

		HttpHeaders headers = new HttpHeaders();

		return new HttpEntity<>(headers);

	}
}
