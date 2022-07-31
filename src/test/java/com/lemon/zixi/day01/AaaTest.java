package com.lemon.zixi.day01;

import javax.naming.PartialResultException;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-18 22:36
 * @Desc： 作业1-test
 **/

public class AaaTest {
    public static void main(String[] args) {
        Calculator e = new Calculator();
        e.a = 3;
        e.b = 4;
//        int result1 = e.jian(e.a,e.b);
        int result2 = e.sum(e.a,e.b);
        int result3 = e.cheng(e.a,e.b);
        int result4 = e.chu(e.a,e.b);
        System.out.println(e.a);
        System.out.println(e.b);
//        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println("========================");
        System.out.println(e.jian(e.a,e.b));

        //car
        Car c = new Car();
        c.brand = "奔驰";
        c.chelun= "有标志";
        c.color = "白色";
        System.out.println(c.brand);
        System.out.println(c.chelun);
        System.out.println(c.color);
        c.qidong();
        c.shahche();
        System.out.println("============================");

        //Animal类
        Cat a = new Cat();
        a.eat();
        a.sleep();
        a.zhualaoshu();
        Dog d = new Dog();
        d.kanjia();
        d.sleep();
        d.eat();
        System.out.println("======================");
        //输出两个数组相同的内容，例如：{1,3,4,10} {11,3,13,55}
        // 结果输出：3 （提示使用双重循环）

    }
}