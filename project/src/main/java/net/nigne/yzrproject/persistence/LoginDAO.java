package net.nigne.yzrproject.persistence;

import net.nigne.yzrproject.domain.MemberVO;

public interface LoginDAO {
	
	public MemberVO getMember(String member_id);
	
}
