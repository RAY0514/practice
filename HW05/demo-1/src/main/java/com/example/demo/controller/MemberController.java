package com.example.demo.controller;

import com.example.demo.emtity.Member;
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

    @GetMapping("/rest/getAllTeacher")
    public List<Member> getAllTeacher() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/rest/getAllStudent")
    public List<Member> getAllStudent() {
        return memberService.getAllStudent();
    }

    @GetMapping("/rest/getTeacher")
    public List<Member> getTeacher(@RequestParam("id") String id) {
        return memberService.getTeacher(id);
    }

    @GetMapping("/rest/getStudent")
    public List<Member> getStudent(@RequestParam("id") String id) {
        return memberService.getStudent(id);
    }

}