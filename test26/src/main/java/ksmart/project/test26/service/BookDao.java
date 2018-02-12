package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.BookMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
	
		public List<Book> bookSelectPage(Map<String, Object> map) {
			logger.debug("bookSelectPage() map = {}", map);
			return sqlSessionTemplate.selectList(mapperRoot+"bookSelectPage", map);
		}
		
		public int bookSelectTotalCount() {
			logger.debug("bookSelectTotalCount() 실행확인"); 
			return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectCount");	
		}
		
	public List<Book> bookSelectList(){
		logger.debug("bookSelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelectList");
	}
	
	public Book bookSelectOneForUpdate(int bookId) {
		logger.debug("bookSelectOneForUpdate() bookId = {}", bookId);
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectOne", bookId);
	}
	
	public int bookInsert(Book book) {
		logger.debug("bookInsert() book = {}", book);
		return sqlSessionTemplate.insert(mapperRoot+"bookInsert", book);
	}
	
	public int bookUpdate(Book book) {
		logger.debug("bookUpdate() book = {}", book);
		return sqlSessionTemplate.update(mapperRoot+"bookUpdate", book);
	}
	
	public int bookDelete(int bookId) {
		logger.debug("bookDelete() = {}", bookId);
		return sqlSessionTemplate.delete(mapperRoot+"bookDelete", bookId);
	}
}
