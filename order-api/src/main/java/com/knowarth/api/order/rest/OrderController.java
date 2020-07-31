package com.knowarth.api.order.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowarth.api.order.dto.OrderDTO;
import com.knowarth.api.order.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("/orders")
	@ApiOperation(value = "Create new order")
	public Long createOrder(@RequestBody @Valid OrderDTO orderDTO) {
		return service.createOrder(orderDTO);
	}

	@GetMapping("/orders/{orderId}")
	private OrderDTO getOrder(@PathVariable Long orderId) {
		return service.getOrder(orderId);
	}
}
