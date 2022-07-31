package com.study;

import com.study.util.Environment;
import groovy.grape.GrapeIvy;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-27 10:05
 * @Desc：
 **/

public class FutureloanRSA {
    @Test
    public void futureloanRSA() {
        //调登录接口获取token和ID
        String data1 = "{\"mobile_phone\":\"13329334510\",\"pwd\":\"12345678\"}";
        Response login = ApiCall.futureloanLogin(data1);
        int member_id = login.jsonPath().get("data.id");
        Environment.saveEnvironment("member_id", member_id);
     //获取sign
        String token = login.jsonPath().get("data.token_info.token");
        String sign = getSign(token);
        long timestamp = System.currentTimeMillis() / 1000;
        String data2 = "{\n" +
                "    \"member_id\": #member_id#,\n" +
                "    \"amount\": 10000.0,\n" +
                "    \"timestamp\":"+timestamp+",\n" +
                "    \"sign\": "+sign+"\n" +
                "}";
        ApiCall.futureloanRecharge("#token#", data2);
    }


    public static String getSign(String token){
        String signData = token.substring(0, 50);
        long timestamp = System.currentTimeMillis() / 1000;
        String sign = signData+timestamp;
        return sign;
    }
}
