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

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityService;

@Controller
public class CityController{
   @Autowired
   private CityService cityService;
   
 //입력값과 리턴값을 확인하기위해 로거기능 사용
 	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
   
 
 	@RequestMapping(value="/city/cityList", method = RequestMethod.GET)
 	public String citySelcetList(Model model) {
 		List<City> list = cityService.citySelcetList();
 		logger.debug("citySelcetList() list = {}", list);
 		model.addAttribute("list", list);
 		return "city/cityList";
 	}
 	
 	
 	@RequestMapping(value="/city/cityInsert", method = RequestMethod.GET)
     public String cityInsert() {
 		logger.debug("cityInsert() 실행확인");
         return "city/cityInsert";
     }
 	
 	
 	@RequestMapping(value="/city/cityInsert", method = RequestMethod.POST)
     public String cityInsert(City city) {
 		logger.debug("cityInsert() cityName = {}", city.getCityName());
 		cityService.cityInsert(city);
         return "redirect:/city/cityList";
     }
 	
 	
 	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
 	public String citySelectOne( Model model, @RequestParam(value="cityId", required=true) int cityId) {
 		logger.debug("citySelectOne() cityId = {}", cityId);
 		City city = cityService.citySelectOne(cityId);
 		logger.debug("citySelectOne() cityName = {}", city.getCityName());
 		model.addAttribute("city", city);
 		
 		return "city/cityUpdate";
 	}
 	
 
 	@RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
     public String cityUpdate(City city) {		
 		logger.debug("cityUpdate() cityName = {}", city.getCityName());
 		cityService.cityUpdate(city);
        
         return "redirect:/city/cityList";
     }
 	
 	
 	@RequestMapping(value="/city/cityDelete", method = RequestMethod.GET)
 	public String cityDelete(@RequestParam(value="cityId", required=true) int cityId) {
 		logger.debug("cityDelete() cityId = {}", cityId);
 		cityService.cityDelete(cityId);
 		
 		return "redirect:/city/cityList";
 	}
 }