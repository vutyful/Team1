package project.simsim.systems.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.simsim.systems.daos.MemberDAO;
import project.simsim.systems.domains.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	
	/**
	  * 아이디 중복 체크하는 sql + 로그인 기능 sql
	  * 회원정보 하나 가져오기
	  */
	  public MemberVO idCheck( MemberVO vo)
	  {
		  return memberDAO.idCheck(vo);
	  }
	  
	  
	  /**
	   * 회원가입 sql
	   */
	   public int userInsert(MemberVO vo )
	   {
		   
		  return memberDAO.memberInsert(vo);
	   }

	   @Override
	   public MemberVO CheckUnique(MemberVO vo) {
		   return memberDAO.CheckUnique(vo);
	   }


	@Override
	public int memberUpdate(MemberVO vo) {

		return memberDAO.memberUpdate(vo);
	}


	@Override
	public int picUpdate(MemberVO vo) {
		return memberDAO.picUpdate(vo);
	}


	@Override
	public int memberLeave(MemberVO vo) {

		return memberDAO.memberLeave(vo);
	}


}
