package net.nigne.yzrproject.persistence;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

@Repository
public class DetailDAOImpl implements DetailDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DetailVO getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<DetailVO> cq = cb.createQuery(DetailVO.class);
		Root<DetailVO> root = cq.from(DetailVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<DetailVO> tq = entityManager.createQuery(cq);
		DetailVO vo = tq.getSingleResult();
		return vo;
	}

	@Override
	public List<ActorVO> getActor(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ActorVO> cq = cb.createQuery(ActorVO.class);
		Root<ActorVO> root = cq.from(ActorVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<ActorVO> tq = entityManager.createQuery(cq);
		List<ActorVO> actorlist = tq.getResultList();
		return actorlist;
	}

	@Override
	public List<DirectorVO> getdirector(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<DirectorVO> cq = cb.createQuery(DirectorVO.class);
		Root<DirectorVO> root = cq.from(DirectorVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<DirectorVO> tq = entityManager.createQuery(cq);
		List<DirectorVO> directorlist = tq.getResultList();
		return directorlist;
	}

	@Override
	public GpaVO getgpa(String movie_id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GpaVO> cq = cb.createQuery(GpaVO.class);
		Root<GpaVO> root = cq.from(GpaVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root);
		cq.where(p);
		TypedQuery<GpaVO> tq = entityManager.createQuery(cq);
		GpaVO vo = tq.getSingleResult();
		return vo;
	}

	@Override
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception {
		// TODO Auto-generated method stub
		GpaVO vo = entityManager.find(GpaVO.class, getgpa(movie_id).getMovie_id());
		GpaVO mergevo = entityManager.merge(vo);
		mergevo.setActing(
				(vo.getActing() * (vo.getFemale() + vo.getMale()) + acting) / (vo.getFemale() + vo.getMale() + 1));
		mergevo.setDirection((vo.getDirection() * (vo.getFemale() + vo.getMale()) + direction)
				/ (vo.getFemale() + vo.getMale() + 1));
		mergevo.setBeauty(
				(vo.getBeauty() * (vo.getFemale() + vo.getMale()) + beauty) / (vo.getFemale() + vo.getMale() + 1));
		mergevo.setOst((vo.getOst() * (vo.getFemale() + vo.getMale()) + ost) / (vo.getFemale() + vo.getMale() + 1));
		mergevo.setStory(
				(vo.getStory() * (vo.getFemale() + vo.getMale()) + story) / (vo.getFemale() + vo.getMale() + 1));
		mergevo.setMale(vo.getMale() + male);
		mergevo.setFemale(vo.getFemale() + female);
		mergevo.setTeenager(vo.getTeenager() + teenager);
		mergevo.setTwenties(vo.getTwenties() + twenties);
		mergevo.setThirties(vo.getThirties() + thirties);
		mergevo.setForties(vo.getForties() + forties);
	}

	@Override
	public void reviewInsert(String member_id, String movie_id, String review_title, String review_content,
			String review_date, int review_cnt, String review_file, String review_like) throws Exception {
		ReviewVO vo = new ReviewVO();
		vo.setMovie_id(movie_id);
		vo.setMember_id(member_id);
		vo.setReview_title(review_title);
		// vo.setNo(3);
		vo.setReview_content(review_content);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(cal.getTime().getTime());
		vo.setReview_date(date);
		vo.setReview_cnt(review_cnt);
		vo.setReview_file(review_file);
		vo.setReview_like(review_like);
		entityManager.persist(vo);
	}

	@Override
	public List<ReviewVO> getReview(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReviewVO> cq = cb.createQuery(ReviewVO.class);
		Root<ReviewVO> root = cq.from(ReviewVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root);
		cq.where(p);
		TypedQuery<ReviewVO> tq = entityManager.createQuery(cq);
		List<ReviewVO> reviewList = tq.getResultList();
		return reviewList;
	}

	public List<GenreVO> getGenre(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GenreVO> cq = cb.createQuery(GenreVO.class);
		Root<GenreVO> root = cq.from(GenreVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<GenreVO> tq = entityManager.createQuery(cq);
		List<GenreVO> genrelist = tq.getResultList();
		return genrelist;
	}

	@Override
	public ReviewVO getReview_read(int no) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReviewVO> cq = cb.createQuery(ReviewVO.class);
		Root<ReviewVO> root = cq.from(ReviewVO.class);
		Predicate p = cb.equal(root.get("no"), no);
		cq.select(root).where(p);
		TypedQuery<ReviewVO> tq = entityManager.createQuery(cq);
		ReviewVO vo = tq.getSingleResult();
		return vo;
	}

	@Override
	public void replyinsert(int reply_no,int review_no, String user_id, String reply_content, String reply_date,
			String reply_reply) throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setReply_no(reply_no);
		vo.setReview_no(review_no);
		vo.setUser_id(user_id);
		vo.setReply_content(reply_content);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(cal.getTime().getTime());
		vo.setReply_date(date);
		vo.setReply_reply(reply_reply);
		entityManager.persist(vo);
	}

	@Override
	public List<ReplyVO> getreply(int review_no) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReplyVO> cq = cb.createQuery(ReplyVO.class);
		Root<ReplyVO> root = cq.from(ReplyVO.class);
		Predicate p = cb.equal(root.get("review_no"), review_no);
		cq.select(root).where(p);
		TypedQuery<ReplyVO> tq = entityManager.createQuery(cq);
		List<ReplyVO> replylist = tq.getResultList();
		return replylist;
	}

	@Override
	public List<ReplyVO> getreply_reply(int review_no) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReplyVO> cq = cb.createQuery(ReplyVO.class);
		Root<ReplyVO> root = cq.from(ReplyVO.class);
		Predicate p = cb.equal(root.get("review_no"), review_no);
		cq.select(root).where(p);
		TypedQuery<ReplyVO> tq = entityManager.createQuery(cq);
		List<ReplyVO> replylist1 = tq.getResultList();
		return replylist1;
	}

	@Override
	public void reply_reply_insert(int reply_no, int review_no, String user_id, String reply_content, String reply_date,
			String reply_reply) throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setReply_no(reply_no);
		vo.setReview_no(review_no);
		vo.setUser_id(user_id);
		vo.setReply_content(reply_content);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(cal.getTime().getTime());
		vo.setReply_date(date);
		vo.setReply_reply(reply_reply);
		entityManager.persist(vo);
	}

	@Override
	public long getTotalCount(String movie_id) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(long.class);
		Root<ReviewVO> root = cq.from(ReviewVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(cb.count(root.get("movie_id")));
		cq.where(p);
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		long totalcount = tq.getSingleResult();
		return totalcount;
	
	}

	@Override
	public List<ReviewVO> getListPage(String movie_id, Criteria criteria) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReviewVO> cq = cb.createQuery(ReviewVO.class);
		Root<ReviewVO> root = cq.from(ReviewVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root);
		cq.where(p);
		TypedQuery<ReviewVO> tq = entityManager.createQuery(cq).setFirstResult(criteria.getStartPage()).setMaxResults(criteria.getArticlePerPage());
		List<ReviewVO> reviewpagelist = tq.getResultList();
		return reviewpagelist;
	}

	@Override
	public long getReplyCount(int review_no) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(long.class);
		Root<ReviewVO> root = cq.from(ReviewVO.class);
		Predicate p = cb.equal(root.get("review_no"), review_no);
		cq.select(cb.count(root.get("review_no")));
		cq.where(p);
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		long totalreplycount = tq.getSingleResult();
		return totalreplycount;
	}

	@Override
	public List<ReplyVO> getreplyPage(int review_no, Criteria criteria) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReplyVO> cq = cb.createQuery(ReplyVO.class);
		Root<ReplyVO> root = cq.from(ReplyVO.class);
		Predicate p = cb.equal(root.get("review_no"), review_no);
		cq.select(root);
		cq.where(p);
		TypedQuery<ReplyVO> tq = entityManager.createQuery(cq).setFirstResult(criteria.getStartPage()).setMaxResults(criteria.getArticlePerPage());
		List<ReplyVO> replywpagelist = tq.getResultList();
		return replywpagelist;
	}

}