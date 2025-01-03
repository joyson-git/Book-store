package com.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.entity.Book;
import com.bookStore.repositary.Bookrepositary;

@Service
public class BookService {
	
 
 
 @Autowired
 private Bookrepositary bRep;

 public void save(Book b) {
     bRep.save(b);
 }
	
 public List<Book> getAllBooks() {
     return bRep.findAll();
 }
 
 public Book getBookById(int id) {
	 return bRep.findById((long) id).get();
 }
 
 public void deleteById(int id) {
	bRep.deleteById( (long) id); 
 }
 
 
 
 
}