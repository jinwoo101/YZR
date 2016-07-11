package net.nigne.yzrproject.persistence;


import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;

public interface ActorDAO {
	
	public List<ActorVO> getList(String movie_id);
	
}
