package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.MemberMapper.";
	//movie list
	public List<Member> memberSelectList(){
		return sqlSessionTemplate.selectList(mapperRoot+"memberSelectList");
	}
	
	//select one movie
	public Member memberSelectOneForUpdate(int memberNo) {
		return sqlSessionTemplate.selectOne(mapperRoot+"memberSelectOne", memberNo);
	}
	//update movie
	public int memberUpdate(Member member) {
		return sqlSessionTemplate.update(mapperRoot+"memberUpdate", member);
	}
	
	
	public int memberInsert(Member member) {
		return sqlSessionTemplate.insert(mapperRoot+"memberInsert", member);
	}
	
	public int memberDelete(String memberId) {
		return sqlSessionTemplate.delete(mapperRoot+"memberDelete", memberId);
	}
	
}