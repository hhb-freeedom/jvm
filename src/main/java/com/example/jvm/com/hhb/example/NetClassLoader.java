package com.example.jvm.com.hhb.example;

import java.io.*;
import java.net.URL;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 17:10
 * @Description: 网络类加载器
 * 对比一下两个自定义类加载器在什么时候委派父类加载，这个可以自己根据情况确定,自己测试一下
 */
public class NetClassLoader extends ClassLoader {


    private String rootUrl;

    public NetClassLoader() {

    }

    public NetClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        //先查询有没有加载过这个类。
        Class<?> clazz = findLoadedClass(name);

        // 如果已经加载，则直接返回加载好的类
        if (clazz != null) {
            return clazz;
        } else { // 如果没有，加载新的类
            if (clazz != null) {
                return clazz;
            } else {
                byte[] clazzData = getClassDate(name);
                if (clazzData == null) {
                    // 委派给父类加载
                    clazz = this.getParent().loadClass(name);
                } else {
                    clazz = defineClass(name, clazzData, 0, clazzData.length);
                }
            }
        }
        return clazz;
    }

    private byte[] getClassDate(String className) {
        String path = rootUrl + "/" + className.replaceAll("\\.", "/") + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(path);
            is = url.openStream();
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer, 0, temp);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
