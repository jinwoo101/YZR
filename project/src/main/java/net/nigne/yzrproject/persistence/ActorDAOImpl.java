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

@Repository
public class ActorDAOImpl implements ActorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ActorVO> getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ActorVO> cq=cb.createQuery(ActorVO.class);
		Root<ActorVO> root = cq.from(ActorVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<ActorVO> tq = entityManager.createQuery(cq);
		List<ActorVO> actorlist = tq.getResultList();
		return actorlist;
	}
}