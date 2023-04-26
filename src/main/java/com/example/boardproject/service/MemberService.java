package com.example.boardproject.service;

import com.example.boardproject.domain.Member;
import com.example.boardproject.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepo;

    public Member getMember(Member member) {

        return memberRepo.findById(member.getSeq()).get();
    }

    public void addMember(Member member) {

        memberRepo.save(member);
    }

    public void updateMember(Member member) {

        Member updateMember = memberRepo.findById(member.getSeq()).get();

        if(member.getNickname()!=null)
            updateMember.setNickname(member.getNickname());
        else
            updateMember.setNickname(updateMember.getNickname());

        if(member.getPassword()!=null)
            updateMember.setPassword(member.getPassword());
        else
            updateMember.setPassword(updateMember.getPassword());

        if(member.getEmail()!=null)
            updateMember.setEmail(member.getEmail());
        else
            updateMember.setEmail(updateMember.getEmail());

        memberRepo.save(updateMember);

    }

    public void deleteMember(Member member) {

        memberRepo.deleteById(member.getSeq());
    }

}
