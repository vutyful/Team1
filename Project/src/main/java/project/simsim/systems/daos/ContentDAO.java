package project.simsim.systems.daos;

import java.util.List;

import project.simsim.systems.domains.ContentVO;

public interface ContentDAO {
	public void saveContent(ContentVO vo);
	public void modifyContent(ContentVO vo);
	public void deleteContent(ContentVO vo);
	public ContentVO getContent(ContentVO vo);
	public List<ContentVO> getContentsList();
	public List<String> getCategoryList();
}
