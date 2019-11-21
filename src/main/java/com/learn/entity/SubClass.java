package com.learn.entity;

/**
 * @author： lxj
 * @date： 2019/10/16
 * @description：
 */
public class SubClass extends SupClass {
    static int sub=4;
    static {
        sub= SupClass.sup;
        System.out.println(sub);
        System.out.println("子类静态块");
    }

    public static void main(String[] args) {
        SubClass subClass=new SubClass();
        System.out.println(subClass.toString());
    }
}
