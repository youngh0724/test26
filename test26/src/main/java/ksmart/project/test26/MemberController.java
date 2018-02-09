package ksmart.project.test26;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//홈화면에서 정보 수정버튼 클릭시 들어오는 요청 처리
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.GET)
	public String memberSelectOneForUpdate(Model model, @RequestParam(value="memberNo", required=true) int memberNo) {
		logger.debug("memberSelectOneForUpdate() memberNo = {}", memberNo);
		//한명의 정보를 조회하는 메서드 호출
		Member member = memberService.memberSelectOneForUpdate(memberNo);
		logger.debug("memberSelectOneForUpdate() memberId = {}", member.getMemberId());
		//model에 결과값 member를 세팅한다.
		model.addAttribute("member", member);
		return "member/memberUpdate";
	}
	
	//회원정보 수정화면에서 수정완료버튼 클릭시 들어오는 요청처리
	@RequestMapping(value="/member/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Member member) {
		logger.debug("memberUpdate() member = {}", member);
		//한명의 정보를 수정하는 메서드 호출
		memberService.memberUpdate(member);
		return "redirect:/member/memberInfo";
	}
	
	//홈화면에서 회원 정보버튼 클릭시 들어오는 요청처리
	@RequestMapping(value="/member/memberInfo", method = RequestMethod.GET)
	public String memberInfo() {
		//처리내용은 없고 화면 포워드를 시킨다. 메서드 실행확인용 로그를 남긴다.
		logger.debug("memberInfo() 실행확인");
		return "member/memberInfo";
	}
	
	//홈화면에서 회원가입버튼 클릭시 들어오는 요청처리
	@RequestMapping(value="/member/memberInsert", method = RequestMethod.GET)
	public String memberInsert() {
		//처리내용은 없고 화면 포워드를 시킨다. 메서드 실행확인용 로그를 남긴다.
		logger.debug("memberInsert() 실행확인");
		return "member/memberInsert";
	}
	
	//회원가입화면에서 가입버튼 클릭시 들어오는 요청처리
	@RequestMapping(value="/member/memberInsert", method = RequestMethod.POST)
	public String memberInsert(Member member) {		
		logger.debug("memberInsert() member = {}", member);
		//입력받은 정보를 db에 입력하는 메서드를 호출한다.
		memberService.memberInsert(member);
		return "redirect:/login/login";
	}
	
	//홈 화면에서 회원탈퇴버튼 클릭시 들어오는 요청처리
	@RequestMapping(value="/member/memberDelete", method = RequestMethod.GET)
	public String memberDelete(@RequestParam(value="memberId", required=true) String memberId, HttpSession session) {
		logger.debug("memberDelete() memberId = {}", memberId);
		//회원정보 삭제 메서드 호출
		memberService.memberDelete(memberId);
		//session도 연결을 끈는다.
		session.invalidate();
		return "redirect:/";
	}
}
