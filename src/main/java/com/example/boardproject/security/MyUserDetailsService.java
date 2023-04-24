package com.example.boardproject.security;

import com.example.boardproject.domain.Member;
import com.example.boardproject.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> findUser = memberRepo.findByMemberId(username);
        Member member = findUser.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다"));

        return User.builder()
                .username(member.getMemberId())
                .password(member.getPassword())
                .roles(member.getRole())
                .build();
    }
}
