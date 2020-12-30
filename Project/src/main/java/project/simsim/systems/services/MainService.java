package project.simsim.systems.services;

import java.util.List;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.ManagerAdVO;
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
	
	//해당 아이디로 추천 누른 댓글번호 문자열 가져오기
	public String getLikeReply(String id);
	
	//해당 아이디로 추천 누른 댓글번호 문자열 업데이트
	public void updateLikeReply(String id, String like_reply);
	
	//해당 댓글의 추천 수 가져오기 (댓글 번호 필요)
	public String getRreco (ReplyVO vo);
	
	//해당 댓글의 추천 수 업데이트 (댓글번호, 업데이트된 추천수 필요 )
	public void updateRreco (ReplyVO vo);
	
	//연관 컨텐츠 가져오기
	public List<ContentVO> getLinkContent(ContentVO vo);
	
	//광고 전체 랜덤하게 가져오기
	public List<ManagerAdVO> getAllAd();
	
	//해당 광고번호로 광고 레코드 가져오기
	public ManagerAdVO getOneAd(ManagerAdVO vo);
	
	
}
