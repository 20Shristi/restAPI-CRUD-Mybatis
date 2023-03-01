package com.springboot.rest;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.rest.models.Book;

//@MappedTypes(Book.class)
//@MapperScan("com.springboot.rest.mapper")
@SpringBootApplication
public class SampleRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRestApiApplication.class, args);
	}

}
