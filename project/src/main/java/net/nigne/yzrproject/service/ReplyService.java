package net.nigne.yzrproject.service;

import java.sql.Timestamp;
import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

public interface ReplyService {
	



	public List<ReplyVO> getreply(int review_no);
	public List<ReplyVO> getreply_reply(int review_no);
	public long getReplyCount(int review_no);
	public List<ReplyVO> getreplyPage(int review_no, Criteria criteria);
	public void replyinsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public void reply_reply_insert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public void delete_reply(int no);
	

}