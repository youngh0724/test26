package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolController {
	@Autowired
	private IdolDao idolDao;
	
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
}
