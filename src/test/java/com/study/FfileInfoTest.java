package com.study;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-14 10:47
 * @Desc：
 **/

public class FfileInfoTest {
    //用例编码	用例名称	测试入参	响应断言
    @Excel(name = "用例编码")
    private  int caseId;
    @Excel(name = "用例名称")
    private  String caseName;
    @Excel(name = "测试入参")
    private  String caseParam;
    @Excel(name = "响应断言")
    private  String caseAssert;
    @Excel(name = "数据库断言")
    private String dbAssert;

    public FfileInfoTest() {
    }

    public FfileInfoTest(int caseId, String caseName, String caseParam, String caseAssert, String dbAssert) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.caseParam = caseParam;
        this.caseAssert = caseAssert;
        this.dbAssert = dbAssert;
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

    public String getCaseParam() {
        return caseParam;
    }

    public void setCaseParam(String caseParam) {
        this.caseParam = caseParam;
    }

    public String getCaseAssert() {
        return caseAssert;
    }

    public void setCaseAssert(String caseAssert) {
        this.caseAssert = caseAssert;
    }

    public String getDbAssert() {
        return dbAssert;
    }

    public void setDbAssert(String dbAssert) {
        this.dbAssert = dbAssert;
    }

    @Override
    public String toString() {
        return "FfileInfoTest{" +
                "caseId=" + caseId +
                ", caseName='" + caseName + '\'' +
                ", caseParam='" + caseParam + '\'' +
                ", caseAssert='" + caseAssert + '\'' +
                ", dbAssert='" + dbAssert + '\'' +
                '}';
    }
}
