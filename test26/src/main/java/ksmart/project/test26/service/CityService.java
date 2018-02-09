package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CityService {
	@Autowired
	private CityDao cityDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	
	public List<City> citySelcetList(){
		List<City> list = cityDao.citySelectList();
		logger.debug("citySelcetList() list = {}", list);
		return list;
	}
	
	public int cityInsert(City city) {
		logger.debug("cityInsert() cityName = {}", city.getCityName());
		int row = cityDao.cityInsert(city);
		logger.debug("cityInsert() row = {}", row);
		return row;
	}
	
	public City citySelectOne(int cityId) {
		logger.debug("citySelectOne() cityId = {}", cityId);
		City city = cityDao.citySelectOneForUpdate(cityId);
		logger.debug("citySelectOne() city = {}", city);
		return city;
	}
	
	public int cityUpdate(City city) {
		logger.debug("cityUpdate() country = {}", city);
		int row = cityDao.cityUpdate(city); 
		logger.debug("cityUpdate() row = {}", row);
		return row;
	}
	
	public int cityDelete(int cityId) {
		logger.debug("cityDelete() cityId = {}", cityId);
		int row = cityDao.cityDelete(cityId);
		logger.debug("cityDelete() row = {}", row);
		return row;
	}
	
}
 