package com.knowarth.api.order.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

	private Long id;

	@NotNull
	@Size(min = 2, message = "Customer Name cannot be empty")
	private String customerName;

	@NotNull(message = "Order date cannot be empty")
	private Date orderDate;

	@NotNull
	@Size(min = 2, message = "Shipping address cannot be empty")
	private String shippingAddress;

	private List<OrderItem> items;

	@NotNull(message = "Total cannot be empty")
	private BigDecimal total;

}
