package com.example.demo.repository;

import com.example.demo.emtity.MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MEMBER, Integer> {

    List<MEMBER> findByMemberName(String teacherId);


}
