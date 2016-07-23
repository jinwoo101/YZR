package net.nigne.yzrproject.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.PageMaker;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.service.MovieService;
import net.nigne.yzrproject.service.ReviewService;

@Controller
public class MovielController {
	@Autowired
	private MovieService Movie_service;
	@Autowired
	private ReviewService Review_service;
	

	@RequestMapping(value = "/movie/{movie_id}", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @PathVariable("movie_id") String movie_id) throws Exception {
		MovieVO movievo = Movie_service.getList(movie_id);
		model.addAttribute("movievo", movievo);
		List<ActorVO> actorlist = Movie_service.getActor(movie_id);
		model.addAttribute("actorlist", actorlist);
		List<DirectorVO> directorlist = Movie_service.getDirector(movie_id);
		model.addAttribute("directorlist", directorlist);
		List<GenreVO> genrelist = Movie_service.getGenre(movie_id);
		model.addAttribute("genrelist", genrelist);
		GpaVO gpavo = Movie_service.getGpa(movie_id);
		model.addAttribute("gpavo", gpavo);
		
		List<ReviewVO> reviewlist = Review_service.getReview(movie_id);
		model.addAttribute("reviewlist", reviewlist);
		return "movie";
	}
	@RequestMapping(value = "/movie/chart/{movie_id}", method = RequestMethod.GET)
	public ResponseEntity<GpaVO> get(@PathVariable("movie_id") String movie_id) {
		ResponseEntity<GpaVO> entity = null;
		try {
			GpaVO vo = Movie_service.getGpa(movie_id);
			entity = new ResponseEntity<>(vo, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
//	
//	HttpSession session = request.getSession();
//	String member_id = (String)session.getAttribute("member_id");
	
	@RequestMapping(value = "/movie/chart/{movie_id}", method = RequestMethod.POST)
	public ResponseEntity<String> chart_update(@PathVariable("movie_id") String movie_id, @RequestBody GpaVO vo,HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		System.out.println("acting" + vo.getActing());
			try {
				System.out.println("action");
				Movie_service.gpaUpdate(movie_id, vo.getActing(), vo.getDirection(), vo.getBeauty(), vo.getOst(), vo.getStory(),
						vo.getMale(), vo.getFemale(), vo.getTeenager(), vo.getTwenties(), vo.getThirties(),
						vo.getForties());
				entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			} catch (Exception e) {
				entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
