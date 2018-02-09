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
		List<Movie> list = movieDao.movieList();		
		return list;
	}
	//영화 목록 추가
	public int movieInsert(Movie movie) {		
		int row = movieDao.movieInsert(movie);		
		return row;		
	}
	//영화 목록 한개 선택	
	public Movie movieSelectOneForUpdate(int movieId) {
		Movie movie = movieDao.movieSelectOneForUpdate(movieId);
		return movie;		
	}
	//영화 수정	
	public int movieUpdate(Movie movie) {
		int row = movieDao.movieUpdate(movie);
		return row;
	}
	//영화 삭제	
	   public int movieDelete(int movieId) {
	      int row = movieDao.movieDelete(movieId);
	      return row;
	}

}
	
	

