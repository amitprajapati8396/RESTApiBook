package com.app.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.restapi.entites.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book getBookById(int id);
    
  
}