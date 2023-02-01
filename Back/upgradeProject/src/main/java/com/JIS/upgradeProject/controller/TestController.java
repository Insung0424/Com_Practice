package com.JIS.upgradeProject.controller;

import com.JIS.upgradeProject.DTO.TestDTO;
import com.JIS.upgradeProject.entity.TestEntity;
import com.JIS.upgradeProject.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "test", description = "테스트용 컨트롤러입니다")
@RequiredArgsConstructor
@RestController
@RequestMapping("/content")
public class TestController {

    private final TestService testService;

    @Operation(summary = "전체 조회", description = "content 테이블에 있는 데이터 전체를 조회합니다")
    @GetMapping("/list")
    public List<TestEntity> list () {
        return testService.list();
    }

    @Operation(summary = "단일 데이터 입력", description = "content 테이블에 데이터 하나를 입력합니다")
    @PostMapping("/plus")
    public String plus (@RequestBody TestDTO testDTO) {
        String result = testService.plus(testDTO).getWord() == testDTO.getWord() ? "Success" : "Fail";
        return result;
    }

    @Operation(summary = "단일 데이터 삭제", description = "content 테이블에 있는 데이터 하나를 삭제합니다")
    @DeleteMapping("/minus")
    public String empty (@RequestBody TestDTO testDTO) {
        String result = testService.empty(testDTO) == 0  ? "Fail" : "Success";
        return result;
    }

    @Operation(summary = "DATA ROW Count", description = "content 테이블에 있는 행의 갯수를 반환합니다")
    @GetMapping("/amount")
    public int amount () {
        int i = Long.valueOf(testService.amount()).intValue();
        return i;
    }

    @Operation(summary = "단일 데이터 조회", description = "content 테이블에 있는 데이터 하나를 조회합니다")
    @GetMapping("/one/{id}")
    public Optional<TestEntity> one (@PathVariable Long id) {
        return testService.one(id);
    }


}
