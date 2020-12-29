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
		return mainDAO.deleteReply(vo);
	}

	@Override
	//해당 아이디로 추천 누른 댓글번호 문자열 가져오기
	public String getLikeReply(String id) {
		return mainDAO.getLikeReply(id);
	}

	@Override
	//해당 아이디로 추천 누른 댓글번호 문자열 업데이트
	public void updateLikeReply(String id, String like_reply) {
		mainDAO.updateLikeReply(id, like_reply);
	}

	@Override
	//해당 댓글의 추천 수 가져오기 (댓글 번호 필요)
	public String getRreco(ReplyVO vo) {
		return mainDAO.getRreco(vo);
	}

	@Override
	//해당 댓글의 추천 수 업데이트 (댓글번호, 업데이트된 추천수 필요 )
	public void updateRreco(ReplyVO vo) {
		mainDAO.updateRreco(vo);
	}

	@Override
	//연관 컨텐츠 가져오기
	public List<ContentVO> getLinkContent(ContentVO vo) {
		return null;
	}

	

}
