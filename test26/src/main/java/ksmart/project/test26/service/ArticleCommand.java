package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticleCommand {
	private int ArticleId;
	private String articleTitle;
	private List<MultipartFile> files;
		
	public ArticleCommand() {
		super();
	}
	public ArticleCommand(int articleId, String articleTitle, List<MultipartFile> files) {
		super();
		ArticleId = articleId;
		this.articleTitle = articleTitle;
		this.files = files;
	}
	public int getArticleId() {
		return ArticleId;
	}
	public void setArticleId(int articleId) {
		ArticleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	

}
