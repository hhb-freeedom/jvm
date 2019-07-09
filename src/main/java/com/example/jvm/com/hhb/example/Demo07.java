package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 13:46
 * @Description:
 */
public class Demo07 {

    static {
        System.err.println("初始化Demo07");
    }


    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用
//        new A(); new 一个对象
//        System.err.println(A.width);  调用类的静态变量

//        Class.forName("com.example.jvm.com.hhb.example.A"); 反射调用


        // 被动引用
//        System.err.println(A.max); // 调用常量


//        A[] as = new A[10]; // 通过数据定义类的引用，不会触发类的初始化

        System.err.println(B.width); // B不会被初始化，但是A、A_Father 会被初始化
    }


}


class B extends A {
    static {
        System.err.println("静态初始化类B");
    }
}


class A extends A_Father {

    public final static int max = 500;


    public static int width = 100;

    static {
        System.err.println("静态初始化类A");
        width = 300;
    }

    public A() {
        System.err.println("初始化类A");
    }

}

class A_Father {
    public static int height = 50;

    static {
        System.err.println("静态初始化类A_Father");
    }


    public A_Father() {
        System.err.println("初始化类A_Father");
    }
}