package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.Book;
import com.library.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	//@ResponseBody					//----- removed -----
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody @Validated Book book)
	{
		//return bs.addBook(book);
		return new ResponseEntity<>(bs.addBook(book),HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteBook")
	public ResponseEntity<Book> deleteBook(@RequestParam long bookId)
	{
		return new ResponseEntity<>(bs.deleteBook(bookId),HttpStatus.OK);
	}
	
	
	
	/*
	@ExceptionHandler(value=BookNameNotNull.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleBookNameNotNull(BookNameNotNull bn) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(),bn.getMessage());
	}
	*/
	
	
	
}
