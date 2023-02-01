package com.JIS.upgradeProject.DTO;

import com.JIS.upgradeProject.entity.TestEntity;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class TestDTO {

    @Schema(description = "autoIncrementNumber", defaultValue = "number")
    private Long id;

    @Schema(description = "입력값", defaultValue = "text")
    private String word;

    public TestEntity toEntity() {
        return TestEntity.builder().word(word).build();
    }
}
