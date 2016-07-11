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
	
	@Transactional(readOnly=true)
	@Override
	public GpaVO getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}
}
