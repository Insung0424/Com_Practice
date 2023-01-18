package com.nex.service;

import java.util.List;

import com.nex.testDTO.TestData;

public interface TestService {

	public int insertData(String word);
	
	public TestData getOne(int randomN);
	
	public List<TestData> getAll();
	
}
