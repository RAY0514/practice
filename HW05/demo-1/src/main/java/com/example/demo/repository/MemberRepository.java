package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//JpaRepository<entity , entity ID 資料型態>
public interface MemberRepository extends JpaRepository<Member, String> {

    @Query(value = "select * from member where id= 1", nativeQuery = true)
    Member findByBilly();

    @Query(value = "select * from member where id= 2", nativeQuery = true)
    Member findByHeidi();

    @Query(value = "select * from member where id= 3", nativeQuery = true)
    Member findByJacky();

    @Query(value = "select * from member where id= 4", nativeQuery = true)
    Member findByLawrence();

    Member findMemberById(String id);
}