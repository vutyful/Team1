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
	
	//프로필 수정
	@RequestMapping(value="/hjview/profileEdit.do")
	public String profileEdit(MemberVO vo, HttpSession session) {
		vo.setId((String)session.getAttribute("login"));
		//로그인 안했을 때
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
	

		MemberVO result = memberservice.idCheck(vo);
		//로그인 실패
		if(result==null || result.getId()==null) {
			//로그인 페이지 그대로
			return "hjview/login";
		}else {
			//session에 로그인 기록 저장
			session.setAttribute("login",result.getId());	
			//session에 로그인한 맴버 넘버 저장
			session.setAttribute("longinNo", result.getMemnum());
			//체크박스 체크 시, 세션에 다른이름으로 기록 저장
			if(remember[0]=="Y") {
			session.setAttribute("id", result.getId());
			session.setAttribute("pass", result.getPass());
			}else {
			session.setAttribute("id", "");
			session.setAttribute("pass", "");
			}
			
			return "../views/main/main_login";
		}
	}

	//회원가입
	@RequestMapping("/hjview/userInsert.do")
	public String insert(MemberVO vo, Model m) {
		//이름, 이메일, 아이디 중복 확인
		memberservice.CheckUnique(vo);
		
		//삽입
		memberservice.userInsert(vo);
		return "../views/main/main";
		
	}
	/*
	@RequestMapping("hjview/{url}.do")
	public String basic(@PathVariable("url") String url) {
		return "hjview/"+url;
	}
	*/
	
	
	//프로필 이미지 업로드
	@RequestMapping(value ="/hjview/uploadPic") 
	public String pic(MemberVO vo, HttpSession session, Model m) throws IOException {
		//로그인 안했을 때
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";}
		
		//file정보만 있는 vo에 세션에서 로그인 id 정보 추기
		vo.setId((String)session.getAttribute("login"));

			//파일 업로드 없을 때
		if(vo.getFile()==null){
			MemberVO result = memberservice.idCheck(vo);
			m.addAttribute("member",result);	
			return "hjview/profile";
			//파일 업로드 있을 때
		}else if(vo.getFile()!=null){
			memberservice.picUpdate(vo);
			MemberVO result = memberservice.idCheck(vo);
			m.addAttribute("member",result);	
			return "hjview/profile";
		}else{
			return "hjview/profile";
		}
	}
	
	//프로필 눌렀을 때 회원 정보 세팅
	@RequestMapping(value ="/hjview/profile.do")
	public String profile( HttpSession session, Model m) {
		MemberVO vo = new MemberVO();
		vo.setId((String)session.getAttribute("login"));
		//로그인 안했을 때
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";
		}
		//로그인 했을 때
		MemberVO result = memberservice.idCheck(vo);
		m.addAttribute("member",result);	
		return "hjview/profile";
	}
	
	
	@RequestMapping("/hjview/join.do")
	public void join() {
		
	}
	@RequestMapping("/hjview/login.do")
	public void login() {
		
	}
	@RequestMapping("/hjview/leaveOk.do")
	public void leaveOK() {
		
	}
	
	//탈퇴
	@RequestMapping(value="/hjview/leave.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String leave(MemberVO vo, HttpSession session, @RequestParam("confirmNum") String confirmNum, Model m) {
		MemberVO result =  memberservice.idCheck(vo);
		
		m.addAttribute("g","gg");
		
		String msg="탈퇴 시 모든 정보가 사라지며 복구가 어렵습니다.";
		//아이디가 일치할 때
		if(!vo.getId().equals(session.getAttribute("login"))) {
			msg="아이디가 일치하지 않습니다.";
		
		//비밀번호가 틀렸거나 맞는 비밀번호가 없을 때,
		}else if(vo.getPass()=="" || vo.getPass()==null ||result==null ) {
			msg="비밀번호가 틀렸습니다.";
		}else if(confirmNum==null ||confirmNum==""|| !confirmNum.equals("123")){
			msg="이메일을 확인해주세요.";
		}else if(confirmNum.equals("123")){
			msg="탈퇴가 완료 되었습니다.";
			memberservice.memberLeave(vo);
			session.invalidate();
		}
		return msg;
	}
	
	


}
