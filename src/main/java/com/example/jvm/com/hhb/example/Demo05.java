package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-04 16:41
 * @Description:
 */
public class Demo05 {

    public final static int M = 1024 * 1024;

    //-verbose:gc
    // -XX:+PrintGCDetails
    // -XX:+UseSerialGC 指定垃圾回收器
    // -Xms20M 指定堆内存最小值
    // -Xmx20M 指定堆内存最大值
    // -Xmn10M 只能新生代大小
    // -XX:SurvivorRatio=8 分配Eden区域大小为8M，这样两个survivor区域一个1M
    // -XX:PretenureSizeThreshold=6M 设置对象多大的时候直接进入到老年代
    public static void main(String[] args) {
        //  byte[] b1 = new byte[8 * M]; 不配置  -XX:PretenureSizeThreshold  参数的情况下 当对象所占空间大雨eden区域大小的时候，会直接分配
        // 到老年区。
          byte[] b1 = new byte[7 * M];
    }


}
