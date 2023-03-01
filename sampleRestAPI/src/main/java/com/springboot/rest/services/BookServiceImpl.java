package com.springboot.rest.services;

import java.text.MessageFormat;
import java.util.*;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.springboot.rest.common.exception.*;
import com.springboot.rest.mapper.bookMapper;
import com.springboot.rest.models.Book;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private bookMapper bookmapper;

	
	@Override
    public Book create(Book book) {
        Book bookById = getByTitle(book.getTitle());
        if(!ObjectUtils.isEmpty(bookById)){
          throw new DuplicateException(MessageFormat.format("Book {0} already exists in the system", book.getTitle()));
        }
        bookmapper.insert(book);
        return getByTitle(book.getTitle());
    }

    @Override
    public List<Book> getAll(){
        return bookmapper.findAll();
    }

	@Override
	public Book getOne(int isbn) {
		
		Book book = bookmapper.findById(isbn);
        if(ObjectUtils.isEmpty(book)){
           throw new DataNotFoundException(MessageFormat.format("Book id {0} not found", String.valueOf(isbn)));
        }
        return book;
    }

	@Override
	public void deleteById(int isbn) {
		boolean isDeleted = bookmapper.deleteById(isbn);
        if(!isDeleted){
            throw new BadRequestException("Delete error, please check ID and try again");
        }
		
	}

	@Override
	public Book getByTitle(String title) {
		 return bookmapper.findByTitle(title);
	}
	
	
	
//	@Override
//	public List<Book> getBooksByAuthor(String author) {
//		return getBookList().stream().filter((book)->book.getAuthor().equals(author)).collect(Collectors.toList());
//	}
//
//	@Override
//	public List<Book> getBooksBycategory(String category){
//		
//		return getBookList()
//				.stream()
//				.filter((book)->book.getCategory().equals(category))
//				.collect(Collectors.toList());
//	}
	
//	private List<Book> getBookList(){
//		
//		return Arrays.asList(new Book(1001, "java", "kathy", "Tech"),
//				new Book(1010, "spring", "Rod", "Tech"),
//				new Book(1111, "Captain", "Hal", "Comic"),
//				new Book(2001, "Miracle", "Kathy", "Fiction"),
//				new Book(2020, "python", "Russom", "Tech")
//				);
//	}

}
