package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.MovieMapper.";
	public List<Movie> selectMovieList(){
		return sqlSessionTemplate.selectList(mapperRoot+"selectMovieList");
	}
	
	public int insertMovie(Movie movie) {
		return sqlSessionTemplate.insert(mapperRoot+"insertMovie", movie);
	}
	public Movie getMovie(int movieId) {
		return sqlSessionTemplate.selectOne(mapperRoot+"selectMovie", movieId);
	}

	public int updateMovie(Movie movie) {
		return sqlSessionTemplate.update(mapperRoot+"updateMovie", movie);
	}
}
