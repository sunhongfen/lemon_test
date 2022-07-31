package com.study.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 09:05
 * @Desc：
 **/

public class Environment {
    public static Map<String,Object> map = new HashMap<String, Object>();

    public static void saveEnvironment(String avKey,Object avValue){
        map.put(avKey,avValue);
    }
    public static Object getEnvironment(String key){
        Object value = map.get(key);
        return value;
    }


    //正则替换
    public static String regexTest(String inputParam){
        String regex = "#(.+?)#";
        //编译
        Pattern pattern = Pattern.compile(regex);
        //匹配
        Matcher matcher = pattern.matcher(inputParam);
        //循环
        while(matcher.find()){
            //整体字符串
            String whole = matcher.group(0);
            //匹配到第一个
            String subStr = matcher.group(1);
            //替换
            inputParam=inputParam.replace(whole,Environment.getEnvironment(subStr)+"");
        }return inputParam;
    }
    public static Map regexTest(Map headersMap){
        String datas = JSONObject.toJSONString(headersMap);
        datas = regexTest(datas);
        Map map = JSONObject.parseObject(datas);
        return map;
    }
}
