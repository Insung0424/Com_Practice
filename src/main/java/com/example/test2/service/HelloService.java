package com.example.test2.service;

import com.example.test2.entity.Hello;
import com.example.test2.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public void save(Hello hello){
        helloRepository.save(hello);
    }

    public Optional<Hello> findId(Long id){
        return helloRepository.findById(id);
    }

    public List<Hello> findTextAll(){
        return helloRepository.findAll();
    }

}
