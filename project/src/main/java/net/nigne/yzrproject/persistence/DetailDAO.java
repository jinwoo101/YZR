package net.nigne.yzrproject.persistence;

import java.sql.Timestamp;
import java.util.List;



import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

public interface DetailDAO {

	public DetailVO getList(String movie_id);
	public List<ActorVO> getActor(String movie_id);
	public List<DirectorVO> getdirector(String movie_id);
	public GpaVO getgpa(String movie_id);
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception;
	public List<GenreVO> getGenre(String movie_id);
	public void reviewInsert(String member_id, String movie_id, String review_title, String review_content,
			String review_date, int review_cnt, String review_file, String review_like) throws Exception;
	
	public List<ReviewVO> getReview(String movie_id);
	public ReviewVO getReview_read(int no);
	public void Reviewcnt_Update(int no, int review_cnt) throws Exception;
	public void Review_update(int no,String review_title, String review_content) throws Exception;
	public long getTotalCount(String movie_id);
	public List<ReviewVO> getListPage(String movie_id, Criteria criteria);

	public void replyinsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public void reply_reply_insert(int reply_no,int review_no, String user_id, String reply_content, String reply_date, String reply_reply) throws Exception;
	public List<ReplyVO> getreply(int review_no);
	public List<ReplyVO> getreply_reply(int review_no);
	public long getReplyCount(int review_no);
	public List<ReplyVO> getreplyPage(int review_no, Criteria criteria);

	
	
	public void delete_reply(int no);
	public void delete_review_reply(int review_no);
	public void delete_review(int review_no);


	

//	public void gpaInsert(String movie_id, String acting) throws Exception;
}
