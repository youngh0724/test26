package ksmart.project.test26;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.LoginDao;
import ksmart.project.test26.service.LoginService;
import ksmart.project.test26.service.Member;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login/login", method = RequestMethod.GET)
	public String loginCheck() {		
		return "login/loginForm";
	}
	
	@RequestMapping(value="/login/login", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, Member member) {
		String flag = "login/loginForm";
		
		member = loginService.loginCheckService(member);
		if (member == null) {
			
		} else {
			session.setAttribute("loginMember", member);
			flag = "redirect:/";
		}
		
		return flag;
	}
	@RequestMapping(value="/login/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
