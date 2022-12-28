package com.example.demo.Repository;

import com.example.demo.Emtity.MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MEMBER, Integer> {

    List<MEMBER> findByMemberName(String teacherId);


}
