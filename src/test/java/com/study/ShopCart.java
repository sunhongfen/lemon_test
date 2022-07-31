package com.study;

import com.alibaba.fastjson.JSONObject;
import com.lemon.common.BaseTest;
import com.study.common.BaseTestCase;
import com.study.util.Environment;
import com.study.util.ExcelUtil;
import com.study.util.JDBCUtil;
import io.restassured.response.Response;
import org.apache.commons.dbutils.QueryRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.sql.rowset.JdbcRowSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 09:33
 * @Desc：
 **/

public class ShopCart extends BaseTestCase{
    @Test
    public static void shopCart(){
        //接口入参
        String inputParam ="{\"basketId\":0,\"count\":1,\"prodId\":#prodId#,\"shopId\":1,\"skuId\":#skuId#}";
        //调用前面封装好的核心接口
        Response response = LoginSearchInfo.login_search_info();
        //获取token
//       Object token = Environment.getEnvironment("token");
        //调用购物车接口
        Response shopCartRes = ApiCall.shopCart("#token#",inputParam);
        //响应状态码断言
        Assert.assertEquals(shopCartRes.getStatusCode(),200);
        //数据库断言
        String assertSql = "SELECT * from tz_basket where user_id = (SELECT user_id FROM tz_user WHERE nick_name = \"Donald\");";
//        Object data = JDBCUtil.querySingleData(assertSql);
        Map<String, Object> map = JDBCUtil.queryOneData(assertSql);
        Object basket_count = map.get("basket_count");
        Assert.assertEquals(basket_count,1);
    }
    //购物车接口响应断言
    @Test(dataProvider ="res_assert")
    public void resAssert(FfileInfoTest ffileInfoTest) throws Exception {
        //调用登录接口获取token
        String loginData = "{\"principal\":\"Donald\",\"credentials\":\"123456\",\"appType\":3,\"loginType\":0}";
        Response login = ApiCall.login(loginData);
        String token = login.jsonPath().get("access_token");
        //调用购物车接口获取响应结果为响应断言实际数据
        Response shopCart = ApiCall.shopCart(token, ffileInfoTest.getCaseParam());
       //从excel表格中获取相应断言数据为期望结果
        String caseAssert = ffileInfoTest.getCaseAssert();
        //进行响应结果断言，根据期望结果和实际结果
       BaseTestCase.assertRes(shopCart,caseAssert);
       //数据库断言
        BaseTestCase.assertDB(ffileInfoTest.getDbAssert());


    }
    @DataProvider
    public static Object[]  res_assert() throws Exception {
        //调用ExcelUtil.excelUtil读取sheet；
        List<FfileInfoTest> ffileInfoTests = ExcelUtil.excelUtil(1, "src\\test\\resources\\testcase.xlsx");
    return ffileInfoTests.toArray();
    }

}
