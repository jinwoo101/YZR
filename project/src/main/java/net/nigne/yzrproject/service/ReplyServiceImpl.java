package net.nigne.yzrproject.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.persistence.LoginDAO;
import net.nigne.yzrproject.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;

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
	public void delete_reply(int no) {
		// TODO Auto-generated method stub
		dao.delete_reply(no);
	}
	
	
}