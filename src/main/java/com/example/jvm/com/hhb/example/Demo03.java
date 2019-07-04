package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-03 13:49
 * @Description:
 */
public class Demo03 {


    private Object instance;

    public static void main(String[] args) {

        Demo03 demo1 = new Demo03();
        Demo03 demo2 = new Demo03();

        demo1.instance = demo2;
        demo2.instance = demo2;


        demo1 = null;
        demo2 = null;


        System.gc();
    }

}
