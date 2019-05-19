package com.cn.passself.lintcode;

/**
 * https://www.lintcode.com/problem/triangle/description
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class Lintcode109 {

    public static int minimumTotal(int[][] triangle) {
        // write your code here

        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        // state: result[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            result[n-1][i] = triangle[n-1][i];
        }

        //bottom up
        for (int i = n - 2;i>=0; i--) {
            for (int j = 0; j <= i; j++) {
                result[i][j] = Math.min(result[i + 1][j], result[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return result[0][0];
    }


    public int minimumTotal2(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return 0;
        }
        int m = triangle.length;
        int[][] f = new int[m][m];

        f[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (min > f[m - 1][i]) {
                min = f[m - 1][i];
            }
        }

        return min;
    }

    //Version 2 : Memorize Search
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
                + triangle[x][y];
        return minSum[x][y];
    }

    public int minimumTotalV2(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }

    public static void main(String[] args) {
        //System.out.println(minimumTotal(hi));
    }
}
