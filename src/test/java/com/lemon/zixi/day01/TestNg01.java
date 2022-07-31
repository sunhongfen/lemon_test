package com.lemon.zixi.day01;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.List;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-24 20:44
 * @Desc：
 **/

public class TestNg01 {
//    @Test(invocationCount = 34,threadPoolSize = 4)
//    @Test
//    @AfterMethod
//    public void Demo01(){
//        System.out.println("ceshi01");
//    }
//    @Test
//    @BeforeMethod
//    public void Demo02(){
//        System.out.println("ceshi02");
//    }
//    @Test
//    @BeforeSuite
//    public void Demo03(){
//        System.out.println("ceshi03");
//    }
//    @Test
//    @Parameters({"username","password"})
//    public void Demo04(String username,String password){
//        System.out.println(username+":"+password);
//    }
    @Test(dataProvider = "testNg03")
    public void testNg02(Excel01 excel01){
        System.out.println(excel01);
    }
    @DataProvider
    public Object[] testNg03() throws Exception {
        FileInputStream file = new FileInputStream("target\\test-classes\\api_testcases_futureloan_v1 (2).xls");
        ImportParams importParams = new ImportParams();
        importParams.setSheetNum(2);
        List<Excel01> list = ExcelImportUtil.importExcel(file, Excel01.class, importParams);
        Object[] l1=list.toArray();
        return l1;
    }

}
