package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	//영화 리스트 
	@RequestMapping(value="/movie/movieList")
	public String movieList(Model model) {
		List<Movie> list = movieDao.selectMovieList();
		model.addAttribute("list", list);
		return "movie/movieList";
	}
	//영화 추가 처리 요청
	@RequestMapping(value="/movie/insertMovie", method = RequestMethod.POST)
	public String insertMovie(Movie movie) {
		System.out.println(movie);
		movieDao.insertMovie(movie);		
		return "redirect:/movie/movieList";		
	}
	//영화 추가 폼 요청
	@RequestMapping(value="/movie/insertMovie", method = RequestMethod.GET)
	public String insertMovie() {
		System.out.println("MovieController.java insertMovie() insertMovie.jsp 폼으로 이동 GET 방식");
		return "movie/insertMovie";
	}
	//영화 수정 처리 요청
	@RequestMapping(value="/movie/updateMovie", method = RequestMethod.POST)
	public String updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
		return "redirect:/movie/movieList";		
	}
	//영화 수정 폼 요청
	@RequestMapping(value="/movie/updateMovie", method = RequestMethod.GET)
	public String updateMovie(Model model, @RequestParam(value="movieId", required=true) int movieId) {
		Movie movie = movieDao.getMovie(movieId);
		model.addAttribute("movie",movie);
		return "movie/updateMovie";
	}
	//영화 삭제 요청
	@RequestMapping(value="movie/deleteMovie", method = RequestMethod.GET)
	   public String bookDelete(@RequestParam(value="movieId", required=true) int movieId) {
	      movieDao.deleteMovie(movieId);
	      return "redirect:/movie/movieList";
	}

}