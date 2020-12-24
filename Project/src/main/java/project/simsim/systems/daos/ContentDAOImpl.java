package project.simsim.systems.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.simsim.systems.domains.ContentVO;

@Repository
public class ContentDAOImpl implements ContentDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void saveContent(ContentVO vo) {
		System.out.println("DAO : saveContent");
		mybatis.insert("ContentMAP.saveContent", vo);
	}

	@Override
	public List<ContentVO> getContentsList() {
		System.out.println("DAO : getContentsList");
		return mybatis.selectList("ContentMAP.getContentsList");
	}

	@Override
	public ContentVO getContent(ContentVO vo) {
		System.out.println("DAO : getContent");
		return (ContentVO)mybatis.selectOne("ContentMAP.getContent", vo);
	}

	@Override
	public void modifyContent(ContentVO vo) {
		System.out.println("DAO : modifyContent");
		mybatis.update("ContentMAP.modifyContent", vo);
	}

	@Override
	public void deleteContent(ContentVO vo) {
		System.out.println("DAO : deleteContent");
		mybatis.delete("ContentMAP.deleteContent", vo);
	}

	@Override
	public List<String> getCategoryList() {
		System.out.println("DAO : getCategoryList");
		return mybatis.selectList("ContentMAP.getCategoryList");
	}

}
