package ksmart.project.test26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public Member memberUpdateService(int memberNo) {
		Member member = memberDao.getMember(memberNo);
		return member;
	}
	
	public int memberUpdateService(Member member) {
		int row = memberDao.memberUpdate(member);
		return row;
	}
	
	public int memberInsertService(Member member) {
		int row = memberDao.insertMember(member);
		return row;
	}
	
	public int memberDeleteService(String memberId) {
		int row = memberDao.deleteMember(memberId);
		return row;
	}

}
