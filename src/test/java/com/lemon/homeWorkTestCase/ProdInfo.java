package com.lemon.homeWorkTestCase;

import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 11:22
 * @Desc：
 **/

public class ProdInfo extends BaseTest {
    @Test
    public void prod_info_success(){
        int prodId = 2131;
        Response response = ApiCall.prodInfo(2131);
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);

    }
}
