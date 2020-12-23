package project.simsim.systems.daos;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.simsim.systems.domains.ManagerAdVO;



@Repository("ManagerAdDAO")
public class ManagerAdDAOImpl implements ManagerAdDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
 
	@Override
	public void insertManager(ManagerAdVO vo) { 
		System.out.println("===> Mybatis insertManager() 호출");
		mybatis.insert("ManagerAdDAO.insertManager",vo);
		
	}

	@Override
	public void updateManager(ManagerAdVO vo) {
		System.out.println("===> Mybatis updateManager() 호출");
		mybatis.update("ManagerAdDAO.updateManager",vo);
		
	}

	@Override
	public void deleteManager(ManagerAdVO vo) {
		System.out.println("===> Mybatis deleteManager() 호출");
		mybatis.delete("ManagerAdDAO.deleteManager",vo);
		
	}
	@Override
	public ManagerAdVO getManager(ManagerAdVO vo) {
		System.out.println("===> Mybatis getManager() 호출");
		return (ManagerAdVO) mybatis.selectOne("ManagerAdDAO.getManager", vo);
	}
	
	@Override
	public List<ManagerAdVO> getManagerList(ManagerAdVO vo) {
		System.out.println("===> Mybatis getManagerList() 호출");
		return mybatis.selectList("ManagerAdDAO.getManagerList",vo);
	}


}
