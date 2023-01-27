package com.nex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nex.VO.TestDataVO;
import com.nex.service.TestService;
import com.nex.testDTO.TestDataDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "TEST")
@RestController
public class TestController {
	
	@Autowired
	private TestService testservice;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@ApiOperation(value = "DB 값 1개 조회", notes = "Test테이블의 row 값을 구한뒤 그값을 size로 랜덤한 1개의 값을 가져온다")
	@GetMapping("/test")
    public TestDataVO test(@ApiIgnore TestDataVO testDataVO) {
		
		List<TestDataVO> total = testservice.getAll();
		
		int randomN = (int)(Math.random()*total.size())+1;
		TestDataVO randomData = testservice.getOne(randomN);
        return randomData;
    }
	
	@ApiOperation(value = "테이블 전체 조회", notes = "log.info를 사용해서 Test테이블에 있는 전체값들을 출력")
	@PostMapping("/getAll")
	public List<TestDataVO> get(@ApiIgnore TestDataVO testDataVO) {
		List<TestDataVO> total = testservice.getAll();
		return total;
	}

	@ApiImplicitParam(name = "word", value = "입력 text", paramType = "path")
	@ApiOperation(value = "Test 테이블 값 입력", notes = "입력하고자하는 내용을 입력한다.")
    @PostMapping("/inputTest")
    public String insert(@ApiIgnore @RequestBody TestDataDTO testData) {
		
		int t1 = testservice.insertData(testData.getWord());
		boolean bt1 = t1>0 ? true : false;
		String result = bt1 ? "success" : "fail";
		
        return result;
    }
	
	@ApiImplicitParam(name = "word", value = "입력 text", paramType = "path")
	@ApiOperation(value = "Test 테이블 값 입력", notes = "입력하고자하는 내용을 입력한다.")
	@PostMapping
	public String delData(@ApiIgnore @RequestBody TestDataDTO testData) {
		
		int t1 = testservice.insertData(testData.getWord());
		boolean bt1 = t1>0 ? true : false;
		String result = bt1 ? "success" : "fail";
		
		return result;
	}
	
	@ApiImplicitParam(name = "word", value = "입력 text", paramType = "path")
	@ApiOperation(value = "Test 테이블 값 입력", notes = "입력하고자하는 내용을 입력한다.")
	@PostMapping
	public String upData(@ApiIgnore @RequestBody TestDataDTO testData) {
		
		int t1 = testservice.insertData(testData.getWord());
		boolean bt1 = t1>0 ? true : false;
		String result = bt1 ? "success" : "fail";
		
		return result;
	}
    
}
