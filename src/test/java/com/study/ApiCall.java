package com.study;

import com.study.common.GlobalConfig;
import com.study.util.Environment;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.trustStore;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 08:38
 * @Desc：
 **/

public class ApiCall {

    public static Response request(String method, String url, Map headersMap, String inputParam) {
        //日志文件重定向到本地target文件下：
        //1、先判断本地文件路径是否存在,不存在则新建；
        String logFilePath = null;
        //if GlobalConfig这是一个开关
        if (!GlobalConfig.IS_DEBUG) {
            String logPath = "target/log/";
            File file = new File(logPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            PrintStream fileOutPutStream = null;
            logFilePath = logPath + "test" + System.currentTimeMillis() + ".log";
            try {
                fileOutPutStream = new PrintStream(new File(logFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(fileOutPutStream));
        }
        //基础url
        RestAssured.baseURI=GlobalConfig.URL;
        //环境变量，参数化替换，调用正则；
        inputParam = Environment.regexTest(inputParam);
        headersMap = Environment.regexTest(headersMap);
        url = Environment.regexTest(url);
        //接口定义
        Response res = null;
        if ("post".equalsIgnoreCase(method)) {
            res =
                    given().
                            log().all().
                            headers(headersMap).
                            body(inputParam).
                            when().
                            post(url).
                            then().
                            log().all().
                            extract().response();
        } else if ("get".equalsIgnoreCase(method)) {
            res =
                    given().
                            log().all().
                            headers(headersMap).
                            when().
                            get(url + "?" + inputParam).
                            then().
                            log().all().
                            extract().response();
        } else if ("put".equalsIgnoreCase(method)) {
            res =
                    given().
                            log().all().
                            headers(headersMap).
                            body(inputParam).
                            when().
                            put(url).
                            then().
                            log().all().
                            extract().response();
        } else {
            System.out.println("请求方式非法");
        }

        if (!GlobalConfig.IS_DEBUG) {
            //     allure中添加日志附件
            try {
                Allure.addAttachment("接口请求响应信息",
                        new FileInputStream(logFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }return res;
    }


        /**
         * 登录接口
         * @param inputParam 接口请求入参
         * @return 返回接口响应数据
         */
        public static Response login (String inputParam){
            Map<String,Object> headersMap = new HashMap<>();
            headersMap.put("Content-Type", "application/json");
            return request("post", "http://mall.lemonban.com:8107/login", headersMap, inputParam);
        }

        /**
         * 搜索接口
         * @param inputParam 接口请求入参
         * @return 返回接口响应数据
         */
        public static Response search (String inputParam){
            Map<String,Object> headersMap = new HashMap<>();
            headersMap.put("Content-Type", "application/json");
            return request("get", "/search/searchProdPage", headersMap, inputParam);
        }

        /**
         * 详细信息接口
         * @param prodId，商品ID
         * @return 返回接口响应数据
         */
        public static Response info ( int prodId){
            Map<String,Object> headersMap = new HashMap<>();
            headersMap.put("Content-Type", "application/json");
            return request("get", "/prod/prodInfo", headersMap, "prodId=" + prodId);
        }

        /**
         * 加入购物车接口
         * @param token token
         * @param inputParam 接口入参
         * @return 返回接口响应数据
         */
        public static Response shopCart (String token, String inputParam){
            //存入请求头;
            Map<String,Object> headersMap = new HashMap<>();
            headersMap.put("Content-Type", "application/json");
            headersMap.put("Authorization", "bearer" + token);
            return request("post", "/p/shopCart/changeItem", headersMap, inputParam);
        }

    /**
     * 发送验证码接口
     * @param inputParam 请求入参
     * {"mobile":"12332123212"}
     * @return 返回接口响应数据
     */
    public static Response sendRegisterSms(String inputParam) {
        Map<String,Object>headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        return request("put", "/user/sendRegisterSms", headersMap, inputParam);
    }

    /**
     * 校验验证码接口
     * @param inputParam 接口请求入参
     * {"mobile":"12332112321","validCode":"461818"}
     * @return 返回接口响应数据
     */
    public static Response checkRegisterSms(String inputParam) {
        Map<String,Object>headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        return request("put", "/user/checkRegisterSms", headersMap, inputParam);
    }

    /**
     * 注册接口
     * @param inputParam 接口请求入参
     *{"appType":3,"checkRegisterSmsFlag":"45b2cadb10ea49e9bf3bc2dc3eae3beb",
     * "mobile":"12332112321","userName":"lemon_01","password":"123456",
     *"registerOrBind":1,"validateType":1}
     * @return 返回接口响应数据
     */
    public static Response register(String inputParam) {
        Map<String,Object>headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        return request("put", "/user/registerOrBindUser", headersMap, inputParam);
    }


    /**
     * 确认订单接口
     * @param token token
     * @param inputParam 请求入参
     * {"addrId":0,"orderItem":{"prodId":426,"skuId":7552,"prodCount":1,
     * "shopId":1},"couponIds":[],"isScorePay":0,"userChangeCoupon":0,
     *"userUseScore":0,"uuid":"d3857ad7-b8c0-4fc8-809c-b513a3ec5abc"}
     * @return 返回接口返回数据
     */
    public static Response orderConfirm(String token,String inputParam){
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Authorization","bearer" + token);
        return request("post","/p/order/confirm",headerMap,inputParam);
    }

    /**
     * 提交订单接口
     * @param token token
     * @param inputParam 接口请求入参
     * {"orderShopParam":[{"remarks":"","shopId":1}],
     * "uuid":"d3857ad7-b8c0-4fc8-809c-b513a3ec5abc"}
     * @return 返回接口返回信息
     */
    public static Response orderSubmit(String token,String inputParam){
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Authorization","bearer" + token);
        return request("post", "/p/order/submit", headerMap, inputParam);
    }

    /**
     * 支付下单接口
     * @param token token
     * @param inputParam 接口请求入参
     * {"payType":3,"orderNumbers":"1551403493104029696"}
     * @return 返回接口返回信息
     */
    public static Response orderPay(String token,String inputParam){
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Authorization","bearer" + token);
       return request("post","/p/order/pay",headerMap,inputParam);
    }

    /**
     * 订单回调mock接口
     * @param inputParam 接口请求入参
     *  {"payNo":123451234512345，#商城支付订单号,
     *  "bizPayNo":xxx,#微信方的订单号
     *  "isPaySuccess":true,#true成功，false失败}
     * @return success/false
     */
    public static Response noticePay(String inputParam){
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        return request("post","/notice/pay/3",headerMap,inputParam);
    }

    /**
     * Erp登录，md5加密
     * @param inputParam 接口入参
     *loginame=admin&password=e10adc3949ba59abbe56e057f20f883e
     * @return 返回接口返回数据
     */
    public static Response erpLogin(String inputParam){
        Map<String,Object>headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/x-www-form-urlencoded");
        return request("post","/user/login",headerMap,inputParam);
    }

    /**
     * 前程贷登录接口-RSA加密
     * @param inputParam，接口入参（这个是已经注册，可以直接使用的帐号）
     * {
     *     "mobile_phone": "13329334510",
     *     "pwd": "12345678"
     * }
     * @return
     */
    public static Response futureloanLogin(String inputParam){
        Map<String,Object>headerMap = new HashMap<>();
        headerMap.put("X-Lemonban-Media-Type","lemonban.v3");
        headerMap.put("Content-Type","application/json");
        return request("post","/futureloan/member/login",headerMap,inputParam);
    }

    /**
     * 前程贷充值接口-RSA加密
     * @param token token
     * @param inputParam 接口入参
     *{
     *     "member_id": XXX,     //登录接口返回的ID
     *     "amount": 10000.0,    //充值金额
     *     "timestamp": XXX,     //时间戳，秒级
     *     "sign": "XXX"         //取 token 前 50 位再拼接上timestamp
     *                   值，然后通过 RSA 公钥加密得到的字符串
     * }
     * @return
     */
    public static Response futureloanRecharge(String token,String inputParam){
        Map<String,Object>headerMap = new HashMap<>();
        headerMap.put("X-Lemonban-Media-Type","lemonban.v3");
        headerMap.put("Content-Type","application/json");
        headerMap.put("Authorization","Bearer"+token);
        return request("post", "/futureloan/member/recharge", headerMap, inputParam);
    }
}

