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
        List<Member> memberList = new ArrayList<>();
        for (Member teacherMember : getAllTeacher()) {//放老師
            memberList.add(teacherMember);
        }
        for (Member studentMember : getAllStudent()) {//放老師
            memberList.add(studentMember);
        }
        return memberList;
    }

    public List<Member> getAllTeacher() {
        //全部老師
        //jpa is null
        List<Member> memberList = memberRepository.findByClasses(null);//沒有Classes的是老師
        List<Member> teacherList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            Member teacher = new Teacher();
            teacher.setId(memberList.get(i).getId());
            teacher.setName(memberList.get(i).getName());
            teacher.setGender(memberList.get(i).getGender());
            teacher.setSubject(memberList.get(i).getSubject());
            teacher.setJobTitle(memberList.get(i).getJobTitle());
            teacherList.add(teacher);
        }
        return teacherList;
    }

    public List<Member> getAllStudent() {
        //全部學生
        List<Member> memberList = memberRepository.findBySubject(null);//沒有Subject的是學生
        List<Member> studentList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            Member student = new Student();
            student.setId(memberList.get(i).getId());
            student.setName(memberList.get(i).getName());
            student.setGender(memberList.get(i).getGender());
            student.setClasses(memberList.get(i).getClasses());
            student.setAdmissionYearMonth(memberList.get(i).getAdmissionYearMonth());
            studentList.add(student);
        }
        return studentList;
    }

    public List<Member> getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        List<Member> memberList = new ArrayList<>();
        Member teacherDate = memberRepository.findMemberById(teacherId);
        Member Teacher = new Teacher();
        Teacher.setId(teacherDate.getId());
        Teacher.setName(teacherDate.getName());
        Teacher.setGender(teacherDate.getGender());
        Teacher.setSubject(teacherDate.getSubject());
        Teacher.setJobTitle(teacherDate.getJobTitle());
        memberList.add(Teacher);
        return memberList;
    }

    public List<Member> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        List<Member> memberList = new ArrayList<>();
        Member studentDate = memberRepository.findMemberById(studentId);
        Member student = new Student();
        student.setId(studentDate.getId());
        student.setName(studentDate.getName());
        student.setGender(studentDate.getGender());
        student.setClasses(studentDate.getClasses());
        student.setAdmissionYearMonth(studentDate.getAdmissionYearMonth());
        memberList.add(student);
        return memberList;
    }

    //crud
    public void insert(Member member) {
        memberRepository.save(member);
    }

    public void update() {//
        Member Id = memberRepository.findMemberById("5");
        Id.setClasses("123");
        memberRepository.save(Id);
    }

    public void delete(String id) {
        memberRepository.deleteById(id);
    }

}
