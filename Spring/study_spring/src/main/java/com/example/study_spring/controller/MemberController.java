package com.example.study_spring.controller;

import com.example.study_spring.dto.MemberForm;
import com.example.study_spring.entity.Member;
import com.example.study_spring.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    //로그인 페이지
    @GetMapping("/login")
    public String member(){
        return "member/login";
    }
    //회원가입 페이지
    @GetMapping("/members/create")
    public String sign_up(){
        return"member/signUp";
    }
    //로그인 체크
    @PostMapping("/login/check")
    public String l_check(){
        //아이디 패스워드 일치한지 체크
        return "";
    }
    //회원가입 체크
    @PostMapping("/check")
    public String s_check(MemberForm form){
        //dto 엔티티로 변환
        log.info(form.toString());
        Member mema = form.toEntity();
        //레파이토리로 db에 입력
        log.info(mema.toString());
        Member memb = memberRepository.save(mema);
        //db 에서 id와 passwd 닉네임 이메일 중복여부 체크 후
        //맞으면 해당 목록으로 이동
            return "redirect:/members";
    }

    //Read
    @GetMapping("/members/{id}")
    public String id_request(@PathVariable Long id, Model model){
        log.info("id="+id);
        //1. id를 조회해 데이터 가져오기
        Member mem = memberRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("Member",mem);
        //3. 뷰 페이지 반환하기
        return"/member/show";
    }

    //모든 값 보여주기
    @GetMapping("/members")
    public String view_all(Model model){
        //1. 다 가져와서 담기
        List<Member> memList = (List<Member>)memberRepository.findAll();
        //2. 모델에 담기
        log.info("memberList ="+memList);
        model.addAttribute("memberList",memList);
        //3. 뷰페이지 이동
        return"/member/index";
    }

    //수정 Update
    @GetMapping("/members/{id}/update")
    public String getUpdate(@PathVariable Long id,Model model){
        //1. 요청 id로 데이터베이스에서 값꺼내오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        //2. 모델에 등록
        model.addAttribute("member",memberEntity);
        //3. 뷰페이지 반환
        return"/member/edit";
    }

    @PostMapping("/members/update")
    public String postUpdate(MemberForm form){
        //1. dto -> entity
        Member member = form.toEntity();
        //2. db에서 값꺼내오기
        log.info(member.toString());
//
//        Member target = memberRepository.findById().orElse(null);
//        //3.null인지 확인하고 수정
//        if(target!=null){
//            memberRepository.save(memberEntity);
//        }
//        //4. 뷰페이지 리다이렉트
//        return "redirect:/members/"
        return"";
    }
    //삭제 Delete

}
