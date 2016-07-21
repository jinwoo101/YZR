package net.nigne.yzrproject.persistence;

import java.sql.Timestamp;
import java.util.List;



import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.Criteria;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.ReplyVO;
import net.nigne.yzrproject.domain.ReviewVO;

public interface MovieDAO {

	public MovieVO getList(String movie_id);
	public List<ActorVO> getActor(String movie_id);
	public List<DirectorVO> getdirector(String movie_id);
	public GpaVO getgpa(String movie_id);	
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception;
	public List<GenreVO> getGenre(String movie_id);
	
	

	

//	public void gpaInsert(String movie_id, String acting) throws Exception;
}
