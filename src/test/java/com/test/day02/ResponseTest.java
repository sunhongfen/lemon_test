package com.test.day02;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-29 16:20
 * @Desc：
 **/

public class ResponseTest {
    @Test
    public void postDemo1() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res =
                given().
                        header("Content-Type", "application/json").
                        body(jsonData).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();


//        System.out.println(res.contentType());
//        System.out.println(res.time());
//        System.out.println(res.getStatusCode());
//        System.out.println(res.getHeaders());
        //获取解析响应体数据：
        System.out.println("=================================");
//        System.out.println(res.jsonPath().get("nickName"));
//        System.out.println(res.jsonPath().get("expires_in"));


    }

    @Test
    public void postDemo2() {
//            String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res2 =
                given().
                        when().
                        get("http://mall.lemonban.com:8107/prod/prodListByTagId?tagId=2&size=12").
                        then().
                        log().all().
                        extract().response();
//        System.out.println(res2.jsonPath().get("records[0].prodId"));
//        System.out.println(res2.jsonPath().get("records[0].price"));

    }

    @Test
    public void postDemo3() {
//            String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res3 =
                given().
                        when().
                        get("https://www.baidu.com/?tn=44004473_52_oem_dg").
                        then().
                        log().all().
                        extract().response();
//        System.out.println(res3.htmlPath().get("html.head.title"));
//        System.out.println(res3.htmlPath().get("html.head.meta[2].@name"));
    }

    @Test
    public void postDemo4() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res4 =
                given().
                        header("Content-Type", "application/json").
                        body(jsonData).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();
        String name = res4.jsonPath().get("nickName");
        Assert.assertEquals(name,"waiwai");
        int code = res4.getStatusCode();
        Assert.assertEquals(code,200);





    }
}
