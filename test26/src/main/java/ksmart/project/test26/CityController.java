package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityDao;

@Controller
public class CityController{
   @Autowired
   private CityDao citydao;
   @RequestMapping(value="/city/cityList")
   public String cityList(Model model) {
      List<City> list = citydao.selectCityList();
      model.addAttribute("list",list);
      return "/city/cityList";
   }
   
   // city/cityUpdate에서  get 방식으로 호출하여 한명 리스트 출력
   @RequestMapping(value="/city/cityUpdate", method = RequestMethod.GET)
   public String citySelectOne(Model model, @RequestParam(value="city_id", required=true) int city_id) {
	   City city = citydao.getCity(city_id);
      model.addAttribute("city", city);
      return "/city/cityUpdate";
   }
   
   // city/cityUpdate에서 post 방식으로 호출 
   @RequestMapping(value="/city/cityUpdate", method = RequestMethod.POST)
   public String cityUpdate(City city) {
      citydao.updateCity(city);
      return "redirect:/city/cityList";
   }
   
   // city INSERT 입력부분
   @RequestMapping(value="city/cityInsert", method = RequestMethod.GET)
   public String cityInsert() {
      return "/city/cityInsert";
   }
   
   // city INSERT
   @RequestMapping(value="/city/cityInsert", method = RequestMethod.POST)
   public String cityInsert(City city) {
      citydao.insertCity(city);
      return "redirect:/city/cityList";
   }
   
   // city DELETE
   @RequestMapping(value="/city/cityDelete", method = RequestMethod.GET)
      public String cityDelete(@RequestParam(value="city_id", required=true) int city_id) {
         citydao.deleteCity(city_id);
         return "redirect:/city/cityList";
   }
}