package ksmart.project.test26.service;

import java.util.List;

public class BookAndBookFile {
	private int bookId;
	private String bookName;
	private List<BookFile> list;
		
	public BookAndBookFile() {
		super();
	}
	public BookAndBookFile(int bookId, String bookName, List<BookFile> list) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.list = list;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<BookFile> getList() {
		return list;
	}
	public void setList(List<BookFile> list) {
		this.list = list;
	}	
}
