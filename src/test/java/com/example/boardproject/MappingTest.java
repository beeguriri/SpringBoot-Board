package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MappingTest {

//    @Autowired
//    MemberRepository memberRepo;
//
//    @Autowired
//    BoardRepository boardRepo;
//
//    @Autowired
//    CommentRepository commentRepo;
//
////    @Test
//    void mappingTest1() {
//
//        User user = userRepo.findById(1L).get();
//        System.out.println("=".repeat(10));
//        System.out.println(user.getUserName() + "'s Board Lists");
//        System.out.println("=".repeat(10));
//        List<Board> list = user.getBoardList();
//        for(Board b : list)
//            System.out.println(b);
//
//    }
//
////    @Test
//    void mappingTest2() {
//
//        User user = userRepo.findById(2L).get();
//
//        System.out.println("=".repeat(10));
//        System.out.println(user.getUserName() + "'s Comment Lists");
//        System.out.println("=".repeat(10));
//        List<Comment> list = user.getCommentList();
//        for(Comment c : list)
//            System.out.println(c);
//
//    }
//
//    @Test
//    void mappingTest3() {
//
//        Board board = boardRepo.findById(1L).get();
//
//        System.out.println("=".repeat(10));
//        System.out.println(board.getUser().getUserName() + "'s " + board.getTitle() + "'s Comment Lists");
//        List<Comment> list = board.getCommentList();
//        for(Comment c : list)
//            System.out.println(c);
//        System.out.println("=".repeat(10));
//
//    }

}
