package ksmart.project.test26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public Member memberSelectOneForUpdate(int memberNo) {
		Member member = memberDao.memberSelectOneForUpdate(memberNo);
		return member;
	}
	
	public int memberUpdate(Member member) {
		int row = memberDao.memberUpdate(member);
		return row;
	}
	
	public int memberInsert(Member member) {
		int row = memberDao.memberInsert(member);
		return row;
	}
	
	public int memberDelete(String memberId) {
		int row = memberDao.memberDelete(memberId);
		return row;
	}

}
