package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    public List<Member> members() {
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        List<Member> list = new ArrayList<>();
        member1.setId("1");
        member1.setName("Billy");
        member1.setGender("male");
        list.add(member1);

        member2.setId("2");
        member2.setName("Heidi");
        member2.setGender("female");
        list.add(member2);

        member3.setId("3");
        member3.setName("Jacky");
        member3.setGender("male");
        list.add(member3);

        member4.setId("4");
        member4.setName("Lawrence");
        member4.setGender("male");
        list.add(member4);
        return list;
    }


    @GetMapping("test")
    public List<Member> test(String name) {
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        List<Member> list = new ArrayList<>();
        member1.setId("1");
        member1.setName("Billy");
        member1.setGender("male");
        list.add(member1);

        member2.setId("2");
        member2.setName("Heidi");
        member2.setGender("female");
        list.add(member2);

        member3.setId("3");
        member3.setName("Jacky");
        member3.setGender("male");
        list.add(member3);

        member4.setId("4");
        member4.setName("Lawrence");
        member4.setGender("male");
        list.add(member4);
        return list;
    }

    @GetMapping("/test1")
    public String test() {
        return "123";
    }
}

