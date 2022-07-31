package com.study;

import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-27 09:03
 * @Desc：
 **/

public class ErpLogin {
    @Test
    public void test_md5(){
        //加密的原始数据：
        String data = "123456";
        /*加密的处理方式：
        首先要明确的是：密文传输，在入参中，要用密文，比如在测试中，入参需要用密文，
        要怎么处理呢？就是我有已知的数据，来加密，现在就是要加密，开发的jar包中会
        给出，我调用的方法，直接调用方法就加密，然后给数据拼接到入参中，进行接口调用;
        1、找开发确认，家里方式是什么
        2、同时管开发要jar包
        3、给jar包引入到当前的工程中：
        4、然后在pom文件中，引入坐标依赖，
         */
        //这里需要调用开发md5加密的方法，给data加密，然后给加密后的数据，
        //拼接到erpLoginData中，用来入参；
        String erpLoginData = "loginame=admin&password=";
        ApiCall.erpLogin(erpLoginData);
    }
}
