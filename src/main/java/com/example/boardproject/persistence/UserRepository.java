package com.example.boardproject.persistence;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    //userID로 찾기
    Optional<User> findByUserId(String userID);

}
