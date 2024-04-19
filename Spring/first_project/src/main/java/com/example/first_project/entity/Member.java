package com.example.first_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String login_id;
    @Column
    private String login_pw;
}
