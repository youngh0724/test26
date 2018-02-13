package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping(value="/movie/movieList")
	public String movieSelectList(Model model
		 ,@RequestParam(value="currentPage",defaultValue="1") int currentPage
		 ,@RequestParam(value="pagePerRow",defaultValue="10") int pagePerRow
		 ,@RequestParam(value="word", required=false) String word) {
		
		logger.debug("movieSelectList() currentPage = {}", currentPage);
		logger.debug("movieSelectList() rowPerPage = {}", pagePerRow);
		logger.debug("movieSelectList() word = {}", word);
						 
		Map map = movieService.movieSelectListByPage(currentPage, pagePerRow, word);
		
		logger.debug("movieSelectList() map = {}", map);
		
		List<Movie> list = (List<Movie>)map.get("list");
		int totalCount = (Integer)map.get("totalCount");
		
		logger.debug("movieSelectList() list = {}", list);
		logger.debug("movieSelectList() totalCount = {}", totalCount);		
		
		int lastPage = (totalCount/pagePerRow)+1;
		
		model.addAttribute("list", list);		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("pagePerRow", pagePerRow);
		
		return "movie/movieList";
	}
	
	/*
	//영화 리스트
	
	@RequestMapping(value="/movie/movieList")
	public String movieList(Model model) {
		List<Movie> list = movieService.movieList();
		model.addAttribute("list", list);
		logger.debug("movieList() list.get(1).getMovieId = {}", list.get(1).getMovieId());
		return "movie/movieList";		
	}
	*/
	//영화 추가
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.POST)
	public String movieInsert(Movie movie) {
		System.out.println(movie);
		movieService.movieInsert(movie);	
		logger.debug("movieList() movie.getMovieId = {}", movie.getMovieId());
		return "redirect:/movie/movieList";		
	}
	//영화 추가 폼 요청
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.GET)
	public String movieInsert() {		
		logger.debug("movieInsert() movieInsert.jsp 폼 요청");
		return "movie/movieInsert";
	}
	//영화 수정 처리 요청
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.POST)
	public String movieUpdate(Movie movie) {
		movieService.movieUpdate(movie);
		logger.debug("movieUpdate() movie.getMovieId = {}", movie.getMovieId());
		return "redirect:/movie/movieList";		
	}
	//영화 수정 처리 폼 
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.GET)
	public String movieUpdate(Model model, @RequestParam(value="movieId", required=true) int movieId) {
		Movie movie = movieService.movieSelectOneForUpdate(movieId);
		model.addAttribute("movie",movie);
		logger.debug("movieUpdate() movie.getMovieId = {}", movie.getMovieId());
		return "movie/movieUpdate";
	}
	//영화 삭제 처리 요청
	@RequestMapping(value="movie/movieDelete", method = RequestMethod.GET)
	   public String movieDelete(@RequestParam(value="movieId", required=true) int movieId) {
	      movieService.movieDelete(movieId);
	      logger.debug("movieDelete() movieId = {}", movieId);
	      return "redirect:/movie/movieList";
	}

}