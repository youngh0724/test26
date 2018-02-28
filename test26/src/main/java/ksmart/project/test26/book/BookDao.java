package ksmart.project.test26.book;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.book.dto.Book;
import ksmart.project.test26.book.dto.BookAndBookFile;
import ksmart.project.test26.book.dto.BookFile;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//문자열을 상수화 시켜 경로작성을 용이하게 바꿔주었다
	private final String mapperRoot = "ksmart.project.test26.service.BookMapper.";
	
	//(전체해당)입력값과 리턴값을 확인하기위해 logger.debug 사용
	
	private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
	
	// 파일 업로드 처리에 필요한 bookFileID 조회 처리
	public BookFile bookSelectOneBookFile(int bookFileId) {
		logger.debug("bookSelectOneBookFile() bookFileId = {}", bookFileId);
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectOneBookFile", bookFileId);
	}
	
	// 업로드 된 파일 삭제 처리
	public int bookDeleteFile(int bookFileId) {
		logger.debug("bookDeleteFile() bookFileId = {}", bookFileId);
		return sqlSessionTemplate.delete(mapperRoot+"bookDeleteBookFile", bookFileId);
	}
	
	// 업로드된 파일 조회 처리
	public List<BookFile> bookSelectListBookFile(int bookId){
		logger.debug("bookSelectListDetail() bookId = {}", bookId);
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelectListBookFile", bookId);
	}
	
	// 파일 업로드 처리에 필요한 Mapping 처리
	public BookAndBookFile bookAndBookFileMap(int bookId){
		logger.debug("bookAndBookFileMap() bookId = {}", bookId);
		return sqlSessionTemplate.selectOne(mapperRoot+"bookAndBookFileMap", bookId);
	}
		
	// Mapping 처리
	public List<Book> bookSelectPage(Map map) {
		logger.debug("bookSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("bookSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("bookSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelectPage", map);
	}
	
	// 전체 총합 카운트
	public int bookSelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectCount");	
	}
	
	// 전체 리스트 조회
	public List<Book> bookSelectList(){
		logger.debug("bookSelectList() 실행확인");
		//mapper에 id가 selectBookList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"bookSelcetList");
	}
	
	// 업데이트에 필요한 bookId 조회 처리
	public Book bookSelectOneForUpdate(int bookId) {
		logger.debug("bookSelectOneForUpdate() bookId = {}", bookId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 book객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"bookSelectOne", bookId);
	}
	
	// 리스트 추가 처리
	public int bookInsert(Book book) {
		logger.debug("bookInsert() book = {}", book);
		//book객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"bookInsert", book);
	}
	
	// 업로드 파일 추가 처리
	public int bookInsertFile(BookFile bookFile) {
		logger.debug("bookInsertFile() bookFileName : {}", bookFile.getFileName());
		logger.debug("bookInsertFile() bookFileExt : {}", bookFile.getFileExt());
		logger.debug("bookInsertFile() bookFileSize : {}", bookFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"bookInsertFile", bookFile);
	}
	
	// 업로드 파일 삭제 처리
	public int bookDeleteFile(BookFile bookFile) {
		return sqlSessionTemplate.insert(mapperRoot+"bookDeleteFile", bookFile);
	}
	
	// 리스트 업데이트 처리
	public int bookUpdate(Book book) {
		logger.debug("bookUpdate() book = {}", book);
		//book객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"bookUpdate", book);
	}
	
	// 리스트 삭제처리
	public int bookDelete(int bookId) {
		logger.debug("bookDelete() bookId = {}", bookId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"bookDelete", bookId);
	}
}
