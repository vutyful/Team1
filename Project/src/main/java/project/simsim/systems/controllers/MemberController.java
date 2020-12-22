package project.simsim.systems.controllers;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.simsim.systems.domains.MemberVO;
import project.simsim.systems.services.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	

	@RequestMapping("/hjview/loginOk.do")
	public void loginMain() {
		
	}
	
	//로그인
	@RequestMapping("/hjview/userLogin.do")
	public String login(MemberVO vo  ,@RequestParam("remember-id") String[] rememberId, HttpSession session, HttpServletRequest request) {
		MemberVO result = memberservice.idCheck_Login(vo);
		
	    // 쿠키값 가져오기
	    Cookie[] cookies = request.getCookies() ;
	     
	    if(cookies != null){
	    	for (Cookie cookie : cookies) {
	    		if("lastId".equals(cookie.getName())){
	    			session.setAttribute("lastId", cookie.getValue());
	    		}
	    	}
	    }

		
		if(result==null || result.getId()==null) {
			//로그인 페이지 그대로
			return "hjview/login";
		}else {
			//session에 로그인 기록 저장
			session.setAttribute("login",result.getId());	
			if(rememberId[0] == "Y") {
				new Cookie("lastId", result.getId());
			}
			
			return "hjview/loginOk";
		}
	}

	//회원가입
	@RequestMapping("hjview/userInsert.do")
	public String insert(MemberVO vo) {
		memberservice.userInsert(vo);
		
		System.out.println(vo.getId());
		
		return "hjview/joinResult";
		
	}
	
	@RequestMapping("/hjview/{url}.do")
	public String test(@PathVariable String url) {
		return "/hjview/"+url;
	}
	
	


}
