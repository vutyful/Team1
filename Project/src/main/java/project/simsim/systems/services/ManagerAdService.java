package project.simsim.systems.services;

import java.util.List;



import project.simsim.systems.domains.ManagerAdVO;





public interface ManagerAdService {
	
     
	// 광고 등록
		void insertManager(ManagerAdVO vo);

		// 광고 수정
		void updateManager(ManagerAdVO vo);


		// 광고 삭제
		void deleteManager(ManagerAdVO vo);
		
		// 광고 상세 조회
		ManagerAdVO getManager(ManagerAdVO vo);
		
		// 광고 목록 조회
		List<ManagerAdVO> getManagerList(ManagerAdVO vo); 

	
		
}
