package com.example.boardproject.security;

import com.example.boardproject.domain.User;
import com.example.boardproject.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<User> findUser = userRepo.findByUserId(userId);
        User user = findUser.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다"));

        return (UserDetails) User.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .userRole(user.getUserRole())
                .build();

    }
}
