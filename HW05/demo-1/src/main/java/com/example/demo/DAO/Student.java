package com.example.demo.DAO;

public class Student extends Member {

    String classes;
    String admissionYearMonth;

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setAdmissionYearMonth(String admissionYearMonth) {
        this.admissionYearMonth = admissionYearMonth;
    }

    public String getClasses() {
        return classes;
    }

    public String getAdmissionYearMonth() {
        return admissionYearMonth;
    }

}
