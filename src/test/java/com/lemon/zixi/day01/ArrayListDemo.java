package com.lemon.zixi.day01;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-21 15:27
 * @Desc：
 **/

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("eqwrq");
        list.add(3241);
        list.add(0,"111");
        System.out.println(list);
        System.out.println("==========================");
        //指定数据类型：泛型
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("sdfad");
        list1.add("543");
        list1.add("fdsfasf");
        list1.add("fdjsakf");
        System.out.println(list1);
        ArrayList<Integer>list2 = new ArrayList();
        list2.add(3241);
        list2.add(234);
        list2.add(543);
        list2.add(533);
        System.out.println(list1.get(2));
        System.out.println(list2.get(0));
        System.out.println(list1.size());
        System.out.println(list1.indexOf("sdfad"));
        System.out.println("==================");
        Object[] arrs = list2.toArray();
        for (Object arr : arrs) {
//            System.out.println(arr);
        }
        for (int i = 0;i<arrs.length;i++){
//            System.out.println(arrs[i]);
        }
        System.out.println(list2);

        System.out.println("=============================");
        System.out.println(list1);
        for (String s : list1) {
            System.out.println(s);
        }
        for (int o = 0;o<list1.size();o++){
            System.out.println(list1.get(o));
        }

    }
}
