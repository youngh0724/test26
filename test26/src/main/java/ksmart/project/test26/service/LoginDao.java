package ksmart.project.test26.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "ksmart.project.test26.service.LoginMapper.";
	
	public Member loginSelectOne(Member member) {	
		return sqlSessionTemplate.selectOne(mapperRoot+"loginSelectOne", member);
	}

}
