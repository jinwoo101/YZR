package net.nigne.yzrproject.service;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.GpaVO;

public interface GpaService {
	
	public void gpaInsert(String movie_id,String acting) throws Exception;
}
