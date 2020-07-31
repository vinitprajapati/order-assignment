package com.knowarth.api.order.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowarth.api.order.item.exception.InvalidOrderException;
import com.knowarth.api.order.item.model.OrderItem;
import com.knowarth.api.order.item.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repo;

	public List<OrderItem> createOrderItem(Long orderId, List<OrderItem> items) {
		items.forEach(item -> {
			item.setOrderId(orderId);
			repo.save(item);
		});
		return items;
	}

	public List<OrderItem> getOrderItems(Long orderId) {
		List<OrderItem> items = repo.findByOrderId(orderId);

		if (items.size() == 0) {
			throw new InvalidOrderException("Invalid order id, please provide valid order id");
		}

		return items;
	}

}
