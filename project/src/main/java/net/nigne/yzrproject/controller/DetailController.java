package net.nigne.yzrproject.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/detail/{movie_id}", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @PathVariable("movie_id") String movie_id) throws Exception {
		DetailVO vo=service.getList(movie_id);
		model.addAttribute("vo", vo);
		List<ActorVO> actorlist = service1.getList(movie_id);
		model.addAttribute("actorlist", actorlist);
		List<DirectorVO> directorlist = service2.getList(movie_id);
		model.addAttribute("directorlist", directorlist);
		return "detail";
	}

//	@RequestMapping(value = "/detail", method = RequestMethod.POST)
//	public ResponseEntity<String> insert(@RequestBody GpaVO vo){
//		ResponseEntity<String> entity = null;
//		System.out.println("acting"+vo.getActing());
//		try{
//			String movie_id = "a"+Math.random();
//			service3.gpaInsert(movie_id, vo.getActing() , vo.getDirection(),vo.getBeauty(),vo.getOst(),vo.getStory());
//			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
//			System.out.println("5555555555555555");
//		}catch(Exception e){
//			System.out.println("6666666");
//			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//		System.out.println("7777777777777755");
//		return entity;
//	}
//	
	@RequestMapping(value = "/detail/chart/{movie_id}", method = RequestMethod.GET)
	public ResponseEntity<GpaVO> get(@PathVariable("movie_id") String movie_id){
		ResponseEntity<GpaVO> entity = null;
		
		try{
			GpaVO vo = service3.get(movie_id);
			entity = new ResponseEntity<>(vo, HttpStatus.OK);
			System.out.println("5555555555555555");
		}catch(Exception e){
			System.out.println("6666666");
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("7777777777777755");
		return entity;
	}
	
	@RequestMapping(value = "/detail/chart/{movie_id}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("movie_id") String movie_id,@RequestBody GpaVO vo, @RequestParam("data") GpaVO data){
		ResponseEntity<String> entity = null;
		System.out.println("acting"+vo.getActing());
		try{
			System.out.println("가나난나나나나"+data.getActing());
			service3.gpaUpdate(data,movie_id,vo.getActing(),vo.getDirection(),vo.getBeauty(),vo.getOst(),vo.getStory());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			System.out.println("5222222555555");
		}catch(Exception e){
			System.out.println("6662222666");
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("777777222227777755");
		return entity;
	}
	
	
}
