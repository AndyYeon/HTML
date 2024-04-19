package com.example.first_project.controller;

import com.example.first_project.dto.MemberForm;
import com.example.first_project.entity.Member;
import com.example.first_project.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/loginPage")
    public String login_page(){
        return "members/login";
    }

    @PostMapping("/members/login")
    public String do_login(MemberForm member){
        log.info(member.toString());
        //1. DTO를 엔티티로 변환
        Member mem = member.toEntity();
        //2. 리파지토리를 이용하여 엔티티를 DB에 저장
        Member sv = memberRepository.save(mem);
        log.info(sv.toString());
        return"";
    }

}
