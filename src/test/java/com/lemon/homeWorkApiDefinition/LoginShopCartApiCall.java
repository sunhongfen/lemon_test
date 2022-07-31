package com.lemon.homeWorkApiDefinition;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 17:41
 * @Desc：
 **/

public class LoginShopCartApiCall {
    @Test
    public void Login_ProdInfo_ProdList_Search_Shop(){
        //登录接口
        String loginData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response login = ApiCall.login(loginData);
        //提取token
        Object authorization = login.jsonPath().get("access_token");
        //商品列表接口
        int tagId = 1;
        int size = 12;
        String prodListData = "tagId="+tagId+"&size="+size;
        Response response = ApiCall.prodList(prodListData);
        //商品搜索接口
        String data = "py47";
        String searchData = "prodName="+data+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response response1 = ApiCall.searchProd(searchData);
        //提取商品ID
        int prodId1 = response1.jsonPath().get("records[0].prodId");
        //选择商品接口
        Response response2 = ApiCall.prodInfo(prodId1);
        Object skuId = response2.jsonPath().get("skuList[0].skuId");

        //购物车接口
        String shopCart = "{\"basketId\":0,\"count\":1,\"prodId\":"+ prodId1+",\"shopId\":1,\"skuId\":"+skuId+"}";
//        String shopCart = "{\"basketId\":0,\"count\":1,\"prodId\":\"2131\",\"shopId\":1,\"skuId\":9659}";
        String token = "bearer"+authorization;
        Response response3 = ApiCall.shopCart(token,shopCart);
        int code = response3.getStatusCode();
        Assert.assertEquals(code,200);

    }
}
