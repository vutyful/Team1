package project.simsim.systems.controllers;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.simsim.systems.domains.MemberVO;
import project.simsim.systems.services.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	
	//프로필 이미지 업로드
	@RequestMapping(value ="/hjview/uploadPic") 
	public String pic(MemberVO vo, HttpSession session, Model m) throws IOException {
		vo.setId((String)session.getAttribute("login"));
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";
		}else {
			memberservice.picUpdate(vo);
			m.addAttribute("member",vo.getPic());
			
			return "redirect:/hjview/profile.do";
		}
	
	}
	
	//프로필 수정
	@RequestMapping(value="/hjview/profileEdit.do")
	public String profileEdit(MemberVO vo, HttpSession session) {
		vo.setId((String)session.getAttribute("login"));
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";
		}else {
		memberservice.memberUpdate(vo);
		
		
		return "redirect:/hjview/profile.do";}
	}
	
	//비밀번호 찾기
	@RequestMapping("/hjview/passFind.do")
	public void passFind() {
		
	}
	
	
	@RequestMapping("/hjview/loginOk.do")
	public void loginMain() {
		
	}
	
	//로그인
	@RequestMapping("/hjview/userLogin.do")
	public String login(MemberVO vo  , HttpSession session, @RequestParam("remember-id") String[] remember) {
		MemberVO result = memberservice.idCheck_Login(vo);
		
		
		if(result==null || result.getId()==null) {
			//로그인 페이지 그대로
			return "hjview/login";
		}else {
			//session에 로그인 기록 저장
			session.setAttribute("login",result.getId());	
			//체크박스 체크 시, 세션에 다른이름으로 기록 저장
			if(remember[0]=="Y") {
			session.setAttribute("id", result.getId());
			session.setAttribute("pass", result.getPass());
			}else {
			session.setAttribute("id", "");
			session.setAttribute("pass", "");
			}
			
			return "redirect:/main/main_login.do";
		}
	}

	//회원가입
	@RequestMapping("/hjview/userInsert.do")
	public String insert(MemberVO vo) {
		memberservice.userInsert(vo);
		
		System.out.println(vo.getId());
		
		return "../views/main/main";
		
	}
	/*
	@RequestMapping("hjview/{url}.do")
	public String basic(@PathVariable("url") String url) {
		return "hjview/"+url;
	}
	*/
	
	//프로필 눌렀을 때 회원 정보 세팅
	@RequestMapping("/hjview/profile.do")
	public String profile( HttpSession session, Model m) {
		MemberVO vo = new MemberVO();
		vo.setId((String)session.getAttribute("login"));
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";
		}
		MemberVO result = memberservice.getMember(vo);
		m.addAttribute("member",result);	
		return "hjview/profile";
	}
	
	@RequestMapping("/hjview/join.do")
	public void join() {
		
	}
	@RequestMapping("/hjview/login.do")
	public void login() {
		
	}
	@RequestMapping("/hjview/leave.do")
	public void leave() {
		
	}
	
	


}
