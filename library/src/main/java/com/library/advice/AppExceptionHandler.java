package com.library.advice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.dao.DataIntegrityViolationException;
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
			// getDefaultMessage()
		});
		return errorMap;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		Map<String, String> errorMap = new LinkedHashMap<>();
		errorMap.put("ErrorCode", "404");
		String str=e.getRootCause().getMessage();
		String pat= "'([^']*)'";
		Pattern pattern =Pattern.compile(pat);
		Matcher matcher=pattern.matcher(str);
		while(matcher.find())
		{
			str=matcher.group();
			break;
		}
		
		errorMap.put("msg", "Book Name "+str+" already exist");
		//errorMap.put("msg",e.getMostSpecificCause().getLocalizedMessage());
			return errorMap;
	}

}
