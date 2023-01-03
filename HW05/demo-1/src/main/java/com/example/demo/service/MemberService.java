package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.DAO.Student;
import com.example.demo.DAO.Teacher;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<com.example.demo.DAO.Member> getAllMember() {
        List<com.example.demo.DAO.Member> list = new ArrayList<>();
        List<Member> listMember = memberRepository.findAll();
        for (int i = 0; i <= 1; i++) {
            Teacher teacher = new Teacher();
            teacher.setId(listMember.get(i).getId());
            teacher.setName(listMember.get(i).getName());
            teacher.setGender(listMember.get(i).getGender());
            teacher.setSubject(listMember.get(i).getSubject());
            teacher.setJobTitle(listMember.get(i).getJobTitle());
            list.add(teacher);
        }
        for (int i = 2; i <= 3; i++) {
            Student student = new Student();
            student.setId(listMember.get(i).getId());
            student.setName(listMember.get(i).getName());
            student.setGender(listMember.get(i).getGender());
            student.setClasses(listMember.get(i).getClasses());
            student.setAdmissionYearMonth(listMember.get(i).getAdmissionYearMonth());
            list.add(student);
        }
        return list;
    }

    public List<Teacher> getAllTeacher() {
        //全部老師
        //jpa is null
        List<Member> listMember = memberRepository.findByClasses(null);//沒有Classes的是老師
        List<Teacher> listTeacher = new ArrayList<>();
        for (int i = 0; i < listMember.size(); i++) {
            Teacher teacher = new Teacher();
            teacher.setId(listMember.get(i).getId());
            teacher.setName(listMember.get(i).getName());
            teacher.setGender(listMember.get(i).getGender());
            teacher.setSubject(listMember.get(i).getSubject());
            teacher.setJobTitle(listMember.get(i).getJobTitle());
            listTeacher.add(teacher);
        }
        return listTeacher;
    }

    public List<Student> getAllStudent() {
        //全部學生
        List<Member> listMember = memberRepository.findBySubject(null);//沒有Subject的是學生
        List<Student> listStudent = new ArrayList<>();
        for (int i = 0; i < listMember.size(); i++) {
            Student student = new Student();
            student.setId(listMember.get(i).getId());
            student.setName(listMember.get(i).getName());
            student.setGender(listMember.get(i).getGender());
            student.setClasses(listMember.get(i).getClasses());
            student.setAdmissionYearMonth(listMember.get(i).getAdmissionYearMonth());
            listStudent.add(student);
        }
        return listStudent;
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
