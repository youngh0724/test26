package ksmart.project.test26;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	//countryList.jsp view파일을 요청
	@RequestMapping(value="/country/countryList", method = RequestMethod.GET)
	public String countrySelcetList(Model model) {	
		//countryDao의 selectCountryList메서드를 실행시켜 결과값을 리스트에 저장한다.
		List<Country> list = countryService.countrySelcetList();
		//list에 들어있는 값을 확인해본다.
		logger.debug("countrySelcetList() list = {}", list);
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		return "country/countryList";
	}
	
	//countryInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.GET)
    public String countryInsert() {
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("countryInsert() 실행확인"); 
        return "country/countryInsert";
    }
	
	//countryInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.POST)
    public String countryInsert(Country country) {		
		logger.debug("countryInsert() countryName = {}", country.getCountryName());
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		countryService.countryInsert(country);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/country/countryUpdate", method = RequestMethod.GET)
	public String countrySelectOne( Model model, @RequestParam(value="countryId", required=true) int countryId) {
		logger.debug("countrySelectOne() countryId = {}", countryId);
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
    public String countryUpdate(Country country) {		
		logger.debug("countryUpdate() countryName = {}", country.getCountryName());
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		countryService.countryUpdate(country);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/country/countryDelete", method = RequestMethod.GET)
	public String countryDelete(@RequestParam(value="countryId", required=true) int countryId) {
		logger.debug("countryDelete() countryId = {}", countryId);
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		countryService.countryDelete(countryId);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/country/countryList";
	}
}
