package com.dgrm.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dgrm.dao.TestDAO;
import com.dgrm.dto.TestVO;

@Service
public class TestServiceImp implements TestService{

	@Inject
	 private TestDAO dao;
	 
	@Override
	public List<TestVO> selectAllContents() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(dao.selectAllContents().toString());
		return dao.selectAllContents();
	}

	@Override
	public int insertContents(String contents) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertContents(contents);
	}

	@Override
	public int updateContents(TestVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateContents(vo);
	}

	@Override
	public int deleteContents(ArrayList<String> list) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteContents(list);
	}

	@Override
	public List<TestVO> selectOneContents(String contents) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOneContents(contents);
	}



}
