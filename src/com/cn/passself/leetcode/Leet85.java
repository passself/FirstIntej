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

    public int maximalRectangle2(char[][] matrix) {
        if ( matrix == null || matrix.length == 0 ) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] row_sum = new int[n];
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ )
                // 遇到0重置，1累加
                row_sum[j] = ('0' == matrix[i][j]) ? 0 : row_sum[j] + 1;
            int area = largestRectangleArea(row_sum);
            if ( area > max )
                max = area;
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        int max = 0, n = heights.length;
        int[] small_left = new int[n];
        int[] small_right = new int[n];
        small_left[0] = -1;
        small_right[n-1] = n;
        for ( int i = 1; i < n; i++ ) {
            int idx = i - 1;
            while ( idx >= 0 && heights[idx] >= heights[i] )
                idx = small_left[idx];
            small_left[i] = idx;
        }
        for ( int i = n - 2; i >= 0; i-- ) {
            int idx = i + 1;
            while ( idx < n && heights[idx] >= heights[i] )
                idx = small_right[idx];
            small_right[i] = idx;
        }
        for ( int i = 0; i < n; i++ ) {
            int area = (small_right[i] - small_left[i] - 1) * heights[i];
            if ( area > max )
                max = area;
        }
        return max;
    }
}
