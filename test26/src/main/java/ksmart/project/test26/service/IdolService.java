package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {
	private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	@Autowired
	private IdolDao idolDao;
	
	//Controller
	public List<Idol> idolSelectList(){
		List<Idol> list = idolDao.idolSelectList();
		logger.debug("idolSelectList idol = {}", list);
		return list;
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.insertIdol을 호출
	public int idolInsert(Idol idol) {
		int row = idolDao.idolInsert(idol);
		logger.debug("idolInsert idol = {}", idol.getIdolName());
		return row;
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.getIdol을 호출
	public Idol idolSelectOneForUpdate(int idolId) {
		Idol idol = idolDao.idolSelectOneForUpdate(idolId);
		logger.debug("idolSelectOneForUpdate idol = {}", idolId);
		return idol;
	} 
	//Controller에서 입력받을 값을 통해 idoDao.updateIdol을 호출
	public int idolUpdate(Idol idol) {
		int row = idolDao.idolUpdate(idol);
		logger.debug("idolUpdate idol = {}", idol.getIdolId());
		logger.debug("idolUpdate idol = {}", idol.getIdolName());
		return row;
	}
	//Controller에서 입력받을 값을 통해 idoDao.deleteIdol을 호출
	public int idolDelete(int idolId) {
		int row = idolDao.idolDelete(idolId);
		logger.debug("idolDelete idol = {}", idolId);
		return row;
		
	}
}
