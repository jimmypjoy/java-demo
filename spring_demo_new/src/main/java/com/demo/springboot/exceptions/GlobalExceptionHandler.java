package com.demo.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
		System.out.println("Exception handling: @ExceptionHandler(MethodArgumentNotValidException.class) ");
		ex.printStackTrace();
		return ResponseEntity.badRequest()
				.body("Validation error: " + ex.getBindingResult().getFieldError().getDefaultMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
		System.out.println("Exception handling: @ExceptionHandler(ConstraintViolationException.class)");
		ex.printStackTrace();
		return ResponseEntity.badRequest().body("Validation error: " + ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {
		System.out.println("Exception handling: @ExceptionHandler(Exception.class)");
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + ex.getMessage());
	}
}
