package project.simsim.systems.services;

import java.util.List;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.ReplyVO;

public interface MainService {

	//모든 컨텐츠 불러오기
	public List<ContentVO> getAllContent(ContentVO vo);
	
	//선택된 컨텐츠의 레코드 가져오기
	public ContentVO getSelectByconnum(ContentVO vo);
	
	//선택된 컨텐츠의 레코드 가져오기
	public ContentVO getSelectByconnum(String connum);
	
	//아이디로 해당 북마크 값 가져오기
	public String getBookmark(String id);
	
	//해당 아이디의 북마크에 수정된 북마크 값 넣기
	public int updateBookmark(String id,String bm);
	
	//해당 아이디로 회원번호 가져오기
	public String getMemnumById(String id);
	
	//댓글 달기
	public int insertReply(ReplyVO vo);
	
	//해당 게시글의 댓글 전부 불러오기
	public List<ReplyVO> getAllReply(ContentVO vo);
	
	//해당 댓글 수정
	public int updateReply(ReplyVO vo);
	
	//해당 댓글 삭제
	public int deleteReply(ReplyVO vo);
	
	//해당 댓글 추천 여부 업데이트
	public int updateReco(ReplyVO vo);
	
}
