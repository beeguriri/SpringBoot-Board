package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.TestBoard;
import com.example.boardproject.domain.User;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.TestBoardRepository;
import com.example.boardproject.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardProjectApplicationTests {

    @Autowired
    UserRepository userRepo;

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
    void userInsertTest(){

        User user = new User();

        user.setUserId("testUser2");
        user.setUserName("tester");
        user.setPassword("1234");
        user.setEmail("aaa@bbb.com");
        userRepo.save(user);

    }

//    @Test
    void boardInsertTest(){

        Board board = new Board();
        board.setTitle("test1");
        board.setContent("test1_content");
        boardRepo.save(board);
    }

//    @Test
    void mappingTest() {

        Board board = new Board();
        User user = new User();

        user.setUserId("mappingtest2");
        user.setUserName("mappingtest");
        user.setPassword("1234");
        user.setEmail("mappingtest@bbb.com");
        userRepo.save(user);

        board.setUser(user);
        board.setTitle("mappingtest2");
        board.setContent("mappingtest2");

        boardRepo.save(board);

    }

    @Test
    void mappingTest2() {

        Board board = new Board();
        User user = new User();
        Comment comment = new Comment();

        user.setUserId("mappingtest4");
        user.setUserName("mappingtest");
        user.setPassword("1234");
        user.setEmail("mapping@aaa.com");
        userRepo.save(user);

        board.setUser(user);
        board.setTitle("mappingtest4");
        board.setContent("mappingtest4");
        boardRepo.save(board);

        comment.setUser(user);
        comment.setBoard(board);
        comment.setContent("comment test4");
        commentRepo.save(comment);

    }

//    @Test
    void dateTest() {

        TestBoard tboard = new TestBoard();

        testRepo.save(tboard);
    }

}
