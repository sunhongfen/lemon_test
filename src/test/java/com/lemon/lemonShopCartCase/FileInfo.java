package com.lemon.lemonShopCartCase;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.restassured.response.Response;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-13 15:57
 * @Desc：
 **/

public class FileInfo {
    @Excel(name = "用例编码")
     private int caseId;
    @Excel(name = "用例名称")
     private String caseName;
    @Excel(name = "测试入参")
     private String inputParam;
    @Excel(name = "响应断言")
     private String caseAssert;

    public FileInfo() {
    }

    public FileInfo(int caseId, String caseName, String inputParam, String caseAssert) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.inputParam = inputParam;
        this.caseAssert = caseAssert;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getInputParam() {
        return inputParam;
    }

    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }

    public String getCaseAssert() {
        return caseAssert;
    }

    public void setCaseAssert(String caseAssert) {
        this.caseAssert = caseAssert;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "caseId=" + caseId +
                ", caseName='" + caseName + '\'' +
                ", inputParam='" + inputParam + '\'' +
                ", caseAssert='" + caseAssert + '\'' +
                '}';
    }
}
