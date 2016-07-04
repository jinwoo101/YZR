package net.nigne.yzrproject.persistence;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.nigne.yzrproject.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<EmpVO> getList() {
		// TODO Auto-generated method stub
		System.out.println(sessionFactory);
		Session session=sessionFactory.getCurrentSession();
		System.out.println(session);
		List<EmpVO> list=session.createCriteria(EmpVO.class).list();
		
		return list;
	}
	@Override
	public void empInsert(int no) throws Exception{
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		EmpVO vo=new EmpVO();
		vo.setEmp_no(no);
		vo.setEmp_name(""+no);
		vo.setAddress(""+no);
		session.save(vo);
	}
}