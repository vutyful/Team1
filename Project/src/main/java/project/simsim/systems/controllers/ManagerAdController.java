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
public class ManagerAdController {
	
	@Autowired
	private ManagerAdService ManagerAdService;
	
	
	@RequestMapping("managerAd/{manager}.do")
	public String viewPage(@PathVariable String manager) {
		return "/managerAd/" + manager; 
	}
	
	@RequestMapping("managerAd/click_login.do")
	public String click(String gender, String birth, String link, String adnum)
	{/*
		//1. 젠더를 구해서 해당 젠더만 1 증가시키는거 보낸다.
		int number = Integer.parseInt(adnum);
		if(gender.equals("남"))
			ManagerAdService.clickGender("clickm", number);
		else
			ManagerAdService.clickGender("clickf", number);
		//2. 나이를 구해서 나이만 증가시키는거 보낸다.
		int age = Integer.parseInt(birth.substring(4));//연도만 가져옴
		//이거 범위 비교해서 연령 10대인지 20대인지 ... 구하셔서 그거 증가시키는 sql만드세요
		if(2000 < age <= 2010)
		{
			//10대의 값을 증가시키는 sql 만드시면됩니다. 나머지 다 만드시면 끗.
		}
		
		//3. total(광고 총 클릭수) +1 증가시키는거 보낸다. */
		final String red="redirect:http://" + link;
		return red;
	}
	
	@RequestMapping("managerAd/click.do")
	public String click(String link)
	{	
		//3. total(광고 총 클릭수) +1 증가시키는거 보낸다. 
		final String red="redirect:http://" + link;
		return red;
	}
	
	@RequestMapping("{manager}.do")
	public String viewPage1(@PathVariable String manager) {
		return manager ;
	}
    //광고 목록창 불러오기
	@RequestMapping("managerAd/getManagerList.do")
	public void getManagerAdList(ManagerAdVO vo,Model model) {
        ArrayList<ManagerAdVO> temp = (ArrayList<ManagerAdVO>) ManagerAdService.getManagerList(vo);
		       for(ManagerAdVO t : temp)
		    {System.out.println("dao"+ t.getAdname());}
    model.addAttribute("managerList",ManagerAdService.getManagerList(vo));
	}
	
	//광고 상세정보창 보기
	@RequestMapping("managerAd/getManager.do")
	public void getManager(ManagerAdVO vo,Model model) {
		System.out.println("con : gM");
		model.addAttribute("manager",ManagerAdService.getManager(vo));
    }
	
	// 광고등록
	@RequestMapping("managerAd/saveManager.do")
	public String insertAdManager(ManagerAdVO vo) {
	  ManagerAdService.insertManager(vo);
		 return "redirect:/managerAd/getManagerList.do" ;
	}
	
	//광고수정
	@RequestMapping("managerAd/updateManager.do")
	public String updateManager(@ModelAttribute("manager") ManagerAdVO vo) {
		ManagerAdService.updateManager(vo);
		return "redirect:/managerAd/getManagerList.do";
	}
	
	//광고삭제
	@RequestMapping("managerAd/deleteManager.do")
	public String deleteManager(ManagerAdVO vo) {
		ManagerAdService.deleteManager(vo);
		return "redirect:/managerAd/getManagerList.do";
	}
	
}
