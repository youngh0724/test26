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
	public List<Idol> selectIdolList(){
		List<Idol> list = idolDao.selectIdolList();
		return list;
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.insertIdol을 호출
	public void insertIdol(Idol idol) {
		idolDao.insertIdol(idol);
	}
	//Controller에서 매개변수를 입력받을 값을 통해 idoDao.getIdol을 호출
	public Idol getIdol(int idolId) {
		Idol idol = idolDao.getIdol(idolId);
		return idol;
	} 
	//Controller에서 입력받을 값을 통해 idoDao.updateIdol을 호출
	public void IdolModify(Idol idol) {
		idolDao.updateIdol(idol);
	}
	//Controller에서 입력받을 값을 통해 idoDao.deleteIdol을 호출
	public void deleteIdol(int idolId) {
		idolDao.deleteIdol(idolId);
	}
}
