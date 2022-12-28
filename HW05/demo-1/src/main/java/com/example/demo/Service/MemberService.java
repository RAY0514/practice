package com.example.demo.Service;

import com.example.demo.Emtity.MEMBER;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<MEMBER> getAllMember() {
        return memberRepository.findAll();
    }

    public List<MEMBER> getAllTeacher() {
        memberRepository.findAll();
        List<MEMBER> list = new ArrayList<>();
        list.add(memberRepository.findAll().get(0));
        list.add(memberRepository.findAll().get(1));
        return list;
    }

    public List<MEMBER> getAllStudent() {
        memberRepository.findAll();
        List<MEMBER> list = new ArrayList<>();
        list.add(memberRepository.findAll().get(2));
        list.add(memberRepository.findAll().get(3));
        return list;
    }

    public List<MEMBER> getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        return memberRepository.findByMemberName(teacherId);
    }

    public List<MEMBER> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        return memberRepository.findByMemberName(studentId);
    }

}
