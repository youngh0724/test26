package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	
	public List<Book> bookSelcetList(){
		List<Book> list = bookDao.bookSelectList();
		logger.debug("bookSelcetList() list = {}", list);
		return list;
	}
	
	public int bookInsert(Book book) {
		logger.debug("bookInsert() bookName = {}", book.getBookName());
		int row = bookDao.bookInsert(book);
		logger.debug("bookInsert() row = {}", row);
		return row;
	}
	
	public Book bookSelectOne(int bookId) {
		logger.debug("bookSelectOne() bookId = {}", bookId);
		Book book = bookDao.bookSelectOneForUpdate(bookId);
		logger.debug("bookSelectOne() book = {}", book);
		return book;
	}
	
	public int bookUpdate(Book book) {
		logger.debug("bookUpdate() country = {}", book);
		int row = bookDao.bookUpdate(book); 
		logger.debug("bookUpdate() row = {}", row);
		return row;
	}
	
	public int bookDelete(int bookId) {
		logger.debug("bookDelete() bookId = {}", bookId);
		int row = bookDao.bookDelete(bookId);
		logger.debug("bookDelete() row = {}", row);
		return row;
	}
	
}
 