package com.study;

import com.study.common.BaseTestCase;
import com.study.util.Environment;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 08:39
 * @Desc：
 **/

public class LoginSearchInfo extends BaseTestCase {
    @Test
    public static Response login_search_info(){
        //登录接口调用
        String loginData = "{\"principal\":\"Donald\",\"credentials\":\"123456\",\"appType\":3,\"loginType\":0}";
        Response login = ApiCall.login(loginData);
        //获取token
        String token = login.jsonPath().get("access_token");
        //保存token到环境变量
        Environment.saveEnvironment("token",token);
        System.out.println("========================登录接口================================");

        //搜索接口
        String searceData = "prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response search = ApiCall.search(searceData);
        //获取prodId
        int prodId = search.jsonPath().get("records[0].prodId");
        //保存prodId到环境变量
        Environment.saveEnvironment("prodId",prodId);
        System.out.println("===============================搜索接口===========================");

        //详细信息接口
        Response info = ApiCall.info(prodId);
        //获取skuId
        int skuId = info.jsonPath().get("skuList[0].skuId");
        //保存skuId到环境变量
        Environment.saveEnvironment("skuId",skuId);
        System.out.println("===================================详细信息接口======================");
        return info;
    }
}
