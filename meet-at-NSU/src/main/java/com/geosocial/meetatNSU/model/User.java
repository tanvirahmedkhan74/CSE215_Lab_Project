package com.geosocial.meetatNSU.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nsuID;
    private String nsuMail;
    private String userName;
    private String passWord;
    private String Department;
    private String Semester;
    private String Hobbby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNsuID() {
        return nsuID;
    }

    public void setNsuID(int nsuID) {
        this.nsuID = nsuID;
    }

    public String getNsuMail() {
        return nsuMail;
    }

    public void setNsuMail(String nsuMail) {
        this.nsuMail = nsuMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getHobbby() {
        return Hobbby;
    }

    public void setHobbby(String hobbby) {
        Hobbby = hobbby;
    }
}
