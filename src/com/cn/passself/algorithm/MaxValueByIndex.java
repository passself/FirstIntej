package com.cn.passself.algorithm;

/**
 * 一个数组中，遍历得出(任意两个元素之和) + (这两个元素的索引之差)的最大值
 * 大熊猫给出的答案
 */
public class MaxValueByIndex {

    public static int solution(int[] A){
        int plusMax = 0;
        int minusMax = 0;

        for (int i = 0; i < A.length; i++) {
            plusMax = Math.max(plusMax,A[i]+i);
            minusMax = Math.max(minusMax,A[i]-i);
        }
        return plusMax + minusMax;
    }
}
