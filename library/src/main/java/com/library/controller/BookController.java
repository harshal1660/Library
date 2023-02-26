package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.entity.Book;
import com.library.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	@ResponseBody
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
		return bs.addBook(book);
	}
	
	
	/*
	@ExceptionHandler(value=BookNameNotNull.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleBookNameNotNull(BookNameNotNull bn) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(),bn.getMessage());
	}
	*/
	
	
	
}
