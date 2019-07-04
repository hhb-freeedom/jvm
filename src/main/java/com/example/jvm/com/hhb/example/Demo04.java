package com.example.jvm.com.hhb.example;

/**
 * @author: huanghongbo
 * @Date: 2019-07-04 16:41
 * @Description:
 */
public class Demo04 {

    public static void main(String[] args) {

        //-verbose:gc
        // -XX:+PrintGCDetails
        // -XX:+UseSerialGC 指定垃圾回收器
        // -Xms20M 指定堆内存最小值
        // -Xmx20M 指定堆内存最大值
        // -Xmn10M 只能新生代大小
        // -XX:SurvivorRatio=8 分配Eden区域大小为8M，这样两个survivor区域一个1M
        byte[] b1 = new byte[2 * 1024 * 1024]; // 现在新生代的Eden区域分配
        byte[] b2 = new byte[2 * 1024 * 1024];// 现在新生代的Eden区域分配
        byte[] b3 = new byte[2 * 1024 * 1024];// 现在新生代的Eden区域分配 Eden现在还剩2M
        byte[] b4 = new byte[4 * 1024 * 1024];  // 这时候来了一个4M的,这时候Eden装不开了，触发一次垃圾回收，要把对象放到survivor里面，但是survivor区域也不是很大，只有1M，所以触发内存分配担保
        // 于是把上面的三个对象移动到the space ，
        System.gc();


//        [GC (Allocation Failure) [DefNew: 7135K->359K(9216K), 0.0057531 secs] 7135K->6503K(19456K), 0.0057938 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]  发生在新生代，新生代的对象存活率不高。
//        [Full GC (System.gc()) [Tenured: 6144K->6144K(10240K), 0.0014150 secs] 10759K->10587K(19456K), [Metaspace: 2663K->2663K(1056768K)], 0.0014408 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
//        Heap
//        def new generation   total 9216K, used 4771K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//        eden space 8192K,  58% used [0x00000007bec00000, 0x00000007bf0a8e60, 0x00000007bf400000)
//        from space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
//        to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
//        tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//        the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
//        Metaspace       used 2669K, capacity 4486K, committed 4864K, reserved 1056768K
//        class space    used 287K, capacity 386K, committed 512K, reserved 1048576K


    }


}
