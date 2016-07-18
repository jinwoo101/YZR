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
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.PageMaker;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.service.DetailService;

@Controller
public class DetailController {
	@Autowired
	private DetailService service;

	@RequestMapping(value = "/detail/{movie_id}", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @PathVariable("movie_id") String movie_id) throws Exception {
		DetailVO vo = service.getList(movie_id);
		model.addAttribute("vo", vo);
		List<ActorVO> actorlist = service.getActor(movie_id);
		model.addAttribute("actorlist", actorlist);
		List<DirectorVO> directorlist = service.getdirector(movie_id);
		model.addAttribute("directorlist", directorlist);
		List<GenreVO> genrelist = service.getGenre(movie_id);
		model.addAttribute("genrelist", genrelist);
		GpaVO gpavo = service.getgpa(movie_id);
		model.addAttribute("gpavo", gpavo);
		List<ReviewVO> reviewlist = service.getReview(movie_id);
		model.addAttribute("reviewlist", reviewlist);
		return "detail";
	}
	@RequestMapping(value = "detail/review_read/{no}", method = RequestMethod.GET)
	public String review_read(Locale locale, Model model,@PathVariable("no") int no) throws Exception {
		ReviewVO reviewvo = service.getReview_read(no);
		model.addAttribute("reviewvo", reviewvo);
		
		List<ReplyVO> replylist = service.getreply(no);
		model.addAttribute("replylist", replylist);
		
		List<ReplyVO> replylist1 = service.getreply_reply(no);
		model.addAttribute("replylist1", replylist1);
		return "review_read";
	}
	

	@RequestMapping(value = "/detail/chart/{movie_id}", method = RequestMethod.GET)
	public ResponseEntity<GpaVO> get(@PathVariable("movie_id") String movie_id) {
		ResponseEntity<GpaVO> entity = null;
		try {
			GpaVO vo = service.getgpa(movie_id);
			entity = new ResponseEntity<>(vo, HttpStatus.OK);
			System.out.println("5555555555555555");
		} catch (Exception e) {
			System.out.println("6666666");
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("7777777777777755");
		return entity;
	}

	@RequestMapping(value = "/detail/chart/{movie_id}", method = RequestMethod.POST)
	public ResponseEntity<String> update(@PathVariable("movie_id") String movie_id, @RequestBody GpaVO vo) {
		ResponseEntity<String> entity = null;
		System.out.println("acting" + vo.getActing());
		try {
			System.out.println("action");
			service.gpaUpdate(movie_id, vo.getActing(), vo.getDirection(), vo.getBeauty(), vo.getOst(), vo.getStory(),
					vo.getMale(), vo.getFemale(), vo.getTeenager(), vo.getTwenties(), vo.getThirties(),
					vo.getForties());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			System.out.println("�뜝�럥�빢�뜝�럩�젧");
		} catch (Exception e) {
			System.out.println("�뜝�럥�빢�뜝�럩�젧�뜝�럩沅롳옙紐닷뜝占�");
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("�뜝�럥�빢�뜝�럩�젧..");
		return entity;
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
			service.reviewInsert(vo.getMember_id(), movie_id , vo.getReview_title(), vo.getReview_content(),vo.getReview_date(),vo.getReview_cnt(),vo.getReview_file(), vo.getReview_like());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			System.out.println("555555555555");
		} catch (Exception e) {
			System.out.println("6666666");
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("�뜝�럩肉��뜝�럩�졑");
		return entity;
	}
	
	@RequestMapping(value = "/review/new/reply/{no}", method = RequestMethod.POST)
	public ResponseEntity<String> reply_insert(@RequestBody ReplyVO vo,@PathVariable("no") int no) {
		ResponseEntity<String> entity = null;
		try {
			service.replyinsert(vo.getReply_no(),vo.getReview_no(), vo.getUser_id(), vo.getReply_content(), vo.getReply_date(), vo.getReply_reply());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			System.out.println("댓글");
		} catch (Exception e) {
			System.out.println("댓글실패");
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("�뜝�럩肉��뜝ㅋㅋ럩�졑");
		return entity;
	}
	
	@RequestMapping(value = "/review/new/reply/y/{no}", method = RequestMethod.POST)
	public ResponseEntity<String> reply_reply_insert(@RequestBody ReplyVO vo,@PathVariable("no") int no) {
		ResponseEntity<String> entity = null;
		try {
			service.reply_reply_insert(vo.getReply_no(),vo.getReview_no(), vo.getUser_id(), vo.getReply_content(), vo.getReply_date(), vo.getReply_reply());
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			System.out.println("대댓글");
		} catch (Exception e) {
			System.out.println("댓글실패");
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		System.out.println("�뜝�럩肉��뜝ㅋㅋ럩�졑");
		return entity;
	}		
	
	@RequestMapping(value = "/detail/{movie_id}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("page") Integer page   ) {
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			// ������ ó���� ���� Criteria ����
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			// ��� ���� ��������
			long replyTotal = service.getTotalCount(movie_id);
			// ��� ��������
			List<ReviewVO> list = service.getListPage(movie_id, criteria);
			// ������ ����Ŀ�� �� ��� ������, ������������ �ִ� Criteria �� �Ѱܼ�
			// ����¡ ���� ����Ѵ�
			PageMaker pm = new PageMaker(criteria, replyTotal);
			// ���������� Map �� ��� ��ϰ� ����¡ ó�� ���� ��Ƽ� 
			Map<String, Object> map = new HashMap<>();
			map.put("l", list);
			map.put("p", pm);
			// �������� �����Ѵ�
			entity = new ResponseEntity<>(map, HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		return entity;
	}
}
