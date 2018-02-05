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
	//아이돌 목록보기
	public List<Idol> selectIdolList(){
		return sqlSessionTemplate.selectList(nameSpace +"selectIdolList");
	}
	//아이돌 등록
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(nameSpace + "insertIdol", idol);
	}
	//업데이트 할 한명의 정보 가져오기
	public Idol getIdol(int idolId) {
		System.out.println(idolId +"<-- idolDao getIdol idolNo");
		return sqlSessionTemplate.selectOne(nameSpace + "selectListId", idolId);
	}
	//아이돌 업데이트
	public int updateIdol(Idol idol) {
		return sqlSessionTemplate.insert(nameSpace + "updateIdol", idol);
	}
}
