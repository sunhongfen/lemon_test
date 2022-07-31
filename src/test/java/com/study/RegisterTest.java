package com.study;

import com.github.javafaker.Faker;
import com.study.ApiCall;
import com.study.common.BaseTestCase;
import com.study.util.Environment;
import com.study.util.JDBCUtil;
import com.study.util.RandomDataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-21 21:03
 * @Desc：
 **/

public class RegisterTest extends BaseTestCase {
    @Test
    public static void register(){
        //1、调用发送验证码接口
        String unRegisterPhone = RandomDataUtil.getUnRegisterPhone();
        Environment.saveEnvironment("unRegisterPhone",unRegisterPhone);
        String data01 = "{\"mobile\":\"#unRegisterPhone#\"}";
        ApiCall.sendRegisterSms(data01);

        //2、调用数据库获取验证码
        String sql = "SELECT mobile_code FROM tz_sms_log WHERE id=(SELECT MAX(id) FROM tz_sms_log);";
        Object validCode = JDBCUtil.querySingleData(sql);
        Environment.saveEnvironment("validCode",validCode);
        System.out.println("=================================发送验证码===================");
        //3、校验验证码
        String data02="{\"mobile\":\"#unRegisterPhone#\",\"validCode\":\"#validCode#\"}";
        Response checkRegister = ApiCall.checkRegisterSms(data02);
        String checkRegisterSmsFlag = checkRegister.body().asString();
        //4、验证码校验的字符串保存到环境变量中
        Environment.saveEnvironment("checkRegisterSmsFlag",checkRegisterSmsFlag);
        System.out.println("================================校验验证码========================");
        //5、注册接口
        String name = RandomDataUtil.getUnRegisterName();
        Environment.saveEnvironment("name",name);
        String data03="{\"appType\":3,\"checkRegisterSmsFlag\":\"#checkRegisterSmsFlag#\"," +
                "\"mobile\":#unRegisterPhone#,\"userName\":\"#name#\"," +
                "\"password\":\"123456\",\"registerOrBind\":1,\"validateType\":1}";
        Response register = ApiCall.register(data03);
        //6、响应断言
        int code = register.getStatusCode();
        Assert.assertEquals(code,200);
        Object nickName = register.jsonPath().get("nickName");
        Assert.assertEquals(nickName,name);
        //7、数据库断言
        String assertData = "SELECT COUNT(*) FROM tz_user WHERE nick_name = "+"\"'name'\""+";";
        System.out.println(assertData);
        long registerCount = (long)JDBCUtil.querySingleData(assertData);
        Assert.assertEquals(registerCount,1);
    }
}
