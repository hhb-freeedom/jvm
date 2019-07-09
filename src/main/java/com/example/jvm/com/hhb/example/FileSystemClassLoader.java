package com.example.jvm.com.hhb.example;

import sun.jvm.hotspot.debugger.Page;

import java.io.*;

/**
 * @author: huanghongbo
 * @Date: 2019-07-09 17:10
 * @Description: 自定义文件系统加载器
 */
public class FileSystemClassLoader extends ClassLoader {


    private String roorDir;

    public FileSystemClassLoader() {

    }

    public FileSystemClassLoader(String roorDir) {
        this.roorDir = roorDir;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        //先查询有没有加载过这个类。
        Class<?> clazz = findLoadedClass(name);

        // 如果已经加载，则直接返回加载好的类
        if (clazz != null) {
            return clazz;
        } else { // 如果没有，加载新的类
            try {
                // 委派给父类加载
                clazz = this.getParent().loadClass(name);
            } catch (Exception e) {

            }

            if (clazz != null) {
                return clazz;
            } else {
                byte[] clazzData = getClassDate(name);
                if (clazzData == null) {
                    throw new ClassNotFoundException();
                } else {
                    clazz = defineClass(name, clazzData, 0, clazzData.length);
                }
            }
        }
        return clazz;
    }

    private byte[] getClassDate(String className) {
        String path = roorDir + "/" + className.replaceAll("\\.", "/") + ".class";

        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File(path));
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
