package ksmart.project.test26.service;

import java.util.List;

public class ArticleAndArticleFile {
	private int articleId;
	private String articleTitle;
	private List<ArticleFile> list;
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
	public List<ArticleFile> getList() {
		return list;
	}
	public void setList(List<ArticleFile> list) {
		this.list = list;
	}
	
	
}
