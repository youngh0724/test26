package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "ksmart.project.test26.service.CountryMapper.";
	
	public List<Country> countrySelectList(){
		//mapper에 id가 selectCountryList인 쿼리문을 실행시키고 결과값을 리턴한다.
		return sqlSessionTemplate.selectList(mapperRoot+"countrySelcetList");
	}
	
	public Country countrySelectOneForUpdate(int countryId) {
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 country객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"countrySelectOne", countryId);
	}
	
	public int countryInsert(Country country) {
		//country객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"countryInsert", country);
	}
	
	public int countryUpdate(Country country) {
		//country객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"countryUpdate", country);
	}
	
	public int countryDelete(int countryId) {
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"countryDelete", countryId);
	}
}
