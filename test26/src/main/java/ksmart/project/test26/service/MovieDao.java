package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.MovieMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	
		
	public MovieAndMovieFile movieAndMovieFile(int movieId) {
		logger.debug("movieAndMovieFile() movieId {}", movieId);
		return sqlSessionTemplate.selectOne(mapperRoot+"movieJoinFile", movieId);
	}
		
		
	public List<Movie> movieSelectPage(Map<String, Object> map) {
		logger.debug("movieSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("movieSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("movieSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"movieSelectPage", map);
	}
	
	public int movieSelectTotalCount() {
		logger.debug("movieSelectTotalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"movieSelectCount");	
	}
		
	public List<Movie> movieSelectList(){
		logger.debug("movieSelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"movieSelectList");
	}
	
	public Movie movieSelectOneForUpdate(int movieId) {
		logger.debug("movieSelectOneForUpdate() movieId = {}", movieId);
		return sqlSessionTemplate.selectOne(mapperRoot+"movieSelectOne", movieId);
	}
	
	public int movieInsert(Movie movie) {
		logger.debug("movieInsert() movie = {}", movie);
		return sqlSessionTemplate.insert(mapperRoot+"movieInsert", movie);
	}
	public int movieInsertFile(MovieFile movieFile) {
		logger.debug("movieInsertFile() movieFileName : {}", movieFile.getFileName());
		logger.debug("movieInsertFile() movieFileExt : {}", movieFile.getFileExt());
		logger.debug("movieInsertFile() movieFileSize : {}", movieFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"movieInsertFile", movieFile);
	}
	public int movieUpdate(Movie movie) {
		logger.debug("movieUpdate() movie = {}", movie);
		return sqlSessionTemplate.update(mapperRoot+"movieUpdate", movie);
	}
	
	public int movieDelete(int movieId) {
		logger.debug("movieDelete() = {}", movieId);
		return sqlSessionTemplate.delete(mapperRoot+"movieDelete", movieId);
	}
}
