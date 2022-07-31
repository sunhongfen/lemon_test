package com.lemon.testcase;

import com.lemon.ApiDefinition.ApiCall;
import com.lemon.common.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-30 13:42
 * @Desc：
 **/

public class SearchProductTest extends BaseTest {
    @Test
   public void search_product_test(){
        String data = "py47";
        String productName = "prodName="+data+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
       Response res4 = ApiCall.searchProduct(productName);
       int code = res4.getStatusCode();
       Assert.assertEquals(code,200);
       String name = res4.jsonPath().get("records[0].prodName");
       Assert.assertTrue(name.contains(data));

   }

}