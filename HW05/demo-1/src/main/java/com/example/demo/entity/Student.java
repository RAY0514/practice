package com.example.demo.entity;

public class Student extends Member {

    private String id;
    private String name;
    private String gender;
    private String admissionYearMonth;
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
        return "GetStudent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", admissionYearMonth='" + admissionYearMonth + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
