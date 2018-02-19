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

import ksmart.project.test26.service.Article;
import ksmart.project.test26.service.ArticleCommand;
import ksmart.project.test26.service.ArticleFile;
import ksmart.project.test26.service.ArticleService;


@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(value="/article/articleDetail", method = RequestMethod.GET)
	public String articleFileSelectList(Model model, HttpSession session, @RequestParam(value="articleId", required=true) int articleId) {
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		logger.debug("articleFileSelectList() articleId = {}", articleId);
		
		List<ArticleFile> list = articleService.articleFileSelectList(articleId);
		
		model.addAttribute("list", list);
		
		return "article/articleDetail";
	}
	
	//articleList.jsp view파일을 요청
		@RequestMapping(value="/article/articleList", method = RequestMethod.GET)
		public String articleSelcetList(Model model, HttpSession session, 
				@RequestParam(value="currentPage", defaultValue="1") int currentPage,
				@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
				@RequestParam(value="searchWord", required=false) String searchWord) {	
			
			if(session.getAttribute("loginMember") == null) {
				return "sessionError";
			}
					
			logger.debug("articleSelcetList() currentPage = {}", currentPage);
			logger.debug("articleSelcetList() rowPerPage = {}", rowPerPage);
			logger.debug("articleSelcetList() searchWord = {}", searchWord);
			Map map = articleService.articleSelectListByPage(currentPage, rowPerPage, searchWord);
			//list에 들어있는 값을 확인해본다.
			logger.debug("articleSelcetList() map = {}", map);
			
			List<Article> list = (List<Article>)map.get("list");
			int totalCount = (Integer) map.get("totalCount");		
			
			int lastPage = (totalCount/rowPerPage)+1;
			//db에서 받아온 결과값을 model에 세팅한다.
			model.addAttribute("list", list);
			model.addAttribute("lastPage", lastPage);
			model.addAttribute("rowPerPage", rowPerPage);
			model.addAttribute("currentPage", currentPage);
			return "article/articleList";
		}
	//추가 화면 호출
	@RequestMapping(value="/article/articleInsert", method = RequestMethod.GET)
	public String articleInsert(HttpSession session) {		
		logger.debug("articleInsert() articleInsert.jsp 화면 호출");
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		return "article/articleInsert";
	}
	
	//추가화면에서  정보를 입력받아 처리service호출
	@RequestMapping(value="/article/articleInsert", method = RequestMethod.POST)
	public String articleInsert(ArticleCommand articleCommand) {
		logger.debug("articleInsert() articleTitle: {}", articleCommand.getArticleTitle());
		logger.debug("articleInsert() articleSize: {}", articleCommand.getFiles().size());
		
		articleService.articleInsert(articleCommand);
		return "redirect:/article/articleList";
	}

}
