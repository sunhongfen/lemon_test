package com.lemon.zixi.day01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-23 07:53
 * @Desc：
 **/

public class StudentZuoYe {
    private String name;
    private Integer age;
    private Integer score;

    public StudentZuoYe(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public void StudentZuoYe(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentZuoYe{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
