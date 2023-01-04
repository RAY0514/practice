package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", subject='" + subject + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", admissionYearMonth='" + admissionYearMonth + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
