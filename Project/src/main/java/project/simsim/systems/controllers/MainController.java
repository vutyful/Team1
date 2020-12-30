package project.simsim.systems.controllers;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import project.simsim.systems.domains.ContentVO;
import project.simsim.systems.domains.ManagerAdVO;
import project.simsim.systems.domains.ReplyVO;
import project.simsim.systems.services.MainServiceImpl;

@Controller
@SessionAttributes("login")
public class MainController {
	
	@Autowired
	private MainServiceImpl mainService;
	
	//메인화면 연결 (로그인 전)
	@RequestMapping("main/main.do")
	public void start(ContentVO vo,Model m) {
		//DB에서 가져온 모든 컨텐츠 메인으로 넘기기
		m.addAttribute("contents", mainService.getAllContent(vo)); 
		//랜덤 광고 전체 가져오기
		m.addAttribute("ad", mainService.getAllAd().get(0));
		
	}
	
	//메인화면 연결 (로그인 후)
	@RequestMapping("/main/main_login.do")
	public void main(ContentVO vo,Model m) {
		//DB에서 가져온 모든 컨텐츠 메인으로 넘기기
		m.addAttribute("contents", mainService.getAllContent(vo)); 
		//랜덤 광고 전체 가져오기
		m.addAttribute("ad", mainService.getAllAd().get(0));
	}
	
	
	@RequestMapping("/main/{url}.do")
	public String text(@PathVariable String url) {
		return "/main/"+url;
	}
	

	//로그인 상태에서 북마크로 이동
	@RequestMapping("/main/bookmark.do") 
	public void bookmark(HttpSession session,Model m) {
		String id = (String) session.getAttribute("login");
		//해당 아이디의 북마크 얻어오기
		String bm = mainService.getBookmark(id);
		if(bm==null) { //기존 북마크가 하나도 없다면 "북마크가 없습니다 html띄우기"
			
		}
		String[] bms = bm.split("/");
		List<ContentVO> list = new ArrayList<ContentVO>();
		for(String connum:bms) {
			list.add(mainService.getSelectByconnum(connum));
		}
		m.addAttribute("bookmarks", list);
		
	}
	
	//관리자
	@RequestMapping("/{url}.do") 
	public String temp(@PathVariable String url) {
		return url;
	}
 
	//메인에서 컨텐츠 view로 이동 (로그인 후)
	@RequestMapping("/main/contents_login.do")
	public void contents_login(HttpSession session,ContentVO vo,Model m,String check) {
		
		/**
		 * 컨텐츠 띄우기 전 북마크 여부 확인하기
		 */
		String id = (String) session.getAttribute("login");
		String bm = mainService.getBookmark(id);
		if(bm != null)
		{
			String[] bms = bm.split("/");
			List<String> list = new ArrayList<String>();
			Collections.addAll(list, bms);
			if(list.contains(Integer.toString(vo.getConnum()))) {
				check = "true";
			}else check = "false";
		}
		
		m.addAttribute("check", check);
		//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
		m.addAttribute("content", mainService.getSelectByconnum(vo));
		/**
		 *  해당 게시글의 댓글 전부 불러오기
		 */
		List<ReplyVO> replyList = mainService.getAllReply(vo);
		m.addAttribute("replys", replyList);
		
		// 내가 추천누른 댓글번호 리스트 가져오기
		// split("/")적용한 list Model로 값 넘겨주기
		// 화면단에서 댓글번호와 
		
		System.out.println(id); 
		
		m.addAttribute("myLike", mainService.getLikeReply(id));
		System.out.println(mainService.getLikeReply(id));
		
		//연관컨텐츠 가져오기
		m.addAttribute("link_content", mainService.getLinkContent(vo));
		
	}
	
	//메인에서 컨텐츠 view로 이동(로그인 전)
	@RequestMapping("/main/contents.do")
	public void contents(ContentVO vo,Model m) {
		//메인에서 넘어온 컨텐츠의 connum으로 해당 컨텐츠 레코드 가져오기
		m.addAttribute("content", mainService.getSelectByconnum(vo));
		//해당 게시글의 댓글 전부 불러오기
		m.addAttribute("replys", mainService.getAllReply(vo));
		//연관컨텐츠 가져오기
		m.addAttribute("link_content", mainService.getLinkContent(vo));
		
		}

	//해당 게시글을 북마크하기(hover)
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
	
	//댓글 달기 (해당 게시글 번호, 회원번호(아이디 이용),댓글 내용 필요)
	@RequestMapping(value = "/main/insertReply.do",produces = "application/text;charset=utf-8")
	@ResponseBody
	public List<ReplyVO> insertReply(HttpSession session,ReplyVO rvo,ContentVO cvo) {
		String id = (String)session.getAttribute("login");
		//아이디로 회원번호 얻어오기
		int memnum = Integer.parseInt(mainService.getMemnumById(id));
		//댓글 작성
		rvo.setMemnum(memnum);
		int result = mainService.insertReply(rvo);
		//해당 게시글의 모든 댓글 가져오기
		List<ReplyVO> replyList = mainService.getAllReply(cvo);
		
		return replyList;
	}
	
	//댓글 추천/취소
	@RequestMapping(value = "/main/updateReco.do", produces = "application/text;charset=utf-8")
	@ResponseBody
	@Transactional
	public String updateReco(ReplyVO vo,HttpSession session) {
		String id = (String)session.getAttribute("login");
		int replynum = vo.getReplynum();
		System.out.println("ajax로 넘긴 댓글번호:"+replynum);

		//해당 아이디로 추천 눌렀던 댓글들 가져오기
		String likes = mainService.getLikeReply(id);
		System.out.println("가져온 추천목록:"+likes);
		String result = "ok"; //추천 눌러지면 ok, 취소하면 no 리턴
		
		if(likes==null) { //만약 추천한 댓글이 하나도 없다면
			//추천 댓글 목록에 바로 넣기
			mainService.updateLikeReply(id, Integer.toString(replynum));
			//해당 댓글 추천수 가져오기
			int rreco = Integer.parseInt(mainService.getRreco(vo));
			System.out.println("해당댓글 추천수:"+rreco);
			//추천 수 업데이트
			rreco+=1;
			vo.setRreco(rreco);
			mainService.updateRreco(vo);
			
			return result;
		}
		
		String[] myLikes = likes.split("/");
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, myLikes);
		String likes_result = new String();
		System.out.println("likes length : " + likes.length());
		if(!(likes.isEmpty())) { //가져온 추천 문자열에 해당 댓글 번호가 없다면 list에 추가,이미 있다면 해당 댓글 번호를 list에서 제거
			if(list.contains(Integer.toString(replynum))) {
				list.remove(Integer.toString(replynum));
				result = "no";
				//해당 댓글 추천수 가져오기
				int rreco = Integer.parseInt(mainService.getRreco(vo));
				//추천 수 -1 후 업데이트 
				rreco-=1;
				vo.setRreco(rreco);
				mainService.updateRreco(vo);
				
			}else {
				list.add(Integer.toString(replynum));
				//해당 댓글 추천수 가져오기
				int rreco = Integer.parseInt(mainService.getRreco(vo));
				//추천 수  +1 후 업데이트
				rreco+=1;
				vo.setRreco(rreco);
				mainService.updateRreco(vo);
			}
			for(int i=0;i<list.size();i++) { //북마크 list를 다시 "/" 붙여서 String으로
				if(i==0) {
					likes_result = list.get(i);
				}else {
					likes_result = likes_result + "/" +list.get(i);
				}
			}
			//수정된 추천댓글 string을 id에 맞는 테이블에 넣음
			mainService.updateLikeReply(id, likes_result);
			System.out.println(likes_result);
		}
		return result;
	}
	
	@RequestMapping(value = "/main/getReco.do", produces = "application/text;charset=utf-8")
	@ResponseBody
	//댓글 추천/취소 후 추천 수 가져와서 화면에 실시간 반영
	public String getReco(ReplyVO vo) {
		return mainService.getRreco(vo);
	};
	
	//댓글 수정
	@RequestMapping(value = "/main/updateReply.do" , produces = "application/text;charset=utf-8")
	@ResponseBody
	public String updateReply(ReplyVO vo) {
		int result = mainService.updateReply(vo);
		return String.valueOf(result);
	}
	
	//댓글 삭제
	@RequestMapping(value = "/main/deleteReply.do" , produces = "application/text;charset=utf-8")
	@ResponseBody
	public String deleteReply(ReplyVO vo) {
		System.out.println(vo.getReplynum());
		System.out.println("댓글삭제");
		int result = mainService.deleteReply(vo);
		System.out.println(result);
		return String.valueOf(result);
	}
	
	//댓글 삭제 후 댓글 리스트 다시 띄우기
	@RequestMapping(value = "/main/getAllreply.do", produces = "application/text;charset=utf-8" )
	@ResponseBody
	public List<ReplyVO> getAllreply(ContentVO vo){
		System.out.println(vo.getConnum());
		return mainService.getAllReply(vo);
	}

	//로그아웃
	@RequestMapping("/main/logout.do")
	public String logout() {
		return "redirect:main.do";
	}

}
