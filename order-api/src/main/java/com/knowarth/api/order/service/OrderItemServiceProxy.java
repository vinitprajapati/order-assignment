package com.knowarth.api.order.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.knowarth.api.order.dto.OrderItem;

@FeignClient(name = "orderitem")
public interface OrderItemServiceProxy {

	@PostMapping("/api/orderitems/{orderId}")
	public List<OrderItem> createOrderItems(@PathVariable Long orderId, 
			@RequestBody List<OrderItem> items);

	@GetMapping("/api/orderitems/{orderId}")
	public List<OrderItem> getOrderItems(@PathVariable Long orderId);

}
