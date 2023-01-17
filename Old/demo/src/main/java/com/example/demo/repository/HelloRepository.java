package com.example.demo.repository;

import com.example.demo.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HelloRepository extends JpaRepository<Hello, Long> {


}
