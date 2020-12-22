package project.simsim.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	//회원 관련 view (로그인, 회원가입)
	@RequestMapping("/hjview/{all}.do")
	public String all(@PathVariable String url) {
		return "/hjview/"+url;
	}
	
	//로그인 됐다 치고 로그인 상태의 메인 띄우기
	@RequestMapping("/main/main_login.do")
	public void text() {
		
	}
	
	//로그인 상태의 메인(main_login.jsp)에서 북마크로 이동
	@RequestMapping("/main/bookmark.do")
	public String bookmark() {
		return "main/bookmark";
	}
	
	//로그인 상태의 메인에서 컨텐츠 view로 이동
	@RequestMapping("/main/contents_login.do")
	public String contents_login() {
		return "main/contents_login";
	}

	//컨텐츠 view에서 
}
