package project.simsim.systems.controllers;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			return "redirect:/main/main_login.do";
		}
	}

	
	//회원가입 시 이름, 이메일, 아이디 중복 확인
	@RequestMapping(value="/hjview/check.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String check(MemberVO vo) {
		//이름, 이메일, 아이디 중복 확인
		List<MemberVO> list=memberservice.CheckUnique(vo);
		if(list.isEmpty()) {
			return "성공";
		}
		for(MemberVO v : list) {
			if(v.getName().equals(vo.getName())) {
				return "이미 존재하는 이름 입니다.";
			}
			if(v.getId().equals(vo.getId())) {
				return "이미 존재하는 아이디 입니다.";
			}
		};
		return "이미 존재하는 이메일입니다.";
		}
	
	//회원 정보 삽입
	@RequestMapping(value="/hjview/userInsert.do")
	public String insert(MemberVO vo) {
		//삽입
		memberservice.userInsert(vo);
		return "redirect:/hjview/joinResult.do";
	}
	
	
	
	
	
	
	/*
	@RequestMapping("hjview/{url}.do")
	public String basic(@PathVariable("url") String url) {
		return "hjview/"+url;
	}
	*/
	
	
	//프로필 이미지 업로드
	@RequestMapping(value ="/hjview/uploadPic.do") 
	public String pic(MemberVO vo, HttpSession session, Model m) throws IOException {
		//file정보만 있는 vo에 세션에서 로그인 id 정보 추기
		vo.setId((String)session.getAttribute("login"));
		//로그인 안했을 때
		if(session==null ||  vo.getId()==null) {
			return "redirect:/hjview/login.do";}
		//프로필 업로드
		memberservice.picUpdate(vo);
		m.addAttribute("member",vo);
		return "redirect:/hjview/profile.do";

	}
	

	
	
	
	//프로필 눌렀을 때 회원 정보 세팅
	@RequestMapping(value ="/hjview/profile.do")
	public String profile( HttpSession session, Model m, 
			@RequestParam(value="page", required=false, defaultValue="1") Integer page,
			@RequestParam(value="page", required=false, defaultValue="1") Integer block) {
		MemberVO vo = new MemberVO();
		vo.setId((String)session.getAttribute("login"));
		//로그인 안했을 때
		if(session==null || vo.getId()==null) {
			return "redirect:/hjview/login.do";}
		
		//로그인 했을 때
		MemberVO result = memberservice.idCheck(vo);
		
		//원하는 포멧으로 birth 변경
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birthday= format.parse(result.getBirth());
			result.setBirth(format.format(birthday));
		} catch (ParseException e) {
		}
		m.addAttribute("member",result);	
		
		//댓글 세팅
		int memnum = (int)session.getAttribute("longinNo");
		Map<String, Integer> reply = new HashMap<String, Integer>();
		reply.put("memnum", memnum);
		reply.put("page", page);
		
		
		List<Map<String,Object>> replyList=memberservice.getReply(reply);
		
		int totalCount;//총 댓글 수
		int pageTotalCount; //총 페이지
		int countPerPage=10; //한 인덱스당 게시물 갯수

		
		//총게시글 수
		totalCount =Integer.parseInt((String.valueOf(replyList.get(1).get("COUNT"))));
		//총 page 수
		pageTotalCount = totalCount/countPerPage;
		if(totalCount%countPerPage !=0)pageTotalCount++;

		
		
		
		m.addAttribute("replyList",replyList);
		m.addAttribute("totalCount",totalCount);
		m.addAttribute("pageTotalCount",pageTotalCount);
		m.addAttribute("countPerPage",countPerPage);
		
		return "hjview/profile";
	}
	
	
	//프로필 수정 시 닉네임. 이메일 중복체크
	@RequestMapping(value="/hjview/checkProfile.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String checkProfile(MemberVO vo,  HttpSession session, @RequestParam("newPass") String newPass) {
		vo.setId((String)session.getAttribute("login"));

		//pass맞는지 확인
		if(memberservice.idCheck(vo)==null) {
			return "비밀번호가 틀립니다.";
		}

		//이름, 이메일, 중복 확인
		List<MemberVO> list=memberservice.checkUniqueProfile(vo);
				
		if(list.isEmpty()) {
			return "성공";
		}else {
		for(MemberVO v : list) {
			if(v.getName().equals(vo.getName())) {
				return "이미 존재하는 이름 입니다.";}
		}
		return "이미 존재하는 이메일입니다.";
		}
		}
	
	
	//프로필 수정
	@RequestMapping(value="/hjview/profileEdit.do")
	public String profileEdit(MemberVO vo,HttpSession session,@RequestParam("newPass") String newPass) {
		vo.setId((String)session.getAttribute("login"));
		//새 비밀번호 입력 시 새 비밀번호로 바꿈
		if(newPass==null || newPass.equals("")) {
		}else {
		vo.setPass(newPass);
		}
		memberservice.memberUpdate(vo);
		return "redirect:/hjview/profile.do";
		
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
	//아이디, 비밀번호, 이메일 인증번호 확인
	@RequestMapping(value="/hjview/leaveCheck.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String leave(MemberVO vo, HttpSession session, @RequestParam("confirmNum") String confirmNum) {
		MemberVO result =  memberservice.idCheck(vo);
		//아이디가 일치할 때
		if(!vo.getId().equals(session.getAttribute("login"))) {
			return "아이디가 일치하지 않습니다.";
		
		//비밀번호가 틀렸거나 맞는 비밀번호가 비었을 때
		}else if(result==null ) {
			return "비밀번호가 틀렸습니다.";
		}else if(confirmNum==null ||confirmNum==""){
			return "이메일을 확인해주세요.";
		}else if(!confirmNum.equals("123")) {
			return "인증번호가 일치하지 않습니다.";
		}else {
			return "탈퇴";
		}
	}
	
	
	//탈퇴 하고 페이지 이동
	@RequestMapping("/hjview/leave.do")
	public void leave(MemberVO vo, HttpSession session) {
		memberservice.memberLeave(vo);
		session.invalidate();
		
	}
	
	@RequestMapping("/hjview/bye.do")
	public String leave() {
		return "redirect:/main/main_login.do";
		
	}
	


}
