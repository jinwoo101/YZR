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

import net.nigne.yzrproject.domain.DetailVO;

@Repository
public class DetailDAOImpl implements DetailDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public DetailVO getList(String movie_id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DetailVO> cq=cb.createQuery(DetailVO.class);
		Root<DetailVO> root = cq.from(DetailVO.class);
		Predicate p = cb.equal(root.get("movie_id"), movie_id);
		cq.select(root).where(p);
		TypedQuery<DetailVO> tq = entityManager.createQuery(cq);
		DetailVO vo = tq.getSingleResult();		
		return vo;
	}
}