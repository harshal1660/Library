package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.exception.BookNameNotNull;
import com.library.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo br;

	@Override
	public Book addBook(Book book) {
		if (book.getBookName() == null) {
			throw new RuntimeException("Book name is mandatory");
		} else {
			br.save(book);
			return book;
		}
	}

}
