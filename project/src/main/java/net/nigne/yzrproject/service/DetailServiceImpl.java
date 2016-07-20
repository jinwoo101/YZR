package net.nigne.yzrproject.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.persistence.DetailDAO;
import net.nigne.yzrproject.persistence.LoginDAO;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	private DetailDAO dao;

	@Transactional(readOnly = true)
	@Override
	public DetailVO getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ActorVO> getActor(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getActor(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DirectorVO> getdirector(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getdirector(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public GpaVO getgpa(String movie_id) {
		return dao.getgpa(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception {
		dao.gpaUpdate(movie_id, acting, direction, beauty, ost, story, male, female, teenager, twenties, thirties,
				forties);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void reviewInsert(String member_id, String movie_id, String review_title, String review_content,
			String review_date, int review_cnt, String review_file, String review_like) throws Exception {
		dao.reviewInsert(member_id, movie_id, review_title, review_content, review_date, review_cnt, review_file,
				review_like);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<ReviewVO> getReview(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getReview(movie_id);
		}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<GenreVO> getGenre(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getGenre(movie_id);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public ReviewVO getReview_read(int no) {
		// TODO Auto-generated method stub
		return dao.getReview_read(no);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void replyinsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date,String reply_reply) throws Exception {
		dao.replyinsert(reply_no,review_no, user_id, reply_content, reply_date, reply_reply);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<ReplyVO> getreply(int review_no) {
		// TODO Auto-generated method stub
		return dao.getreply(review_no);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<ReplyVO> getreply_reply(int review_no) {
		// TODO Auto-generated method stub
		return dao.getreply_reply(review_no);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void reply_reply_insert(int reply_no, int review_no, String user_id, String reply_content, String reply_date,
			String reply_reply) throws Exception {
		// TODO Auto-generated method stub
		dao.reply_reply_insert(reply_no, review_no, user_id, reply_content, reply_date, reply_reply);
		
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public long getTotalCount(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getTotalCount(movie_id);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<ReviewVO> getListPage(String movie_id, Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getListPage(movie_id, criteria);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public long getReplyCount(int review_no) {
		// TODO Auto-generated method stub
		return dao.getReplyCount(review_no);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<ReplyVO> getreplyPage(int review_no, Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.getreplyPage(review_no, criteria);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void Reviewcnt_Update(int no, int review_cnt) throws Exception {
		// TODO Auto-generated method stub
		dao.Reviewcnt_Update(no, review_cnt);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void Review_update(int no, String review_title, String review_content) throws Exception {
		dao.Review_update(no, review_title, review_content);
		
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void delete_review(int review_no) {
		// TODO Auto-generated method stub
		dao.delete_review(review_no);
	}
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public ReplyVO getReply_no(int no) {
		// TODO Auto-generated method stub
		return dao.getReply_no(no);
	}
	
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void delete_reply(int no) {
		// TODO Auto-generated method stub
		dao.delete_reply(no);
	}
}