package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public List<Member> getAllTeacher() {
        List<Member> list = new ArrayList<>();
        list.add(memberRepository.findAll().get(0));
        list.add(memberRepository.findAll().get(1));
        return list;
    }

    public List<Member> getAllStudent() {
        List<Member> list = new ArrayList<>();
        list.add(memberRepository.findAll().get(2));
        list.add(memberRepository.findAll().get(3));
        return list;
    }

    public List<Member> getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        Integer teacherIdNum = Integer.valueOf(teacherId).intValue();
        System.out.println(teacherIdNum);
        return memberRepository.findByMemberId(teacherIdNum);
    }

    public List<Member> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        int studentIdNum = Integer.valueOf(studentId).intValue();
        return memberRepository.findByMemberId(studentIdNum);
    }

}
