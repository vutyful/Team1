package project.simsim.systems.daos;

import project.simsim.systems.domains.MemberVO;

public interface MemberDAO {
	/**
	 * id 체트 기능 구현
	 */	
	MemberVO  idCheck( MemberVO vo );
	
	/**
	 * 회원가입기능 구현
	 */
	int memberInsert(MemberVO vo);
	
	MemberVO CheckUnique(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int picUpdate(MemberVO vo);
	
	int memberLeave(MemberVO vo);
}
