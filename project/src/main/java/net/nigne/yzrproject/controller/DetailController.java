package net.nigne.yzrproject.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.service.ActorService;
import net.nigne.yzrproject.service.DetailService;
import net.nigne.yzrproject.service.DirectorService;
import net.nigne.yzrproject.service.EmpService;
import net.nigne.yzrproject.service.GpaService;

@Controller
public class DetailController {
	@Autowired
	private DetailService service;
	@Autowired
	private ActorService service1;
	@Autowired
	private DirectorService service2;
	@Autowired
	private GpaService service3;
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		String movie_id = "a"; 
		DetailVO vo=service.getList(movie_id);
		model.addAttribute("vo", vo);
		List<ActorVO> actorlist = service1.getList(movie_id);
		model.addAttribute("actorlist", actorlist);
		List<DirectorVO> directorlist = service2.getList(movie_id);
		model.addAttribute("directorlist", directorlist);
		
		GpaVO gpavo = service3.getList(movie_id);
		model.addAttribute("gpavo", gpavo);
		
		return "detail";
		
	}
}