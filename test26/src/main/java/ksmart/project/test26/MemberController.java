package ksmart.project.test26;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberDao;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.GET)
	public String memberUpdate(Model model, @RequestParam(value="memberNo", required=true) int memberNo) {
		Member member = memberDao.getMember(memberNo);
		model.addAttribute("member", member);
		return "member/memberUpdate";
	}
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Member member) {
		memberDao.memberUpdate(member);
		return "redirect:/member/memberList";
	}
}
