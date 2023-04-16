package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOARD_SEQ")
    private Long seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
    private Date regiDate;

    private Date updateDate;

    @Column(insertable = false, columnDefinition = "number default 0")
    private Long cnt;

//    @ManyToOne
//    @JoinColumn(name="USER_SEQ")
//    private User user;
//
//    private void setUser(User user){
//        this.user = user;
//        user.getBoardList().add(this);
//    }
}
