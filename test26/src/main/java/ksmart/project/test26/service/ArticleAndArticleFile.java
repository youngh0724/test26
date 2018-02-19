package ksmart.project.test26.service;

import java.util.List;

public class ArticleAndArticleFile {
	private Article article;
	private List<ArticleFile> list;
		
	public ArticleAndArticleFile() {
		super();
	}
	public ArticleAndArticleFile(Article article, List<ArticleFile> list) {
		super();
		this.article = article;
		this.list = list;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<ArticleFile> getList() {
		return list;
	}
	public void setList(List<ArticleFile> list) {
		this.list = list;
	}
	

}
