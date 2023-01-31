package com.JIS.upgradeProject.controller;

import com.JIS.upgradeProject.DTO.TestDTO;
import com.JIS.upgradeProject.entity.TestEntity;
import com.JIS.upgradeProject.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/content")
public class TestController {

    private final TestService testService;

    @GetMapping("/list")
    public List<TestEntity> list () {
        return testService.list();
    }

    @PostMapping("/plus")
    public void plus (@RequestBody TestDTO testDTO) {
        testService.plus(testDTO);
    }

    @DeleteMapping("/minus")
    public void empty (@RequestBody TestDTO testDTO) {
        testService.empty(testDTO);
    }

    @GetMapping("/one")
    public Optional<TestEntity> one (Long id) {
        return testService.one(id);
    }
}
