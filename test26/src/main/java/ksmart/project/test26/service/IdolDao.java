package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	//final을 적용시킴으로써 상수화시켜 선언
	private final String nameSpace = "ksmart.project.test26.service.IdolMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// select 쿼리문을 실행시키고 리턴
	public List<Idol> selectIdolList() {
		return sqlSessionTemplate.selectList(nameSpace + "selectIdolList");
	}

	// insert 쿼리문을 실행시키고 리턴
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(nameSpace + "insertIdol", idol);
	}

	// 수정처리시 한명의 아이돌 select 쿼리문 실행시키고 리턴
	public Idol getIdol(int idolId) {
		System.out.println(idolId + "<-- idolDao getIdol idolNo");
		return sqlSessionTemplate.selectOne(nameSpace + "selectListId", idolId);
	}

	// update 쿼리를 실행시키고 리턴
	public int updateIdol(Idol idol) {
		System.out.println(idol + "<-- idolDao");
		return sqlSessionTemplate.update(nameSpace + "IdolUpdate", idol);
	}

	// delete 쿼리를 실행시키고 리턴
	public int deleteIdol(int idolId) {
		return sqlSessionTemplate.delete(nameSpace + "deleteIdol", idolId);
	}

}
