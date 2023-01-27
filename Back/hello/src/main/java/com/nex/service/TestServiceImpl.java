package com.nex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nex.VO.TestDataVO;
import com.nex.mappers.TestMapper;
import com.nex.testDTO.TestDataDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
	
	private final TestMapper testMapper;
	
	@Override
	public int insertData(String word) {
		return testMapper.insertData(word);
	}

	@Override
	public TestDataVO getOne(int randomN) {
		return testMapper.getOne(randomN);
	}

	@Override
	public List<TestDataVO> getAll() {
		List<TestDataVO> total = testMapper.getAll();
		return total;
	}

}
