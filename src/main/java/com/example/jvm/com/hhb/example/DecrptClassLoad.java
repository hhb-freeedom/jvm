package com.example.jvm.com.hhb.example;

import java.io.*;

/**
 * @author: huanghongbo
 * @Date: 2019-07-10 13:42
 * @Description:
 */
public class DecrptClassLoad extends ClassLoader {


    private String rootDir;

    public DecrptClassLoad(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        } else {
            try {
                loadedClass = this.getParent().loadClass(name);
            } catch (Exception e) {

            }
            if (loadedClass != null) {
                return loadedClass;
            } else {
                byte[] clazzData = getClassDate(name);
                if (clazzData == null) {
                    throw new ClassNotFoundException();
                } else {
                    loadedClass = defineClass(name, clazzData, 0, clazzData.length);
                }
            }
        }
        return loadedClass;
    }

    private byte[] getClassDate(String className) {
        String path = rootDir + "/" + className.replaceAll("\\.", "/") + ".class";

        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File(path));
            int tmp = -1;
            while ((tmp = is.read()) != -1) {
                baos.write(tmp ^ 0xff);
            }

            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
