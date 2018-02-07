package ksmart.project.test26;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberDao;
import ksmart.project.test26.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.GET)
	public String memberUpdate(Model model, @RequestParam(value="memberNo", required=true) int memberNo) {
		Member member = memberService.memberUpdateService(memberNo);
		model.addAttribute("member", member);
		return "member/memberUpdate";
	}
	
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Member member) {
		memberService.memberUpdateService(member);
		return "redirect:/member/memberList";
	}
	@RequestMapping(value="/member/memberList", method = RequestMethod.GET)
	public String memberList() {
		return "member/memberList";
	}
	
	@RequestMapping(value="/member/memberInsert", method = RequestMethod.GET)
	public String memberInsert() {
		return "member/memberInsertForm";
	}
	
	@RequestMapping(value="/member/memberInsert", method = RequestMethod.POST)
	public String memberInsert(Member member) {		
		memberService.memberInsertService(member);
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/member/memberDelete", method = RequestMethod.GET)
	public String memberDelete(@RequestParam(value="memberId", required=true) String memberId, HttpSession session) {
		memberService.memberDeleteService(memberId);
		session.invalidate();
		return "redirect:/";
	}
}