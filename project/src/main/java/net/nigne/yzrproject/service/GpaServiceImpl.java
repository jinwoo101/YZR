package net.nigne.yzrproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.persistence.GpaDAO;


@Service
public class GpaServiceImpl implements GpaService {
	
	@Autowired
	private GpaDAO dao;
		
	@Transactional(rollbackFor={Exception.class})
	@Override
	public void gpaInsert(String movie_id, String acting) throws Exception {
		// TODO Auto-generated method stub
		dao.gpaInsert(movie_id, acting);		
	}
}
