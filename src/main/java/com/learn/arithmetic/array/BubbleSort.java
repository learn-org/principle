package com.learn.arithmetic.array;

import java.util.Arrays;

/**
 * @author: lxj
 * @Date: 2020/5/27
 * @Description:
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 3, 9, 11, 13, 34, 21, 12, 89};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if(array!=null && array.length>0){
            for(int i=0; i<array.length; i++){
                for(int j=0; j<array.length-i-1; j++){
                    if(array[j] > array[j+1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
        return array;
    }
}
