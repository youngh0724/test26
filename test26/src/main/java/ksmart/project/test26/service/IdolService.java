package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {
	@Autowired
	private IdolDao idolDao;
	
	//Controller
	public List<Idol> idolSelectList(){
		List<Idol> list = idolDao.idolSelectList();
		return list;
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.insertIdol을 호출
	public void idolInsrt(Idol idol) {
		idolDao.idolInsrt(idol);
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.getIdol을 호출
	public Idol idolSelectOneForUpdate(int idolId) {
		Idol idol = idolDao.idolSelectOneForUpdate(idolId);
		return idol;
	} 
	//Controller에서 입력받을 값을 통해 idoDao.updateIdol을 호출
	public void idolUpdate(Idol idol) {
		idolDao.idolUpdate(idol);
	}
	//Controller에서 입력받을 값을 통해 idoDao.deleteIdol을 호출
	public void idolDelete(int idolId) {
		idolDao.idolDelete(idolId);
	}
}
