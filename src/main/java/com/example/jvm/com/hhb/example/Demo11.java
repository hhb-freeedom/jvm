package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 18:13
 * @Description: 测试简单的加密解密操作（取反）
 * <p>
 * <p>
 * 自己可以再练习一下DES对称加密
 */
public class Demo11 {


    public static void main(String[] args) throws ClassNotFoundException {
        DecrptClassLoad fileSystemClassLoader = new DecrptClassLoad("/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制/test");

        Class<?> clazz = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.HelloWorld");


        System.err.println(clazz);

        // 取反操作
//        int a = 3;  // 00000011
//        System.err.println(Integer.toBinaryString(a ^ 0xff));


    }
}
