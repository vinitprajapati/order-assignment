package com.knowarth.api.order.item.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowarth.api.order.item.model.OrderItem;
import com.knowarth.api.order.item.service.OrderItemService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class OrderItemController {

	@Autowired
	private OrderItemService service;

	@PostMapping("/orderitems/{orderId}")
	@ApiOperation(value = "Add multiple order items")
	public ResponseEntity<List<OrderItem>> createOrderItem(@PathVariable Long orderId,
			@RequestBody List<OrderItem> items) {
		service.createOrderItem(orderId, items);
		return new ResponseEntity<List<OrderItem>>(items, HttpStatus.CREATED);
	}

	@GetMapping("/orderitems/{orderId}")
	@ApiOperation(value = "Fetch all order items for provided order id")
	public ResponseEntity<List<OrderItem>> getOrderItem(@PathVariable Long orderId) {
		return new ResponseEntity<List<OrderItem>>(service.getOrderItems(orderId), HttpStatus.OK);
	}

}
