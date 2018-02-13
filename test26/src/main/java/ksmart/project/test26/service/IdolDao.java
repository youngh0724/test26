package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	private static final Logger logger = LoggerFactory.getLogger(IdolDao.class);
	//final을 적용시킴으로써 상수화시켜 선언
	private final String mapperRoot = "ksmart.project.test26.service.IdolMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Idol> idolSelectPage(Map map) {
		logger.debug("idolSelectPage() map = {}", map);
		logger.debug("idolSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("idolSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("idolSelectPage() map.word = {}", map.get("word"));
		return sqlSessionTemplate.selectList(mapperRoot+"idolSelectPage", map);
	}
	
	public int idolSelectTotalCount() {
		logger.debug("idolSelectTotalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"idolSelectCount");	
	}	
	
	// select 쿼리문을 실행시키고 리턴
	public List<Idol> idolSelectList() {
		return sqlSessionTemplate.selectList(mapperRoot + "idolSelectList");
	}

	// insert 쿼리문을 실행시키고 리턴
	public int idolInsert(Idol idol) {
		logger.debug("idolInsert idol = {}", idol.getIdolName());
		return sqlSessionTemplate.insert(mapperRoot + "idolInsrt", idol);
	}

	// 수정처리시 한명의 아이돌 select 쿼리문 실행시키고 리턴
	public Idol idolSelectOneForUpdate(int idolId) {
		//System.out.println(idolId + "<-- idolDao idolSelectOneForUpdate idolNo");
		logger.debug("idolSelectOneForUpdate idolId = {}", idolId);
		return sqlSessionTemplate.selectOne(mapperRoot + "idolSelectOneForUpdate", idolId);
	}

	// update 쿼리를 실행시키고 리턴
	public int idolUpdate(Idol idol) {
		//System.out.println(idol + "<-- idolDao");
		logger.debug("idolUpdate idolId = {}", idol.getIdolId());
		logger.debug("idolUpdate idolName = {}", idol.getIdolName());
		return sqlSessionTemplate.update(mapperRoot + "IdolUpdate", idol);
	}

	// delete 쿼리를 실행시키고 리턴
	public int idolDelete(int idolId) {
		logger.debug("idolDelete idolId = {}", idolId);
		return sqlSessionTemplate.delete(mapperRoot + "idolDelete", idolId);
	}

}
