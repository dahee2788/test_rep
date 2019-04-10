package com.dgrm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dgrm.dto.TestVO;

@Repository
public class TestDAOImp implements TestDAO{

	
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.dgrm.mybatis.mapper";

	
	@Override
	public List<TestVO> selectAllContents() throws Exception {
		// TODO Auto-generated method stub
		//return sqlSession.selectList(Namespace+".selectallcontents");
		
		System.out.println(sqlSession.selectList(Namespace+".selectallcontents").toString());
		System.out.println("daoimp들어옴");
		
		return sqlSession.selectList(Namespace+".selectallcontents");
	}


	@Override
	public int insertContents(String contents) throws Exception {
		// TODO Auto-generated method stub
		int res=sqlSession.insert(Namespace+".insertContents", contents);
		return res;
	}


	@Override
	public int updateContents(TestVO vo) throws Exception {
		// TODO Auto-generated method stub
		int res= sqlSession.update(Namespace+".updateContents", vo);
		return res;
	}


	@Override
	public int deleteContents(ArrayList<String> list) throws Exception {
		// TODO Auto-generated method stub
		int res=0;
		for (String seq : list) {
			int suc=sqlSession.delete(Namespace+".deleteContents", seq);
			if(suc>0) res++;
		}
		return res;
	}


	@Override
	public List<TestVO> selectOneContents(String contents) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(Namespace+".selectOneContents", contents);
	}




}
