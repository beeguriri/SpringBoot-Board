package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.Member;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MappingTest2 {

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    BoardRepository boardRepo;

    @Autowired
    CommentRepository commentRepo;

//    @Test
    void dummyInsert() {

        for(long i=1; i<=3; i++) {

            Member member = memberRepo.findById(i).get();

            for (int j=1; j<=5; j++) {

                Board board = new Board();

                board.setMember(member);
                board.setTitle("추가추가" + j);
                board.setContent("dummy data를 입력하고 있습니다..." + j);

                boardRepo.save(board);
            }
        }

    }

    @Test
    void dummyInsert2() {

        for(long i=1; i<=3; i++) {

            Member member = memberRepo.findById(i).get();

            for (long j=1; j<=5; j++) {

                Board board = boardRepo.findById(j).get();

                for (int k=1; k<=5; k++){

                    Comment comment = new Comment();

                    comment.setMember(member);
                    comment.setBoard(board);
                    comment.setContent("dummy comment 입력" + k);

                    commentRepo.save(comment);

                }
            }
        }

    }


}
