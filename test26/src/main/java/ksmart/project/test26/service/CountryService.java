package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryDao countryDao;
	
	public List<Country> selectCountryListService(){
		List<Country> list = countryDao.selectCountryList();
		return list;
	}
	
	public int countryNameAddService(Country country) {
		int row = countryDao.insertCountry(country);
		return row;
	}
	
	public Country countryNameUpdateService(int countryId) {
		Country country = countryDao.selectCountryOne(countryId);
		return country;
	}
	
	public int countryNameUpdateService(Country country) {
		int row = countryDao.updateCountry(country); 
		return row;
	}
	
	public int countryNameDeleteService(int countryId) {
		int row = countryDao.deleteCountry(countryId);
		return row;
	}
	
}
