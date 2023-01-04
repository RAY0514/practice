package com.example.demo.service;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;


    @DisplayName("全部資料抓取")
    @Test
    void getAllMember() {
        System.out.println(memberService.getAllMember());
    }

    @DisplayName("全部教師資料抓取")
    @Test
    void getAllTeacher() {
        System.out.println(memberService.getAllTeacher());
    }

    @DisplayName("全部學生資料抓取")
    @Test
    void getAllStudent() {
        System.out.println(memberService.getAllStudent());
    }

    @DisplayName("特定老師資料抓取")
    @Test
    void getTeacher() {
        System.out.println(memberService.getTeacher("1"));
    }

    @DisplayName("特定學生資料抓取")
    @Test
    void getStudent() {
        System.out.println(memberService.getStudent("3"));
    }

    @DisplayName("新增資料")
    @Test
    void insert() {
        Member member = new Member();

        memberService.insert(member);
    }

    @DisplayName("更新資料")
    @Test
    void updata() {
        memberService.update();
    }

    @DisplayName("刪除資料")
    @Test
    void delete() {
        memberService.delete("5");
    }

}