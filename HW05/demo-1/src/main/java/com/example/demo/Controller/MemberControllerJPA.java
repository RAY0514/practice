package com.example.demo.Controller;

import com.example.demo.Emtity.MEMBER;
import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberControllerJPA {

    @Autowired
    MemberService memberService;

    @GetMapping("/rest/getAllMember")
    public List<MEMBER> getAllMember() {
        return memberService.getAllMember();
    }

    @GetMapping("/rest/getAllTeacher")
    public List<MEMBER> getAllTeacher() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/rest/getAllStudent")
    public List<MEMBER> getAllStudent() {
        return memberService.getAllStudent();
    }

    @GetMapping("/rest/getTeacher")
    public List<MEMBER> getTeacher(@RequestParam("id") String id) {
        return memberService.getTeacher(id);
    }

    @GetMapping("/rest/getStudent")
    public List<MEMBER> getStudent(@RequestParam("id") String id) {
        return memberService.getStudent(id);
    }

}