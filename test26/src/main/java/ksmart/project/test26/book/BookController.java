package ksmart.project.test26.book;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.project.test26.book.dto.Book;
import ksmart.project.test26.book.dto.BookAndBookFile;
import ksmart.project.test26.book.dto.BookCommand;
import ksmart.project.test26.book.dto.BookFile;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@RequestMapping(value="/book/bookFileDown", method = RequestMethod.GET)
	public ModelAndView bookFileDownload(HttpSession session,
			@RequestParam(value="bookFileId", required=true) int bookFileId) {
		logger.debug("bookFileDownload() bookFileId = {}", bookFileId);
		String path = session.getServletContext().getRealPath("/resources");
		
		File downloadFile = bookService.bookFileDownload(bookFileId, path);
		
		logger.debug("bookFileDownload() downloadFile = {}", downloadFile);
				
		return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	}
	
	@RequestMapping(value="/book/bookDeleteFile", method = RequestMethod.GET)
	public String bookDeleteFile(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value="bookFileId", required=true) int bookFileId) {
		logger.debug("bookDeleteFile() bookFileId = {}", bookFileId);
		String path = session.getServletContext().getRealPath("/resources");
		int bookId = bookService.bookDeleteFile(bookFileId, path);	
		redirectAttributes.addAttribute("bookId", bookId);
		return "redirect:/book/bookDetail";
	}	
	
	//bookList.jsp view파일을 요청
	@RequestMapping(value="/book/bookList", method = RequestMethod.GET)
	public String bookSelcetList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
				
		logger.debug("bookSelcetList() currentPage = {}", currentPage);
		logger.debug("bookSelcetList() rowPerPage = {}", rowPerPage);
		logger.debug("bookSelectPage() searchWord = {}", searchWord);
		Map map = bookService.bookSelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("bookSelcetList() map = {}", map);
		
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
	
	@RequestMapping(value="/book/bookDetail", method = RequestMethod.GET)
	public String bookSelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="bookId", required=true) int bookId) {
		logger.debug("bookSelectListDetail() bookId = {}", bookId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		
		String returnStr = "redirect:/book/bookList";
		
		List<BookFile> list = bookService.bookSelectListBookFile(bookId);
		
		if(list.size() != 0) {
			BookAndBookFile bookAndBookFile = bookService.bookAndBookFileMap(bookId);
			logger.debug("bookSelectListDetail() bookAndBookFile = {}", bookAndBookFile);
			model.addAttribute("bookAndBookFile", bookAndBookFile);
			returnStr = "book/bookDetail";
		}
		return returnStr;
	}
	
	//bookInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.GET)
    public String bookInsert(HttpSession session) {
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("bookInsert() 실행확인"); 
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}		
        return "book/bookInsert";
    }
	
	//bookInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/book/bookInsert", method = RequestMethod.POST)
    public String bookInsert(BookCommand bookCommand, HttpSession session) {	
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}	
		logger.debug("bookInsert() bookName = {}", bookCommand.getBookName());
		String path = session.getServletContext().getRealPath("/resources");
		logger.debug("bookInsert() ResourcesRealPath = {}", path);
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		bookService.bookInsert(bookCommand, path);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/book/bookList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
	public String bookSelectOne( Model model, HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		logger.debug("bookSelectOne() bookId = {}", bookId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//매개변수로 받은 bookId값을 이요하여 하나의 book객체를 리턴받는다.
		Book book = bookService.bookSelectOne(bookId);		
		logger.debug("bookSelectOne() bookName = {}", book.getBookName());
		//리턴받은 book객체를 model에 세팅한다.
		model.addAttribute("book", book);
		//업데이트폽으로 포워드 시킨다.
		return "book/bookUpdate";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.POST)
    public String bookUpdate(HttpSession session, Book book) {		
		logger.debug("bookUpdate() bookName = {}", book.getBookName());
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		bookService.bookUpdate(book);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/book/bookList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/book/bookDelete", method = RequestMethod.GET)
	public String bookDelete(HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		logger.debug("bookDelete() bookId = {}", bookId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		String path = session.getServletContext().getRealPath("/resources");
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		bookService.bookDelete(bookId, path);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/book/bookList";
	}
}
