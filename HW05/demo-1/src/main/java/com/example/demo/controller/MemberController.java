package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Member> getAllTeacher() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/rest/all-student")
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

    @PostMapping("/rest/insert")
    public void insert(@RequestBody Member member) {
        memberService.insert(member);
    }

    @GetMapping("/rest/update")
    public void update(@RequestBody Member updateMember, @RequestParam("id") String id) {
        Member oldMember = memberService.getStudentTest(id);
        System.out.println("原本的資料" + oldMember);
        System.out.println("要更新的資料" + updateMember);
        if (updateMember.getName() != null) {
            oldMember.setName(updateMember.getName());
        }
        if (updateMember.getGender() != null) {
            oldMember.setGender(updateMember.getGender());
        }
        if (updateMember.getSubject() != null) {
            oldMember.setSubject(updateMember.getSubject());
        }
        if (updateMember.getJobTitle() != null) {
            oldMember.setJobTitle(updateMember.getJobTitle());
        }
        if (updateMember.getAdmissionYearMonth() != null) {
            oldMember.setAdmissionYearMonth(updateMember.getAdmissionYearMonth());
        }
        if (updateMember.getClasses() != null) {
            oldMember.setClasses(updateMember.getClasses());
        }
        System.out.println("最後的資料" + oldMember);
        System.out.println("-----------------");
        memberService.update(oldMember);
        System.out.println(memberService.getStudent(id));
    }

    @GetMapping("/rest/delete")
    public void delete(@RequestParam("id") String id) {
        memberService.delete(id);
    }
}