package net.nigne.yzrproject.persistence;

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
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.domain.GpaVO;

@Repository
public class GpaDAOImpl implements GpaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@Override
//	public void gpaInsert(String movie_id, int acting, int direction, int beauty, int ost, int story) throws Exception{
//		// TODO Auto-generated method stub
//		GpaVO vo = new GpaVO();
//		vo.setMovie_id(movie_id);
//		vo.setActing(acting);
//		vo.setDirection(direction);
//		vo.setBeauty(beauty);
//		vo.setOst(ost);
//		vo.setStory(story);
//		entityManager.persist(vo);
//	}

//	Select sum(a) avg(a) from gpa;
	@Override
	public GpaVO get(String movie_id) {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<GpaVO> cq=cb.createQuery(GpaVO.class);
		Root<GpaVO> root = cq.from(GpaVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root);
		cq.where(p);
		TypedQuery<GpaVO> tq = entityManager.createQuery(cq);
		GpaVO vo = tq.getSingleResult();		
		return vo;
	}

	@Override
	public void gpaUpdate(GpaVO data,String movie_id, int acting, int direction, int beauty, int ost, int story) throws Exception {
		// TODO Auto-generated method stub
		GpaVO vo=entityManager.find(GpaVO.class, get(movie_id).getMovie_id());
		GpaVO mergevo=entityManager.merge(vo);
		mergevo.setActing(data.getActing()+acting);
		mergevo.setDirection(data.getDirection()+direction);
		mergevo.setBeauty(data.getBeauty()+beauty);
		mergevo.setOst(data.getOst()+ost);
		mergevo.setStory(data.getStory()+story);
	}
}