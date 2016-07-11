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
import net.nigne.yzrproject.domain.DirectorVO;

@Repository
public class DirectorDAOImpl implements DirectorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DirectorVO> getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DirectorVO> cq=cb.createQuery(DirectorVO.class);
		Root<DirectorVO> root = cq.from(DirectorVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<DirectorVO> tq = entityManager.createQuery(cq);
		List<DirectorVO> directorlist = tq.getResultList();		
		return directorlist;
	}
}