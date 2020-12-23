package project.simsim.systems.daos;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.simsim.systems.domains.MemberVO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("===> MemberMapper idCheck 호출");
		return mybatis.selectOne("MemberMAP.idCheck", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		System.out.println("===>  MemberMapper userInsert() 호출");
		return mybatis.insert("MemberMAP.insertMember", vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		System.out.println("===>  MemberMapper getMember() 호출");
		return mybatis.selectOne("MemberMAP.getMember",vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		System.out.println("===>  MemberMapper memberUpdate() 호출");
		return mybatis.update("MemberMAP.memberUpdate",vo);
	}

	@Override
	public int picUpdate(MemberVO vo) {
		System.out.println("===>  MemberMapper picUpdate() 호출");
		return mybatis.update("MemberMAP.picUpdate",vo);

	}



}
