package com.example.demo.controller;

import com.example.demo.DAO.Member;
import com.example.demo.DAO.Student;
import com.example.demo.DAO.Teacher;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/rest/getAllMember")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    @GetMapping("/rest/all-teacher")
    public List<Teacher> getAllTeacher() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/rest/all-student")
    public List<Student> getAllStudent() {
        return memberService.getAllStudent();
    }

    @GetMapping("/rest/getTeacher")
    public List<Teacher> getTeacher(@RequestParam("id") String id) {
        return memberService.getTeacher(id);
    }

    @GetMapping("/rest/getStudent")
    public List<Student> getStudent(@RequestParam("id") String id) {
        return memberService.getStudent(id);
    }

}