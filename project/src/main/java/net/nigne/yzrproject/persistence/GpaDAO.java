package net.nigne.yzrproject.persistence;


import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.GpaVO;

public interface GpaDAO {
	
	public void gpaInsert(String movie_id, String acting) throws Exception;
}
