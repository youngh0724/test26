package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.CityMapper.";
	//city list
	public List<City> selectCityList(){
		return sqlSessionTemplate.selectList(mapperRoot+"selectCityList");
	}
	//insert city
	public int insertCity(City city) {
		return sqlSessionTemplate.insert(mapperRoot+"insertCity", city);
	}
	//select one city
	public City getCity(int cityId) {
		return sqlSessionTemplate.selectOne(mapperRoot+"selectCity", cityId);
	}
	//update city
	public int updateCity(City city) {
		return sqlSessionTemplate.update(mapperRoot+"updateCity", city);
	}
	//delete city
	public int deleteCity(int cityId) {
		return sqlSessionTemplate.delete(mapperRoot+"deleteCity", cityId);
	}
}