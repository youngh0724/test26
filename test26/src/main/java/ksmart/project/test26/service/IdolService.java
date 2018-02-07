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
	public List<Idol> selectIdolList(){
		List<Idol> list = idolDao.selectIdolList();
		return list;
	}
	public void insertIdol(Idol idol) {
		idolDao.insertIdol(idol);
	}
	public Idol getIdol(int idolId) {
		Idol idol = idolDao.getIdol(idolId);
		return idol;
	}
	public void IdolModify(Idol idol) {
		idolDao.updateIdol(idol);
	}
	public void deleteIdol(int idolId) {
		idolDao.deleteIdol(idolId);
	}
}
