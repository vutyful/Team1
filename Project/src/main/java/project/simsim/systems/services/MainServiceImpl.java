package project.simsim.systems.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.simsim.systems.daos.MainDAO;
import project.simsim.systems.domains.ContentVO;

@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mainDAO;

	@Override
	//content 레코드 모두 가져와 랜덤하게 배열 후 20개만 리턴
	public List<ContentVO> getAllContent(ContentVO vo) {
		System.out.println("Service:getAllContent");
		
		/*
		 * List<ContentVO> list = new ArrayList<ContentVO>(); List<ContentVO> result =
		 * new ArrayList<ContentVO>();
		 * 
		 * list = dao.getAllContent(); //DB에서 가져온 레코드 list에 담기
		 * Collections.shuffle(list); //랜덤하게 섞기 for(int i=0;i<20;i++) {
		 * result.add(list[i]); }
		 */
		return mainDAO.getAllContent(vo);
	}

	@Override
	//선택된 컨텐츠의 레코드 가져오기 
	public ContentVO getSelectByconnum(ContentVO vo) {
		System.out.println("Service:getSelectByconnum");
		return mainDAO.getSelectByconnum(vo);
	}

	

}
