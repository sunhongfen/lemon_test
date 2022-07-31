package com.lemon.zixi.day01;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-23 14:15
 * @Desc：
 **/

public class Excel01 {
    /*
    //序号(caseId)	接口模块(interface)	用例标题(title)
    // 请求头(requestHeader)	请求方式(method)	接口地址(url)
    // 参数输入(inputParams)	期望返回结果(expected)
    @Excel(name = "序号(caseId)")
    private Integer caseId;
    @Excel(name = "接口模块(interface)")
    private String interfacedemo;
    @Excel(name = "用例标题(title)")
    private String title;
    @Excel(name = "请求头(requestHeader)")
    private String requestHeader;
    @Excel(name = "请求方式(method)")
    private String method;
    @Excel(name = "接口地址(url)")
    private String url;
    @Excel(name = "参数输入(inputParams)")
    private String inputParams;
    @Excel(name = "期望返回结果(expected)")
    private String expected;

    public Excel01() {
    }

    public Excel01(Integer caseId, String interfacedemo, String title, String requestHeader, String method, String url, String inputParams, String expected) {
        this.caseId = caseId;
        this.interfacedemo = interfacedemo;
        this.title = title;
        this.requestHeader = requestHeader;
        this.method = method;
        this.url = url;
        this.inputParams = inputParams;
        this.expected = expected;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getInterfacedemo() {
        return interfacedemo;
    }

    public void setInterfacedemo(String interfacedemo) {
        this.interfacedemo = interfacedemo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "Excel01{" +
                "caseId=" + caseId +
                ", interfacedemo='" + interfacedemo + '\'' +
                ", title='" + title + '\'' +
                ", requestHeader='" + requestHeader + '\'' +
                ", method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", inputParams='" + inputParams + '\'' +
                ", expected='" + expected + '\'' +
                '}';
        */
//序号(caseId)	接口模块(interface)	用例标题(title)
// 请求头(requestHeader)	请求方式(method)	接口地址(url)
// 参数输入(inputParams)	期望返回结果(expected)
    @Excel(name = "序号(caseId)")
        private Integer caseId;
    @Excel(name= "接口模块(interface)")
        private String interfaceDemo;
    @Excel(name = "用例标题(title)")
        private String title;
    @Excel(name = "请求头(requestHeader)")
        private String requestHeader;
    @Excel(name = "请求方式(method)")
        private String method;
    @Excel(name = "接口地址(url)")
        private String url;
    @Excel(name = "参数输入(inputParams)")
        private String inputParams;
    @Excel(name = "期望返回结果(expected)")
        private String expected;

    public Excel01(Integer caseId, String interfaceDemo, String title, String requestHeader, String method, String url, String inputParams, String expected) {
        this.caseId = caseId;
        this.interfaceDemo = interfaceDemo;
        this.title = title;
        this.requestHeader = requestHeader;
        this.method = method;
        this.url = url;
        this.inputParams = inputParams;
        this.expected = expected;
    }

    public Excel01() {
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getInterfaceDemo() {
        return interfaceDemo;
    }

    public void setInterfaceDemo(String interfaceDemo) {
        this.interfaceDemo = interfaceDemo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "Excel01{" +
                "caseId=" + caseId +
                ", interfaceDemo='" + interfaceDemo + '\'' +
                ", title='" + title + '\'' +
                ", requestHeader='" + requestHeader + '\'' +
                ", method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", inputParams='" + inputParams + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

}

