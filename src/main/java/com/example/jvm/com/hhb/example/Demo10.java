package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 17:29
 * @Description:
 */
public class Demo10 {

    // javac -d . HelloWorld.java
    // java com.example.jvm.com.hhb.example.HelloWorld
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制");
        FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader("/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制");
        Class<?> clazz1 = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.HelloWorld");
        Class<?> clazz2 = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.HelloWorld");
        Class<?> clazz3 = fileSystemClassLoader2.findClass("com.example.jvm.com.hhb.example.HelloWorld");

        System.err.println(clazz1);
        System.err.println(clazz2);
        System.err.println(clazz3);
        System.err.println(clazz1.hashCode());
        System.err.println(clazz2.hashCode());
        System.err.println(clazz3.hashCode());
        System.err.println(clazz1 == clazz2);
        System.err.println(clazz1.equals(clazz2));

        System.err.println(clazz1 == clazz3); // 被两个加载器加载的同一个类，JVM不认为是相同的类
        System.err.println(clazz1.equals(clazz3));// 被两个加载器加载的同一个类，JVM不认为是相同的类


        Class<?> clazz4 = fileSystemClassLoader.findClass("java.lang.String");
        Class<?> clazz5 = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.Demo06");

        System.err.println(clazz1.getClassLoader()); // 自定义类加载器
        System.err.println(clazz4.getClassLoader()); // 引导类加载器
        System.err.println(clazz5.getClassLoader()); // 系统默认类加载器


    }


}
