package com.knowarth.api.order.item.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {

	private String message;
	private String details;
	private Date timestamp;

}
