package project.simsim.systems.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.simsim.systems.daos.MemberDAO;
import project.simsim.systems.domains.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	
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
	   { String psw = pwdEncoder.encode(vo.getPass());
		vo.setPass(psw);
		  return memberDAO.memberInsert(vo);
	   }

	   @Override
	   public List<MemberVO> CheckUnique(MemberVO vo) {
		   return memberDAO.CheckUnique(vo);
	   }

	   @Override
	   public List<MemberVO> checkUniqueProfile(MemberVO vo) {
		   return memberDAO.checkUniqueProfile(vo);

	   }

	@Override
	public int memberUpdate(MemberVO vo) {
		String psw = pwdEncoder.encode(vo.getPass());
		vo.setPass(psw);

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
	
	@Override
	public int tempPass(MemberVO vo) {
		String psw = pwdEncoder.encode(vo.getPass());
		vo.setPass(psw);
		
		return memberDAO.tempPass(vo);
	}
	
	
	

	private int countPerPage=10; //한 인덱스당 게시물 갯수

	@Override
	public List<Map<String,Object>> getReply(Map<String,Integer> reply) {
		// pageNo에 따른 결과만 검색
				/*페이지 번호	시작 레코드번호 	끝 레코드번호
				 * 1			1			5
				 * 2			6			10
				 * 3			11			15
				 * 4			16			20
				 */
		int endRow = reply.get("page")*countPerPage;
		int firstRow = endRow-countPerPage+1;
		reply.put("endRow", endRow);
		reply.put("firstRow", firstRow);
		

		return memberDAO.getReply(reply);
	}
	
	
	

	


}
