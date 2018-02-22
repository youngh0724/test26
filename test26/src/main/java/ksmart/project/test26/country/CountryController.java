package ksmart.project.test26.country;

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

import ksmart.project.test26.country.dto.Country;
import ksmart.project.test26.country.dto.CountryAndCountryFile;
import ksmart.project.test26.country.dto.CountryCommand;
import ksmart.project.test26.country.dto.CountryFile;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@RequestMapping(value="/country/countryFileDown", method = RequestMethod.GET)
	public ModelAndView countryFileDownload(HttpSession session,
			@RequestParam(value="countryFileId", required=true) int countryFileId) {
		logger.debug("countryFileDownload() countryFileId = {}", countryFileId);
		String path = session.getServletContext().getRealPath("/resources");
		
		File downloadFile = countryService.countryFileDownload(countryFileId, path);
		
		logger.debug("countryFileDownload() downloadFile = {}", downloadFile);
				
		return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	}
	
	@RequestMapping(value="/country/countryDeleteFile", method = RequestMethod.GET)
	public String countryDeleteFile(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value="countryFileId", required=true) int countryFileId) {
		logger.debug("countryDeleteFile() countryFileId = {}", countryFileId);
		String path = session.getServletContext().getRealPath("/resources");
		int countryId = countryService.countryDeleteFile(countryFileId, path);	
		redirectAttributes.addAttribute("countryId", countryId);
		return "redirect:/country/countryDetail";
	}	
	
	//countryList.jsp view파일을 요청
	@RequestMapping(value="/country/countryList", method = RequestMethod.GET)
	public String countrySelcetList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
				
		logger.debug("countrySelcetList() currentPage = {}", currentPage);
		logger.debug("countrySelcetList() rowPerPage = {}", rowPerPage);
		logger.debug("countrySelectPage() searchWord = {}", searchWord);
		Map map = countryService.countrySelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("countrySelcetList() map = {}", map);
		
		List<Country> list = (List<Country>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "country/countryList";
	}
	
	@RequestMapping(value="/country/countryDetail", method = RequestMethod.GET)
	public String countrySelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="countryId", required=true) int countryId) {
		logger.debug("countrySelectListDetail() countryId = {}", countryId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		
		String returnStr = "redirect:/country/countryList";
		
		List<CountryFile> list = countryService.countrySelectListCountryFile(countryId);
		
		if(list.size() != 0) {
			CountryAndCountryFile countryAndCountryFile = countryService.countryAndCountryFileMap(countryId);
			logger.debug("countrySelectListDetail() countryAndCountryFile = {}", countryAndCountryFile);
			model.addAttribute("countryAndCountryFile", countryAndCountryFile);
			returnStr = "country/countryDetail";
		}
		return returnStr;
	}
	
	//countryInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.GET)
    public String countryInsert(HttpSession session) {
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("countryInsert() 실행확인"); 
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}		
        return "country/countryInsert";
    }
	
	//countryInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.POST)
    public String countryInsert(CountryCommand countryCommand, HttpSession session) {	
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}	
		logger.debug("countryInsert() countryName = {}", countryCommand.getCountryName());
		String path = session.getServletContext().getRealPath("/resources");
		logger.debug("countryInsert() ResourcesRealPath = {}", path);
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		countryService.countryInsert(countryCommand, path);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/country/countryUpdate", method = RequestMethod.GET)
	public String countrySelectOne( Model model, HttpSession session, @RequestParam(value="countryId", required=true) int countryId) {
		logger.debug("countrySelectOne() countryId = {}", countryId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//매개변수로 받은 countryId값을 이요하여 하나의 country객체를 리턴받는다.
		Country country = countryService.countrySelectOne(countryId);		
		logger.debug("countrySelectOne() countryName = {}", country.getCountryName());
		//리턴받은 country객체를 model에 세팅한다.
		model.addAttribute("country", country);
		//업데이트폽으로 포워드 시킨다.
		return "country/countryUpdate";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/country/countryUpdate", method = RequestMethod.POST)
    public String countryUpdate(HttpSession session, Country country) {		
		logger.debug("countryUpdate() countryName = {}", country.getCountryName());
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		countryService.countryUpdate(country);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/country/countryDelete", method = RequestMethod.GET)
	public String countryDelete(HttpSession session, @RequestParam(value="countryId", required=true) int countryId) {
		logger.debug("countryDelete() countryId = {}", countryId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		String path = session.getServletContext().getRealPath("/resources");
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		countryService.countryDelete(countryId, path);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/country/countryList";
	}
}
