package com.lemon.zixi.day01;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-21 18:24
 * @Desc：
 **/

public class Teacher {
    private String name;
    private int age;

    public Teacher(){

    }
    public Teacher(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    private String name1;
    private int age1;
    public void teachers1(){

    }
    public void teachers(String name1,int age1){
        this.name1 = name1;
        this.age1 = age1;

    }

    public String getName1() {
        return name1;
    }
    public int getAge1(){
        return age1;
    }
    public void setName1(){

    }
    public void setAge1(){

    }
}
