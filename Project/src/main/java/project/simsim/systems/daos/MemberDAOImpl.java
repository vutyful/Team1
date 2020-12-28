package project.simsim.systems.daos;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<MemberVO> CheckUnique(MemberVO vo) {
		System.out.println("===>  MemberMapper CheckUnique() 호출");
		return mybatis.selectList("MemberMAP.CheckUnique", vo);
	}

	@Override
	public List<MemberVO> checkUniqueProfile(MemberVO vo) {
		System.out.println("===>  MemberMapper checkUniqueProfile() 호출");
		return mybatis.selectList("MemberMAP.checkUniqueProfile", vo);
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

	@Override
	public int memberLeave(MemberVO vo) {
		System.out.println("===>  MemberMapper memberLeave() 호출");
		return mybatis.update("MemberMAP.memberLeave",vo);

	}

	@Override
	public List<Map<String,Object>> getReply(Map<String,Integer> reply) {
		System.out.println("===>  MemberMapper getReply() 호출");
		return mybatis.selectList("MemberMAP.getReply",reply);

	}
	

}
