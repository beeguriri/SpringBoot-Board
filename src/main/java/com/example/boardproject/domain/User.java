package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_SEQ")
    private Long seq;

    @Column(updatable = false, nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String userRole;

    private String email;

//    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
    @CreatedDate
    public LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();


    private User(Long seq, String userId, String password, String userRole) {
        this.seq = seq;
        this.userId = userId;
        this.password = password;
        this.userRole = userRole;
    }

}
