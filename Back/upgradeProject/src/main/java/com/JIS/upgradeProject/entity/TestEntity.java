package com.JIS.upgradeProject.entity;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="content") // 테이블 명을 작성
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "자동증가하는 숫자")
    private long id;

    @Column(nullable = false)
    @Schema(description = "입력값", defaultValue = "text")
    private String word;

}
