package project.simsim.systems.services;


import org.springframework.stereotype.Service;

import project.simsim.systems.domains.MemberVO;


public interface MemberService {
	
	public MemberVO idCheck_Login( MemberVO vo);
	
	public int userInsert(MemberVO vo );

	public MemberVO getMember(MemberVO vo );

	public int memberUpdate(MemberVO vo );
	
	public int picUpdate(MemberVO vo );
}

