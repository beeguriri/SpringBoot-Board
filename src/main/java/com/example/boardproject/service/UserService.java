package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import com.example.boardproject.domain.User;
import com.example.boardproject.persistence.BoardRepository;
import com.example.boardproject.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;


    public User getUser(Long seq) {

        return userRepo.findById(seq).get();
    }

    public void addUser(User user) {

        userRepo.save(user);

    }

    public void updateUser(User user) {

        User updateUser = userRepo.findById(user.getSeq()).get();

        if(user.getUserName()!=null)
            updateUser.setUserName(user.getUserName());
        else
            updateUser.setUserName(updateUser.getUserName());

        if(user.getPassword()!=null)
            updateUser.setPassword(user.getPassword());
        else
            updateUser.setPassword(updateUser.getPassword());

        if(user.getEmail()!=null)
            updateUser.setEmail(user.getEmail());
        else
            updateUser.setEmail(updateUser.getEmail());

        userRepo.save(updateUser);

    }

    public void deleteUser(User user) {

        userRepo.deleteById(user.getSeq());
    }


}
