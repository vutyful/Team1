package project.simsim.systems.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import project.simsim.systems.domains.ManagerAdVO;
import project.simsim.systems.services.ManagerAdService;

@Controller
public class ManagerAdSTController {
    
	
	@Autowired
	private ManagerAdService ManagerAdService;
	
	
	@RequestMapping("managerAdST/{manager}.do")
	public String viewPage1(@PathVariable String manager) { 
		return "/managerAdST/" + manager; 
	}
	
	//광고통계창 목록
	@RequestMapping("managerAd/getManagerST.do")
	public void getManagerST(ManagerAdVO vo,Model model) {
         ArrayList<ManagerAdVO> temp = (ArrayList<ManagerAdVO>) ManagerAdService.getManagerList(vo);
		       for(ManagerAdVO t : temp)
		    {System.out.println("dao"+ t.getAdname());}
    model.addAttribute("managerSTList",ManagerAdService.getManagerList(vo));
	}
	
	@RequestMapping("managerAd/getManagerSTList.do")
	public void getManagerSTList(ManagerAdVO vo,Model model) {
		model.addAttribute("manager",ManagerAdService.getManager(vo));
		
	}
	
	
}
	

