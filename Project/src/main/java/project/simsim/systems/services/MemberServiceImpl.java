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
	  */
	  public MemberVO idCheck_Login( MemberVO vo)
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

	   //회원 정보 가져오기
	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);
	}


	@Override
	public int memberUpdate(MemberVO vo) {

		return memberDAO.memberUpdate(vo);
	}


	@Override
	public int picUpdate(MemberVO vo) {
		return memberDAO.picUpdate(vo);
	}
}
