package project.simsim.systems.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.ManagerAdVO;
import project.simsim.systems.domains.ReplyVO;

@Repository("mainDAO")
public class MainDAOImpl implements MainDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	//메인에 띄울 컨텐츠 전부 끌어오기
	public List<ContentVO> getAllContent(ContentVO vo) {
		System.out.println("DAO : getAllContent");
		return mybatis.selectList("MainMAP.selectAll");
	}

	@Override
	//클릭된 컨텐츠 레코드 가져오기
	public Map getSelectByconnum(ContentVO vo) {
		
		//return mybatis.selectOne("MainMAP.getOneContent",vo);
		return mybatis.selectOne("MainMAP.getJoinContent",vo);
	}
	
	@Override
	//클릭된 컨텐츠 레코드 가져오기
	public ContentVO getSelectByconnum(String connum) {
		
		return mybatis.selectOne("MainMAP.getContentOne",connum);
	}

	@Override
	//아이디로 해당 북마크 값 가져오기
	public String getBookmark(String id) {
		
		return mybatis.selectOne("MainMAP.getbookmark",id);
	}

	@Override
	//해당 아이디의 북마크에 수정된 북마크 값 넣기
	public int updateBookmark(String id, String bm) {
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("bm", bm);
		return mybatis.update("MainMAP.updateBookmark", map);
		
	}

	@Override
	//해당 아이디로 회원번호 가져오기
	public String getMemnumById(String id) {
		return mybatis.selectOne("MainMAP.getMemnum",id);
	}

	@Override
	//댓글 등록
	public int insertReply(ReplyVO vo) {
		return mybatis.insert("MainMAP.regist_reply",vo);
	}

	@Override
	//해당 게시글의 댓글 전부 불러오기
	public List<ReplyVO> getAllReply(ContentVO vo) {
		System.out.println("dao:getAllReply");
		return mybatis.selectList("MainMAP.selectAllReply", vo);
	}

	@Override
	//해당 댓글 수정
	public int updateReply(ReplyVO vo) {
		return mybatis.update("MainMAP.updateReply", vo);
	}

	@Override
	//해당 댓글 삭제
	public int deleteReply(ReplyVO vo) {
		return mybatis.delete("MainMAP.deleteReply", vo);
	}

	@Override
	//해당 아이디로 추천 누른 댓글번호 문자열 가져오기
	public String getLikeReply(String id) {
		return mybatis.selectOne("MainMAP.getLikeReply",id);
	}

	@Override
	//해당 아이디로 추천 누른 댓글번호 문자열 업데이트
	public void updateLikeReply(String id, String like_reply) {
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("like_reply", like_reply);
		mybatis.update("MainMAP.updateLikeReply",map);
	}

	@Override
	//해당 댓글의 추천 수 가져오기 (댓글 번호 필요)
	public String getRreco(ReplyVO vo) {
		return mybatis.selectOne("MainMAP.getRreco", vo);
	}

	@Override
	//해당 댓글의 추천 수 업데이트 (댓글번호, 업데이트된 추천수 필요 )
	public void updateRreco(ReplyVO vo) {
		mybatis.update("MainMAP.updateRreco", vo);
	}

	@Override
	//연관 컨텐츠 가져오기
	public List<ContentVO> getLinkContent(ContentVO vo) {
		System.out.println(mybatis.selectList("MainMAP.getLinkContent", vo));
		return mybatis.selectList("MainMAP.getLinkContent", vo);
	}

	@Override
	//광고 전체 랜덤하게 가져오기
	public List<ManagerAdVO> getAllAd() {
		return mybatis.selectList("MainMAP.getAllAd");
	}

	@Override
	//해당 광고번호로 광고 레코드 가져오기
	public ManagerAdVO getOneAd(ManagerAdVO vo) {
		return mybatis.selectOne("MainMAP.getOneAd",vo);
	}

}
