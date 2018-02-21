package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieCommand;
import ksmart.project.test26.service.MovieService;

@Controller
public class MovieController{
   @Autowired
   private MovieService movieService;
   
 //입력값과 리턴값을 확인하기위해 로거기능 사용
 	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
   
 
 	@RequestMapping(value="/movie/movieList", method = RequestMethod.GET)
 	public String movieSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
 		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
 		
 		logger.debug("movieSelectPage() map.startRow = {}", currentPage);
		logger.debug("movieSelectPage() map.rowPerPage = {}", rowPerPage);
		logger.debug("movieSelectPage() map.searchWord = {}", searchWord);
		Map<String, Object> map = movieService.movieSelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("movieSelectList() map = {}", map);
		
		@SuppressWarnings("unchecked")
		List<Movie> list = (List<Movie>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "movie/movieList";
	}
 	
 	
 	
 	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.GET)
     public String movieInsert(HttpSession session) {
 		logger.debug("movieInsert() 실행확인");
 		
 		if(session.getAttribute("loginMember") == null) {
 			return "sessionError";
 		}
         return "movie/movieInsert";
     }
 	
 	
 	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.POST)
     public String movieInsert(MovieCommand movieCommand, HttpSession session) {
 		logger.debug("movieInsert() movieName = {}", movieCommand.getMovieName());
 		logger.debug("movieInsert() movieSize = {}", movieCommand.getFiles().size());
 		
 		String path = session.getServletContext().getRealPath("/resources");
 		logger.debug("movieInsert() path = {}", path);
 		 movieService.movieInsert(movieCommand, path);
         return "redirect:/movie/movieList";
     }
 	
 	
 	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.GET)
 	public String movieSelectOne( Model model, @RequestParam(value="movieId", required=true) int movieId) {
 		logger.debug("movieSelectOne() movieId = {}", movieId);
 		Movie movie = movieService.movieSelectOne(movieId);
 		logger.debug("movieSelectOne() movieName = {}", movie.getMovieName());
 		model.addAttribute("movie", movie);
 		
 		return "movie/movieUpdate";
 	}
 	
 
 	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.POST)
     public String movieUpdate(Movie movie) {		
 		logger.debug("movieUpdate() movieName = {}", movie.getMovieName());
 		movieService.movieUpdate(movie);
        
         return "redirect:/movie/movieList";
     }
 	
 	
 	@RequestMapping(value="/movie/movieDelete", method = RequestMethod.GET)
 	public String movieDelete(@RequestParam(value="movieId", required=true) int movieId) {
 		logger.debug("movieDelete() movieId = {}", movieId);
 		movieService.movieDelete(movieId);
 		
 		return "redirect:/movie/movieList";
 	}
 	
 }