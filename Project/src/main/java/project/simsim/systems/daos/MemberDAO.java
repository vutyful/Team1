package project.simsim.systems.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	List<MemberVO> CheckUnique(MemberVO vo);
	
	List<MemberVO> checkUniqueProfile(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
	int picUpdate(MemberVO vo);
	
	int memberLeave(MemberVO vo);
	
	int tempPass(MemberVO vo);
	
	List<Map<String,Object>> getReply(Map<String,Integer> reply);
}
