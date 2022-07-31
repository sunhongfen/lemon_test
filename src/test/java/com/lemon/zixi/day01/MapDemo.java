package com.lemon.zixi.day01;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

import static org.apache.poi.sl.usermodel.PresetColor.Desktop;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-22 09:18
 * @Desc：
 **/

public class MapDemo {
    public static void main(String[] args) throws Exception {
        /*
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("id",1);
        map.put("score",100);
        map.put("age",12);
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s+"="+map.get(s));
        }
        System.out.println("================================");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : entries) {
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
        }
        System.out.println("=================================");

        Map<String,Integer> map = new HashMap();
        map.put("id",2);
        map.put("score",100);
        map.put("weight",70);
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key+"="+map.get(key));
        }
        System.out.println("==================================");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        System.out.println("============================");
        Student student1 = new Student();
        student1.age = 25;
        student1.gender = "男";
        student1.name = "张三";
        Student student2 = new Student();
        student2.age = 26;
        student2.gender = "男";
        student2.name = "李四";
        Student student3 = new Student();
        student3.age = 25;
        student3.gender = "男";
        student3.name = "赵六";
        Student student4 = new Student();
        student4.age = 27;
        student4.gender = "女";
        student4.name = "小花";
        List<Student> list1 = new ArrayList<Student>();
        list1.add(student1);
        list1.add(student2);
        List<Student>list2 = new ArrayList<Student>();
        list2.add(student3);
        list2.add(student4);
        Map<String,List<Student>> map = new HashMap<String, List<Student>>();
        map.put("1801",list1);
        map.put("1802",list2);
        Set<Map.Entry<String, List<Student>>> entries = map.entrySet();
        for (Map.Entry<String, List<Student>> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        String json = "{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"}";
        StudentZuoYe s=JSONObject.parseObject(json,StudentZuoYe.class);
        System.out.println(s);
        Map<String,Object> map = JSONObject.parseObject(json,Map.class);
        System.out.println(map);
        System.out.println("========================================");
        String json1 =  "[{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"},{\"name\": \"李四\", \"age\": \"16\", \"score\":\"100\"}]\n";
        List<HashMap> list = JSONObject.parseArray(json1,HashMap.class);
        System.out.println(list);
        List<StudentZuoYe> l = JSONObject.parseArray(json1,StudentZuoYe.class);
        System.out.println(l);
        System.out.println("======================================");
        FileInputStream file = new FileInputStream("src\\test\\resources\\api_testcases_futureloan_v1 (2).xls");
        ImportParams importParams = new ImportParams();
        importParams.setSheetNum(1);
        importParams.setStartSheetIndex(1);
        List<Excel01> excel = ExcelImportUtil.importExcel(file, Excel01.class, importParams);
        Object[] list1 = excel.toArray();
        for (Object l1 : list1) {
            System.out.println(l1);

        }

         */
        FileInputStream file= new FileInputStream("src\\test\\resources\\api_testcases_futureloan_v1 (2).xls");
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(1);
        List<Excel01> list = ExcelImportUtil.importExcel(file, Excel01.class, importParams);
//        System.out.println(list);
        Object[] lists = list.toArray();
        for (Object l1 : lists) {
            System.out.println(l1);

        }


        }


    }
