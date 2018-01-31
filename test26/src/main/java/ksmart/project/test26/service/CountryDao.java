package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sst;
	public List<Country> selectCountryList(){
		return sst.selectList("ksmart.project.test26.service.CountryMapper.selectCountryList");
	}
	
}
