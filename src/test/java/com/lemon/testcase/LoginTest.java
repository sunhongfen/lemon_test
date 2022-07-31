package com.lemon.testcase;

import com.lemon.ApiDefinition.ApiCall;
import com.lemon.common.BaseTest;
import io.restassured.response.Response;
import javafx.scene.chart.XYChart;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-30 10:24
 * @Desc：
 **/

public class LoginTest extends BaseTest {
   @Test
    public static void test_login_success() {
       //1、准备测试数据
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //2、直接调用登录的接口请求
        Response res = ApiCall.login(jsonData);
       String auth = res.getHeader("Authorization");
        //3、断言
        int code = res.getStatusCode();
       Assert.assertEquals(code,200);


    }
}
