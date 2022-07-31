package com.lemon.homeWorkApiDefinition;

import com.lemon.util.Environment;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 09:28
 * @Desc：
 **/

public class ApiCall {
    /**
     * 商城登录接口定义
     * @param apiParam 接口入参
     * {"principal":"waiwai","credentials":"lemon123456","appType":3,"loginType":0}
     * @return 接口响应结果
     */
    public static Response login(String apiParam){
        Response res =
                given().
                        header("Content-Type","application/json").
                        body(apiParam).
                when().
                        post("http://mall.lemonban.com:8107/login").
                then().
                        log().all().
                        extract().response();
        return res;
    }

    /**
     * 商城热销接口
     * @param apiParam,接口入参
     * tagId=20&size=20
     * @return 响应结果
     */
    public static Response prodList(String apiParam){
        Response res =
                        given().
                        when().
                                get("http://mall.lemonban.com:8107/prod/prodListByTagId?"+apiParam).
                        then().
                                log().all().
                                extract().response();
        return res;
    }

    /**
     *商品搜索接口
     * @param apiParam
     * prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12
     * @return 接口响应结果
     */

public static Response searchProd(String apiParam){
        Response res =
                        given().
                        when().
                                get("http://mall.lemonban.com:8107/search/searchProdPage?"+apiParam).
                        then().
                                log().all().
                                extract().response();
        return res;
    }

    /**
     * 选择商品接口
     * @param prodId 接口入参
     * prodId=2131
     * @return 接口响应结果
     */
    public static Response prodInfo(int prodId){
        Response res =
                given().
                when().
                        get("http://mall.lemonban.com:8107/prod/prodInfo?"+"prodId="+prodId).
                then().
                        log().all().
                        extract().response();
        return res;
    }

    /**
     * 购物车接口
     * @param token 鉴权token，登录接口返回
     * @param apiParam 接口入参
     * {"basketId":0,"count":1,"prodId":"2131","shopId":1,"skuId":9659}
     * @return 接口响应结果
     */
    public static Response shopCart(String token,String apiParam){
        apiParam = Environment.replaceParams(apiParam);
        Response res =
                        given().
                                log().all().
                                header("Content-Type","application/json").
                                header("Authorization",token).
                                body(apiParam).
                        when().
                                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                        then().
                                log().all().
                                extract().response();
        return res;
    }
}