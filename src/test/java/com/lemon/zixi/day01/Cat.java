package com.lemon.zixi.day01;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-18 23:49
 * @Desc：
 **/

public class Cat extends Animal{
    public void zhualaoshu(){
        System.out.println("猫会抓老鼠");
    }

    @Override
    public void eat(){
        System.out.println("饿了吃饭");
    }
}
