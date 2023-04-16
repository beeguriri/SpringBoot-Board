package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"board", "user"})
@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_SEQ")
    private Long seq;

    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
    private Date regiDate;

    private Date updateDate;

    @ManyToOne
    @JoinColumn(name="BOARD_SEQ")
    private Board board;

    @ManyToOne
    @JoinColumn(name="USER_SEQ")
    private User user;

}
