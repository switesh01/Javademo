package com.lt.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.model.Order;


@RestController
public class OrderController {

	@GetMapping("/hello-world")
	public String helloWorld() {

		return "Hello World";
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/details")
	@ResponseBody
	public Order details() {

		Order order = new Order();
		order.setOrderId(101);
		order.setOrderName("Admin");
		order.setDescription("Order demo");
		return order;
	}
}
