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
	//movie list
	public List<Movie> movieList(){
		return sqlSessionTemplate.selectList(mapperRoot+"selectMovieList");
	}
	//insert movie
	public int movieInsert(Movie movie) {
		return sqlSessionTemplate.insert(mapperRoot+"insertMovie", movie);
	}
	//select one movie
	public Movie movieSelectOneForUpdate(int movieId) {
		return sqlSessionTemplate.selectOne(mapperRoot+"selectMovie", movieId);
	}
	//update movie
	public int movieUpdate(Movie movie) {
		return sqlSessionTemplate.update(mapperRoot+"updateMovie", movie);
	}
	//delete movie
	public int movieDelete(int movieId) {
		return sqlSessionTemplate.delete(mapperRoot+"deleteMovie", movieId);
	}
}
