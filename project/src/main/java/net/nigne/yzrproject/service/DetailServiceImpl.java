package net.nigne.yzrproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.DetailVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.persistence.DetailDAO;
import net.nigne.yzrproject.persistence.LoginDAO;

@Service
public class DetailServiceImpl implements DetailService {
	
	@Autowired
	private DetailDAO dao;
	
	@Transactional(readOnly=true)
	@Override
	public DetailVO getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}
}
