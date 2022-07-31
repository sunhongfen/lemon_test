package com.lemon.homeWorkTestCase;

import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 11:15
 * @Desc：
 **/

public class SearchProd extends BaseTest {
    @Test
    public void search_prod_success(){
        String data = "py47";
        String apiParam = "prodName="+data+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response response = ApiCall.searchProd(apiParam);
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);
        Object prodName = response.jsonPath().get("records[0].prodName");
        Assert.assertEquals(prodName,"py47");


    }
}
