package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        for (Member teacherMember : getAllTeacher()) {//放老師
            x.add(teacherMember);
        }
        for (Member studentMember : getAllStudent()) {//放學生
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
        try {
            Member teacherDate = memberRepository.findMemberById(teacherId);//沒找到會拋NullPointerException
            System.out.println(teacherDate);
            if (teacherDate.getClasses() != null) {//class不是null不是老師
                System.out.println("不是老師");
            } else {//class 是null,是老師
                Member Teacher = new Teacher();
                Teacher.setId(teacherDate.getId());
                Teacher.setName(teacherDate.getName());
                Teacher.setGender(teacherDate.getGender());
                Teacher.setSubject(teacherDate.getSubject());
                Teacher.setJobTitle(teacherDate.getJobTitle());
                memberList.add(Teacher);
            }
            return memberList;

        } catch (NullPointerException ex) {
            System.out.println("沒有此筆資料");
        }
        return memberList;
    }

    public List<Member> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        List<Member> memberList = new ArrayList<>();
        try {
            Member studentDate = memberRepository.findMemberById(studentId);//沒找到會拋NullPointerException
            if (studentDate.getSubject() != null) {//subject不是null是老師
                System.out.println("不是學生");
            } else {//subject是null是學生
                Member student = new Student();
                student.setId(studentDate.getId());
                student.setName(studentDate.getName());
                student.setGender(studentDate.getGender());
                student.setClasses(studentDate.getClasses());
                student.setAdmissionYearMonth(studentDate.getAdmissionYearMonth());
                memberList.add(student);
                return memberList;
            }
        } catch (NullPointerException ex) {
            System.out.println("沒有此筆資料");
        }
        return memberList;
    }

    //crud
    public void insert(Member member) {
        //POST 插入資料放body
        Optional<Member> checkId = memberRepository.findById(member.getId());//在原本的資料庫找member.getId()這筆
        if (!checkId.isPresent()) { //isPresent()= (checkId!=null)  //!checkId.isPresent() =>check是空的
            memberRepository.save(member);
        } else {
            System.out.println("此id已存在");
        }
    }

    public void update(Member newMember) {
        Optional<Member> checkId = memberRepository.findById(newMember.getId());
        if (checkId.isPresent()) {
            memberRepository.save(newMember);
        } else {
            System.out.println("資料不存在");
        }
    }

    public void delete(String id) {
        try {
            memberRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("沒有此筆資料");
        }
    }

    public Member getStudentTest(String studentId) {
        // 根據輸入的ID取得學生資料
        return memberRepository.findMemberById(studentId);
    }

}

