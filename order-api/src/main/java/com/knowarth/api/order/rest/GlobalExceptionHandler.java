package com.knowarth.api.order.rest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.knowarth.api.order.dto.ErrorDetails;
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

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails details = new ErrorDetails();
		details.setTimestamp(new Date());
		details.setMessage("Invalid order, please provide order item with all details.");

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(validation -> validation.getDefaultMessage()).collect(Collectors.toList());
		details.setDetails(errors.toString());

		return new ResponseEntity<>(details, status);

	}

}
