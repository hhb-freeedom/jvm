package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 15:51
 * @Description:
 */
public class Demo08 {


    public static void main(String[] args) throws ClassNotFoundException {
//        System.err.println(ClassLoader.getSystemClassLoader()); // sun.misc.Launcher$AppClassLoader@135fbaa4 应用类加载器
//
//        System.err.println(ClassLoader.getSystemClassLoader().getParent()); //sun.misc.Launcher$ExtClassLoader@2503dbd3 拓展类加载器
//
//        System.err.println(ClassLoader.getSystemClassLoader().getParent().getParent());

//        System.err.println(System.getProperty("java.class.path"));


        ClassLoader.getSystemClassLoader().loadClass("java.sdfdsf");
    }


}
