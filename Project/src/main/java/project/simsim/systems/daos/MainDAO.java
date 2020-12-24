package project.simsim.systems.daos;

import java.util.List;

import project.simsim.systems.domains.ContentVO;

public interface MainDAO {

	//메인에 띄울 컨텐츠 전부 끌어오기
	public List<ContentVO> getAllContent(ContentVO vo);
	
	//클릭된 컨텐츠 레코드 가져오기
	public ContentVO getSelectByconnum(ContentVO vo);
	
	//아이디로 해당 북마크 값 가져오기
	public String getBookmark(String id);
		
	//해당 아이디의 북마크에 수정된 북마크 값 넣기
	public int updateBookmark(String id,String bm);
}
