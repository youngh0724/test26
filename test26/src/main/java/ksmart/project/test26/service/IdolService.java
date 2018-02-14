package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class IdolService {
	private final int LINE_PER_PAGE = 5;
	@Autowired
	private IdolDao idolDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
		private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	
		public Map<String, Object> idolSelectListByPage(int currentPage, int rowPerPage, String searchWord){
			
			logger.debug("idolSelectPage() map.startRow = {}", currentPage);
			logger.debug("idolSelectPage() map.rowPerPage = {}", rowPerPage);
			logger.debug("idolSelectPage() map.searchWord = {}", searchWord);
			
			int startRow = (currentPage-1)*rowPerPage;
			Map map = new HashMap();
			map.put("startRow", startRow);
			map.put("rowPerPage", rowPerPage);
			map.put("searchWord", searchWord);
			
			List<Idol> list = idolDao.idolSelectPage(map);
			logger.debug("idolSelectListByPage() list = {}", list);
			int totalCount = idolDao.idolSelectTotalCount();
			logger.debug("idolSelectListByPage() totalCount = {}", totalCount);
			
			Map returnMap = new HashMap();
			returnMap.put("list", list);
			returnMap.put("totalCount", totalCount);
			
			return returnMap;
		}	
		
	
	public List<Idol> idolSelectList(int startRow){
		List<Idol> list = idolDao.idolSelectList();
		logger.debug("idolSelectList() list = {}", list);
		return list;
		
	}
	
	public int idolInsert(Idol idol) {
		logger.debug("idolInsert() idolName = {}", idol.getIdolName());
		int row = idolDao.idolInsert(idol);
		logger.debug("idolInsert() row = {}", row);
		return row;
	}
	
	public Idol idolSelectOne(int idolId) {
		logger.debug("idolSelectOne() idolId = {}", idolId);
		Idol idol = idolDao.idolSelectOneForUpdate(idolId);
		logger.debug("idolSelectOne() idol = {}", idol);
		return idol;
	}
	
	public int idolUpdate(Idol idol) {
		logger.debug("idolUpdate() idol = {}", idol);
		int row = idolDao.idolUpdate(idol); 
		logger.debug("idolUpdate() row = {}", row);
		return row;
	}
	
	public int idolDelete(int idolId) {
		logger.debug("idolDelete() idolId = {}", idolId);
		int row = idolDao.idolDelete(idolId);
		logger.debug("idolDelete() row = {}", row);
		return row;
	}
	
}
 