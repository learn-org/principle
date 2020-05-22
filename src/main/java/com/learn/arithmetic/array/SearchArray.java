package com.learn.arithmetic.array;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class SearchArray {

    public static void main(String[] args) {
        int[] search = {5,4,6};
        int[] dist = {9,3,1,4,6,4,3,6,5,4,6};
        int[] dist1 = {1,5,5,4,3,4,5,6,4,};

        System.out.println(indexOf(search, dist));
        System.out.println(matchNum(search, dist1));
    }

    /**
     * 一. 在一个数组中查找另一个数组所在起始位置(首次出现的位置,下标从0开始,未找到返回-1)
     * 要求:
     * 1. 按照平常的自己的编程风格进行书写(考虑变量的命名,程序的性能)
     * 2. 代码需要生产环境可用(考虑异常处理等)
     * 例如:
     * 数组search[5,4,6] 在数组 dist[9,3,5,4,6,4,3,6,5] 的起始位置是 2
     * 数组search[5,4,6] 在数组 dist[1,5,2,3,4,5,6] 的起始位置是 -1
     * @param search
     * @param dist
     * @return
     */
    public static int indexOf(int[] search, int[] dist) {
        if(search==null || search.length==0 || dist==null || dist.length==0 || dist.length<search.length){
            return -1;
        }
        for(int j=0; j<dist.length; j++){
            int index = 0;
            int i = 0;
            int k = 0;
            if(search[0] == dist[j]){
                index = j;
                k = j;
                while(i+1<search.length && k+1<dist.length){
                    if(search[++i] != dist[++k]){
                        break;
                    }
                }
                if(i+1 == search.length){
                    return index;
                }
            }
        }
        return -1;
    }

    /**
     * 二. 如果search在dist中顺序出现而不要求连续出现, 那代码应该如何修改?如何计算这种匹配的可能性?
     * 例如:
     * 数组search[5,4,6] 在数组 dist[1,5,5,4,3,4,5,6] 的起始位置是 1,
     * (因为dist下标{1,3,7}和下标{1,5,7}的元素都等于search[5,4,6],故可能性有两种)
     * @param search
     * @param dist
     * @return
     */
    public static int matchNum(int[] search, int[] dist) {
        if(search==null || search.length==0 || dist==null || dist.length==0 || dist.length<search.length){
            return -1;
        }
        int matchNum = 0;
        for(int j=0; j<dist.length; j++){
            int index = 0;
            int k = 0;
            if(search[0] == dist[j]){
                k = j;
               for(int i=1; i<search.length; i++){
                   while(k+1<dist.length){
                       if(search[i] == dist[++k]){
                           index++;
                           break;
                       }
                   }
                   if(index+1 == search.length){
                       matchNum++;
                   }
               }
            }
        }
        return matchNum;
    }
}
