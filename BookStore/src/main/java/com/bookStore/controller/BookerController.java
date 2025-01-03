package com.bookStore.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;



@Controller
public class BookerController {
	
	@Autowired
	 private MyBookListService myBookService;
	
	
	@Autowired
	 private BookService service;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	
  @GetMapping("/book_register")
  public String bookRegister() {
	  return "bookregister";
  }

 
  
  @GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBooks();
		return new ModelAndView("bookList","book",list);
	}
  
  
  
  
  
  @PostMapping("/save")
  public String addBook (@ModelAttribute Book b) {
	   service.save(b);
	   return "redirect:/available_books";	  
  }
  
  
  
  
  
  @GetMapping("/my_books")
   public String getMyBooks(Model model) {
       List<MyBookList> list = myBookService.getAlBooks();
       model.addAttribute("book", list);
       return "mybook";
     
   }

	  
  
  
  
  
  
/*		@RequestMapping("/mylist/{id}")
		public String getMyList(@PathVariable("id") int id) {
			Book b=service.getBookById(id);
			MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
			myBookService.saveMyBook(mb);
			return "redirect: /mybook";
		}
		
	*/
  
  @RequestMapping("/mylist/{id}")
  public String getMyList(@PathVariable("id") int id) {
      Book b = service.getBookById(id);
      MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
      myBookService.saveMyBook(mb);
      return "redirect:/mybook";
  }
	
		
  @RequestMapping("/editBook/{id}")
		public String editBook(@PathVariable("id") int id,Model model) {
			Book b=service.getBookById(id);
			model.addAttribute("book",b);
			return "bookedit";
		}
		
			
		
		@RequestMapping("/deleteBook/{id}")
		public String deleteBook(@PathVariable("id")int id) {
			service.deleteById(id);
			return "redirect:/available_books";
		} 
		
	}