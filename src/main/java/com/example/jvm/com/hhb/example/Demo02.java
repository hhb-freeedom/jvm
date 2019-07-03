package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-01 11:34
 * @Description:
 */
public class Demo02 {


    public static void main(String[] args) {
        //字节码常量，存放在方法区
        String s1 = "abc";
        String s2 = "abc";

        // 存放在堆内存
        String s3 = new String("abc");
        String s4 = new String("abc");

        // 比较地址
        System.err.println(s1 == s2); // true
        System.err.println(s1 == s3); // false
        // 运行时常量
        System.err.println(s1 == s3.intern()); // true
        System.err.println(s4 == s3); // false
    }


}
