package net.nigne.yzrproject.service;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;

public interface ActorService {
	
	public List<ActorVO> getList(String movie_id);
	
}
