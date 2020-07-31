package com.knowarth.api.order.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem {

	@NotNull( message = "Product code is missing, please provide product code")
	@Size(min=2, message = "Product code must contain atleast 2 characters")
	private String productCode;

	@NotNull( message = "Product Name is missing, please provide product code")
	@Size(min=4, message = "Product Name must contain atleast 4 characters")
	private String productName;

	@Min(value = 1, message = "Quantity must be greater than 0.")
	private int quantity;

}
