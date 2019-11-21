package com.learn.arithmetic.stack;


import java.util.*;

/**
 * @author： lxj
 * @date： 2019/10/15
 * @description：带最小值操作的栈
 * 中文English
 * 实现一个栈, 支持以下操作:
 *
 * push(val) 将 val 压入栈
 * pop() 将栈顶元素弹出, 并返回这个弹出的元素
 * min() 返回栈中元素的最小值
 * 要求 O(1) 开销.
 *
 * 样例
 * 样例 2:
 *
 * 输入:
 *   push(1)
 *   min()
 *   push(2)
 *   min()
 *   push(3)
 *   min()
 * 输出:
 *   1
 *   1
 *   1
 * 注意事项
 * 保证栈中没有数字时不会调用 min()
 */
public class MinStack {
   /**
     * 栈的大小
     */
    static int[] stackArr=new int[1];
    /**
     * 栈中元素的个数
     */
    static int num=0;

    public static void push(int number) {
        if(num >= stackArr.length){
            int[] expandArr=new int[num + 1];
            System.arraycopy(stackArr,0,expandArr,0,num);
            stackArr= expandArr;
        }
        stackArr[num++]=number;

    }

    public static int pop() {
        int p=stackArr[--num];
        stackArr[num]=0;
        return p;
    }

    public static int min() {
        int[] backArr=new int[stackArr.length];
        System.arraycopy(stackArr,0,backArr,0,stackArr.length);
        for(int i=0;i<backArr.length;i++){
            for(int j=0;j<backArr.length-i-1;j++){
                if(backArr[j]<backArr[j+1]){
                    int temp=backArr[j];
                    backArr[j]=backArr[j+1];
                    backArr[j+1]=temp;
                }
            }
        }
//        System.out.println(Arrays.toString(backArr));
        return backArr[num-1];
    }

   /* *//**
     * 栈的大小
     *//*
    static List<Integer> stackList=new ArrayList();
    *//**
     * 栈中元素的个数
     *//*
    static int num=0;

    public static void push(int number) {
        stackList.add(number);
        num++;
    }

    public static int pop() {
        int p=stackList.get(--num);
        stackList.remove(num);
        return p;
    }

    public static int min() {
        return stackList.stream().min(Comparator.comparing(Integer::intValue)).get();
    }*/

    public static int[] deleteArrayEle(int[] array,int ele){
        if(array!=null && array.length>0){
            System.out.println("删除元素前的数组："+Arrays.toString(array));
            //删除元素的下标
            int num=0;
            //数组的长度
            int l=array.length;
            for(int i=0;i<l;i++){
                if(array[i] == ele){
                    num=i;
                    break;
                }
            }
          if(num > 1){
              for(int j=num;j<l;j++){
                  if(j == l-1){
                      break;
                  }
                  array[j] = array[j+1];
              }
              l--;
              int[] resultArray=new int[l];
              System.arraycopy(array,0,resultArray,0,l);
              System.out.println("删除元素后的数组："+Arrays.toString(resultArray));
              return resultArray;
          }
        }
        return array;
    }
    public static void main(String[] args) {
     /*   push(1);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());*/


/*        push(1);
        System.out.println(pop());
        push(2);
        push(3);
        System.out.println(min());
        push(1);
        System.out.println(min());*/
        /**
         * 输出
         * [1,1,1,1,2,3,4]
         * 期望答案
         * [1,1,1,3,2,1,4]
         */
/*        push(1);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(min());*/
        /**
         * 输出
         * [-100,-101,0,50,100,-99,-101,-100,0]
         * 期望答案
         * [-101,-101,-101,50,100,-99,-101,-100,0]
         */
       /* push(-100);
        push(-101);
        push(-99);
        System.out.println(min());
        push(100);
        System.out.println(min());
        push(50);
        System.out.println(min());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        push(0);
        System.out.println(min());*/

       int[] array={1,2,3,45,6,7};
        deleteArrayEle(array,45);
    }

}
