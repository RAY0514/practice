package com.example.demo.DAO;

/*
DAO(Data Access object 資料訪問物件)
 */
public class Member {

    String id;
    String name;
    String gender;

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

    public String toString(){
        return "content{" +
                "  id ='" + id + '\'' +
                ", name =" + name + '\'' +
                ", gender =" + gender +
                '}';
    }

}