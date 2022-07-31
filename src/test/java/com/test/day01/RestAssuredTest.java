package com.test.day01;

import groovy.transform.SelfType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-03-06 19:27
 * @Desc：
 **/

public class RestAssuredTest {
    public static void main(String[] args) {
        //简单的get请求
//        given().
//                when().
//                        get("http://mall.lemonban.com:8107/prod/prodInfo?prodId=182").
//                        then().
//                                log().all();
        //简单post请求
//        String jsondata="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
//        given().
//                header("Content-Type","application/json").
//                body(jsondata).
//                when().
//                post("http://mall.lemonban.com:8107/login").
//                then().
//                log().all();
    }
    @Test
    public void getDemo(){
        //get请求参数放在param后面
                given().
                        queryParam("prodId",182).
                when().
                        get("http://mall.lemonban.com:8107/prod/prodInfo").
                then().
                        log().all();
    }
    @Test
    public void jsondata1(){
        //form表单传参
        given().
                header("Content-Type","application/x-www-form-urlencoded").
                body("loginame=admin&password=e10adc3949ba59abbe56e057f20f883e").
                when().
                post("http://erp.lemfix.com/user/login").
                then().
                log().all();
    }
    @Test
    public void postDemo2(){
        //json传参
        String jsondata1 = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        given().
                header("Content-Type","application/json").
                body(jsondata1).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all();
    }

    @Test
    public void postDemo3(){
        String xmldata = "<?xml version =\"1.0\"encoding=\"utf-8\"?>\n"+
                "<suite>\n"+
                "<class>测试xml</class>\n"+
                "</suite>";
        given().
                header("Content-Type","application/xml").
                body(xmldata).
                when().
                post("http://www.httpbin.org/post").
                then().
                log().all();
    }
//    @AaaTest
//    public void postDemo3(){
//        String xmldata = "<?xml version =\"1.0\"encoding=\"utf-8\"?>\n"+
//                "<suite>\n"+
//                "<class>测试xml</class>\n"+
//                "</suite>";
//        given().
//                header("Content-Type","multipart/form-data").
//                body(xmldata).
//                when().
//                post("http://mall.lemonban.com:8108/admin/file/upload/img").
//                then().
//                log().all();
//    }

    @Test
    public void postDemo04(){
        //post请求，上传文件
        given().
                header("Authorization","bearer086a7774-2372-46bb-b8cf-e611fe03b1c5").
                multiPart(new File("C:\\Users\\sun_h\\Desktop\\汪文斌.jpg")).
                when().
                post("http://mall.lemonban.com:8108/admin/file/upload/img").
                then().
                log().all();
    }
//    @AaaTest
//    public void Demo01(){
//        String jsondata2 = "{\"password\":\"sdfaf\"}";
//                given().
//                        header("Content-Type","application/json").
//                        header("Authorization","bearer2341sjdkfhjf").
//                          body(jsondata2).
//                when().
//                        post("http://mall.lemonban.com:8108/admin/file/upload/img").
//                then().
//                        log().all();

}
