package com.lemon.lemonShopCartCase;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.lemon.lemonApiDefinition.LemonApiDefin;
import com.lemon.lemonApiDefinition.LoginSearchProdInfo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-12 23:01
 * @Desc：
 **/

public class LemonShopCartCase {

    @Test
    public static void lemon_shop_cart_case() {
        //登录接口参数
        String loginParam = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //调登录接口
        Response resLogin = LemonApiDefin.lemon_login_test(loginParam);
        //获取token
        String token = resLogin.jsonPath().get("access_token");
//        登录接口断言
//        int statusCode = resLogin.getStatusCode();
//        Assert.assertEquals(statusCode,200);


        //搜索商品接口参数

        String searchParam = "prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        //调搜索接口
        Response resSearch = LemonApiDefin.lemon_search(searchParam);
        //获取prodId
        int prodId = resSearch.jsonPath().get("records[0].prodId");


        //选择商品入参
        Response resProdInfo = LemonApiDefin.lemon_prodInfo(prodId);
        //获取skuId
        int skuId = resProdInfo.jsonPath().get("skuList[0].skuId");
        System.out.println(skuId);
        //断言
//        int code = resProdInfo.getStatusCode();
//        Assert.assertEquals(code,200);

        //添加购物车接口
        String shopCartParam = "{\"basketId\":0,\"count\":1,\"prodId\":" + prodId + ",\"shopId\":1,\"skuId\":" + skuId + "}";
        Response resShopCart = LemonApiDefin.lemon_shop_cart(token, shopCartParam);
        int code = resShopCart.getStatusCode();
        Assert.assertEquals(code, 200);


    }

    @Test
    public static void login_search_prodInfo_success() {
        //调用从登录--商品信息，业务流程组合接口
        Response resLoginSearchInfo = LoginSearchProdInfo.login_search_info();
        //调用购物车接口
        String shopCartParam = "{\"basketId\":0,\"count\":1,\"prodId\":" + LoginSearchProdInfo.prodId + ",\"shopId\":1,\"skuId\":" + LoginSearchProdInfo.skuId + "}";
        Response resShopCart = LemonApiDefin.lemon_shop_cart(LoginSearchProdInfo.token, shopCartParam);
        int code = resShopCart.getStatusCode();
        Assert.assertEquals(code, 200);
    }


    @DataProvider
    public Object[] login_test() {
        Object[] loginData = {"{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
                "{\"principal\":\"waiwa\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
                "{\"principal\":\"waiwai\",\"credentials\":\"lemon1234\",\"appType\":3,\"loginType\":0}"};
        return loginData;
    }

    @Test(dataProvider = "login_test")
    public static void loginTest(String loginData) {
        Response res = LemonApiDefin.lemon_login_test(loginData);
    }


    @DataProvider
    public Object[] login_from_excel() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);
        FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\testcase.xlsx");
        List<FileInfo> fileInfos = ExcelImportUtil.importExcel(fileInputStream, FileInfo.class, importParams);
        return fileInfos.toArray();
    }
    @Test(dataProvider = "login_from_excel")
    public void login_from_excel_case(FileInfo fileInfos){
        Response res = LemonApiDefin.lemon_login_test(fileInfos.getInputParam());
        //获取excel中断言
        String caseAssert = fileInfos.getCaseAssert();
        if (null!=caseAssert){
        //转为map格式
        Map<String,Object> assertCase = JSONObject.parseObject(caseAssert);
        //遍历map
        Set<Map.Entry<String, Object>> entries = assertCase.entrySet();
        for (Map.Entry<String, Object> keyValue : entries) {
            String key = keyValue.getKey();
            Object value = keyValue.getValue();
            if ("statusCode".equals(key)){
                Assert.assertEquals(res.getStatusCode(),value);
            }else{
                Assert.assertEquals(res.jsonPath().get(key),value);
            }
        }
        }


    }


}
