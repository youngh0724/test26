package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   
 //입력값과 리턴값을 확인하기위해 로거기능 사용
 	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
   
 
 	@RequestMapping(value="/book/bookList", method = RequestMethod.GET)
 	public String bookSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
 		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
 		
 		logger.debug("bookSelectPage() map.startRow = {}", currentPage);
		logger.debug("bookSelectPage() map.rowPerPage = {}", rowPerPage);
		logger.debug("bookSelectPage() map.searchWord = {}", searchWord);
		Map<String, Object> map = bookService.bookSelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("bookSelectList() map = {}", map);
		
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "book/bookList";
	}
 	
 	
 	
 	@RequestMapping(value="/book/bookInsert", method = RequestMethod.GET)
     public String bookInsert() {
 		logger.debug("bookInsert() 실행확인");
         return "book/bookInsert";
     }
 	
 	
 	@RequestMapping(value="/book/bookInsert", method = RequestMethod.POST)
     public String bookInsert(Book book) {
 		logger.debug("bookInsert() bookName = {}", book.getBookName());
 		bookService.bookInsert(book);
         return "redirect:/book/bookList";
     }
 	
 	
 	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
 	public String bookSelectOne( Model model, @RequestParam(value="bookId", required=true) int bookId) {
 		logger.debug("bookSelectOne() bookId = {}", bookId);
 		Book book = bookService.bookSelectOne(bookId);
 		logger.debug("bookSelectOne() bookName = {}", book.getBookName());
 		model.addAttribute("book", book);
 		
 		return "book/bookUpdate";
 	}
 	
 
 	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.POST)
     public String bookUpdate(Book book) {		
 		logger.debug("bookUpdate() bookName = {}", book.getBookName());
 		bookService.bookUpdate(book);
        
         return "redirect:/book/bookList";
     }
 	
 	
 	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
 	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId) {
 		logger.debug("bookDelete() bookId = {}", bookId);
 		bookService.bookDelete(bookId);
 		
 		return "redirect:/book/bookList";
 	}
 	
 }