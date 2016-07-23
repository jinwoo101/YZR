package net.nigne.yzrproject.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MemberVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;
import net.nigne.yzrproject.persistence.MovieDAO;
import net.nigne.yzrproject.persistence.LoginDAO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO dao;

	@Transactional(readOnly = true)
	@Override
	public MovieVO getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ActorVO> getActor(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getActor(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DirectorVO> getDirector(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getDirector(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public GpaVO getGpa(String movie_id) {
		return dao.getGpa(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception {
		dao.gpaUpdate(movie_id, acting, direction, beauty, ost, story, male, female, teenager, twenties, thirties,
				forties);
	}
	
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<GenreVO> getGenre(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getGenre(movie_id);
	}
	
}