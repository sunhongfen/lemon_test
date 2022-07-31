package com.lemon.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.xsom.XSUnionSimpleType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-06 10:57
 * @Desc：
 **/

public class Environment {

//    public static  Map<String,Object> envMap = new HashMap<String, Object>();
//
//    public static void putEnvi(String enviName,Object enviValue){
//        Environment.envMap.put(enviName,enviValue);
//    }
//
//
//    public static Object getEnvi(String enviName){
//        Object getEnv = Environment.envMap.get(enviName);
//        return getEnv;
//    }


//    public static void main(String[] args){
//        String inputParam = "{\"basketId\":0,\"count\":1,\"prodId\":#prodId#,\"shopId\":1,\"skuId\":#skuId#}";
//        Environment.putEnvi("prodId",101);
//        Environment.putEnvi("skuId",203);
//        String regex = "#(.+?)#";
//        //编译
//        Pattern pattern = Pattern.compile(regex);
//        //匹配
//        Matcher matcher = pattern.matcher(inputParam);
//        while (matcher.find()){
//            //整个匹配到的字符串
//            String whol = matcher.group(0);
//            //分组第一个
//            String substr = matcher.group(1);
//
//            inputParam = inputParam.replace(whol,Environment.getEnvi(substr)+"");
//
//        }
//        System.out.println(inputParam);
//
//
//    }

        static Map<String,Object> map = new HashMap<String,Object>();
        //map中put数据
        public static void saveEnvironment(String enviKey,Object enviValue){
            Environment.map.put(enviKey, enviValue);
        }
        //map中get数据
       public static Object getEnvironment(String enviValue) {
           return Environment.map.get(enviValue);
       }

    //环境变量替换
       public static String replaceParams(String inputParam){
//            Environment.saveEnvironment("prodId",101);
//            Environment.saveEnvironment("skuId",203);
//        String inputParam = "{basketId\":0,\"count\":1,\"prodId\":#prodId#,\"shopId\":1,\"skuId\":#skuId#}";
        //定义正则
        String regex = "#(.+?)#";
        //编译为pattern对象
        Pattern pattern = Pattern.compile(regex);
        //参数中匹配
        Matcher matcher = pattern.matcher(inputParam);
        while (matcher.find()){
            //获取整个字符串#xxx#
            String wholeStr = matcher.group(0);
            //获取匹配到的第一个
            String subStr = matcher.group(1);
            //替换，replace，两个参数都需要为String类型
            inputParam=inputParam.replace(wholeStr, Environment.getEnvironment(subStr)+"");
        }
        return inputParam;
    }
    public static Map replaceParams(Map headersMap){
            //FastJson，给Map转为字符串
        String stringData = JSONObject.toJSONString(headersMap);
        //调用字符串replace方法
        stringData = replaceParams(stringData);
        //给字符串还转成Map;
        Map map = JSONObject.parseObject(stringData);
        return map;
    }
}
