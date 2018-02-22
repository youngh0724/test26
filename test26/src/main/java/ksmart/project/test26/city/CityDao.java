package ksmart.project.test26.city;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.city.dto.City;
import ksmart.project.test26.city.dto.CityAndCityFile;
import ksmart.project.test26.city.dto.CityFile;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "ksmart.project.test26.service.CityMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
	
	public CityFile citySelectOneCityFile(int cityFileId) {
		logger.debug("citySelectOneCityFile() cityFileId = {}", cityFileId);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectOneCityFile", cityFileId);
	}
	
	public int countrtyDeleteFile(int cityFileId) {
		logger.debug("countrtyDeleteFile() cityFileId = {}", cityFileId);
		
		return sqlSessionTemplate.delete(mapperRoot+"cityDeleteCityFile", cityFileId);
	}
	
	public List<CityFile> citySelectListCityFile(int cityId){
		
		logger.debug("citySelectListDetail() cityId = {}", cityId);
		return sqlSessionTemplate.selectList(mapperRoot+"citySelectListCityFile", cityId);
	}
	
	public CityAndCityFile cityAndCityFileMap(int cityId){
		logger.debug("cityAndCityFileMap() cityId = {}", cityId);
		return sqlSessionTemplate.selectOne(mapperRoot+"cityAndCityFileMap", cityId);
	}
		
	public List<City> citySelectPage(Map map) {
		logger.debug("citySelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("citySelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("citySelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"citySelectPage", map);
	}
	
	public int citySelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectCount");	
	}
	
	public List<City> citySelectList(){
		logger.debug("citySelectList() 실행확인");
		//mapper에 id가 selectCityList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"citySelcetList");
	}
	
	public City citySelectOneForUpdate(int cityId) {
		logger.debug("citySelectOneForUpdate() cityId = {}", cityId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 city객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectOne", cityId);
	}
	
	public int cityInsert(City city) {
		logger.debug("cityInsert() city = {}", city);
		//city객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"cityInsert", city);
	}
	
	public int cityInsertFile(CityFile cityFile) {
		logger.debug("cityInsertFile() cityFileName : {}", cityFile.getFileName());
		logger.debug("cityInsertFile() cityFileExt : {}", cityFile.getFileExt());
		logger.debug("cityInsertFile() cityFileSize : {}", cityFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"cityInsertFile", cityFile);
	}
	
	public int cityDeleteFile(CityFile cityFile) {
		return sqlSessionTemplate.insert(mapperRoot+"cityDeleteFile", cityFile);
	}
	
	public int cityUpdate(City city) {
		logger.debug("cityUpdate() city = {}", city);
		//city객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"cityUpdate", city);
	}
	
	public int cityDelete(int cityId) {
		logger.debug("cityDelete() cityId = {}", cityId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"cityDelete", cityId);
	}
}
