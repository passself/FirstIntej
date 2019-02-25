package com.cn.passself.leetcode;

import java.util.Arrays;

public class Leet85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right,n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0,curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j] ++;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    left[j] = Math.max(curLeft,left[j]);
                }else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n- 1; j >= 0; j--) {
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(curRight,right[j]);
                }else{
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j< n;j++){
                result = Math.max(result,(right[j] - left[j]) * height[j]);
            }
        }

        return result;
    }
}
