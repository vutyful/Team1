package project.simsim.systems.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.simsim.systems.daos.MainDAO;
import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.ReplyVO;

@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mainDAO;

	@Override
	//content 레코드 모두 가져와 랜덤하게 배열 후 20개만 리턴
	public List<ContentVO> getAllContent(ContentVO vo) {
		System.out.println("Service:getAllContent");
		
		/*
		 * List<ContentVO> list = new ArrayList<ContentVO>(); List<ContentVO> result =
		 * new ArrayList<ContentVO>();
		 * 
		 * list = dao.getAllContent(); //DB에서 가져온 레코드 list에 담기
		 * Collections.shuffle(list); //랜덤하게 섞기 for(int i=0;i<20;i++) {
		 * result.add(list[i]); }
		 */
		return mainDAO.getAllContent(vo);
	}

	@Override
	//선택된 컨텐츠의 레코드 가져오기 
	public ContentVO getSelectByconnum(ContentVO vo) {
		return mainDAO.getSelectByconnum(vo);
	}

	@Override
	//선택된 컨텐츠의 레코드 가져오기 
	public ContentVO getSelectByconnum(String connum) {
		return mainDAO.getSelectByconnum(connum);
	}
	
	@Override
	//아이디로 해당 북마크 값 가져오기
	public String getBookmark(String id) {
		String bm = mainDAO.getBookmark(id);
		return bm;
	}

	@Override
	//해당 아이디의 북마크에 수정된 북마크 값 넣기
	public int updateBookmark(String id, String bm) {
		return mainDAO.updateBookmark(id, bm);
	}

	@Override
	//해당 아이디로 회원번호 가져오기
	public String getMemnumById(String id) {
		return mainDAO.getMemnumById(id);
	}

	@Override
	//댓글 등록
	public int insertReply(ReplyVO vo) {
		return mainDAO.insertReply(vo);
		
	}

	@Override
	//해당 게시글의 댓글 전부 불러오기
	public List<ReplyVO> getAllReply(ContentVO vo) {
		System.out.println("service:getAllReply");
		return mainDAO.getAllReply(vo);
	}

	@Override
	//해당 댓글 수정
	public int updateReply(ReplyVO vo) {
		return mainDAO.updateReply(vo);
	}

	@Override
	//해당 댓글 삭제
	public int deleteReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//해당 댓글 추천 여부 업데이트
	public int updateReco(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
