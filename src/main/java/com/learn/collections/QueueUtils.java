package com.learn.collections;


import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author： lxj
 * @date： 2019/7/18
 * @description：
 */
public class QueueUtils {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(2);
        System.out.println("poll前："+linkedList);
        Integer n=linkedList.poll();
        System.out.println("n："+n);
        System.out.println("poll后："+linkedList);

        PriorityQueue priorityQueue=new PriorityQueue();
        priorityQueue.poll();
        priorityQueue.add(1);
    }
}
