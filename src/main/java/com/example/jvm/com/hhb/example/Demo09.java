package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 16:25
 * @Description:
 */
public class Demo09 {


    public static void main(String[] args) {
        String a = "gaaaaa";
        System.err.println(a.getClass().getClassLoader());
        System.err.println(a);
    }

}
