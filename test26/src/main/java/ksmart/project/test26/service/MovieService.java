package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MovieService {
	private final int LINE_PER_PAGE = 5;
	@Autowired
	private MovieDao movieDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
		public Map<String, Object> movieSelectListByPage(int currentPage, int rowPerPage, String searchWord){
			
			logger.debug("movieSelectPage() map.startRow = {}", currentPage);
			logger.debug("movieSelectPage() map.rowPerPage = {}", rowPerPage);
			logger.debug("movieSelectPage() map.searchWord = {}", searchWord);
			
			int startRow = (currentPage-1)*rowPerPage;
			Map map = new HashMap();
			map.put("startRow", startRow);
			map.put("rowPerPage", rowPerPage);
			map.put("searchWord", searchWord);
			
			List<Movie> list = movieDao.movieSelectPage(map);
			logger.debug("movieSelectListByPage() list = {}", list);
			int totalCount = movieDao.movieSelectTotalCount();
			logger.debug("movieSelectListByPage() totalCount = {}", totalCount);
			
			Map returnMap = new HashMap();
			returnMap.put("list", list);
			returnMap.put("totalCount", totalCount);
			
			return returnMap;
		}	
		
	
	public List<Movie> movieSelectList(int startRow){
		List<Movie> list = movieDao.movieSelectList();
		logger.debug("movieSelectList() list = {}", list);
		return list;
		
	}
	
	public int movieInsert(Movie movie) {
		logger.debug("movieInsert() movieName = {}", movie.getMovieName());
		int row = movieDao.movieInsert(movie);
		logger.debug("movieInsert() row = {}", row);
		return row;
	}
	
	public Movie movieSelectOne(int movieId) {
		logger.debug("movieSelectOne() movieId = {}", movieId);
		Movie movie = movieDao.movieSelectOneForUpdate(movieId);
		logger.debug("movieSelectOne() movie = {}", movie);
		return movie;
	}
	
	public int movieUpdate(Movie movie) {
		logger.debug("movieUpdate() movie = {}", movie);
		int row = movieDao.movieUpdate(movie); 
		logger.debug("movieUpdate() row = {}", row);
		return row;
	}
	
	public int movieDelete(int movieId) {
		logger.debug("movieDelete() movieId = {}", movieId);
		int row = movieDao.movieDelete(movieId);
		logger.debug("movieDelete() row = {}", row);
		return row;
	}
	
}
 