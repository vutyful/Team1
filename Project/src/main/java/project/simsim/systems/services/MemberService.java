package project.simsim.systems.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import project.simsim.systems.domains.MemberVO;


public interface MemberService {
	
	public MemberVO idCheck( MemberVO vo);
	
	public int userInsert(MemberVO vo );
	
	public List<MemberVO> CheckUnique(MemberVO vo );
	
	public List<MemberVO> checkUniqueProfile(MemberVO vo );

	public int memberUpdate(MemberVO vo );
	
	public int picUpdate(MemberVO vo );
	
	public int memberLeave(MemberVO vo );
	
	public List<Map<String,Object>> getReply(Map<String,Integer> reply );
	
}

