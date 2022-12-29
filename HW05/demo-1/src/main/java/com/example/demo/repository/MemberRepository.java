package com.example.demo.repository;

import com.example.demo.emtity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findByMemberId(Integer teacherId);
}
