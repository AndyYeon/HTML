package com.example.study_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String member_id;
    @Column
    private String member_pw;
    @Column
    private String member_email;
    @Column
    private String member_nickname;
}
