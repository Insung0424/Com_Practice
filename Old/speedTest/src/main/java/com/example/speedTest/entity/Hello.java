package com.example.speedTest.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Builder
/*
빌더 패턴으로 구현하면 각 값들은 빌더의 각 값들의 이름 함수로 셋팅이 되지 각각 무슨 값을 의미하는지 파악하기 쉽다.
따라서 생성자로 설정해야하는 값이 많을 경우 빌더를 쓰는 것이 생성자보다 가독성이 좋다.
*/
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String word;

    public Hello(Long id, String word) {
        Id = id;
        this.word = word;
    }
}
