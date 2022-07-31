package com.test.day01;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-28 17:50
 * @Desc：
 **/

public class RestAssuredDemo<given> {
//    public static void main(String[] args) {
//        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
//                given().header("Content-Type","application/json").
//                given().body(jsonData).
//                when().
//                        post("http://mall.lemonban.com:8107/login").
//                then().
//                        log().all();


//    @Test
//   public void getDemo01(){
//                given().
//                when().
//                        get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12").
//                then().
//                        log().all();
//    }
//    @Test
//    public void getDemo02(){
////        String jsonData = "prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
//                given().
//                        queryParam("prodName","py47").
//                        queryParam("categoryI").
//                        queryParam("sort","0").
//                        queryParam("orderBy","0").
//                        queryParam("current",1).
//                        queryParam("isAllProdType","true").
//                        queryParam("st","0").
//                        queryParam("size","12").
//                when().
//                        get("http://mall.lemonban.com:8107/search/searchProdPage").
//                then().
//                        log().all();
//    }
//
//    @Test
//    public void postDemo3(){
//        String jsonData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
//                given().
//                        header("Content-Type","application/json").
//                        body(jsonData).
//                when().
//                        post("http://mall.lemonban.com:8107/login").
//                then().
//                        log().all();
//
//    }
//    @Test
//    public void getDemo4(){
//                given().
//                when().
//                        get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12").
//                then().
//                        log().all();
//    }
//    @Test
//    public void getDemo5(){
//                given().
//                        queryParam("prodName","py47").
//                        queryParam("categoryId").
//                        queryParam("sort","0").
//                        queryParam("orderBy","0").
//                        queryParam("current","1").
//                        queryParam("isAllProdType","true").
//                        queryParam("st","0").
//                        queryParam("size","12").
//                when().
//                        get("http://mall.lemonban.com:8107/search/searchProdPage").
//                then().
//                        log().all();
//    }



    @Test
    public void getDemo6(){
              given().
              when().
                      get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12").
              then().
                      log().body();

    }
    @Test
    public void getDemo7(){
               given().
                       queryParam("prodName","py47").
                       queryParam("categoryId").
                       queryParam("sort","0").
                       queryParam("orderBy","0").
                       queryParam("current","1").
                       queryParam("isAllProdType","true").
                       queryParam("st","0").
                       queryParam("size","12").
               when().
                       get("http://mall.lemonban.com:8107/search/searchProdPage").
               then().
                       log().body();
      }

      @Test
    public void postDemo8(){
        String jsonData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
                given().
                         header("Content-Type","application/json").
                         body(jsonData).
                when().
                        post("http://mall.lemonban.com:8107/login").
                then().
                        log().body();

      }
      @Test
    public void postDemo9(){
                given().
                        header("Content-Type","application/x-www-form-urlencoded").
                        body("loginame=admin&password=e10adc3949ba59abbe56e057f20f883e").
                when().
                        post("http://erp.lemfix.com/user/login").
                then().
                        log().body();
      }
      @Test
    public void postDemo10(){
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <dependency>\n" +
                "            <groupId>io.rest-assured</groupId>\n" +
                "            <artifactId>rest-assured</artifactId>\n" +
                "            <version>4.2.0</version>\n" +
                "        </dependency>";
                given().
                        body(xmlData).
                when().
                        post("https://www.httpbin.org/post").
                then().
                        log().body();
      }
      @Test
    public void postDemo(){
                given().
                        header("Authorization","bearerd3d1c528-6a5a-46e7-968b-3d6a48e5c19e").
                        multiPart(new File("D:\\test.png")).
                when().
                        post("http://mall.lemonban.com:8108/admin/file/upload/img").

                then().
                        log().body();
      }

}
