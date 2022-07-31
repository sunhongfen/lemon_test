package com.lemon.lemonApiDefinition;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-12 22:04
 * @Desc：
 **/

public class LemonApiDefin {
    /**
     * 登录接口
     * @param inputParam 入参
     * {"principal":"waiwai","credentials":"lemon123456","appType":3,"loginType":0}
     * @return ：返回接口响应信息
     */
    public static Response lemon_login_test(String inputParam){
        Response res =
                given().
                        log().all().
                        header("Content-Type","application/json").
                        body(inputParam).
                when().
                        post("http://mall.lemonban.com:8107/login").
                then().
                        log().all().
                        extract().response();
        return res;
    };

    /**
     * 商品搜索接口
     * @param inputParam ：接口入参
     * "prodName=冰顿顿&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12"
     * @return 返回接口响应信息
     */
    public static Response lemon_search(String inputParam){
        Response res =
                given().
                        log().all().
                        when().
                        get("http://mall.lemonban.com:8107/search/searchProdPage?"+inputParam).
                        then().
                        log().all().
                        extract().response();
        return res;
    };

    /**
     * 选择商品接口
     * @param prodId ：接口入参
     * "prodId=2904"
     * @return 返回接口响应信息
     */
    public static Response lemon_prodInfo(int prodId){
        Response res =
                given().
                        log().all().
                        when().
                        get("http://mall.lemonban.com:8107/prod/prodInfo?prodId="+prodId).
                        then().
                        log().all().
                        extract().response();
        return res;

    };

    /**
     * 购物车接口
     * @param token token
     * @param inputParam 接口入参
     *
     * @return
     */
    public static Response lemon_shop_cart(String token,String inputParam){
        Response res =
        given().
                log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body(inputParam).
        when().
                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
        then().
                log().all().
                extract().response();
        return res;
    }
}
