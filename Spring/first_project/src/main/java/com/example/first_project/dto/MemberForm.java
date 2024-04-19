package com.example.first_project.dto;

import com.example.first_project.entity.Member;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {
    private String login_id;
    private String login_pw;

    public Member toEntity(){
        return new Member(null,login_id,login_pw);
    }
}
