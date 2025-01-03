package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.repositary.Mybookrepositary;

@Service
public class MyBookListService {
   @Autowired
	private Mybookrepositary  my_book;
	
    public void saveMyBook(MyBookList book) {
    	my_book.save(book);
    }
	
   public List<MyBookList> getAlBooks(){
	  return my_book.findAll();
   }
    
    public void deleteById(int id){
    	my_book.deleteById(id);
    }
    
    
    
	
}
