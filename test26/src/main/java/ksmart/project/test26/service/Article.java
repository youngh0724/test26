package ksmart.project.test26.service;

public class Article {
	private int articleId;
	private String articleTitle;
	//private ArticleFile[] articleFile;
	
	public Article() {
		super();
	}
	public Article(int articleId, String articleTitle) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
	}
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	

}
