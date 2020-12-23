package project.simsim.systems.daos;

import java.util.List;

import project.simsim.systems.domains.ManagerAdVO;



public interface ManagerAdDAO {
	
	public void insertManager(ManagerAdVO vo);

	public void updateManager(ManagerAdVO vo) ;

	public void deleteManager(ManagerAdVO vo);
	
	public ManagerAdVO getManager(ManagerAdVO vo) ;
	
	public List<ManagerAdVO> getManagerList(ManagerAdVO vo) ;



}
