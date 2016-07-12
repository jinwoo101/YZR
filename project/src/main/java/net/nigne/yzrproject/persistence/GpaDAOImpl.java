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
	
	
	@Override
	public void gpaInsert(String movie_id,String acting) throws Exception{
		// TODO Auto-generated method stub
		GpaVO vo = new GpaVO();
		vo.setMovie_id(movie_id);
		vo.setActing(acting);
		entityManager.persist(vo);
	}
}