package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	
	public List<Book> selectBookListService(){
		List<Book> list = bookDao.selectBookList();
		return list;
	}
	
	public int bookNameAddService(Book book) {
		int row = bookDao.insertBook(book);
		return row;
	}
	
	public Book bookNameUpdateService(int book_id) {
		Book book = bookDao.selectBookOne(book_id);
		return book;
	}
	
	public int bookNameUpdateService(Book book) {
		int row = bookDao.updateBook(book); 
		return row;
	}
	
	public int bookNameDeleteService(int bookId) {
		int row = bookDao.deleteBook(bookId);
		return row;
	}
	
}
 