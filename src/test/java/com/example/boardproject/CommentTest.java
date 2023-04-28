package com.example.boardproject;

import com.example.boardproject.domain.Comment;
import com.example.boardproject.persistence.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {

    @Autowired
    CommentRepository commentRepo;

    @Test
    void deleteComment(){

        Comment delCom = commentRepo.findById(31L).get();
        System.out.println(delCom.toString());
        commentRepo.deleteById(delCom.getSeq());
    }
}
