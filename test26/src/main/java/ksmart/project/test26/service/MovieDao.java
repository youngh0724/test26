package ksmart.project.test26.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	private final String mapperRoot = "ksmart.project.test26.service.MovieMapper.";
	//movie list
	public List<Movie> movieList(){
		logger.debug("movieList() 영화 리스트 출력");
		return sqlSessionTemplate.selectList(mapperRoot+"selectMovieList");		
	}
	//insert movie
	public int movieInsert(Movie movie) {
		logger.debug("movieInsert() movie.getMovieId = {}", movie.getMovieId());
		return sqlSessionTemplate.insert(mapperRoot+"insertMovie", movie);
	}
	//select one movie
	public Movie movieSelectOneForUpdate(int movieId) {
		logger.debug("movieSelectOneForUpdate() movieId = {}", movieId);
		return sqlSessionTemplate.selectOne(mapperRoot+"selectMovie", movieId);
	}
	//update movie
	public int movieUpdate(Movie movie) {
		logger.debug("movieUpdate() movie.getMovieId = {}", movie.getMovieId());
		return sqlSessionTemplate.update(mapperRoot+"updateMovie", movie);
	}
	//delete movie
	public int movieDelete(int movieId) {
		logger.debug("movieDelete() movieId = {}", movieId);
		return sqlSessionTemplate.delete(mapperRoot+"deleteMovie", movieId);
	}
}
