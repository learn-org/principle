package com.learn.arithmetic.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author: lxj
 * @Date: 2020/12/10
 * @Description:
 */

public class Statistics {
    public static void main(String[] args) {
        int k = 1;
        int n = 12;
//        System.out.println(statisticsNumber(k, n));
//        System.out.println(isPrimeNumber(1));
        System.out.println(isUglyNumber(10));
        System.out.println(getUglyNumber(9));
        int[] array = {9,3,2,4,8};
        System.out.println(getNMaxNumber(1, array));
    }
    /**
     * 统计数字
     * 描述
     * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
     * 样例 1：
     * 输入：k = 1, n = 1
     * 输出：1
     * 解释：
     * 在 [0, 1] 中，我们发现 1 出现了 1 次 (1)。
     * 样例 2：
     * 输入：k = 1, n = 12
     * 输出：5
     * 解释：
     * 在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)。
     */
    public static int statisticsNumber (int k, int n) {
        // k在0到n中出现的次数
        int c = 0;
        if (k < 0 || k > 9) {
            return c;
        }
        for (int i = 1; i <= n; i++) {
            String temp = i + "";
            char[] chars = temp.toCharArray();
            int cc = 0;
            for (char ch : chars) {
                // ASCII编码48到57为字符'0' ~ '9'的编码。
                if (ch - 48 == k) {
                    cc ++ ;
                }
            }
            c += cc;
        }
        return c;
    }

    /**
     * 丑数
     * 描述
     * 设计一个算法，找出只含素因子2，3，5的第n个数。
     * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
     * 我们可以认为1也是一个丑数。
     * 样例
     * 样例 1：
     * 输入：9  输出：10
     * 样例 2：
     * 输入：1  输出：1
     */
    public static int getUglyNumber (int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int j1 = 0;
        int j2 = 0;
        int j3 = 0;
        int min = 0;
        for (int i = 1; i < n; i++) {
            int min2 = 2 * arr[j1];
            int min3 = 3 * arr[j2];
            int min5 = 5 * arr[j3];
            min = Math.min(Math.min(min2, min3), min5);
            if (min == min2) {
                j1++;
            }
            if (min == min3) {
                j2++;
            }
            if (min == min5) {
                j3++;
            }
            arr[i] = min;
        }
        return arr[n-1];
    }

    /**
     * 是否是丑数（只含素因子2，3，5的数是丑数）
     *
     * @param k
     * @return
     */
    private static boolean isUglyNumber (int k) {
        // 求出k的所有质数因数
        int[] factorArr = new int[k];
        int c = 0;
        for (int i = 1; i <= k; i++) {
            // 是k的约数且是素数
            if (k % i == 0 && isPrimeNumber(i)) {
                factorArr[c++] = i;
            }
        }
        // 因数数组中不是0的因数个数
        int noZero = 0;
        for (int j : factorArr) {
            if (j != 0) {
                noZero ++;
            }
        }
        // 如果除了自身和1的因数个数超过3个，则不是丑数
        if (noZero > 3) {
            return Boolean.FALSE;
        } else {
            for (int j : factorArr) {
                // 是否是丑数（只含素因子2，3，5的数是丑数）
                if (j !=0 && j !=2 && j != 3 && j!= 5) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 是否是质数（素数）（约数只有1和本身）
     * @param n
     * @return
     */
    private static boolean isPrimeNumber (int n) {
        if (n == 1) {
            return Boolean.FALSE;
        }
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                c ++;
            }
        }
        return c == 0;
    }
    /**
     * 第k大元素
     * 描述
     * 在数组中找到第k大的元素。
     * 你可以交换数组中的元素的位置
     * 样例
     * 样例 1：
     * 输入：n = 1, nums = [1,3,4,2]
     * 输出：4
     * 样例 2：
     * 输入：n = 3, nums = [9,3,2,4,8]
     * 输出：4
     */

    private static int getNMaxNumber (int n, int[] array) {
        if (array != null && array.length > 0) {
            if (n > array.length) {
                return 0;
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length-i-1; j++) {
                    if (array[j] < array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array[n-1];
    }
}
