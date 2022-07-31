package com.lemon.common;

import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;
import java.util.Set;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-05 15:52
 * @Desc：
 **/

public class BaseTest {
    /**
     * 通用响应断言
     * @param assertDatas Excel中响应断言数据（json格式）
     * @param real 调用接口的响应结果
     */
    public static void assertResponse(String assertDatas, Response real){
        Map<String,Object> map = JSONObject.parseObject(assertDatas);
        //遍历map
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        //{"code":200,"nickName":"waiwai"}
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("code".equals(key)){
                int reaCode = real.getStatusCode();
                Assert.assertEquals(reaCode,value);
            }else{
                String data = real.jsonPath().get(key);
                Assert.assertEquals(data,value);
            }

        }

    }
}
