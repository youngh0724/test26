package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookService;

@Controller
public class BookController{
   @Autowired
   private BookService bookService;
   
 
 	@RequestMapping(value="/book/bookList", method = RequestMethod.GET)
 	public String bookList(Model model) {
 		List<Book> list = bookService.selectBookListService();
 		model.addAttribute("list", list);
 		return "book/bookList";
 	}
 	
 	
 	@RequestMapping(value="/book/bookInsert", method = RequestMethod.GET)
     public String bookNameAdd() {
         return "book/bookInsertForm";
     }
 	
 	
 	@RequestMapping(value="/book/bookInsert", method = RequestMethod.POST)
     public String bookNameAdd(Book book) {
 		bookService.bookNameAddService(book);
         return "redirect:/book/bookList";
     }
 	
 	
 	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
 	public String bookNameUpdate( Model model, @RequestParam(value="bookId", required=true) int bookId) {
 		Book book = bookService.bookNameUpdateService(bookId);
 		
 		model.addAttribute("book", book);
 		
 		return "book/bookUpdateForm";
 	}
 	
 
 	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.POST)
     public String bookNameUpdate(Book book) {		
 		
 		bookService.bookNameUpdateService(book);
        
         return "redirect:/book/bookList";
     }
 	
 	
 	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
 	public String bookNameDelete(@RequestParam(value="bookId", required=true) int bookId) {
 		
 		bookService.bookNameDeleteService(bookId);
 		
 		return "redirect:/book/bookList";
 	}
 }