package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	//영화 리스트
	public List<Movie> movieList() {
		List<Movie> list = movieDao.selectMovieList();		
		return list;
	}
	//영화 추가 처리 요청
	public int insertMovie(Movie movie) {		
		int row = movieDao.insertMovie(movie);		
		return row;		
	}
	//영화 수정 처리 요청	
	public Movie selectOneForUpdateMovie(int movieId) {
		Movie movie = movieDao.getMovie(movieId);
		return movie;		
	}
	//영화 수정 폼 요청	
	public int updateMovie(Movie movie) {
		int row = movieDao.updateMovie(movie);
		return row;
	}
	//영화 삭제 요청	
	   public int deleteMovie(int movieId) {
	      int row = movieDao.deleteMovie(movieId);
	      return row;
	}

}
	
	

