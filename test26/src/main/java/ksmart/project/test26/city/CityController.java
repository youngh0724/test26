package ksmart.project.test26.city;

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

import ksmart.project.test26.city.dto.City;
import ksmart.project.test26.city.dto.CityAndCityFile;
import ksmart.project.test26.city.dto.CityCommand;
import ksmart.project.test26.city.dto.CityFile;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	
	//(전체해당)입력값과 리턴값을 확인하기위해 logger.debug 사용
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);

	@RequestMapping(value="/city/cityFileDown", method = RequestMethod.GET)
	public ModelAndView cityFileDownload(HttpSession session,
			@RequestParam(value="cityFileId", required=true) int cityFileId) {
		logger.debug("cityFileDownload() cityFileId = {}", cityFileId);
		String path = session.getServletContext().getRealPath("/resources");
		
		File downloadFile = cityService.cityFileDownload(cityFileId, path);
		
		logger.debug("cityFileDownload() downloadFile = {}", downloadFile);
				
		return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	}
	
	@RequestMapping(value="/city/cityDeleteFile", method = RequestMethod.GET)
	public String cityDeleteFile(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value="cityFileId", required=true) int cityFileId) {
		logger.debug("cityDeleteFile() cityFileId = {}", cityFileId);
		String path = session.getServletContext().getRealPath("/resources");
		int cityId = cityService.cityDeleteFile(cityFileId, path);	
		redirectAttributes.addAttribute("cityId", cityId);
		return "redirect:/city/cityDetail";
	}	
	
	//cityList.jsp view파일을 요청
	@RequestMapping(value="/city/cityList", method = RequestMethod.GET)
	public String citySelcetList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
				
		logger.debug("citySelcetList() currentPage = {}", currentPage);
		logger.debug("citySelcetList() rowPerPage = {}", rowPerPage);
		logger.debug("citySelectPage() searchWord = {}", searchWord);
		Map map = cityService.citySelectListByPage(currentPage, rowPerPage, searchWord);
		//list에 들어있는 값을 확인해본다.
		logger.debug("citySelcetList() map = {}", map);
		
		List<City> list = (List<City>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "city/cityList";
	}
	
	// cityDetail.jsp view파일 요청
	@RequestMapping(value="/city/cityDetail", method = RequestMethod.GET)
	public String citySelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="cityId", required=true) int cityId) {
		logger.debug("citySelectListDetail() cityId = {}", cityId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		
		String returnStr = "redirect:/city/cityList";
		
		List<CityFile> list = cityService.citySelectListCityFile(cityId);
		
		if(list.size() != 0) {
			CityAndCityFile cityAndCityFile = cityService.cityAndCityFileMap(cityId);
			logger.debug("citySelectListDetail() cityAndCityFile = {}", cityAndCityFile);
			model.addAttribute("cityAndCityFile", cityAndCityFile);
			returnStr = "city/cityDetail";
		}
		return returnStr;
	}
	
	//cityInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/city/cityInsert", method = RequestMethod.GET)
    public String cityInsert(HttpSession session) {
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("cityInsert() 실행확인"); 
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}		
        return "city/cityInsert";
    }
	
	//cityInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/city/cityInsert", method = RequestMethod.POST)
    public String cityInsert(CityCommand cityCommand, HttpSession session) {	
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}	
		logger.debug("cityInsert() cityName = {}", cityCommand.getCityName());
		String path = session.getServletContext().getRealPath("/resources");
		logger.debug("cityInsert() ResourcesRealPath = {}", path);
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		cityService.cityInsert(cityCommand, path);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/city/cityList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
	public String citySelectOne( Model model, HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		logger.debug("citySelectOne() cityId = {}", cityId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//매개변수로 받은 cityId값을 이요하여 하나의 city객체를 리턴받는다.
		City city = cityService.citySelectOne(cityId);		
		logger.debug("citySelectOne() cityName = {}", city.getCityName());
		//리턴받은 city객체를 model에 세팅한다.
		model.addAttribute("city", city);
		//업데이트폽으로 포워드 시킨다.
		return "city/cityUpdate";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
    public String cityUpdate(HttpSession session, City city) {		
		logger.debug("cityUpdate() cityName = {}", city.getCityName());
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		cityService.cityUpdate(city);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/city/cityList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/city/cityDelete", method = RequestMethod.GET)
	public String cityDelete(HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		logger.debug("cityDelete() cityId = {}", cityId);
		
		if(session.getAttribute("loginMember") == null) {
			return "sessionError";
		}
		String path = session.getServletContext().getRealPath("/resources");
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		cityService.cityDelete(cityId, path);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/city/cityList";
	}
}
