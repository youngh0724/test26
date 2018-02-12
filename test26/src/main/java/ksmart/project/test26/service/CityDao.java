package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.CityMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
	
		public List<City> citySelectPage(Map<String, Object> map) {
			logger.debug("citySelectPage() map = {}", map);
			return sqlSessionTemplate.selectList(mapperRoot+"citySelectPage", map);
		}
		
		public int citySelectTotalCount() {
			logger.debug("citySelectTotalCount() 실행확인"); 
			return sqlSessionTemplate.selectOne(mapperRoot+"citySelectCount");	
		}
		
		
	public List<City> citySelectList(){
		logger.debug("citySelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"citySelectList");
	}
	
	public City citySelectOneForUpdate(int cityId) {
		logger.debug("citySelectOneForUpdate() cityId = {}", cityId);
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectOne", cityId);
	}
	
	public int cityInsert(City city) {
		logger.debug("cityInsert() city = {}", city);
		return sqlSessionTemplate.insert(mapperRoot+"cityInsert", city);
	}
	
	public int cityUpdate(City city) {
		logger.debug("cityUpdate() city = {}", city);
		return sqlSessionTemplate.update(mapperRoot+"cityUpdate", city);
	}
	
	public int cityDelete(int cityId) {
		logger.debug("cityDelete() = {}", cityId);
		return sqlSessionTemplate.delete(mapperRoot+"cityDelete", cityId);
	}
}
