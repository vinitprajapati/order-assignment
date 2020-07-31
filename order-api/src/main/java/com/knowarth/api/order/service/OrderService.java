package com.knowarth.api.order.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowarth.api.order.dto.OrderDTO;
import com.knowarth.api.order.item.exception.InvalidOrderException;
import com.knowarth.api.order.model.Order;
import com.knowarth.api.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderItemServiceProxy orderItemProxy;

	@Autowired
	private OrderRepository repo;

	public OrderDTO getOrder(Long orderId) {
		Optional<Order> order = repo.findById(orderId);

		if (!order.isPresent()) {
			throw new InvalidOrderException("Invalid order id, please provide valid order id");
		}

		OrderDTO orderDTO = getOrderDTO(order.get());
		orderDTO.setItems(orderItemProxy.getOrderItems(order.get().getId()));

		return orderDTO;
	}

	@Transactional
	public Long createOrder(OrderDTO orderDTO) {
		Order order = getOrder(orderDTO);
		repo.save(order);

		orderItemProxy.createOrderItems(order.getId(), orderDTO.getItems());
		return order.getId();
	}

	private Order getOrder(OrderDTO orderDTO) {
		Order order = new Order();

		order.setCustomerName(orderDTO.getCustomerName());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setShippingAddress(orderDTO.getShippingAddress());
		order.setTotal(orderDTO.getTotal());

		return order;
	}

	private OrderDTO getOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();

		orderDTO.setId(order.getId());
		orderDTO.setCustomerName(order.getCustomerName());
		orderDTO.setShippingAddress(order.getShippingAddress());
		orderDTO.setOrderDate(order.getOrderDate());
		orderDTO.setTotal(order.getTotal());

		return orderDTO;
	}

}
