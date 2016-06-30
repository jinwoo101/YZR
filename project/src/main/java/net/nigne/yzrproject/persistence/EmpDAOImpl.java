package net.nigne.yzrproject.persistence;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import net.nigne.yzrproject.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<EmpVO> getList() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cri=session.createCriteria(EmpVO.class);
		return cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

}