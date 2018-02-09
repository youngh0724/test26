package ksmart.project.test26;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolService;

@Controller
public class IdolController {
	private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
	
	@Autowired
	private IdolService idolService;

	// idolList.jsp 요청
	@RequestMapping(value = "/idol/idolList")
	public String idolSelectList(Model model) {
		List<Idol> list = idolService.idolSelectList();
		model.addAttribute("list", list);
		logger.debug("idolInsrt idol = {}", list.get(1).getIdolId());
		logger.debug("idolInsrt idol = {}", list.get(2).getIdolName());
		return "idol/idolList";
	}

	// 아이돌 등록화면 요청
	@RequestMapping(value = "/idol/idolInsert", method = RequestMethod.GET)
	public String idolInsert() {
		return "/idol/idolInsert";
	}

	// 아이돌 등록처리 요청
	@RequestMapping(value = "/idol/idolInsert", method = RequestMethod.POST)
	public String idolInsrt(Idol idol) {
		idolService.idolInsrt(idol);
		// System.out.println(idol + "<-- idolController idolInsertPost ");
		logger.debug("idolInsrt idol = {}", idol.getIdolId());
		logger.debug("idolInsrt idol = {}", idol.getIdolName());
		return "redirect:/idol/idolList";
	}

	// 아이돌 수정페이지 요청
	@RequestMapping(value = "/idol/idolUpdate", method = RequestMethod.GET)
	public String idolSelectOneForUpdate(Model model, @RequestParam(value = "idolId", required = true) int idolId) {
		Idol idol = idolService.idolSelectOneForUpdate(idolId);
		//System.out.println(idolId + "<--IdoController idolSelectOneForUpdate ");
		model.addAttribute("Idol", idol);
		logger.debug("idolInsrt idol = {}", idol.getIdolId());
		logger.debug("idolInsrt idolId = {}", idol.getIdolName());
		return "/idol/idolUpdate";
	}

	// 아이돌 수정처리 요청
	@RequestMapping(value = "/idol/idolUpdate", method = RequestMethod.POST)
	public String idolUpdate(Idol idol) {
		System.out.println(idol.getIdolId() + "<-- IdolController idolUpdate ");
		idolService.idolUpdate(idol);
		logger.debug("idolInsrt idol = {}", idol.getIdolId());
		logger.debug("idolInsrt idol = {}", idol.getIdolName());
		return "redirect:/idol/idolList";
	}

	// 아이돌 삭제요청
	@RequestMapping(value = "/idol/idolDelete", method = RequestMethod.GET)
	public String idolDelete(@RequestParam(value = "idolId", required = true) int idolId) {
		idolService.idolDelete(idolId);
		logger.debug("idolInsrt idolId = {}", idolId);
		return "redirect:/idol/idolList";
	}

}
