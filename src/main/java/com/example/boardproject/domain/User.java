package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_SEQ")
    private Long seq;

    @Column(updatable = false, nullable = false, unique = true)
    private String userId;

    @Column(updatable = false, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String email;

    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
    private Date createDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

}
