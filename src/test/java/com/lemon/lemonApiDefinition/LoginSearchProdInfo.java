package com.lemon.lemonApiDefinition;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-13 09:20
 * @Desc：
 **/

public class LoginSearchProdInfo {
    /**
     * 登录——搜索——商品信息，业务流程接口封装
     * 返回商品信息接口返回信息
     */
    public static String searchData = "冰顿顿";
    public static int skuId;
    public static int prodId;
    public static String token;
    public static Response login_search_info(){
        //登录接口
        String loginParam = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response resLogin = LemonApiDefin.lemon_login_test(loginParam);
        //获取token
        token = resLogin.jsonPath().get("access_token");

        //搜索接口
        String searchParam = "prodName="+searchData+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response resSearch = LemonApiDefin.lemon_search(searchParam);
        //获取prodId
        prodId = resSearch.jsonPath().get("records[0].prodId");

        //选择商品接口
        Response resProdInfo = LemonApiDefin.lemon_prodInfo(prodId);
        //获取skuId
       skuId = resProdInfo.jsonPath().get("skuList[0].skuId");
       return resProdInfo;
    }
}
