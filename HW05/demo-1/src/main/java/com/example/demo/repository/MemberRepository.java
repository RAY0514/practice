package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<entity , entity ID 資料型態>
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findMemberById(String id);

    /*
    找class
    沒有class是老師
     */
    List<Member> findByClasses(String classes);

    /*
    找Subject
    沒有Subject是學生
     */
    List<Member> findBySubject(String subject);


}