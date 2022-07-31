package com.lemon.service;

import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import com.lemon.util.Environment;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-04 08:42
 * @Desc：
 **/

public class LonginSearchInfoDefinition extends BaseTest {

    public static Response login_search_info(){
        //登录接口
        String loginParam = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response login = ApiCall.login(loginParam);
        //提取token
        String token = login.jsonPath().get("access_token");
        //往变量中保存数值
        System.out.println(token);
        Environment.saveEnvironment("token",token);
        System.out.println("-----------------------------------登录成功-------------------");

        //搜索接口
        String data = "py47";
        String searParam = "prodName="+data+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response searchProd = ApiCall.searchProd(searParam);
        //提取prodId
        int prodId = searchProd.jsonPath().get("records[0].prodId");
        //往变量中保存数值
        Environment.saveEnvironment("prodId",prodId);
        System.out.println("-------------------------------搜索商品----------------------------");


        //商品信息接口
        Response infoParam = ApiCall.prodInfo(prodId);
        int skuId = infoParam.jsonPath().get("skuList[0].skuId");
        //往变量中保存数值
        Environment.saveEnvironment("skuId",skuId);
        System.out.println("-------------------------------商品信息-------------------");
        return infoParam;

    }

}
