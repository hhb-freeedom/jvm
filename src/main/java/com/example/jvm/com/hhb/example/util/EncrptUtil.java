package com.example.jvm.com.hhb.example.util;

import java.io.*;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 18:44
 * @Description: 加密工具类（取反）
 */
public class EncrptUtil {


    public static void main(String[] args) {
        encrpt("/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制/HelloWorld.class", "/Users/baiwang/Desktop/视频/12_注解_反射_字节码_类加载机制/test/HelloWorld.class");
    }


    public static void encrpt(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int tmp = -1;
            while ((tmp = fis.read()) != -1) {
                fos.write(tmp ^ 0xff); // 取反操作
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
