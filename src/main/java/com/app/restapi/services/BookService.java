package com.app.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.restapi.dao.BookRepository;
import com.app.restapi.entites.Book;

@Component
public class BookService {
	@Autowired  
	BookRepository bookRepository;
	// add new Book into DB
	public Book save(Book book){
		return bookRepository.save(book);
	}
	//get all Books from DB
	public Iterable<Book> getAllBooks(){
		return bookRepository.findAll();
	} 
	
	//fetch a Book from DB
    public Book getBookById(int id){
    	return bookRepository.getBookById(id);
    }
   //delete a Book from DB 
	public void delete(int id){
		 bookRepository.deleteById(id);
	} 
	//delete all Books 
	public void deleteAllBooks(){
		bookRepository.deleteAll();
	}
	
   //update Book
	public Book update(Book book){
		return bookRepository.save(book);
	}
	
	
	
	
	
	
	
	
	
	
   // without JAP	
//   private static List<Book> list=new ArrayList<>();
//   static{
//	  list.add(new Book(1010,"The Java Brain","xyz")); 
//	  list.add(new Book(2020,"The Human","abc"));
//	  list.add(new Book(3030,"The people","pqr"));
//   }
//   //get all books from the collection
//   public List<Book> getAllBooks(){
//	  return list; 
//   }
//   //get single book from the book
//   public Book getBookById(int id){
//	 Book book=null;
//	 //java 8 feature stream API
//	  book=list.stream().filter(b->b.getId()==id).findFirst().get();
//
//	  return book;
//   }
//   //add new book into collection
//   public Book addBook(Book book){
//	       list.add(book);
//	   return book; 
//   }
//   //delete a book from the collection
//   public void deleteBook(int id){
//	list= list.stream().filter(b->b.getId()!=id).collect(Collectors.toList());   
//   }
//  //update the book
//   public void updateBook(Book book,int id){
//	   
//	  list=list.stream().map(b->{
//		      if(b.getId()==id){
//		    	 b.setTitle(book.getTitle());
//		    	 b.setAuthor(book.getAuthor()); 
//		       }
//		      return b;
//	        }).collect(Collectors.toList()); 
//   } 
}
