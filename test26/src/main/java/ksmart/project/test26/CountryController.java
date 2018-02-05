package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

@Controller
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	//countryList.jsp view파일을 요청
	@RequestMapping(value="/country/countryList", method = RequestMethod.GET)
	public String countryList(Model model) {	
		//countryDao의 selectCountryList메서드를 실행시켜 결과값을 리스트에 저장한다.
		List<Country> list = countryDao.selectCountryList();
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		return "country/countryList";
	}
	
	//countryInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.GET)
    public String countryNameAdd() {
		//처리하는 내용은 없고 단순 입력폭 파일로 포워드 시켜준다.
        System.out.println("ksmart.project.test26 CountryController.java countryNameAdd 폼 요청");
        return "country/countryInsertForm";
    }
	
	//countryInserForm 입력폼에서 입력받은 값을 db에 insert하는 action을 요청
	@RequestMapping(value="/country/countryInsert", method = RequestMethod.POST)
    public String countryNameAdd(Country country) {		
		System.out.println("ksmart.project.test26 CountryController.java countryNameAdd action 요청");
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
        countryDao.insertCountry(country);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//업데이트 폼페이지 요청
	@RequestMapping(value="/country/countryUpdate", method = RequestMethod.GET)
	public String countryNameUpdate( Model model, @RequestParam(value="countryId", required=true) int countryId) {
		System.out.println("ksmart.project.test26 CountryController.java countryNameUpdate 폼 요청");
		//매개변수로 받은 countryId값을 이요하여 하나의 country객체를 리턴받는다.
		Country country = countryDao.selectCountryOne(countryId);
		//리턴받은 country객체를 model에 세팅한다.
		model.addAttribute("country", country);
		//업데이트폽으로 포워드 시킨다.
		return "country/countryUpdateForm";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/country/countryUpdate", method = RequestMethod.POST)
    public String countryNameUpdate(Country country) {		
		System.out.println("ksmart.project.test26 CountryController.java countryNameUpdate action 요청");
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
        countryDao.updateCountry(country);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/country/countryList";
    }
	
	//삭제 action 요청
	@RequestMapping(value="/country/countryDelete", method = RequestMethod.GET)
	public String countryNameDelete(@RequestParam(value="countryId", required=true) int countryId) {
		System.out.println("ksmart.project.test26 CountryController.java countryNameDelete action 요청");
		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출
		countryDao.deleteCountry(countryId);
		//리스트페이지로 리다이렉트 시킨다.
		return "redirect:/country/countryList";
	}
}
