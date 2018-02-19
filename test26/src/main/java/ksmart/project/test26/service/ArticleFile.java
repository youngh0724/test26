package ksmart.project.test26.service;

public class ArticleFile {
	private int articleFileId;
	private int articleId;
	//private Article article;
	private String fileName;
	private String fileExt;
	private long fileSize;
		
	public ArticleFile() {
		super();
	}
	public ArticleFile(int articleFileId, int articleId, String fileName, String fileExt, long fileSize) {
		super();
		this.articleFileId = articleFileId;
		this.articleId = articleId;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.fileSize = fileSize;
	}
	public int getArticleFileId() {
		return articleFileId;
	}
	public void setArticleFileId(int articleFileId) {
		this.articleFileId = articleFileId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
