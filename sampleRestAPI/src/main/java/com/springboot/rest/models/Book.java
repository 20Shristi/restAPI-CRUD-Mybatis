package com.springboot.rest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Book {
	
	
	 private int isbn;
	 @NotBlank
	 @Size(max = 100)
     private String title;
     private String author;
     private String category;
     
     
	public Book() {
		super();
	}


	public Book(int isbn, String title, String author, String category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.category = category;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbnNo(int isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", category=" + category + "]";
	}
	
     
     
     
}
