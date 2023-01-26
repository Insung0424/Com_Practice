package com.nex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nex.service.TestService;
import com.nex.testDTO.TestData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "TEST")
@RestController
public class TestController {
	
	@Autowired
	private TestService testservice;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@ApiOperation(value = "/ 백엔드 기본 페이지", notes = "DB 값 1개 조회")
	@GetMapping("/test")
    public TestData test() {
		
		List<TestData> total = testservice.getAll();
		
		int randomN = (int)(Math.random()*total.size())+1;
		TestData randomData = testservice.getOne(randomN);
        return randomData;
    }
	
	@ApiOperation(value = "/ 백엔드 기본 페이지", notes = "log.info를 사용해서 Test테이블에 있는 전체값들을 출력")
	@PostMapping("/getAll")
	public List<TestData> get() {
		List<TestData> total = testservice.getAll();
		return total;
	}

	@ApiOperation(value = "백엔드 정보 입력", notes = "입력하고자하는 내용을 입력한다.")
    @PostMapping("/inputTest")
    public String insert(@RequestBody TestData testData) {
		
		int t1 = testservice.insertData(testData.getWord());
		boolean bt1 = t1>0 ? true : false;
		String result = bt1 ? "success" : "fail";
		
        return result;
    }
    
}
