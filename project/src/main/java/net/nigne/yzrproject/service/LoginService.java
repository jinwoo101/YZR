package net.nigne.yzrproject.service;

import net.nigne.yzrproject.domain.MemberVO;

public interface LoginService {
	
	public MemberVO getMember(String member_id);
	
}
