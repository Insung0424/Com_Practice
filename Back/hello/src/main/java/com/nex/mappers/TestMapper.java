package com.nex.mappers;

import java.util.List;

import com.nex.VO.TestDataVO;
import com.nex.testDTO.TestDataDTO;

public interface TestMapper {
	
	public int insertData(String word);
	
	public TestDataVO getOne(int randomN);
	
	public List<TestDataVO> getAll();
}
