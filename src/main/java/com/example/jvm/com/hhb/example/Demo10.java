package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 17:29
 * @Description:
 */
public class Demo10 {


    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制");
        Class<?> clazz1 = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.HelloWorld");
        Class<?> clazz2 = fileSystemClassLoader.findClass("com.example.jvm.com.hhb.example.HelloWorld");
        System.err.println(clazz1);
        System.err.println(clazz2);
        System.err.println(clazz1.hashCode());
        System.err.println(clazz2.hashCode());
        System.err.println(clazz1 == clazz2);
        System.err.println(clazz1.equals(clazz2));
    }


}
