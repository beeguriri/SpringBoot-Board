package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.Member;
import com.example.boardproject.domain.TestBoard;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.MemberRepository;
import com.example.boardproject.persistence.TestBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardProjectApplicationTests {

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    BoardRepository boardRepo;

    @Autowired
    CommentRepository commentRepo;

    @Autowired
    TestBoardRepository testRepo;

    @Test
    void contextLoads() {

        System.out.println("===>test access");
    }

//    @Test
    void memberInsertTest(){

        for(int i=1; i<=3; i++) {
            Member member = new Member();

            member.setMemberId("testuser"+i);
            member.setNickname("테스터"+i);
            member.setPassword("1234");
            member.setEmail("aaa@bbb.com");
            member.setRole("User");

            memberRepo.save(member);
        }

    }

    @Test
    void memberInsertTest2(){

        Member member = new Member();

        member.setMemberId("testAdmin");
        member.setNickname("관리자");
        member.setPassword("1234");
        member.setEmail("aaa@bbb.com");
        member.setRole("Admin");

        memberRepo.save(member);

    }

//    @Test
    void boardInsertTest(){

        Board board = new Board();
        board.setTitle("test1");
        board.setContent("test1_content");
        boardRepo.save(board);
    }

//    @Test
//    void mappingTest() {
//
//        Board board = new Board();
//        User user = new User();
//
//        user.setUserId("mappingtest2");
//        user.setUserName("mappingtest");
//        user.setPassword("1234");
//        user.setEmail("mappingtest@bbb.com");
//        userRepo.save(user);
//
//        board.setUser(user);
//        board.setTitle("mappingtest2");
//        board.setContent("mappingtest2");
//
//        boardRepo.save(board);
//
//    }

//    @Test
//    void mappingTest2() {
//
//        User user = new User();
//
//        user.setUserId("tester2");
//        user.setUserName("tester2");
//        user.setPassword("1234");
//        user.setEmail("mapping@aaa.com");
//        userRepo.save(user);
//
//        for (int i = 1; i <= 3; i++) {
//            Board board = new Board();
//
//            board.setUser(user);
//            board.setTitle("board test "+i);
//            board.setContent("tester "+i);
//            boardRepo.save(board);
//
//            for (int j = 1; j <= 5; j++) {
//
//                Comment comment = new Comment();
//
//                comment.setUser(user);
//                comment.setBoard(board);
//                comment.setContent("comment test " + j);
//                commentRepo.save(comment);
//            }
//        }
//    }

//    @Test
    void dateTest() {

        TestBoard tboard = new TestBoard();

        testRepo.save(tboard);
    }

//    @Test
//    void dummyInsert2() {
//
//        for(long i=4; i<=10; i+=2) {
//
//            User user = userRepo.findById(i).get();
//
//            for (int j=1; j<=10; j++) {
//
//                Board board = new Board();
//
//                board.setUser(user);
//                board.setTitle("dummy 입력" + j);
//                board.setContent("dummy data를 입렬하고 있습니다..." + j);
//
//                boardRepo.save(board);
//            }
//        }
//
//    }

}
