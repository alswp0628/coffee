package service;

import dto.MemberDto;

public interface MemberService {

public boolean getId(String id); // prototype 메소드 사양을 한번에 알수 있음. 
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(String id, String pwd);
}
