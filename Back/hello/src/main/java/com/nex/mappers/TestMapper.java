package com.nex.mappers;

import java.util.List;

import com.nex.testDTO.TestData;

public interface TestMapper {
	
	public int insertData(String word);
	
	public TestData getOne(int randomN);
	
	public List<TestData> getAll();
}