package com.dgrm.service;

import java.util.ArrayList;
import java.util.List;

import com.dgrm.dto.TestVO;

public interface TestService {
	
	public List<TestVO> selectAllContents() throws Exception;
	
	public int insertContents(String contents) throws Exception;
	
	public int updateContents(TestVO vo) throws Exception;
	
	public int deleteContents(ArrayList<String> list) throws Exception;
	
	public List<TestVO> selectOneContents(String contents) throws Exception;

}
