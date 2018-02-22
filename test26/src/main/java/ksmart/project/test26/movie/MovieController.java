package ksmart.project.test26.movie;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.project.test26.movie.dto.Movie;
import ksmart.project.test26.movie.dto.MovieAndMovieFile;
import ksmart.project.test26.movie.dto.MovieCommand;
import ksmart.project.test26.movie.dto.MovieFile;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	@RequestMapping(value="/movie/movieFileDown", method = RequestMethod.GET)
	public ModelAndView movieFileDownload(HttpSession session,
			@RequestParam(value="movieFileId", required=true) int movieFileId) {
		logger.debug("movieFileDownload() movieFileId = {}", movieFileId);
		String path = session.getServletContext().getRealPath("/resources");
		
		File downloadFile = movieService.movieFileDownload(movieFileId, path);
		
		logger.debug("movieFileDownload() downloadFile = {}", downloadFile);
				
		return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	}
	
	@RequestMapping(value="/movie/movieDeleteFile", method = RequestMethod.GET)
	public String movieDeleteFile(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value="movieFileId", required=true) int movieFileId) {
		logger.debug("movieDeleteFile() movieFileId = {}", movieFileId);
		String path = session.getServletContext().getRealPath("/resources");
		int movieId = movieService.movieDeleteFile(movieFileId, path);	
		redirectAttributes.addAttribute("movieId", movieId);
		return "redirect:/movie/movieDetail";
	}	
	
	//movieList.jsp view파일을 요청
	@RequestMapping(value="/movie/movieList", method = RequestMethod.GET)
	public String movieSelcetList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
				
		logger.debug("movieSelcetList() currentPage = {}", currentPage);
		logger.debug("movieSelcetList() rowPerPage = {}", rowPerPage);
		logger.debug("movieSelectPage() searchWord = {}", searchWord);
		Map map = movieService.movieSelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("movieSelcetList() map = {}", map);
		
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
	
	@RequestMapping(value="/movie/movieDetail", method = RequestMethod.GET)
	public String movieSelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="movieId", required=true) int movieId) {
		logger.debug("movieSelectListDetail() movieId = {}", movieId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		
		String returnStr = "redirect:/movie/movieList";
		
		List<MovieFile> list = movieService.movieSelectListMovieFile(movieId);
		
		if(list.size() != 0) {
			MovieAndMovieFile movieAndMovieFile = movieService.movieAndMovieFileMap(movieId);
			logger.debug("movieSelectListDetail() movieAndMovieFile = {}", movieAndMovieFile);
			model.addAttribute("movieAndMovieFile", movieAndMovieFile);
			returnStr = "movie/movieDetail";
		}
		return returnStr;
	}
	
	//movieInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.GET)
    public String movieInsert(HttpSession session) {
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("movieInsert() 실행확인"); 
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}		
        return "movie/movieInsert";
    }
	
	//movieInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/movie/movieInsert", method = RequestMethod.POST)
    public String movieInsert(MovieCommand movieCommand, HttpSession session) {	
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}	
		logger.debug("movieInsert() movieName = {}", movieCommand.getMovieName());
		String path = session.getServletContext().getRealPath("/resources");
		logger.debug("movieInsert() ResourcesRealPath = {}", path);
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		movieService.movieInsert(movieCommand, path);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/movie/movieList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.GET)
	public String movieSelectOne( Model model, HttpSession session, @RequestParam(value="movieId", required=true) int movieId) {
		logger.debug("movieSelectOne() movieId = {}", movieId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//매개변수로 받은 movieId값을 이요하여 하나의 movie객체를 리턴받는다.
		Movie movie = movieService.movieSelectOne(movieId);		
		logger.debug("movieSelectOne() movieName = {}", movie.getMovieName());
		//리턴받은 movie객체를 model에 세팅한다.
		model.addAttribute("movie", movie);
		//업데이트폽으로 포워드 시킨다.
		return "movie/movieUpdate";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/movie/movieUpdate", method = RequestMethod.POST)
    public String movieUpdate(HttpSession session, Movie movie) {		
		logger.debug("movieUpdate() movieName = {}", movie.getMovieName());
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		movieService.movieUpdate(movie);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/movie/movieList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/movie/movieDelete", method = RequestMethod.GET)
	public String movieDelete(HttpSession session, @RequestParam(value="movieId", required=true) int movieId) {
		logger.debug("movieDelete() movieId = {}", movieId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		String path = session.getServletContext().getRealPath("/resources");
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		movieService.movieDelete(movieId, path);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/movie/movieList";
	}
}
