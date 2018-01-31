package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolListController {
	@Autowired
	private IdolDao idolDao;
	@RequestMapping(value="idolList")
	public String idolList(Model model) {
		List<Idol> list = idolDao.selectIdolList();
		model.addAttribute("list",list);
		return "idolList";
		
	}
	
}
