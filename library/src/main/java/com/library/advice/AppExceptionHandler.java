package com.library.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new LinkedHashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put("ErrorCode", "404");
			errorMap.put(error.getField(), error.getDefaultMessage());			
			//getDefaultMessage()
		});
		return errorMap;
	}
	
    
}
