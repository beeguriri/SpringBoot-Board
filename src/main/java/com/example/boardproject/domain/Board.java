package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString(exclude = "member")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOARD_SEQ")
    private Long seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")
//    private Date regiDate;

    @CreatedDate
    public LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(insertable = false, columnDefinition = "integer default 0")
    private Long cnt;

    @ManyToOne
    @JoinColumn(name="MEMBER_SEQ", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //cascade = CascadeType.ALL
    private List<Comment> commentList = new ArrayList<>();

}
