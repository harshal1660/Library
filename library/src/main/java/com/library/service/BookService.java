package com.library.service;

import com.library.entity.Book;

public interface BookService {
	public Book addBook(Book book);
	public Book deleteBook(long bookId);  //deletebook
}
