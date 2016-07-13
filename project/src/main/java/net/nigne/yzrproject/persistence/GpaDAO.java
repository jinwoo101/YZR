package net.nigne.yzrproject.persistence;


import java.util.List;


import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.GpaVO;

public interface GpaDAO {
	public GpaVO get(String movie_id);
//	public void gpaInsert(String movie_id, int acting, int direction, int beauty, int ost, int story) throws Exception;
	public void gpaUpdate(GpaVO data,String movie_id, int acting, int direction, int beauty, int ost, int story) throws Exception;
}
