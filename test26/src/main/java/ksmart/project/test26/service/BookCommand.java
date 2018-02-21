package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BookCommand {
	private int bookId;
	private String bookName;
	private List<MultipartFile> files;
		
	public BookCommand() {
		super();
	}
	public BookCommand(int bookId, String bookName, List<MultipartFile> files) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.files = files;
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
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
}
