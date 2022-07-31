package com.lemon.homeWorkTestCase;

import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 10:10
 * @Desc：
 **/

public class ProdList extends BaseTest {
    @Test
    public void prod_list_success(){
        int tagId = 1;
        int size = 12;
        String apiParam = "tagId="+tagId+"&size="+size;
        Response response = ApiCall.prodList(apiParam);
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);



    }
}
