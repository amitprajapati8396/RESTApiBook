package com.app.restapi.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
   private int author_id;
   private String first_name;
   private String last_name;
   private String country;
   
   //it is used in the corresponding child class. It is placed on the back-reference property
   @JsonBackReference 
   @OneToOne(mappedBy ="author")
   private Book book;

	public int getAuthor_id() {
		return author_id;
	}
	
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", first_name=" + first_name + ", last_name=" + last_name + ", country="
				+ country + ", book=" + book + "]";
	}
	
	     
}
