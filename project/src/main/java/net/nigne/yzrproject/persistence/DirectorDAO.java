package net.nigne.yzrproject.persistence;


import java.util.List;

import net.nigne.yzrproject.domain.DirectorVO;

public interface DirectorDAO {
	
	public List<DirectorVO> getList(String movie_id);
	
}
