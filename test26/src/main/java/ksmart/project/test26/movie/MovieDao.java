package ksmart.project.test26.movie;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.movie.dto.Movie;
import ksmart.project.test26.movie.dto.MovieAndMovieFile;
import ksmart.project.test26.movie.dto.MovieFile;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "ksmart.project.test26.service.MovieMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	//하나의 영화에 첨부된 파일 목록을 조회하는 쿼리문 실행하기 위한 메서드
	public MovieFile movieSelectOneMovieFile(int movieFileId) {
		logger.debug("movieSelectOneMovieFile() movieFileId = {}", movieFileId);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"movieSelectOneMovieFile", movieFileId);
	}
	//영화에 첨부된 파일을 삭제하는 쿼리문을 실행하기 위한 메서드
	public int movieDeleteFile(int movieFileId) {
		logger.debug("countrtyDeleteFile() movieFileId = {}", movieFileId);
		
		return sqlSessionTemplate.delete(mapperRoot+"movieDeleteMovieFile", movieFileId);
	}
	//영화에 첨부된 파일의 정보를 조회하기 위한 쿼리문을 실행하기 위한 메서드
	public List<MovieFile> movieSelectListMovieFile(int movieId){
		
		logger.debug("movieSelectListDetail() movieId = {}", movieId);
		return sqlSessionTemplate.selectList(mapperRoot+"movieSelectListMovieFile", movieId);
	}
	
	public MovieAndMovieFile movieAndMovieFileMap(int movieId){
		logger.debug("movieAndMovieFileMap() movieId = {}", movieId);
		return sqlSessionTemplate.selectOne(mapperRoot+"movieAndMovieFileMap", movieId);
	}
    //영화 목록을 페이징 처리 하기 위한 쿼리문을 실행하는 메서드
	public List<Movie> movieSelectPage(Map map) {
		logger.debug("movieSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("movieSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("movieSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"movieSelectPage", map);
	}
	//전체 영화 목록의 개수를 카운트 해주는 쿼리문을 실행하는 메서드
	public int movieSelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"movieSelectCount");	
	}
	//전체 영화 목록을 조회하는 쿼리문을 실행하는 메서드
	public List<Movie> movieSelectList(){
		logger.debug("movieSelectList() 실행확인");
		//mapper에 id가 selectMovieList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"movieSelcetList");
	}
	//영화 한개를 업데이트 하기위해 한개의 영화를 선택해주는 쿼리문을 실행하는 메서드
	public Movie movieSelectOneForUpdate(int movieId) {
		logger.debug("movieSelectOneForUpdate() movieId = {}", movieId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 movie객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"movieSelectOne", movieId);
	}
	//영화를 추가하기 위한 쿼리문을 실행하는 메서드 
	public int movieInsert(Movie movie) {
		logger.debug("movieInsert() movie = {}", movie);
		//movie객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"movieInsert", movie);
	}
	
	public int movieInsertFile(MovieFile movieFile) {
		logger.debug("movieInsertFile() movieFileName : {}", movieFile.getFileName());
		logger.debug("movieInsertFile() movieFileExt : {}", movieFile.getFileExt());
		logger.debug("movieInsertFile() movieFileSize : {}", movieFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"movieInsertFile", movieFile);
	}
	
	public int movieDeleteFile(MovieFile movieFile) {
		return sqlSessionTemplate.insert(mapperRoot+"movieDeleteFile", movieFile);
	}
	
	public int movieUpdate(Movie movie) {
		logger.debug("movieUpdate() movie = {}", movie);
		//movie객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"movieUpdate", movie);
	}
	
	public int movieDelete(int movieId) {
		logger.debug("movieDelete() movieId = {}", movieId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"movieDelete", movieId);
	}
}
