package com.app.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.restapi.entites.Book;
import com.app.restapi.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
    //save a new Book into DB	
	@PostMapping("/books")
	@ResponseBody
	public Book addBooks(@RequestBody Book book){
      return service.save(book);
	}
	@GetMapping("/books")
	@ResponseBody
	public Iterable<Book> findAllBooks(){
		return service.getAllBooks();
	}
	
	//get a Book from DB 
	@GetMapping("/books/{id}")
	@ResponseBody
	public Book getBook(@PathVariable("id") int id){
	  return service.getBookById(id);	
    }
	
	//delete a book by id from DB
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public void deleteById(@PathVariable("id") int id){
		service.delete(id);
	}
	
	//delete all Books
	@DeleteMapping("/books")
	@ResponseBody
	public void deleteAllBooks(){
		service.deleteAllBooks();
	}
	
	//update Book
	@PutMapping("/books")
	@ResponseBody
	public Book update(@RequestBody Book book){
		book.setAuthor(book.getAuthor());
		book.setTitle(book.getTitle());
		return service.save(book);
	}
	
	
	
	
	
	
	
	
	
  
//	//get all books 	
//   @GetMapping("/books")
//   @ResponseBody
//	public List<Book> getBooks(){
//	  return this.service.getAllBooks();
//   }
//   //get single book via id 
//   @GetMapping("/books/{id}")
//   @ResponseBody
//   public Book getBook(@PathVariable("id") int id){
//	   return service.getBookById(id);
//   }
//   //add a new book
//   @PostMapping("/books")
//   @ResponseBody  //Return msg   
//   public Book addBooks(@RequestBody Book book) { //@RequestBody fetch data from the browser 
//	                                                                    //and store in book obj
//	 
//	   Book b=  this.service.addBook(book); 
//	   return b;
//   }
//  //delete single book 
//   @DeleteMapping("/books/{id}")
//   @ResponseBody
//   public void deleteBook(@PathVariable("id") int id){
//	  this.service.deleteBook(id);
//   } 
//   //update the book 
//   @PutMapping("/books/{id}")
//   @ResponseBody
//   public Book updateBook(@RequestBody Book book ,@PathVariable("id") int id){
//	  service.updateBook(book, id);  
//      return book;
//   }
}
