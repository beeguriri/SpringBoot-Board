package com.example.boardproject.controller;

import com.example.boardproject.domain.Member;
import com.example.boardproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

//    @GetMapping("/join")
//    public String joinMemberView() {
//
//        return "join";
//    }

    @PostMapping("/join")
    public String joinMember(Member member){

        memberService.addMember(member);

        return "redirect:login";
    }

    @GetMapping("/updateMember")
    public String updateMemberView(Model model, Member member) {

        model.addAttribute("updateMember", memberService.getMember(member));
        return "updateMember";
    }

    @PostMapping("/updateMember")
    public String updateMember(Member member){

        memberService.updateMember(member);

        return "redirect:boardList";
    }
}
