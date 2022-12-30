package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
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

    public void getAllTeacher() {
        //全部老師
        //jpa isn ull
    }

    public List<Student> getAllStudent() {
        //全部學生
       return null;
    }



    public List<Teacher> getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        List<Teacher> list = new ArrayList<>();
        Teacher Teacher = new Teacher();
        Teacher.setId(memberRepository.findMemberById(teacherId).getId());
        Teacher.setName(memberRepository.findMemberById(teacherId).getName());
        Teacher.setGender(memberRepository.findMemberById(teacherId).getGender());
        Teacher.setSubject(memberRepository.findMemberById(teacherId).getSubject());
        Teacher.setJobTitle(memberRepository.findMemberById(teacherId).getJobTitle());
        list.add(Teacher);
        return list;
    }

    public List<Student> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(memberRepository.findMemberById(studentId).getId());
        student.setName(memberRepository.findMemberById(studentId).getName());
        student.setGender(memberRepository.findMemberById(studentId).getGender());
        student.setClasses(memberRepository.findMemberById(studentId).getClasses());
        student.setAdmissionYearMonth(memberRepository.findMemberById(studentId).getAdmissionYearMonth());
        list.add(student);
        return list;
    }

}
