package com.example.study_spring.dto;

import com.example.study_spring.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberForm {
    private Long id;
    private String member_id;
    private String member_pw;
    private String member_email;
    private String member_nickname;

    public Member toEntity(){
        return new Member(id,member_id,member_pw,member_email,member_nickname);
    }
}
