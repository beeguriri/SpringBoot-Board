package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.persistence.BoardRepository;
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

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    void insertTest() {
//
//        Board board = new Board();
//        board.setTitle("test1");
//        board.setContent("test1_content");
//        boardRepo.save(board);
//    }


//    @Test
//    void userInsertTest(){
//
//        User user = new User();
//
//        user.setUserId("testUser2");
//        user.setUserName("tester");
//        user.setPassword("1234");
//        user.setEmail("aaa@bbb.com");
//        userRepo.save(user);
//
//    }

    @Test
    void boardInsertTest(){

        Board board = new Board();
        board.setTitle("test1");
        board.setContent("test1_content");
        boardRepo.save(board);
    }
}
