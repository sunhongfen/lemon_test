package com.study;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.study.common.BaseTestCase;
import com.study.util.ExcelUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 10:32
 * @Desc：
 **/

public class LoginFromExcel extends BaseTestCase{
    @DataProvider
    public Object[] login_from_excel() throws Exception {
        //easypoi读取excel文件
        return ExcelUtil.excelUtil(0,"src\\test\\resources\\testcase.xlsx").toArray();
    }
    @Test(dataProvider ="login_from_excel")
    public void login_from_excel_test(FfileInfoTest ffileInfoTest){
        //调登录接口
        Response loginRes = ApiCall.login(ffileInfoTest.getCaseParam());
        String caseAssert = ffileInfoTest.getCaseAssert();
        assertRes(loginRes,caseAssert);

    }
}
