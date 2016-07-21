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
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.PageMaker;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.service.MovieService;
import net.nigne.yzrproject.service.ReplyService;
import net.nigne.yzrproject.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService review_service;
	@Autowired
	private ReplyService Reply_service;

	@RequestMapping(value = "movie/review_read/{no}", method = RequestMethod.GET)
	public String review_read(Locale locale, Model model,@PathVariable("no") int no) throws Exception {
		ReviewVO reviewvo = review_service.getReview_read(no);
		model.addAttribute("reviewvo", reviewvo);
		
		List<ReplyVO> replylist = Reply_service.getreply(no);
		model.addAttribute("replylist", replylist);
		
		List<ReplyVO> replylist1 = Reply_service.getreply_reply(no);
		model.addAttribute("replylist1", replylist1);
		
		review_service.Reviewcnt_Update(no, reviewvo.getReview_cnt());
		return "review_read";
	}

	@RequestMapping(value = "/review/{movie_id}", method = RequestMethod.GET)
	public String review_write(Locale locale, Model model, @PathVariable("movie_id") String movie_id) throws Exception {
		model.addAttribute("movie_id", movie_id);
		return "review";
	}
	

	@RequestMapping(value = "/review/new/{movie_id}", method = RequestMethod.POST)
	public ResponseEntity<String> review_insert(@RequestBody ReviewVO vo,@PathVariable("movie_id") String movie_id) {
		ResponseEntity<String> entity = null;

		try {
			review_service.reviewInsert(vo.getMember_id(), movie_id , vo.getReview_title(), vo.getReview_content(),vo.getReview_date(),vo.getReview_cnt(),vo.getReview_file(), vo.getReview_like());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
	@RequestMapping(value = "/movie/{movie_id}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("page") Integer page   ) {
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			long replyTotal = review_service.getTotalCount(movie_id);
			List<ReviewVO> list = review_service.getListPage(movie_id, criteria);
			PageMaker pm = new PageMaker(criteria, replyTotal);
			Map<String, Object> map = new HashMap<>();
			map.put("l", list);
			map.put("p", pm);
			entity = new ResponseEntity<>(map, HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		return entity;
	}
	
	@RequestMapping(value = "/review_update_read/{review_no}", method = RequestMethod.POST)
	public String review_update_read(@PathVariable("review_no") int review_no, Model model) {
		ReviewVO reviewvo = review_service.getReview_read(review_no);
		model.addAttribute("reviewvo",reviewvo);
		return "review_update";
	}
	
	@RequestMapping(value = "/review/update/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> update_review(@PathVariable("no") int no, @RequestBody ReviewVO vo) {
		ResponseEntity<String> entity = null;
		try {
			review_service.Review_update(no, vo.getReview_title(), vo.getReview_content());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/movie/review_delete/{review_no}", method = RequestMethod.DELETE) 
	public ResponseEntity<String> deleteReview(@PathVariable("review_no") Integer review_no) throws Exception{ 
		ResponseEntity<String> entity = null; 
		try{ 
			review_service.delete_review(review_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK); 
		}catch(Exception e){ 
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		} 
		return entity; 
	} 
	@RequestMapping(value = "/movie/review_reply_delete/{review_no}", method = RequestMethod.DELETE) 
	public ResponseEntity<String> deleteReview_reply(@PathVariable("review_no") Integer review_no) throws Exception{ 
		ResponseEntity<String> entity = null; 
		try{ 
			review_service.delete_review_reply(review_no);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK); 
		}catch(Exception e){ 
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		} 
		return entity; 
	}
}
