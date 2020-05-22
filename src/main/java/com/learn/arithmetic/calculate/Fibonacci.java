package com.learn.arithmetic.calculate;

import java.util.Arrays;

/**
 * @author: lxj
 * @Date: 2020/5/19
 * @Description:
 *       斐波那契数列（Fibonacci sequence）的定义：斐波那契数列指的是这样一个数列
 *        1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368........，
 *        这个数列从第3项开始，每一项都等于前两项之和。
 *        斐波那契数列又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”。
 *        在数学上，斐波纳契数列以如下被以递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）。
 */

public class Fibonacci {

    public static void main(String[] args) {
        int[] a = new int[1];
        for(int j=0; j<a.length; j++){
            a[j] = getFibonacci(j+1);
        }
        int[] b = new int[1];
        for(int k=0; k<b.length; k++){
            b[k] = getFibonacci(k+1);
        }
        System.out.println("a："+Arrays.toString(a));
        System.out.println("b："+Arrays.toString(b));

    }

    /**
     * 斐波那契数列：后面的数是前两个数之和
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
     * @param length
     * @return
     */
    private static int getFibonacci(int length){
        if(length < 0){
            return 0;
        }
        if(length==0 || length==1){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        return getFibonacci(length - 1) + getFibonacci(length - 2);
    }

    private static int getFibonacciOptimize(int length){
        if(length < 0){
            return 0;
        }
        if(length==0 || length==1){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i=3; i<length; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


}
