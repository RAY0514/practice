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

        List<Member> list = new ArrayList<>();
        for (Member memberTeacher : getAllTeacher()) {//放老師
            list.add(memberTeacher);
        }
        for (Member memberStudent : getAllStudent()) {//放老師
            list.add(memberStudent);
        }
        return list;
    }

    public List<Member> getAllTeacher() {
        //全部老師
        //jpa is null
        List<Member> listMember = memberRepository.findByClasses(null);//沒有Classes的是老師
        List<Member> listTeacher = new ArrayList<>();
        for (int i = 0; i < listMember.size(); i++) {
            Member teacher = new Teacher();
            teacher.setId(listMember.get(i).getId());
            teacher.setName(listMember.get(i).getName());
            teacher.setGender(listMember.get(i).getGender());
            teacher.setSubject(listMember.get(i).getSubject());
            teacher.setJobTitle(listMember.get(i).getJobTitle());
            listTeacher.add(teacher);
        }
        return listTeacher;
    }

    public List<Member> getAllStudent() {
        //全部學生
        List<Member> listMember = memberRepository.findBySubject(null);//沒有Subject的是學生
        List<Member> listStudent = new ArrayList<>();
        for (int i = 0; i < listMember.size(); i++) {
            Member student = new Student();
            student.setId(listMember.get(i).getId());
            student.setName(listMember.get(i).getName());
            student.setGender(listMember.get(i).getGender());
            student.setClasses(listMember.get(i).getClasses());
            student.setAdmissionYearMonth(listMember.get(i).getAdmissionYearMonth());
            listStudent.add(student);
        }
        return listStudent;
    }


    public List<Member> getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        List<Member> list = new ArrayList<>();
        Member teacherDate =memberRepository.findMemberById(teacherId);
        Member Teacher = new Teacher();
        Teacher.setId(teacherDate.getId());
        Teacher.setName(teacherDate.getName());
        Teacher.setGender(teacherDate.getGender());
        Teacher.setSubject(teacherDate.getSubject());
        Teacher.setJobTitle(teacherDate.getJobTitle());
        list.add(Teacher);
        return list;
    }

    public List<Member> getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        List<Member> list = new ArrayList<>();
        Member studentDate =memberRepository.findMemberById(studentId);
        Member student = new Student();
        student.setId(studentDate.getId());
        student.setName(studentDate.getName());
        student.setGender(studentDate.getGender());
        student.setClasses(studentDate.getClasses());
        student.setAdmissionYearMonth(studentDate.getAdmissionYearMonth());
        list.add(student);
        return list;
    }

}
