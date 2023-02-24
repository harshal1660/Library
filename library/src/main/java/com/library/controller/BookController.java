package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.entity.Book;
import com.library.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
		return bs.addBook(book);
	}
	
	
	
	
}
