package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-06-26 20:00
 * @Description:
 */
public class Demo01 {


    public static void main(String[] args) {
        A a = new A();
        System.err.println(A.width);
    }

    private static class A {

        public static int width = 100;

        static {
            System.err.println("静态初始化A");
            width = 300;
        }


        public A() {
            System.err.println("创建A的对象");
        }

    }


}

