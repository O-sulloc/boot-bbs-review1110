package com.bbs.review1110.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //entity 어노테이션으로 테이블 생성 가능. 클래스명이랑 같은 테이블을 db에 만들어준다. (P 대문자 -> 소문자로 변경후 테이블 생성)
@Table(name = "product") //안 써줘도 상관없음 사실. 이미 product 테이블이 있어서 다른 이름으로 저장해줘야할 때나 쓰면 됨.
public class Product {

    @Id //id 어노테이션 주면 해당 컬럼이 primary key가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //해당 필드의 값을 어떤 방식으로 자동으로 생성할지 결정. (identity 주로 사용)
    private Long number;

    @Column(nullable = false) //not null 제약 조건 줌
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
