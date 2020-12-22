package project.simsim.systems.services;

import java.util.List;

import project.simsim.systems.domains.ContentVO;

public interface ManageContentsService {
	void saveContent(ContentVO vo); 
	ContentVO getContent(ContentVO vo);
	List<ContentVO> getContentsList();
}
