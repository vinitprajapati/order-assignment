package com.knowarth.api.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.knowarth.api.order.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
