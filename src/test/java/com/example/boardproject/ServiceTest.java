package com.example.boardproject;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.User;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.CommentRepository;
import com.example.boardproject.persistence.UserRepository;
import com.example.boardproject.service.BoardService;
import com.example.boardproject.service.UserService;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    BoardRepository boardRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    CommentRepository commentRepo;

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

//    @Test
    public void testGetBoardList() {

        List<Board> list =  boardService.getBoardList();
        for(Board b: list) {
            System.out.print(b.getSeq()+ "\t");
            System.out.print(b.getTitle()+ "\t");
            System.out.print(b.getUser().getUserName()+ "\t");
            System.out.print(b.getCreatedDate()+"\t");
            System.out.print(b.getModifiedDate()+ "\t");
            System.out.println(b.getCnt());
        }
    }

//    @Test
    public void testGetBoard() {

        Board board = boardRepo.findById(2L).get();

        boardService.getBoard(board);

//        System.out.println("========= " + board.getSeq() + "번 게시물========");
//        System.out.println(board.getUser().getUserName());
//        System.out.println(board.getTitle());
//        System.out.println(board.getCommentList());
    }


//    @Test
    public void testAdduser() {

        User user = new User();

        user.setUserId("addtester");
        user.setUserName("addTester1");
        user.setPassword("1234");
        user.setEmail("zxcv@qqq.com");

        userService.addUser(user);

    }

//    @Test
    public void testUpdateuser() {

        User user = userRepo.findById(2L).get();
        user.setUserName("updateTester");

        userService.updateUser(user);

    }

//    @Test
    public  void testDeleteuser(){

        User user = userRepo.findById(3L).get();

        userService.deleteUser(user);

    }

}
