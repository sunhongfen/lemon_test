package com.lemon.homeWorkTestCase;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.lemon.common.BaseTest;
import com.lemon.homeWorkApiDefinition.ApiCall;
import com.lemon.zixi.day01.JsonObject;
import com.sun.org.apache.xpath.internal.operations.Equals;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-01 10:02
 * @Desc：
 **/

public class Login extends BaseTest {
//    @Test
//    public void longin_success(){
//        String apiParam = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
//        Response login = ApiCall.login(apiParam);
//        int code = login.getStatusCode();
//        Assert.assertEquals(code,200);
//        String nickName = login.jsonPath().get("nickName");
//        Assert.assertEquals(nickName,"waiwai");
//
//    }


//    @DataProvider
//    public Object[] loginTest() {
//        Object[] data = new Object[]{"{\"principal\":\"\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
//                "{\"principal\":\"waiwai\",\"credentials\":\"\",\"appType\":3,\"loginType\":0}",
//                "{\"principal\":\"waiwaiqqqq\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
//                "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3}"};
//        return data;
//    }
//    @Test(dataProvider ="loginTest")
//    public void test_login_success(String data){
//        Response login = ApiCall.login(data);
//    }


    @DataProvider
    public Object[] login_test_from_excel() throws Exception {
        //读取文件
        ImportParams importParams = new ImportParams();
        FileInputStream file= new FileInputStream("src\\test\\resources\\testcase.xlsx");
        List<FileInfo> fileInfos = ExcelImportUtil.importExcel(file, FileInfo.class, importParams);
        //转成一维数组
        Object[] arry = fileInfos.toArray();
        return arry;
    }
//    @Test(dataProvider ="login_test_from_excel")
//    //调用登录接口，方法入参要是FileInfo,对象
//    public void login_test_from_excel_case(FileInfo array) {
//        //因为参数是一个对象，所以入参要为：对象.getInput；
//        Response login = ApiCall.login(array.getInputParams());
//        //获取断言
//        String assertData = array.getDuanyan();
//        //断言从json字符串转成java对象，map
//        Map<String,Object> map = JSONObject.parseObject(assertData);
//        Set<Map.Entry<String, Object>> datas = map.entrySet();
//        for (Map.Entry<String, Object> entry : datas) {
//            //{"code":200,"jsonPath().get("nickName"):"waiwai"}
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if ("code".equals(key)){
//                int code = login.getStatusCode();
//                Assert.assertEquals(code,value);
//                }else{
//                Object nikeName = login.jsonPath().get(key);
//                Assert.assertEquals(nikeName,value);
//            }
//
//            }
//
//
//        }
    @Test(dataProvider ="login_test_from_excel")
    public void test_login_read(FileInfo array){
        //调登录方法，参数是数组类型，所以使用array.的格式
        Response reaLogin = ApiCall.login(array.getInputParams());
        //获取excel中断言
        String arrayDuanyan = array.getDuanyan();
        //给断言转成map格式
//        Map<String,Object> map = JSONObject.parseObject(arrayDuanyan);
//        //遍历map
//        Set<Map.Entry<String, Object>> entries = map.entrySet();
//        //{"code":200,"nickName":"waiwai"}
//        for (Map.Entry<String, Object> entry : entries) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if ("code".equals(key)){
//                int reaCode = reaLogin.getStatusCode();
//                Assert.assertEquals(reaCode,value);
//            }else{
//                String data = reaLogin.jsonPath().get(key);
//                Assert.assertEquals(data,value);
//            }

//        }
        assertResponse(arrayDuanyan,reaLogin);

    }
}