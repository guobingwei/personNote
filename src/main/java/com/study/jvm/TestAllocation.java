package com.study.jvm;

/**
 *  VM参数：
 *  -verbose:gc
 *  -Xms20M (初始堆大小为20M)
 *  -Xmx20M (最大堆大小为20M)
 *  -Xmn10M (新生代大小，初阶可用为9M大小) Eden + 1个survivor的大小
 *  -XX:+PrintGCDetails (打印 GC 信息)
 *  -XX:SurvivorRatio=8 (新生代中 Eden 与 Survivor 的比值)
 * Created by guobing.wei on 2016/7/19.
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;
    public static void testAllocation() {
        byte [] alloca1, alloca2, alloca3, alloca4;
        alloca1 = new byte[2 * _1MB];
        alloca2 = new byte[2 * _1MB];
        alloca3 = new byte[2 * _1MB];
        alloca4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }

    public static void main(String [] args) {
        TestAllocation.testAllocation();
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * (该参数令大于这个设置值的对象直接在老年代中分配,这样做的目的是避免在Eden区及两个Survivor区之间发生大量的内存拷贝
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }
}
