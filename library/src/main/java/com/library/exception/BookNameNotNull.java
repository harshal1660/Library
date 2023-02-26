package com.library.exception;

public class BookNameNotNull extends RuntimeException{
	private String msg;

	public BookNameNotNull(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BookNameNotNull() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
