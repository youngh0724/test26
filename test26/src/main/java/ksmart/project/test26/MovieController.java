package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	@RequestMapping
	public String movieList(Model model) {
		List<Movie> list = movieDao.selectMovieList();
		model.addAttribute("list", list);
		return "movieList";
	}
}
