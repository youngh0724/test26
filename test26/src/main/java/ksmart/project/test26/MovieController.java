package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	//영화 리스트
	@RequestMapping(value="/movie/movieList")
	public String movieList(Model model) {
		List<Movie> list = movieService.movieList();
		model.addAttribute("list", list);
		return "movie/movieList";
	}
	//영화 추가
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.POST)
	public String movieInsert(Movie movie) {
		System.out.println(movie);
		movieService.movieInsert(movie);		
		return "redirect:/movie/movieList";		
	}
	//영화 추가 폼 요청
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.GET)
	public String movieInsert() {
		System.out.println("MovieController.java insertMovie() insertMovie.jsp 영화 추가 폼 요청 GET");
		return "movie/movieInsert";
	}
	//영화 수정 처리 요청
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.POST)
	public String movieUpdate(Movie movie) {
		movieService.movieUpdate(movie);
		return "redirect:/movie/movieList";		
	}
	//영화 수정 처리 폼 
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.GET)
	public String movieUpdate(Model model, @RequestParam(value="movieId", required=true) int movieId) {
		Movie movie = movieService.movieSelectOneForUpdate(movieId);
		model.addAttribute("movie",movie);
		return "movie/movieUpdate";
	}
	//영화 삭제 처리 요청
	@RequestMapping(value="movie/movieDelete", method = RequestMethod.GET)
	   public String movieDelete(@RequestParam(value="movieId", required=true) int movieId) {
	      movieService.movieDelete(movieId);
	      return "redirect:/movie/movieList";
	}

}