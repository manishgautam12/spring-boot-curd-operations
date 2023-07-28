package com.registration.registration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class SignupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollNo;
    private String name;
    private String email;
    private String password;
    public SignupModel(int rollNo, String name, String email, String password) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public SignupModel() {
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "SignupModel [rollNo=" + rollNo + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
    
}
