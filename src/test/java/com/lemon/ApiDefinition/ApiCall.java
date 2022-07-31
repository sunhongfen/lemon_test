package com.lemon.ApiDefinition;

import com.lemon.util.Environment;
import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-30 10:30
 * @Desc：
 **/

public class ApiCall {
    /**
     * 接口封装
     * @param methed，请求方法
     * @param url，请求地址
     * @param headersMap，请求头Map格式，headers
     * @param jsonData，请求参数
     * @return，接口返回值
     */
    public static Response request(String methed, String url, Map headersMap,String jsonData){
        PrintStream fileOutPutStream = null;
        try {
            fileOutPutStream = new PrintStream(new File("log/test_all.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestAssured.filters(new RequestLoggingFilter(fileOutPutStream),new ResponseLoggingFilter(fileOutPutStream));
        url= Environment.replaceParams(url);
        jsonData = Environment.replaceParams(jsonData);
        headersMap = Environment.replaceParams(headersMap);
        Response res = null;
        if("get".equalsIgnoreCase(methed)){
                res=
                        given().
                                headers(headersMap).
                        when().
                                post(url+"?"+jsonData).
                        then().
                                log().all().
                                extract().response();
        }else if ("post".equalsIgnoreCase(methed)){
                     res=
                            given().
                                    headers(headersMap).
                                    body(jsonData).
                            when().
                                    post(url).
                            then().
                                    log().all().
                                    extract().response();
        }else {
                System.out.println("请求方式非法");
            }
        return res;
        }





    /**
     * 登录接口请求定义
      * @param jsonData 传入的接口参数
     *                 {"principal":"waiwai","credentials":"lemon123456","appType":3,"loginType":0}
     * @return
     */
    public static Response login(String jsonData) {
//        Response res =
//                given().
//                        header("Content-Type", "application/json").
//                        body(jsonData).
//                when().
//                        post("http://mall.lemonban.com:8107/login").
//                then().
//                        log().all().
//                        extract().response();
//        return res;
        Map headerMap = new HashMap();
        headerMap.put("Content-Type","application/json");
        return request("post","http://mall.lemonban.com:8107/login",headerMap,jsonData);
    }

    /**
     * 购物车接口
     * @param jsonData 请求参数
     * @param auth token
     * @return 接口返回值
     */
    public static Response shopCart(String jsonData,String auth){
//        Response res1 =
//                given().
//                        header("Content-Type","application/json").
//                        header("Authorization",auth).
//                        body(jsonData).
//                when().
//                        post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
//                then().
//                        extract().response();
//        return res1;
        Map headerMap = new HashMap();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Authorization",auth);
        return request("post","http://mall.lemonban.com:8107/p/shopCart/changeItem",headerMap,jsonData);
    }

    /**
     * 搜索商品接口请求定义
     * @param jsonData 接口请求入参
     *                    prodName=py47&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12
     * @return 响应信息
     */
    public static Response searchProduct(String jsonData){
//        Response res3 =
//                        given().
//                        when().
//                                get("http://mall.lemonban.com:8107/search/searchProdPage?"+productName).
//                        then().
//                                log().all().
//                                extract().response();
//        return res3;
        Map headerMap = new HashMap();
        headerMap.put("Content-Type","application/json");
        return request("get","http://mall.lemonban.com:8107/search/searchProdPage",headerMap,jsonData);

    }

    /**
     * 商品信息接口请求定义
     * @param proId 商品ID
     * @return 响应结果
     */
    public static Response prodInfo(int proId){
//        Response res5 =
//                given().
//                        when().
//                        get("http://mall.lemonban.com:8107/prod/prodInfo?"+"proId="+proId).
//                        then().
//                        log().all().
//                        extract().response();
//        return res5;
        Map headerMap = new HashMap();
        headerMap.put("Content-Type","application/json");
        return request("get","http://mall.lemonban.com:8107/prod/prodInfo",headerMap,"proId="+proId);

    }

}
