package com.nex.testDTO;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
public class TestData {
	
	@Id
	@ApiParam(value = "자동으로 증가하는 번호", required = false, example = "1" )
	private int id;
	
	@ApiParam(value = "입력하고자 하는 내용", required = false, example = "word" )
	private String word;

}
