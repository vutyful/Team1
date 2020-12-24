package project.simsim.systems.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.services.MainServiceImpl;

@Controller
@SessionAttributes("login")
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
	
	//메인화면 연결 (로그인 후)
	@RequestMapping("/main/main_login.do")
	public void main(ContentVO vo,Model m) {
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
	
	//관리자
	@RequestMapping("/{url}.do") 
	public String temp(@PathVariable String url) {
		return url;
	}
 
	//로그인 상태의 메인에서 컨텐츠 view로 이동
	@RequestMapping("/main/contents_login.do")
	public void contents_login(ContentVO vo,Model m, String check) {
		//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
		/*
		String bm = mainService.getBookmark(id);
		if(bm != null)
		{
			String[] bms = bm.split("/");
			List<String> list = new ArrayList<String>();
			Collections.addAll(list, bms);
			if(list.contains(vo.getConnum())) {
				check = "true";
			}
		}
		*/
		m.addAttribute("check", check);
		m.addAttribute("content", mainService.getSelectByconnum(vo));
	}
	
	//메인에서 컨텐츠 view로 이동
	@RequestMapping("/main/contents.do")
	public void contents(ContentVO vo,Model m) {
			//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
			m.addAttribute("content", mainService.getSelectByconnum(vo));
			System.out.println("컨텐츠 레코드 하나 가져오기"+mainService.getSelectByconnum(vo).getImg());
		}

	//해당 게시글을 북마크하기
	@RequestMapping("/main/bm.do")
	public String bm_regist(HttpSession session, String connum,Model m) {
		String id = (String) session.getAttribute("login");
		System.out.println(id+"/"+connum);
		//아이디로 해당 북마크 값 가져오기
		String bm = mainService.getBookmark(id);
		String check = "true"; //true면 북마크 추가, false면 북마크 제거
		if(bm==null) { //기존 북마크가 하나도 없다면
			bm = connum;
			mainService.updateBookmark(id, bm); //바로 북마크 db에 넣기
			m.addAttribute("check", check);
			return "redirect:/main/contents_login.do?connum=" + connum;
		}
		String[] bms = bm.split("/");
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, bms);
		String bms_result = new String();
		
		if(!(bm.isEmpty())) { //가져온 북마크에 해당 게시글 번호가 없다면 list에 추가,이미 있다면 해당 게시글 번호를 list에서 제거
			if(list.contains(connum)) {
				list.remove(connum);
				check = "false";
			}else {
				list.add(connum);
			}
			for(int i=0;i<list.size();i++) { //북마크 list를 다시 "/" 붙여서 String으로
				if(i==0) {
					bms_result = list.get(i);
				}else {
					bms_result = bms_result + "/" +list.get(i);
				}
			}
			//수정된 북마크 string을 id에 맞는 테이블에 넣음
			mainService.updateBookmark(id, bms_result);
			System.out.println(bms_result);
		}
		return "redirect:/main/contents_login.do?connum=" + connum + "&check=" + check;
	}

	//로그아웃
	@RequestMapping("/main/logout.do")
	public String logout() {
		return "redirect:main.do";
	}

}
