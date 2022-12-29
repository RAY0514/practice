package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "id")
    private String memberId;

    @Column(name = "name")
    private String memberName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "subject")
    private String subject;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "admissionYearMonth")
    private String admissionYearMonth;

    @Column(name = "class")
    private String classes;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAdmissionYearMonth() {
        return admissionYearMonth;
    }

    public void setAdmissionYearMonth(String admissionYearMonth) {
        this.admissionYearMonth = admissionYearMonth;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", gender='" + gender + '\'' +
                ", subject='" + subject + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", admissionYearMonth='" + admissionYearMonth + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
