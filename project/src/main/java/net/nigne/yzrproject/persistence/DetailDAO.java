package net.nigne.yzrproject.persistence;

import java.util.List;

import net.nigne.yzrproject.domain.DetailVO;

public interface DetailDAO {
	
	public DetailVO getList(String movie_id);
	
}
