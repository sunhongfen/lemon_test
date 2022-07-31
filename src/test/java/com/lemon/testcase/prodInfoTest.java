package com.lemon.testcase;

import com.lemon.ApiDefinition.ApiCall;
import com.lemon.common.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-30 15:01
 * @Desc：
 **/

public class prodInfoTest extends BaseTest {
    @Test
    public void prod_Info(){
        int proId = 21;
        Response res5 = ApiCall.prodInfo(proId);
        int code = res5.getStatusCode();
        Assert.assertEquals(code,200);

    }
}
