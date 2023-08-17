package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
	
	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<?> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistException e){
		return new ResponseEntity<>("User already exists",HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException e){
		return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	}
}
