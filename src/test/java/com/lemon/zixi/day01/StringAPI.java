package com.lemon.zixi.day01;

import javax.swing.text.AttributeSet;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-21 09:52
 * @Desc：
 **/

public class StringAPI {
    public static void main(String[] args) {
        String str = "ABS";
        String str1 = "ABS";
        String str2 = "ABSS";
        String str3 = "abs";
        System.out.println(str.charAt(1));
        System.out.println(str.contains("C"));
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));
        System.out.println(str.equals("ABS"));
        System.out.println(str.equalsIgnoreCase(str3));
        System.out.println(str.equals(str3));
        System.out.println(str.indexOf("s"));
        System.out.println(str.indexOf("S"));
        System.out.println(str.lastIndexOf("S"));
        System.out.println(str.length());
        String str4 = str.replace("S","W");
        System.out.println(str4);
        System.out.println(str.replace("S","B"));
        System.out.println("===========================");
        String str5 = "a,ba,ca,da,ff";
        String arr[] = str5.split(",");
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        };
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("=========================");
        String str6 = "12334";
        int i = Integer.parseInt(str6);
        System.out.println(i);
        Double d = Double.parseDouble(str6);
        System.out.println(d);

    }

}
