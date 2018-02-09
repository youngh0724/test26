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
	
	public List<Country> countrySelcetList(){
		List<Country> list = countryDao.countrySelectList();
		return list;
	}
	
	public int countryInsert(Country country) {
		int row = countryDao.countryInsert(country);
		return row;
	}
	
	public Country countrySelectOne(int countryId) {
		Country country = countryDao.countrySelectOneForUpdate(countryId);
		return country;
	}
	
	public int countryUpdate(Country country) {
		int row = countryDao.countryUpdate(country); 
		return row;
	}
	
	public int countryDelete(int countryId) {
		int row = countryDao.countryDelete(countryId);
		return row;
	}
	
}
