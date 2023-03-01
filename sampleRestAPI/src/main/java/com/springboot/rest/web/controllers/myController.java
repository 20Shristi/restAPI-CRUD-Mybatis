package com.springboot.rest.web.controllers;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.common.exception.*;
import com.springboot.rest.models.Book;
import com.springboot.rest.services.BookService;
import com.springboot.rest.web.response.SuccessResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class myController {
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/home")
//	public String home() {
//		return "home page";
//	}

//	@GetMapping("/book-by-id/{id}")
//	public Book getBookById(@PathVariable("id") int sbnNO) {
//		return bookService.getById(sbnNO);
//	}
//	
//	@GetMapping("/books-by-author/{author}")
//	public List<Book> getBookByAuthor(@PathVariable String author) {
//		return bookService.getBooksByAuthor(author);
//	}
//	
////http://localhost:8080/books-by-category/?category=fiction
//	@GetMapping("/books-by-category")
//	public List<Book> getBookByCategory(@RequestParam("category") String category) { //to extract the query parameter from url
//		return bookService.getBooksBycategory(category);
//	}
//	
	
	@PostMapping()
    public ResponseEntity<SuccessResponse> create(@RequestBody @Valid Book book) {
        if (!ObjectUtils.isEmpty(book.getIsbn())) {
            throw new BadRequestException("A new data cannot already have an isbn");
        }

        return new ResponseEntity<>(
                new SuccessResponse(bookService.create(book), "Successful registration"),
                HttpStatus.CREATED);
    }

   @GetMapping("/getAll")
   public ResponseEntity<SuccessResponse> getAll() {
       List<Book> books = bookService.getAll();

       return new ResponseEntity<>(new SuccessResponse(books, MessageFormat.format("{0} Results found", books.size())), HttpStatus.OK);
   }

   @GetMapping("/{isbn}")
   public ResponseEntity<SuccessResponse> getOne(@PathVariable("isbn") int isbn) {
       Book book = bookService.getOne(isbn);
       return new ResponseEntity<>(
               new SuccessResponse(book, "Result found"), HttpStatus.OK);
   }

   @DeleteMapping("/{isbn}")
   public ResponseEntity<SuccessResponse> delete(@PathVariable("isbn") int isbn) {
       bookService.deleteById(isbn);
       return new ResponseEntity<>(
               new SuccessResponse(null, "Deletion completed successfully"), HttpStatus.OK);
   }

}

