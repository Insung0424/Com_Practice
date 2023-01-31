package com.JIS.upgradeProject.DTO;

import com.JIS.upgradeProject.entity.TestEntity;
import io.swagger.v3.oas.annotations.Parameter;


public class TestDTO {

    @Parameter(description = "입력값")
    private String word;

    public TestEntity toEntity() {
        return TestEntity.builder().word(word).build();
    }
}
