package net.nigne.yzrproject.persistence;


import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.GpaVO;

public interface GpaDAO {
	
	public GpaVO getList(String movie_id);
	
}
