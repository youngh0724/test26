package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	//영화 리스트
	public List<Movie> movieList() {
		List<Movie> list = movieDao.movieList();	
		logger.debug("movieList() movieId = {}", list.get(1).getMovieId());
		return list;
	}
	//영화 목록 추가
	public int movieInsert(Movie movie) {		
		int row = movieDao.movieInsert(movie);		
		logger.debug("movieInsert() movieId = {}", movie.getMovieId());
		return row;		
	}
	//영화 목록 한개 선택	
	public Movie movieSelectOneForUpdate(int movieId) {
		Movie movie = movieDao.movieSelectOneForUpdate(movieId);
		logger.debug("movieSelectOneForUpdate() movieId = {}", movie.getMovieId());
		return movie;		
	}
	//영화 수정	
	public int movieUpdate(Movie movie) {
		int row = movieDao.movieUpdate(movie);
		logger.debug("movieUpdate() movieId = {}", movie.getMovieId());
		return row;
	}
	//영화 삭제	
	   public int movieDelete(int movieId) {
	      int row = movieDao.movieDelete(movieId);
	      logger.debug("movieUpdate() movieId = {}", movieId);
	      return row;
	}

}
	
	

