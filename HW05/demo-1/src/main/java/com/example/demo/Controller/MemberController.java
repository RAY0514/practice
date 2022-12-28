package com.example.demo.Controller;

import com.example.demo.DAO.Member;
import com.example.demo.DAO.Student;
import com.example.demo.DAO.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    public List<Member> memberList() {
        List<Member> list = new ArrayList<>();
        Teacher teacher1 = new Teacher();
        teacher1.setId("1");
        teacher1.setName("Billy");
        teacher1.setGender("male");
        teacher1.setSubject("數學");
        teacher1.setGobTitle("教務主任");
        list.add(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setId("2");
        teacher2.setName("Heidi");
        teacher2.setGender("female");
        teacher2.setSubject("英文");
        teacher2.setGobTitle("教師");
        list.add(teacher2);

        Student student1 = new Student();
        student1.setId("3");
        student1.setName("Jacky");
        student1.setGender("male");
        student1.setClasses("301");
        student1.setAdmissionYearMonth("201910");
        list.add(student1);

        Student student2 = new Student();
        student2.setId("4");
        student2.setName("Lawrence");
        student2.setGender("male");
        student2.setClasses("801");
        student2.setAdmissionYearMonth("201812");
        list.add(student2);
        return list;
    }


    @GetMapping("/rest/all-teacher")
    public List<Member> teacher() {
        List<Member> list = new ArrayList<>();
        list.add(memberList().get(0));
        list.add(memberList().get(1));
        return list;
    }

    @GetMapping("/rest/all-student")
    public List<Member> student() {
        List<Member> list = new ArrayList<>();
        list.add(memberList().get(2));
        list.add(memberList().get(3));
        return list;
    }

    @GetMapping("/rest/student")
    public Member test1(@RequestParam("id") int id) {
        return memberList().get(id - 1);
    }
}
