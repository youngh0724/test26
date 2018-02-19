package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.ArticleMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);
		
	public int insertArticle(Article article) {
		logger.debug("insertArticle() articleTitle : {}", article.getArticleTitle());
		return sqlSessionTemplate.insert(mapperRoot+"articleInsertTitle", article);
	}
	public int insertArticleFile(ArticleFile articleFile) {
		logger.debug("insertArticleFile() articleFileName : {}", articleFile.getFileName());
		logger.debug("insertArticleFile() articleFileExt : {}", articleFile.getFileExt());
		logger.debug("insertArticleFile() articleFileSize : {}", articleFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"articleInsertFile", articleFile);
	}
	
	public List<Article> articleSelectPage(Map map) {
		logger.debug("articleSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("articleSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("articleSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"articleSelectPage", map);
	}
	
	public int articleSelectTotalCount() {
		logger.debug("articleSelectTotalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"articleSelectCount");	
	}
	
	public List<Article> articleSelectList(){
		logger.debug("articleSelectLists() 실행확인");
		//mapper에 id가 selectCountryList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"articleSelcetList");
	}
}
