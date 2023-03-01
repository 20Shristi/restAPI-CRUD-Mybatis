package com.springboot.rest.services;

import java.util.List;

import com.springboot.rest.models.Book;

public interface BookService {

	Book create(Book book);
	
	List<Book> getAll();
	
	Book getOne(int isbn);
	
	void deleteById(int isbn);

    Book getByTitle(String title);
	
//	List<Book> getBooksByAuthor(String author);
//	List<Book> getBooksBycategory(String category);
}
