package project.simsim.systems.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.simsim.systems.daos.ManagerAdDAOImpl;
import project.simsim.systems.domains.ManagerAdVO;




    @Service("ManagerAdService")
	public class ManagerAdServicelmpl implements ManagerAdService {
		
		@Autowired
		private ManagerAdDAOImpl ManagerAdDAO ;
		
		@Override
		public void insertManager(ManagerAdVO vo) {
			
			ManagerAdDAO.insertManager(vo);
		}
		@Override
		public void updateManager(ManagerAdVO vo){ 
			
			ManagerAdDAO.updateManager(vo);
		}
		@Override
		public void deleteManager(ManagerAdVO vo) {
			
			ManagerAdDAO.deleteManager(vo);
		}
		public ManagerAdVO getManager(ManagerAdVO vo) {
			System.out.println("Ser : gM");
			
			return ManagerAdDAO.getManager(vo);
		}

		@Override
		public List<ManagerAdVO> getManagerList(ManagerAdVO vo) {
			return ManagerAdDAO.getManagerList(vo);
		}
		@Override
		public void clickLogin(ManagerAdVO vo) {
			ManagerAdDAO.clickLogin(vo);
		}
		@Override
		public void click(String adnum) {
			ManagerAdDAO.click(adnum);
		}
	}