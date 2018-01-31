package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sst;
	public List<Movie> selectMovieList(){
		return sst.selectList("ksmart.project.test26.service.MovieMapper.selectMovieList");
	}
	

}
