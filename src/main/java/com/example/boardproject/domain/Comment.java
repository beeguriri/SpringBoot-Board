package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"board", "member"})
@Getter
@Setter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_SEQ")
    private Long seq;

    private String content;

//    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
    @CreatedDate
    public LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name="BOARD_SEQ", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name="MEMBER_SEQ", nullable = false)
    private Member member;

}
