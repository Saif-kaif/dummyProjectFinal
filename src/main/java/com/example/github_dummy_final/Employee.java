package com.example.github_dummy_final;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private  String name, gender;
    private int phoneNUmber;
    private LocalDate doj;

    public Employee(String name, String gender, int phoneNUmber, LocalDate doj) {
        this.name = name;
        this.gender = gender;
        this.phoneNUmber = phoneNUmber;
        this.doj = doj;
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

    public int getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(int phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNUmber=" + phoneNUmber +
                ", doj=" + doj +
                '}';
    }
}
