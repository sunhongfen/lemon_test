package com.lemon.zixi.day01;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-21 07:51
 * @Desc：
 **/

public class EmployeeMethod {
    public static void main(String[] args) {
        Employee06 e1 = new LianXiCoder();
        Employee06 e2 = new LianXiManager();
        Employee06 e3 = new LianXiTester();
        method(e1);
        method(e2);
        method(e3);



    }
    public static void method(Employee06 em){
        em.sleep();
        em.work();

    }

}
