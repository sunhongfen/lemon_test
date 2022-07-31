package com.lemon.zixi.day01;

import java.util.ArrayList;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-06-21 18:23
 * @Desc：
 **/

public class ArrayListDemoZuoYe {
    public static void main(String[] args) {
        /*
        //输出每位老师，以及各位老师平均年龄
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Teacher t1 = new Teacher("张三",25);
        Teacher t2 = new Teacher("李四",25);
        Teacher t3 = new Teacher("老王",19);
        Teacher t4 = new Teacher("老赵",29);
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        for(int i = 0;i<teachers.size();i++){
            System.out.println(teachers.get(i));
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        int sum = 0;
        int avg = 0;
        for (int i = 0;i<teachers.size();i++){
            sum+=teachers.get(i).getAge();
        }
        avg = sum/teachers.size();
        System.out.println(avg);


        System.out.println("===========================");
        String s = "abc,123,中国,llllll,haha";
//        最终输出：abc：3，123：3，中国：2，llllll:6，haha:4
        String[] arr= s.split(",");
       for (int i=0;i<arr.length;i++){
           System.out.println(arr[i]+":"+arr[i].length());
       }
        System.out.println("========================================");
       //反过来输出：
       String str = "aiwozhonghua";
        for (int i = 0;i<str.length()&i>= 0;i--){
            System.out.println(str.lastIndexOf(1));
        }
        */
        System.out.println("=============================");
        ArrayList<Teacher>teacher = new ArrayList<Teacher>();
        Teacher t1 = new Teacher("张三",25);
        Teacher t2 = new Teacher("李四",35);
        Teacher t3 = new Teacher("老王",19);
        Teacher t4 = new Teacher("赵六",29);
        teacher.add(t1);
        teacher.add(t2);
        teacher.add(t3);
        teacher.add(t4);
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1);
        }
        int sum = 0;
        for (int i = 0;i<teacher.size();i++){
            sum+=teacher.get(i).getAge();
        }
        System.out.println(sum/teacher.size());

    }


}
