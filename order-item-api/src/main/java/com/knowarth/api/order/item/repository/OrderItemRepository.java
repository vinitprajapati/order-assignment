package com.knowarth.api.order.item.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.knowarth.api.order.item.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

	public List<OrderItem> findByOrderId(Long orderId);

}
