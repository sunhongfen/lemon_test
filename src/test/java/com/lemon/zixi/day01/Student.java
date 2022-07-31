package com.lemon.zixi.day01;

import org.testng.annotations.BeforeMethod;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-22 15:46
 * @Desc：
 **/

public class Student {
    String name;
    int age;
    String gender;

    public void Student(String name,int age,String gender){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
