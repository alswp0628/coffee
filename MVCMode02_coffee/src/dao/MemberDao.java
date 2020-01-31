package dao;

import dto.MemberDto;

public interface MemberDao {
	
	public MemberDto login(String id, String pwd);
	
	public boolean getId(String id);
	
	public boolean addMember(MemberDto dto);
}
