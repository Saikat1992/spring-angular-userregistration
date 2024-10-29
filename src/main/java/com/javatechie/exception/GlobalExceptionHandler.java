package com.javatechie.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		
		ApiError apiError= new ApiError(809, ex.getMessage(), new Date());
		
		return new ResponseEntity<> (apiError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiError> handleNoSuchElementException(Exception ex, WebRequest request){
		
		ApiError apiError= new ApiError(809, ex.getMessage(), new Date());
		
		return new ResponseEntity<> (apiError,HttpStatus.BAD_REQUEST);
	}
	
	
	
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<Object>
	 * handleglobalException(UserNotFoundException exception, WebRequest request){
	 * 
	 * Map<String, Object> body= new HashMap<String, Object>();
	 * body.put("timestamp", LocalDateTime.now()); body.put("message",
	 * "An error occured");
	 * 
	 * return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @ExceptionHandler(Exception.class) public ResponseEntity<String>
	 * handleNoSuchElementException(NoSuchElementException exception){
	 * 
	 * 
	 * return new ResponseEntity<String>("No such value present in DB",
	 * HttpStatus.NOT_FOUND); }
	 */
	  
	 
}
