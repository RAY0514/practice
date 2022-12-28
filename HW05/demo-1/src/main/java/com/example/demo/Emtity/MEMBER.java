package com.example.demo.Emtity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class MEMBER {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int memberId;

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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
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
}
