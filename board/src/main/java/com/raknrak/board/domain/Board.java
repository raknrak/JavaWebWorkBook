package com.raknrak.board.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{
    //게시물은 데이터베이스에 추가될 때 생성되는 번호(auto increment)를 이용할 것이므로
    //이런 경우에 ‘키 생성 전략(key generate strategy) 중에 GenerationType.IDENTITY로
    //데이터베이스에서 알아서 결정하는 방식을 이용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false) // 컬럼의 길이와 null 허용 여부
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

}

// IDENTITY： 데이터베이스에 위임(MYSQL/MariaDB) - autoincrement
// SEQUENCE： 데이터베이스 시퀀스 오브젝트 사용(ORACLE)- @SequenceGenerator 필요
// TABLE： 키 생성용 테이블 사용, 모든 DB에서 사용 - @TableGenerator 필요
// AUTO: 방언에 따라 자동 지정，기본값
