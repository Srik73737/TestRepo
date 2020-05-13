package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.srik.exception.UserNotFoundException;
import com.srik.model.ResponseDetails;

@ControllerAdvice
@RestController
public class CustomEceptionHandler extends ResponseEntityExceptionHandler {

	

	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ResponseDetails<Object> r = new ResponseDetails<Object>(HttpStatus.NOT_FOUND, ex.getMessage(), null, null);
		return new ResponseEntity(r, HttpStatus.NOT_FOUND);
	}
}
