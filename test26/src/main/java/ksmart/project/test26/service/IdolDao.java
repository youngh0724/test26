package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	private final String nameSpace = "ksmart.project.test26.service.IdolMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// idolList
	public List<Idol> selectIdolList() {
		return sqlSessionTemplate.selectList(nameSpace + "selectIdolList");
	}

	// idolInsert
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(nameSpace + "insertIdol", idol);
	}

	// idolselectOne
	public Idol getIdol(int idolId) {
		System.out.println(idolId + "<-- idolDao getIdol idolNo");
		return sqlSessionTemplate.selectOne(nameSpace + "selectListId", idolId);
	}

	// idolUpdate
	public int updateIdol(Idol idol) {
		System.out.println(idol + "<-- idolDao");
		return sqlSessionTemplate.update(nameSpace + "IdolUpdate", idol);
	}

	// idoldelete
	public int deleteIdol(int idolId) {
		return sqlSessionTemplate.delete(nameSpace + "deleteIdol", idolId);
	}

}
