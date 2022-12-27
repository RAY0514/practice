package com.example.demo;

import java.util.List;

public class MemberService {
    MemberController memberController = new MemberController();

    public List<Member> getAllMember() {
        return memberController.memberList();
    }

    public List<Member> getAllTeacher() {
        return memberController.memberList();
    }

    public List<Member> getAllStudent() {
        return memberController.memberList();
    }

    public Member getTeacher(String teacherId) {
        // 根據輸入的ID取得教師資料
        return memberController.memberList().get(0);
    }

    public Member getStudent(String studentId) {
        // 根據輸入的ID取得學生資料
        return memberController.memberList().get(0);
    }


}
