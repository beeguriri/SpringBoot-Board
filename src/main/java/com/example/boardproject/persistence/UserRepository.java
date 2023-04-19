package com.example.boardproject.persistence;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    //userID로 찾기
//    Board findByUserIdEquals(String userID);

}
