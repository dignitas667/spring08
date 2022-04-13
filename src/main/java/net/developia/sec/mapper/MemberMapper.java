package net.developia.sec.mapper;

import net.developia.sec.domain.MemberVO;

public interface MemberMapper {	// DAO
	public MemberVO read(String user_id);
}
