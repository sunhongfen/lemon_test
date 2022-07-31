package com.study.common;

import com.alibaba.fastjson.JSONObject;
import com.study.FfileInfoTest;
import com.study.util.Environment;
import com.study.util.ExcelUtil;
import com.study.util.JDBCUtil;
import io.restassured.response.Response;
import org.apache.commons.dbutils.QueryRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.ImageProducer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 09:41
 * @Desc：
 **/


public class BaseTestCase {
    /**
     * Excel表格中响应断言
     * @param res 接口响应结果
     * @param resAssert，读取到的excel中的断言数据
     */
    //Excel表格中响应断言
    public static void assertRes(Response res,String resAssert) {
        if (null != resAssert) {
            //读取的excel表格中响应断言数据使用jsonPath,转成map，
            Map<String, Object> caseAssert = JSONObject.parseObject(resAssert);
            //遍历map
            Set<Map.Entry<String, Object>> entries = caseAssert.entrySet();
            for (Map.Entry<String, Object> keyValue : entries) {
                String key = keyValue.getKey();
                Object value = keyValue.getValue();
                //如果，key=statusCode，则实际的结果等于，res.get,
                // 然后断言实际结果就是res.get,期望结果为value;
                if ("statusCode".equals(key)) {
                    int code = res.getStatusCode();
                    Assert.assertEquals(code, value);
                } else {
                    Assert.assertEquals(res.jsonPath().get(key), value);
                }
            }
        }
    }

    public static void assertDB(String dbAssert) throws Exception {
        //读取excel的数据库断言数据，通过jsonPath转成map
         Map<String,Object> map = JSONObject.parseObject(dbAssert);
         //遍历map
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            //map里面的key就是sql;JDBCUtil查询到的是实际值，
            Object actualvalue = JDBCUtil.querySingleData(key);
            //map里面的value就是期望值；
            Assert.assertEquals(actualvalue,value);
        }
    }

}
