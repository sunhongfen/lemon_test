package com.lemon.homeWorkTestCase;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-02 17:53
 * @Desc：
 **/

public class FileInfo {
    @Excel(name = "测试入参")
    private String inputParams;
    @Excel(name = "响应断言")
    private String duanyan;

    public FileInfo(String inputParams, String duanyan) {
        this.inputParams = inputParams;
        this.duanyan = duanyan;
    }

    public FileInfo() {
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getDuanyan() {
        return duanyan;
    }

    public void setDuanyan(String duanyan) {
        this.duanyan = duanyan;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "inputParams='" + inputParams + '\'' +
                ", duanyan='" + duanyan + '\'' +
                '}';
    }
}
