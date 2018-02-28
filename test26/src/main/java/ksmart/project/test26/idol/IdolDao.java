package ksmart.project.test26.idol;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart.project.test26.idol.dto.IdolFile;
import ksmart.project.test26.idol.dto.Idol;
import ksmart.project.test26.idol.dto.IdolAndIdolFile;
import ksmart.project.test26.idol.dto.IdolCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class IdolDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.idol.IdolMapper.";
	//업로드 된 파일 삭제
	public int idolDeleteFile(int idolFileId) {
		logger.debug("idolDeleteFile() idolFileId = {}", idolFileId);
		return sqlSessionTemplate.delete(mapperRoot+"idolDeleteIdolFile", idolFileId);
	}
	
	
	//업로드 된 하나의 파일 정보 가져오기
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
		
		public List<IdolFile> idolSelectListIdolFile(int idolId){
			
			logger.debug("idolSelectListDetail() idolId = {}", idolId);
			return sqlSessionTemplate.selectList(mapperRoot+"idolSelectListIdolFile", idolId);
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
	//아이돌 전체 리스트 	
	public List<Idol> idolSelectList(){
		logger.debug("idolSelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"idolSelectList");
	}
	//업데이틀 위한 한명의 회원정보 
	public Idol idolSelectOneForUpdate(int idolId) {
		logger.debug("idolSelectOneForUpdate() idolId = {}", idolId);
		return sqlSessionTemplate.selectOne(mapperRoot+"idolSelectOne", idolId);
	}
	//아이돌 등록하기
	public int idolInsert(IdolCommand idolCommand) {
		logger.debug("idolInsert() idolCommand = {}", idolCommand);
		return sqlSessionTemplate.insert(mapperRoot+"idolInsert", idolCommand);
	}
	//아이돌 파일 업데이트
	public int idolInsertFile(IdolFile idolfile) {
		logger.debug("insertArticleFile() articleFileName : {}", idolfile.getIdolFileName());
		logger.debug("insertArticleFile() articleFileExt : {}", idolfile.getIdolFileExt());
		logger.debug("insertArticleFile() articleFileSize : {}", idolfile.getIdolFileSize());
		return sqlSessionTemplate.insert(mapperRoot+"idolInsertFile", idolfile);
	}
	//아이돌 수정처리
	public int idolUpdate(Idol idol) {
		logger.debug("idolUpdate() idol = {}", idol);
		return sqlSessionTemplate.update(mapperRoot+"idolUpdate", idol);
	}
	//아이돌 삭제
	public int idolDelete(int idolId) {
		logger.debug("idolDelete() = {}", idolId);
		return sqlSessionTemplate.delete(mapperRoot+"idolDelete", idolId);
	}
}
