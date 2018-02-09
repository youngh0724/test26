package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "ksmart.project.test26.service.MemberMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	//movie list
	public List<Member> memberSelectList(){
		logger.debug("memberSelectList() 실행확인");
		return sqlSessionTemplate.selectList(mapperRoot+"memberSelectList");
	}
	
	//select one movie
	public Member memberSelectOneForUpdate(int memberNo) {
		logger.debug("memberSelectOneForUpdate() memberNo = {}", memberNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"memberSelectOne", memberNo);
	}
	//update movie
	public int memberUpdate(Member member) {
		logger.debug("memberUpdate() member = {}", member);
		return sqlSessionTemplate.update(mapperRoot+"memberUpdate", member);
	}
	
	
	public int memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		return sqlSessionTemplate.insert(mapperRoot+"memberInsert", member);
	}
	
	public int memberDelete(String memberId) {
		logger.debug("memberDelete() memberId = {}", memberId);
		return sqlSessionTemplate.delete(mapperRoot+"memberDelete", memberId);
	}
	
}