package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolController {
	@Autowired
	private IdolDao idolDao;
	// 아이돌 리스트요청 처리
	@RequestMapping(value="/idol/idolList")
	public String idolList(Model model) {
		List<Idol> list = idolDao.selectIdolList();
		model.addAttribute("list",list);
		return "idol/idolList";
	}
	// 입력화면 요청
	@RequestMapping(value="/idol/idolInsert", method = RequestMethod.GET)
	public String idolGet(Idol idol) {
		return "/idol/idolInsert";
	}
	// 아이돌 입력처리요청
	@RequestMapping(value="/idol/idolInsert", method = RequestMethod.POST)
	public String idolInsrtPost(Idol idol) {
		System.out.println(idol +"<-- idolController idolInsertPost ");
		idolDao.insertIdol(idol);
		return "redirect:/idol/idolList";
	}
	// 아이돌 수정화면 요청
	@RequestMapping(value="/idol/idolModify", method = RequestMethod.GET)
	public String idolModify(Model model, @RequestParam(value="idolId", required=true) int idolId) {
		System.out.println(idolId +"<--IdoController idolModify 아이돌아이디값 가져오기");
		Idol idol = idolDao.getIdol(idolId);
		model.addAttribute("Idol", idol);
		return "/idol/idolModify";
	}
	// 아이돌 수정처리 요청
	@RequestMapping(value="/idol/idolModify", method = RequestMethod.POST)
	public String idolModify(Idol idol) {
		System.out.println(idol.getIdolId() +"<-- IdolController idolModify 아이돌아이디처리");
		
		idolDao.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
	//삭제 action 요청
	@RequestMapping(value="/idol/idolDelete", method = RequestMethod.GET)
	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId) {
		idolDao.deleteIdol(idolId);
		return "redirect:/idol/idolList";
	}
	
	
}
