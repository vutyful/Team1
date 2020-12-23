package project.simsim.systems.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.services.MainServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private MainServiceImpl mainService;
	
	//메인화면 연결 (로그인 전)
	@RequestMapping("/main/main.do")
	public void start(ContentVO vo,Model m) {
		//DB에서 가져온 모든 컨텐츠 메인으로 넘기기
		m.addAttribute("contents", mainService.getAllContent(vo)); 
		System.out.println("모든 컨텐츠 가져옴"+mainService.getAllContent(vo).get(0).getCcontent());
	}
	
	
	@RequestMapping("/main/{url}.do")
	public String text(@PathVariable String url) {
		return "/main/"+url;
	}
	

	//로그인 상태의 메인(main_login.jsp)에서 북마크로 이동
	@RequestMapping("/main/bookmark.do") 
	public void bookmark() {
		
	}
 
	//로그인 상태의 메인에서 컨텐츠 view로 이동
	@RequestMapping("/main/contents_login.do")
	public void contents_login(ContentVO vo,Model m) {
		//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
		m.addAttribute("content", mainService.getSelectByconnum(vo));
	}
	
	//메인에서 컨텐츠 view로 이동
		@RequestMapping("/main/contents.do")
		public void contents(ContentVO vo,Model m) {
			//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
			m.addAttribute("content", mainService.getSelectByconnum(vo));
			System.out.println("컨텐츠 레코드 하나 가져오기"+mainService.getSelectByconnum(vo).getTitle());
		}


	//로그아웃
	@RequestMapping("/main/logout.do")
	public String logout() {
		return "redirect:main.do";
	}

}
