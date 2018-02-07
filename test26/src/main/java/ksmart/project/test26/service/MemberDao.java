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
	public List<Member> selectMemberList(){
		return sqlSessionTemplate.selectList(mapperRoot+"selectMemberList");
	}
	
	//select one movie
	public Member getMember(int memberNo) {
		return sqlSessionTemplate.selectOne(mapperRoot+"memberSelect", memberNo);
	}
	//update movie
	public int memberUpdate(Member member) {
		return sqlSessionTemplate.update(mapperRoot+"memberUpdate", member);
	}
	
	
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert(mapperRoot+"insertMember", member);
	}
	
	public int deleteMember(String memberId) {
		return sqlSessionTemplate.delete(mapperRoot+"deleteMember", memberId);
	}
	
}