package com.springboot.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.springboot.rest.models.Book;

@Mapper
@Repository
public interface bookMapper {
	
	@Select("select * from book")
    List<Book> findAll();

    @Select("select * from book WHERE isbn = #{isbn}")
    Book findById(long isbn);

    
    @Insert("INSERT INTO book( isbn, title, author, category) " +
            " VALUES (#{isbnNo}, #{title}, #{author}, #{category})")
    void insert(Book book);
    
    @Select("SELECT * FROM book WHERE title = #{title}")
    Book findByTitle(String title);

    @Delete("DELETE FROM book WHERE isbn = #{isbn}")
    boolean deleteById(long isbn);
}
