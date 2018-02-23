package ksmart.project.test26.idol;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.country.dto.CountryFile;
import ksmart.project.test26.idol.dto.Idol;
import ksmart.project.test26.idol.dto.IdolAndIdolFile;
import ksmart.project.test26.idol.dto.IdolCommand;
import ksmart.project.test26.idol.dto.IdolFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class IdolDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.idol.IdolMapper.";
	
	
	//다운로드 
	public IdolFile idolSelectOneIdolFile(int idolFileId) {
		logger.debug("idolSelectOneIdolFile() idolFileId = {}", idolFileId);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"idolSelectOneIdolFile", idolFileId);
	}
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(IdolDao.class);
		
		public IdolAndIdolFile idolAndIdolFileMap(int idolId){
			logger.debug("idolAndIdolFileMap() idolId = {}", idolId);
			return sqlSessionTemplate.selectOne(mapperRoot+"idolAndIdolFileMap", idolId);
		}
		
		public List<IdolFile> countrySelectListCountryFile(int idolId){
			
			logger.debug("countrySelectListDetail() countryId = {}", idolId);
			return sqlSessionTemplate.selectList(mapperRoot+"countrySelectListCountryFile", idolId);
		}
	
		public List<Idol> idolSelectPage(Map<String, Object> map) {
			logger.debug("idolSelectPage() map.startRow = {}", map.get("startRow"));
			logger.debug("idolSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
			logger.debug("idolSelectPage() map.searchWord = {}", map.get("searchWord"));
			return sqlSessionTemplate.selectList(mapperRoot+"idolSelectPage", map);
		}
		
		public int idolSelectTotalCount() {
			logger.debug("idolSelectTotalCount() 실행확인"); 
			return sqlSessionTemplate.selectOne(mapperRoot+"idolSelectCount");	
		}
		
	public List<Idol> idolSelectList(){
		logger.debug("idolSelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"idolSelectList");
	}
	
	public Idol idolSelectOneForUpdate(int idolId) {
		logger.debug("idolSelectOneForUpdate() idolId = {}", idolId);
		return sqlSessionTemplate.selectOne(mapperRoot+"idolSelectOne", idolId);
	}
	
	public int idolInsert(IdolCommand idolCommand) {
		logger.debug("idolInsert() idolCommand = {}", idolCommand);
		return sqlSessionTemplate.insert(mapperRoot+"idolInsert", idolCommand);
	}
	
	public int idolInsertFile(IdolFile idolfile) {
		logger.debug("insertArticleFile() articleFileName : {}", idolfile.getIdolFileName());
		logger.debug("insertArticleFile() articleFileExt : {}", idolfile.getIdolFileExt());
		logger.debug("insertArticleFile() articleFileSize : {}", idolfile.getIdolFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"idolInsertFile", idolfile);
	}
	
	public int idolUpdate(Idol idol) {
		logger.debug("idolUpdate() idol = {}", idol);
		return sqlSessionTemplate.update(mapperRoot+"idolUpdate", idol);
	}
	
	public int idolDelete(int idolId) {
		logger.debug("idolDelete() = {}", idolId);
		return sqlSessionTemplate.delete(mapperRoot+"idolDelete", idolId);
	}
}
