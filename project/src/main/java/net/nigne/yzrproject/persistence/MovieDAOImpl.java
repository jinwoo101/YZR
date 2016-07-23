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
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public MovieVO getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<MovieVO> cq = cb.createQuery(MovieVO.class);
		Root<MovieVO> root = cq.from(MovieVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<MovieVO> tq = entityManager.createQuery(cq);
		MovieVO vo = tq.getSingleResult();
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
	public List<DirectorVO> getDirector(String movie_id) {
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
	public GpaVO getGpa(String movie_id) {
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
		GpaVO vo = entityManager.find(GpaVO.class, getGpa(movie_id).getMovie_id());
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
}