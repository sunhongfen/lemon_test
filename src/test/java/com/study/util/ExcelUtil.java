package com.study.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.study.FfileInfoTest;

import java.io.FileInputStream;
import java.util.List;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-21 20:00
 * @Desc：
 **/

public class ExcelUtil {
    public static List<FfileInfoTest>  excelUtil(int sheetNum,String dataPath) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(sheetNum);
        FileInputStream file = new FileInputStream(dataPath);
       List<FfileInfoTest> ffileInfoTests = ExcelImportUtil.importExcel(file, FfileInfoTest.class, importParams);
        return ffileInfoTests;

    }
}
