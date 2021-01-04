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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.MemberVO;
import project.simsim.systems.services.MailSendService;
import project.simsim.systems.services.MainService;
import project.simsim.systems.services.MainServiceImpl;
import project.simsim.systems.services.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	@Autowired
	private MailSendService mailservice;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	

	
	
	//로그인
	@RequestMapping(value="/hjview/userCheck.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String userCheck(MemberVO vo,  HttpSession session) {
		//pwdEncoder.matches(입력된 비밀번호(), 암호화된 비밀번호()) 
		MemberVO result = memberservice.idCheck(vo);
		//암호화 된 비밀번호
		boolean pwsIs = pwdEncoder.matches(vo.getPass(), result.getPass());
		//로그인 실패
		if(result==null || result.getId()==null || !pwsIs) {
		return "실패";
		}else if(result.getState().equals("탈퇴")){
			return "탈퇴";
		}else if(result.getState().equals("차단")){
			return "차단";
		}else{
			//session에 로그인 기록 저장
			session.setAttribute("login",result.getId());	
			//session에 로그인한 맴버 넘버 저장
			session.setAttribute("loginNo", result.getMemnum());
			//session에 사진 이름 저장
			session.setAttribute("gender", result.getGender());
			session.setAttribute("birth", result.getBirth());
			session.setAttribute("pic", result.getPic());
			session.setAttribute("auth", result.getAuth());
			return"성공";
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
		return "redirect:/hjview/login.do";
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
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/hjview/profile.do";

	}
	

	
	
	
	//프로필 눌렀을 때 회원 정보 세팅
	@RequestMapping(value ="/hjview/profile.do")
	public String profile( HttpSession session, Model m, 
			@RequestParam(value="page", required=false, defaultValue="1") Integer page) {
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
		
		//댓글 세팅 페이지
		int memnum = (int)session.getAttribute("loginNo");
		Map<String, Integer> reply = new HashMap<String, Integer>();
		reply.put("memnum", memnum);
		reply.put("page", page);
		
		
		List<Map<String,Object>> replyList=memberservice.getReply(reply);

		int totalCount;//총 댓글 수
		int pageTotalCount; //총 페이지
		int countPerPage=5; //한 인덱스당 게시물 갯수
		int pagePerBlock=5; //블록 당 인덱스 개수
		int thisBlock; //지금 블록 0부터 시작
		int firstPage;//지금 블록 처음 페이지
		int lastPage;//지금 블록 마지막 페이지

		
		//총게시글 수
		//값이 없으면 리턴
		if(replyList.size()==0) {return "hjview/profile";}
		totalCount =Integer.parseInt((String.valueOf(replyList.get(0).get("COUNT"))));
		System.out.println("total: " + totalCount);
		//총 page 수
		pageTotalCount = totalCount/countPerPage;
		if(totalCount%countPerPage !=0)pageTotalCount++;
		
		//블록 0부터 시작
		thisBlock=(page-1)/pagePerBlock;
		//지금 블록 처음 페이지
		firstPage=thisBlock*pagePerBlock+1;
		if(firstPage<1) {firstPage=1;}
		
		//지금 블록 마지막 페이지
		lastPage=thisBlock*pagePerBlock+pagePerBlock;
		if(lastPage>pageTotalCount) {lastPage=pageTotalCount;}
		
		
		m.addAttribute("replyList",replyList);
		m.addAttribute("firstPage",firstPage);
		m.addAttribute("lastPage",lastPage);
		m.addAttribute("pageTotalCount",pageTotalCount);
		
		return "hjview/profile";
	}
	
	
	//프로필 수정 시 닉네임. 이메일 중복체크
	@RequestMapping(value="/hjview/checkProfile.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String checkProfile(MemberVO vo,  HttpSession session, @RequestParam("newPass") String newPass) {
		vo.setId((String)session.getAttribute("login"));
		MemberVO result = memberservice.idCheck(vo);
		//비밀번호 맞는지 확인
		boolean passIs = pwdEncoder.matches(vo.getPass(), result.getPass());
		//pass맞는지 확인
		if(!passIs) {
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
		return "redirect:/hjview/profile.do?loca=profile";
		
	}
	
	
	
	
	
	@RequestMapping("/hjview/join.do")
	public void join() {
		
	}
	@RequestMapping("/hjview/login.do")
	public void login() {
		
	}

	
	//탈퇴
	//아이디, 비밀번호, 이메일 인증번호 확인
	@RequestMapping(value="/hjview/leaveCheck.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String leave(MemberVO vo, HttpSession session, @RequestParam("confirmNum") String confirmNum) {
		MemberVO result =  memberservice.idCheck(vo);
		//비밀번호 같나 
		boolean passIs = pwdEncoder.matches(vo.getPass(), result.getPass());
		//랜덤문자
		String tempPass =mailservice.makeTempPass();
		//세션에서 랜덤문자 가져옴
		String tempPassSession = (String)session.getAttribute("tempPass");
		System.out.println("/"+tempPassSession);
		//세션에 랜덤문자 기존의 랜덤문자가 없으면 새로 생성
		if(tempPassSession==null) {
			session.setAttribute("tempPass", tempPass);
			tempPassSession=(String)session.getAttribute("tempPass");
		}
		if(!vo.getId().equals(session.getAttribute("login"))) {
			return "아이디가 일치하지 않습니다.";
		//아이디가 일치할 때
		//비밀번호가 틀렸거나 맞는 비밀번호가 비었을 때
		}else if(!passIs) {
			return "비밀번호가 틀렸습니다.";
		}else if(confirmNum==null ||confirmNum==""){
			//세션에 있는 랜덤문자 보냄
			mailservice.leaveMailSend(tempPassSession, result.getEmail());
			return "이메일을 확인해주세요.";
		}else if(confirmNum.equals(tempPassSession)) {
			return "탈퇴";
		}else {
			return "인증번호가 일치하지 않습니다.";
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
		return "redirect:/main/main.do";
		
	}
	
	
	//비밀번호 찾기
	@RequestMapping(value="/hjview/checkEmail.do",  produces="application/text;charset=utf-8")
	@ResponseBody
	public String checkEmail(MemberVO vo) {
		MemberVO result = memberservice.idCheck(vo);
		
		if(result==null) {
			return "아이디와 이메일을 정확히 입력해 주세요.";
		}else if(!result.getEmail().equals(vo.getEmail())) {
			return "아이디와 일치하는 이메일이 없습니다.";
		}else {
			String tempPass = mailservice.makeTempPass();
			result.setPass(tempPass);
			memberservice.tempPass(result);
			mailservice.mailSend(tempPass, vo.getEmail());
			
			return "성공";
		}
		
		
	}
	
	@RequestMapping
	public void passFind() {
		
	}
	
	
	
	
	


}
