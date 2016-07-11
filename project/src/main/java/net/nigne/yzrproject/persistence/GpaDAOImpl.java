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
import net.nigne.yzrproject.domain.GpaVO;

@Repository
public class GpaDAOImpl implements GpaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public GpaVO getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<GpaVO> cq=cb.createQuery(GpaVO.class);
		Root<GpaVO> root = cq.from(GpaVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<GpaVO> tq = entityManager.createQuery(cq);
		GpaVO gpavo = tq.getSingleResult();
		return gpavo ;
	}
}