package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "ksmart.project.test26.service.BookMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
	
	public List<BookFile> bookSelectListBookFile(int bookId){
		
		logger.debug("bookSelectListDetail() bookId = {}", bookId);
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelectListBookFile", bookId);
	}
	
	public BookAndBookFile bookAndBookFileMap(int bookId){
		logger.debug("bookAndBookFileMap() bookId = {}", bookId);
		return sqlSessionTemplate.selectOne(mapperRoot+"bookAndBookFileMap", bookId);
	}
		
	public List<Book> bookSelectPage(Map map) {
		logger.debug("bookSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("bookSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("bookSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelectPage", map);
	}
	
	public int bookSelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectCount");	
	}
	
	public List<Book> bookSelectList(){
		logger.debug("bookSelectList() 실행확인");
		//mapper에 id가 selectBookList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelcetList");
	}
	
	public Book bookSelectOneForUpdate(int bookId) {
		logger.debug("bookSelectOneForUpdate() bookId = {}", bookId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 book객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectOne", bookId);
	}
	
	public int bookInsert(Book book) {
		logger.debug("bookInsert() book = {}", book);
		//book객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"bookInsert", book);
	}
	
	public int bookInsertFile(BookFile bookFile) {
		logger.debug("bookInsertFile() bookFileName : {}", bookFile.getFileName());
		logger.debug("bookInsertFile() bookFileExt : {}", bookFile.getFileExt());
		logger.debug("bookInsertFile() bookFileSize : {}", bookFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"bookInsertFile", bookFile);
	}
	
	public int bookDeleteFile(BookFile bookFile) {
		return sqlSessionTemplate.insert(mapperRoot+"bookDeleteFile", bookFile);
	}
	
	public int bookUpdate(Book book) {
		logger.debug("bookUpdate() book = {}", book);
		//book객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"bookUpdate", book);
	}
	
	public int bookDelete(int bookId) {
		logger.debug("bookDelete() bookId = {}", bookId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"bookDelete", bookId);
	}
}
