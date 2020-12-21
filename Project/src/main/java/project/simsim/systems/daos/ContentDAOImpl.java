package project.simsim.systems.daos;

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

}
