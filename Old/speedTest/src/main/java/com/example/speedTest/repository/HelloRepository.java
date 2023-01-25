package com.example.speedTest.repository;

import com.example.speedTest.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HelloRepository extends JpaRepository<Hello, Long> {


}
