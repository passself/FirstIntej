package com.cn.passself.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * 旋转矩阵
 */
public class Review0107 {

    public static void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    /**
     * 原地修改，四次交换位置
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2 ; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }

    /**
     * 先水平翻转，再沿对角线翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;  
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        // 沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maxtrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate1(maxtrix);
        System.out.println(""+maxtrix.length);
        for (int i = 0; i < maxtrix.length; i++) {
            System.out.println(Arrays.toString(maxtrix[i]));
        }
    }
}
