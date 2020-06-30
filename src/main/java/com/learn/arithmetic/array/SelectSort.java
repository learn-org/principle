package com.learn.arithmetic.array;

import java.util.Arrays;

/**
 * @author: lxj
 * @Date: 2020/5/27
 * @Description:
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 3, 9, 11, 13, 34, 21, 12, 89};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        if(array!=null && array.length>0){
            for(int i=0; i<array.length-1; i++){
                for(int j=i+1; j<array.length;j++){
                    if(array[j] < array[i]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        return array;
    }
}
