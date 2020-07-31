package com.knowarth.api.order.item.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.knowarth.api.order.item.dto.ErrorDetails;
import com.knowarth.api.order.item.exception.InvalidOrderException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<ErrorDetails> handleInvalidOrderException(InvalidOrderException invalidOrderException,
			WebRequest request) {
		ErrorDetails details = new ErrorDetails();
		details.setTimestamp(new Date());
		details.setMessage(invalidOrderException.getMessage());
		details.setDetails(request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

}
