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
        System.out.println(memberService.getTeacher("6"));
        System.out.println("-------------------");
        System.out.println(memberService.getTeacher("1"));
        System.out.println("-------------------");
        System.out.println(memberService.getTeacher("3"));
    }

    @DisplayName("特定學生資料抓取")
    @Test
    void getStudent() {
        System.out.println(memberService.getStudent("6"));
        System.out.println("-------------------");
        System.out.println(memberService.getStudent("1"));
        System.out.println("-------------------");
        System.out.println(memberService.getStudent("3"));
    }

    @DisplayName("新增資料")
    @Test
    void insert() {
        Member member = new Member();
        member.setId("5");
        member.setName("ray");
        member.setGender("male");
        member.setClasses("456");
        member.setAdmissionYearMonth("0906");
        memberService.insert(member);
    }

    @DisplayName("更新資料")
    @Test
    void updata() {
        Member member = new Member();
        member.setId("6");
        member.setClasses("789");
        member.setAdmissionYearMonth("0921");
        memberService.update(member);
    }

    @DisplayName("刪除資料")
    @Test
    void delete() {
        memberService.delete("6");
    }

    @DisplayName("特定學生資料抓取測試")
    @Test
    void getStudenttest() {
        System.out.println(memberService.getStudentTest("5"));
    }

}