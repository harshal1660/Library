package com.library.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ErrorResponse {
	private int statusCode;
	
	private String msg;

	public ErrorResponse(int statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
