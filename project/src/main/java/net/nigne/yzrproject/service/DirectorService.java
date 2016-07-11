package net.nigne.yzrproject.service;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.DirectorVO;

public interface DirectorService {
	
	public List<DirectorVO> getList(String movie_id);
	
}
