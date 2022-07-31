package com.study.util;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-23 09:49
 * @Desc：
 **/

public class RandomDataUtil {
    public static void main(String[] args) {
//        Faker faker = new Faker(Locale.CHINA);
//        String color = faker.phoneNumber().cellPhone();
//        System.out.println(color);
        getUnRegisterPhone();
        String unRegisterName = getUnRegisterName();
        System.out.println(unRegisterName);
    }

    /**
     * 生成随机号码，然后循环查库，如果注册过，则重新生成;
     * @return 生成的手机号
     */
    public static String getUnRegisterPhone() {
        //faker库生成随机手机号码
        Faker faker = new Faker(Locale.CHINA);
        String phone = faker.phoneNumber().cellPhone();
        System.out.println(phone);
        //用生成的手机号，查库，如果结果为0，说明未注册
        String sql = "SELECT COUNT(*) FROM tz_user WHERE user_mobile = "+phone+";";
        //循环判断，如果手机号被注册则重新生成;
        while (true) {
           long count = (long)JDBCUtil.querySingleData(sql);
            if (count == 0) {
                break;
            } else {
                phone = faker.phoneNumber().cellPhone();
               sql = "SELECT COUNT(*) FROM tz_user WHERE user_mobile = "+phone+";";
            }
        }return phone;
    }
    public static String getUnRegisterName(){
        Faker faker = new Faker();
        String name = faker.name().lastName();
        System.out.println(name);
        String sql = "SELECT COUNT(*) FROM tz_user WHERE nick_name = \""+name+"\";";
        while (true){
            long count =(long)JDBCUtil.querySingleData(sql);
            if (count ==0){
                break;
            }else {
                name = faker.name().firstName();
                sql = "SELECT COUNT(*) FROM tz_user WHERE nick_name = \""+name+"\";";
            }
        }return  name;
    }
}
