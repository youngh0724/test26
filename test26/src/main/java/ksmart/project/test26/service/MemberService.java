package ksmart.project.test26.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
		
	public Member memberSelectOneForUpdate(int memberNo) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("memberSelectOneForUpdate() memberNo = {}", memberNo);
		Member member = memberDao.memberSelectOneForUpdate(memberNo);
		//member에 들어있는 값을 확인해본다.
		logger.debug("memberSelectOneForUpdate() member = {}", member);
		return member;
	}
	
	public int memberUpdate(Member member) {
		logger.debug("memberUpdate() member = {}", member);
		int row = memberDao.memberUpdate(member);
		logger.debug("memberUpdate() row = {}", row);
		return row;
	}
	
	public int memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		int row = memberDao.memberInsert(member);
		logger.debug("memberInsert() row = {}", row);
		return row;
	}
	
	public int memberDelete(String memberId) {
		logger.debug("memberDelete() memberId = {}", memberId);
		int row = memberDao.memberDelete(memberId);
		logger.debug("memberDelete() row = {}", row);
		return row;
	}

}
