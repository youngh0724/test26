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
	public List<Idol> selectIdolList(){
		return sqlSessionTemplate.selectList(nameSpace +"selectIdolList");
	}
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(nameSpace + "insertIdol", idol );
	}
}
