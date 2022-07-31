package com.lemon.homeWorkTestCase;

import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import com.lemon.service.LonginSearchInfoDefinition;
import com.lemon.util.Environment;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 11:28
 * @Desc：
 **/

public class ShopCart extends BaseTest {
//    @Test
//    public void shop_cart_success(){
//        //登录接口获取token
//        String apiParam = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
//        Response login = ApiCall.login(apiParam);
//        //获取token
//        Object access_token = login.jsonPath().get("access_token");
//        String token ="bearer"+access_token;
//        //购物车接口
//        String apiParam1 = "{\"basketId\":0,\"count\":1,\"prodId\":\"2131\",\"shopId\":1,\"skuId\":9659}";
//        Response response = ApiCall.shopCart(token, apiParam1);
//        int code = response.getStatusCode();
//        Assert.assertEquals(code,200);
//    }

    @Test
    public void businessFlow(){
        Response response = LonginSearchInfoDefinition.login_search_info();
        System.out.println("--------------------------商品信息调用------------------------");
        String shopCart = "{\"basketId\":0,\"count\":1,\"prodId\":#prodId#,\"shopId\":1,\"skuId\":#skuId#}";
        String token = "bearer"+(String) Environment.getEnvironment("token");
        Response response3 = ApiCall.shopCart(token,shopCart);
        Assert.assertEquals(response3.getStatusCode(),200);
    }
    @Test
    public void mase(){
        System.out.println(Environment.getEnvironment("token").getClass());
        System.out.println(Environment.getEnvironment("proId").getClass());

    }















}
