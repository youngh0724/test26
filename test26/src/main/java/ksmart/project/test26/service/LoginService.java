package ksmart.project.test26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	
	public Member loginCheckService(Member member) {
		member = loginDao.loginCheck(member);
		return member;
	}
	
}
