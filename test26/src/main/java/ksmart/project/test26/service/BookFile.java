package ksmart.project.test26.service;

public class BookFile {
	private int bookFileId;
	private int bookId;
	private String fileName;
	private String fileExt;
	private long fileSize;
		
	public BookFile() {
		super();
	}
	public BookFile(int bookFileId, int bookId, String fileName, String fileExt, long fileSize) {
		super();
		this.bookFileId = bookFileId;
		this.bookId = bookId;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.fileSize = fileSize;
	}
	public int getBookFileId() {
		return bookFileId;
	}
	public void setBookFileId(int bookFileId) {
		this.bookFileId = bookFileId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
