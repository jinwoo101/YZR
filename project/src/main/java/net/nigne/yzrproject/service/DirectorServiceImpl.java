package net.nigne.yzrproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.persistence.ActorDAO;
import net.nigne.yzrproject.persistence.DetailDAO;
import net.nigne.yzrproject.persistence.DirectorDAO;
import net.nigne.yzrproject.persistence.LoginDAO;

@Service
public class DirectorServiceImpl implements DirectorService {
	
	@Autowired
	private DirectorDAO dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<DirectorVO> getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}
}
