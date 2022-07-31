package com.study;

import com.study.common.BaseTestCase;
import com.study.util.Environment;
import com.study.util.JDBCUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-25 11:32
 * @Desc：
 **/

public class OrderPayTest {
    @Test
    public static void orderPanTest() {
        //之前封装好的，基本接口信息
        Response info = LoginSearchInfo.login_search_info();
        //确认订单
        String confirmData = "{\"addrId\":0,\"orderItem\":{\"prodId\":#prodId#," +
                "\"skuId\":#skuId#,\"prodCount\":1,\"shopId\":1}," +
                "\"couponIds\":[],\"isScorePay\":0," +
                "\"userChangeCoupon\":0,\"userUseScore\":0," +
                "\"uuid\":\"d3857ad7-b8c0-4fc8-809c-b513a3ec5abc\"}";
        Response confirmRes = ApiCall.orderConfirm("#token#", confirmData);
        System.out.println("========================================确认订单=================================");
        //提交订单
        String submitData = "{\"orderShopParam\":[{\"remarks\":\"\"," +
                "\"shopId\":1}]," +
                "\"uuid\":\"d3857ad7-b8c0-4fc8-809c-b513a3ec5abc\"}";
        Response submitRes = ApiCall.orderSubmit("#token#", submitData);
        //获取返回信息中的订单号
        Object orderNumbers = submitRes.jsonPath().get("orderNumbers");
        Environment.saveEnvironment("orderNumbers", orderNumbers);
        System.out.println("================================================提交订单====================================");
        //支付下单
        String payData = "{\"payType\":3,\"orderNumbers\":\"#orderNumbers#\"}";
        Response payRes = ApiCall.orderPay("#token#", payData);
        System.out.println("=============================================支付下单========================================");
        //回调接口
        String noticeData = "{\"payNo\":#orderNumbers#,\"bizPayNo\":23421421,\"isPaySuccess\":true}";
        Response noticeRes = ApiCall.noticePay(noticeData);
        System.out.println("======================================================回调接口================");
        //响应数据断言
        String actural = noticeRes.body().asString();
        int code = noticeRes.getStatusCode();
        Assert.assertEquals(code,200);
        Assert.assertEquals(actural,"success");
        //数据库断言
        String sql = "SELECT status FROM tz_order WHERE order_number = #orderNumbers#;";
        Object acturalDB = JDBCUtil.querySingleData(sql);
        Assert.assertEquals(acturalDB,2);


    }
}
