package com.learn.jvm;

/**
 * @author： lxj
 * @date： 2019/7/18
 * @description：
 */
public class AllocationMemory {

    private static final int _1MB=1024*1024;

    public static void main(String[] args) {
        allocationMemory();

    }
    private static void allocationMemory(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1MB];
//        allocation2=new byte[2*_1MB];
//        allocation3=new byte[2*_1MB];
        allocation4=new byte[6*_1MB];
    }
}
