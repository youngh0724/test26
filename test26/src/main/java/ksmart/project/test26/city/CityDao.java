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
	//문자열을 상수화 시켜 경로작성을 용이하게 바꿔주었다
	private final String mapperRoot = "ksmart.project.test26.service.CityMapper.";
	
	//(전체해당)입력값과 리턴값을 확인하기위해 logger.debug 사용
	
	private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
	
	// 파일 업로드 처리에 필요한 cityFileID 조회 처리
	public CityFile citySelectOneCityFile(int cityFileId) {
		logger.debug("citySelectOneCityFile() cityFileId = {}", cityFileId);
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectOneCityFile", cityFileId);
	}
	
	// 업로드 된 파일 삭제 처리
	public int cityDeleteFile(int cityFileId) {
		logger.debug("cityDeleteFile() cityFileId = {}", cityFileId);
		return sqlSessionTemplate.delete(mapperRoot+"cityDeleteCityFile", cityFileId);
	}
	
	// 업로드된 파일 조회 처리
	public List<CityFile> citySelectListCityFile(int cityId){
		logger.debug("citySelectListDetail() cityId = {}", cityId);
		return sqlSessionTemplate.selectList(mapperRoot+"citySelectListCityFile", cityId);
	}
	
	// 파일 업로드 처리에 필요한 Mapping 처리
	public CityAndCityFile cityAndCityFileMap(int cityId){
		logger.debug("cityAndCityFileMap() cityId = {}", cityId);
		return sqlSessionTemplate.selectOne(mapperRoot+"cityAndCityFileMap", cityId);
	}
		
	// Mapping 처리
	public List<City> citySelectPage(Map map) {
		logger.debug("citySelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("citySelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("citySelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"citySelectPage", map);
	}
	
	// 전체 총합 카운트
	public int citySelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectCount");	
	}
	
	// 전체 리스트 조회
	public List<City> citySelectList(){
		logger.debug("citySelectList() 실행확인");
		//mapper에 id가 selectCityList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"citySelcetList");
	}
	
	// 업데이트에 필요한 cityId 조회 처리
	public City citySelectOneForUpdate(int cityId) {
		logger.debug("citySelectOneForUpdate() cityId = {}", cityId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 city객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"citySelectOne", cityId);
	}
	
	// 리스트 추가 처리
	public int cityInsert(City city) {
		logger.debug("cityInsert() city = {}", city);
		//city객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"cityInsert", city);
	}
	
	// 업로드 파일 추가 처리
	public int cityInsertFile(CityFile cityFile) {
		logger.debug("cityInsertFile() cityFileName : {}", cityFile.getFileName());
		logger.debug("cityInsertFile() cityFileExt : {}", cityFile.getFileExt());
		logger.debug("cityInsertFile() cityFileSize : {}", cityFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"cityInsertFile", cityFile);
	}
	
	// 업로드 파일 삭제 처리
	public int cityDeleteFile(CityFile cityFile) {
		return sqlSessionTemplate.insert(mapperRoot+"cityDeleteFile", cityFile);
	}
	
	// 리스트 업데이트 처리
	public int cityUpdate(City city) {
		logger.debug("cityUpdate() city = {}", city);
		//city객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"cityUpdate", city);
	}
	
	// 리스트 삭제처리
	public int cityDelete(int cityId) {
		logger.debug("cityDelete() cityId = {}", cityId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"cityDelete", cityId);
	}
}
