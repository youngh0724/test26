package ksmart.project.test26.country;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.country.dto.Country;
import ksmart.project.test26.country.dto.CountryAndCountryFile;
import ksmart.project.test26.country.dto.CountryFile;

@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "ksmart.project.test26.service.CountryMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CountryDao.class);
	
	//countryDetail.jsp에서 다운로드 클릭시 들어오는 요청 처리
	public CountryFile countrySelectOneCountryFile(int countryFileId) {
		logger.debug("countrySelectOneCountryFile() countryFileId = {}", countryFileId);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"countrySelectOneCountryFile", countryFileId);
	}
	
	//db에서 파일의 정보를 삭제한다.
	public int countrtyDeleteFile(int countryFileId) {
		logger.debug("countrtyDeleteFile() countryFileId = {}", countryFileId);
		
		return sqlSessionTemplate.delete(mapperRoot+"countryDeleteCountryFile", countryFileId);
	}
	
	//countryList.jsp에서 countryName을 클릭시 들어오는 요청 처리
	public List<CountryFile> countrySelectListCountryFile(int countryId){
		
		logger.debug("countrySelectListDetail() countryId = {}", countryId);
		return sqlSessionTemplate.selectList(mapperRoot+"countrySelectListCountryFile", countryId);
	}
	
	//countryList.jsp에서 countryName을 클릭시 들어오는 요청 처리 중 country_file테이블의 정보를 조회하는 요청 처리
	public CountryAndCountryFile countryAndCountryFileMap(int countryId){
		logger.debug("countryAndCountryFileMap() countryId = {}", countryId);
		return sqlSessionTemplate.selectOne(mapperRoot+"countryAndCountryFileMap", countryId);
	}
		
	//countryList.jsp에서 사용될 list정보를 받아오는 요청 처리
	public List<Country> countrySelectPage(Map map) {
		logger.debug("countrySelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("countrySelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("countrySelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"countrySelectPage", map);
	}
	
	//country테이블에 정보가 총 몇개인지를 조회하는 요청 처리
	public int countrySelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"countrySelectCount");	
	}
	
	//컨트롤러에서 전체 리스트를 조회할때 사용되어지는 메서드 
	public List<Country> countrySelectList(){
		logger.debug("countrySelectList() 실행확인");
		//mapper에 id가 selectCountryList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"countrySelcetList");
	}
	
	public Country countrySelectOneForUpdate(int countryId) {
		logger.debug("countrySelectOneForUpdate() countryId = {}", countryId);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 country객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"countrySelectOne", countryId);
	}
	
	public int countryInsert(Country country) {
		logger.debug("countryInsert() country = {}", country);
		//country객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"countryInsert", country);
	}
	
	public int countryInsertFile(CountryFile countryFile) {
		logger.debug("countryInsertFile() countryFileName : {}", countryFile.getFileName());
		logger.debug("countryInsertFile() countryFileExt : {}", countryFile.getFileExt());
		logger.debug("countryInsertFile() countryFileSize : {}", countryFile.getFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"countryInsertFile", countryFile);
	}
	
	public int countryDeleteFile(CountryFile countryFile) {
		return sqlSessionTemplate.insert(mapperRoot+"countryDeleteFile", countryFile);
	}
	
	public int countryUpdate(Country country) {
		logger.debug("countryUpdate() country = {}", country);
		//country객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"countryUpdate", country);
	}
	
	public int countryDelete(int countryId) {
		logger.debug("countryDelete() countryId = {}", countryId);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"countryDelete", countryId);
	}
}
