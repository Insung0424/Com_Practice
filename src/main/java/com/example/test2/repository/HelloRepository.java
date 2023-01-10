package com.example.test2.repository;

import com.example.test2.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HelloRepository extends JpaRepository<Hello, Long> {


}
