package com.cn.passself.leetcode;

import java.util.Arrays;

public class Leet945 {
    public int minIncrementForUnique(int[] A){
        Arrays.sort(A);
        int result = 0;
        for (int i = 1 ; i < A.length; i++) {
            int pre=A[i-1];
            int cur = A[i];
            if (cur <=pre){
                result+=pre - cur + 1;
                A[i]=pre+1;
            }
        }
        return result;
    }
}
