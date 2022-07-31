package com.study;

import org.testng.annotations.Test;

import javax.xml.ws.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-27 21:20
 * @Desc：
 **/

public class MockTest {
    @Test
    public static void mockTest(){
        String inputParam = "{\n" +
                "                \"mobile_phone\":\"13323234545\",\n" +
                "                \"pwd\":\"123456\"\n" +
                "            }";
        Map<String,Object> map = new HashMap<>();
        map.put("X-Lemonban-Media-Type","lemonban.v1");
                        given().
                                log().all().
                                headers(map).
                                body(inputParam).
                        when().
                                post("http://127.0.0.1:9999/login").
                        then().
                                log().all();
    }
}
