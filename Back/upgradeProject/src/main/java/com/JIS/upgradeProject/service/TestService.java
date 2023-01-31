package com.JIS.upgradeProject.service;

import com.JIS.upgradeProject.DTO.TestDTO;
import com.JIS.upgradeProject.entity.TestEntity;
import com.JIS.upgradeProject.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;

    public Optional<TestEntity> one(Long id) {
        return testRepository.findById(id);
    }

    public List<TestEntity> list() {
        return testRepository.findAll();
    }

    public void plus (TestDTO testDTO) {
        testRepository.save(testDTO.toEntity());
    }

    public void empty(TestDTO testDTO) {
        testRepository.delete(testDTO.toEntity());
    }


}
