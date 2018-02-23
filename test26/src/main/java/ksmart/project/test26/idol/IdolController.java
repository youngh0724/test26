package ksmart.project.test26.idol;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import ksmart.project.test26.idol.dto.Idol;
import ksmart.project.test26.idol.dto.IdolAndIdolFile;
import ksmart.project.test26.idol.dto.IdolCommand;

@Controller
public class IdolController{
   @Autowired
   private IdolService idolService;
   
 //입력값과 리턴값을 확인하기위해 로거기능 사용
 	private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
   
 	//
 	@RequestMapping(value="/idol/idolFileDown", method = RequestMethod.GET)
	public ModelAndView idolFileDownload(HttpSession session,
			@RequestParam(value="idolFileId", required=true) int idolFileId) {
		logger.debug("countryFileDownload() idolFileId = {}", idolFileId);
		String path = session.getServletContext().getRealPath("/resources");
		
		File downloadFile = idolService.idolFileDownload(idolFileId, path);
		
		logger.debug("idolFileDownload() downloadFile = {}", downloadFile);
				
		return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	}
 	
 	//
 	@RequestMapping(value="/idol/idolDetail", method = RequestMethod.GET)
	public String idolSelectFileList(Model model, HttpSession session, 
										@RequestParam(value="idolId", required=true) int idolId) {
		logger.debug("idolSelectFileList() idolId = {}", idolId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		
		IdolAndIdolFile idolAndIdolFile = idolService.idolAndIdolFileMap(idolId);
		
		model.addAttribute("idolAndIdolFile", idolAndIdolFile);
		return "idol/idolDetail";
	}
	
 	//아이돌 목록화면 요청
 	@RequestMapping(value="/idol/idolList", method = RequestMethod.GET)
 	public String idolSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
 		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
 		
 		logger.debug("idolSelectPage() map.startRow = {}", currentPage);
		logger.debug("idolSelectPage() map.rowPerPage = {}", rowPerPage);
		logger.debug("idolSelectPage() map.searchWord = {}", searchWord);
		Map<String, Object> map = idolService.idolSelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("idolSelectList() map = {}", map);
		
		@SuppressWarnings("unchecked")
		List<Idol> list = (List<Idol>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "idol/idolList";
	}
 	
 	
 	//추가 화면 요청
 	@RequestMapping(value="/idol/idolInsert", method = RequestMethod.GET)
     public String idolInsert() {
 		logger.debug("idolInsert() 실행확인");
         return "idol/idolInsert";
     }
 	
 	//추가화면에서 정보를 입력받아 추가처리요청
 	@RequestMapping(value="/idol/idolInsert", method = RequestMethod.POST)
     public String idolInsert(IdolCommand idolCommand,HttpServletRequest request) {
 		String path = request.getSession().getServletContext().getRealPath("/resources");
 		logger.debug("idolInsert() idolName = {}", idolCommand.getIdolName());
		logger.debug("idolInsert() idolsize: {}", idolCommand.getFiles().size());
 		idolService.idolInsert(idolCommand, path);
         return "redirect:/idol/idolList";
     }
 	
 	
 	//수정화면 요청
 	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.GET)
 	public String idolSelectOne( Model model, @RequestParam(value="idolId", required=true) int idolId) {
 		logger.debug("idolSelectOne() idolId = {}", idolId);
 		Idol idol = idolService.idolSelectOne(idolId);
 		logger.debug("idolSelectOne() idolName = {}", idol.getIdolName());
 		model.addAttribute("idol", idol);
 		
 		return "idol/idolUpdate";
 	}
 	
 	//수정화면에서 수정정보를 입력받아 수정처리요청
 	@RequestMapping(value="/idol/idolUpdate", method = RequestMethod.POST)
     public String idolUpdate(Idol idol) {		
 		logger.debug("idolUpdate() idolName = {}", idol.getIdolName());
 		idolService.idolUpdate(idol);
        
         return "redirect:/idol/idolList";
     }
 	
 	//삭제버튼 클릭시 삭제처리 요청
 	@RequestMapping(value="/idol/idolDelete", method = RequestMethod.GET)
 	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId) {
 		logger.debug("idolDelete() idolId = {}", idolId);
 		idolService.idolDelete(idolId);
 		
 		return "redirect:/idol/idolList";
 	}
 	
 }