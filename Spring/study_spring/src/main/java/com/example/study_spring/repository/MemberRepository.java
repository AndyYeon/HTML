package com.example.study_spring.repository;

import com.example.study_spring.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {
}
