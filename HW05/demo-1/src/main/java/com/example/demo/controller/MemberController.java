package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/rest/getAllMember")
    public ResponseEntity<?> getAllMember() {

//        return memberService.getAllMember();
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(memberService.getAllMember());
    }

    @GetMapping("/rest/all-teacher")
    public ResponseEntity<?> getAllTeacher() {
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(memberService.getAllTeacher());
    }

    @GetMapping("/rest/all-student")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(memberService.getAllStudent());
    }

    @GetMapping("/rest/getTeacher")
    public ResponseEntity<?> getTeacher(@RequestParam("id") String id) {
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(memberService.getTeacher(id));
    }

    @GetMapping("/rest/getStudent")
    public ResponseEntity<?> getStudent(@RequestParam("id") String id) {
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(memberService.getStudent(id));
    }

    @PostMapping("/rest/insert")
    @CrossOrigin
    public ResponseEntity<?> insert(@RequestBody Member member) {
        memberService.insert(member);
        System.out.println("here");
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/rest/update")
    public void update(@RequestBody Member updateMember) {
        memberService.update(updateMember);
    }

    @DeleteMapping("/rest/delete")
    @CrossOrigin
    public ResponseEntity<?> delete(@RequestParam("id") String id) {
        memberService.delete(id);
        return ResponseEntity.ok().body("ok");

    }
}