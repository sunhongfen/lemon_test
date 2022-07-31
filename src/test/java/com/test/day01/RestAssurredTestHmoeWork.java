package com.test.day01;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-03-08 07:44
 * @Desc：
 **/

public class RestAssurredTestHmoeWork {
    @Test
    public void homeWorkDemo01(){
        //登录接口
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
    public void homeWorkDemo02(){
        //商品搜索接口
                given().
                when().
                        get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12").
                then().
                        log().all();
    }

    @Test
    public void homeWorkDemo03(){
        //选择商品接口
                given().
                when().
                       get("http://mall.lemonban.com:8107/prod/prodInfo?prodId=182").
                then().
                       log().all();
    }

    @Test
    public void homeWorkDemo04(){
        //加车接口
        String jsondata2 = "{\"basketId\":0,\"count\":1,\"prodId\":\"182\",\"shopId\":1,\"skuId\":525}";
                given().
                         header("Content-Type","application/json").
                         header("Authorization","bearer592f38ac-7af7-4ed9-84cf-25e1394361ad").
                         body(jsondata2).
                when().
                        post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                        log().all();
    }
}
