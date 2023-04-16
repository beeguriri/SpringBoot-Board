package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="USER_SEQ")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

}
