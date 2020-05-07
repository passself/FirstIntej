package com.cn.passself.leetcode;

public class Leet498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int i = 0, j = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];

        int k = 0;
        for (int count = 0; count < rows * cols; count++) {
            result[count] = matrix[j][i];

            if (k % 2 == 0) {//向上遍历
                if (j == 0 && i != cols - 1) {
                    //碰上壁，右移
                    i++;
                    k++;
                } else if (i == cols - 1) {//碰右壁，下移
                    j++;
                    k++;
                } else {//正常移动
                    i++;
                    j--;
                }
            } else {//向下遍历
                if (i == 0 && j != rows - 1) {//碰左壁，下移
                    j++;
                    k++;
                } else if (j == rows - 1) {//碰下壁，右移
                    i++;
                    k++;
                } else {
                    i--;
                    j++;
                }
            }
        }
        return result;
    }

    /**
     * better
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrderN(int[][] matrix){
        if (matrix==null || matrix.length == 0){
            return new int[]{};
        }

        /*int c = 0,r=0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows*cols];

        for (int i = 0 ;i<res.length; i++){
            res[i] = matrix[r][c];
            if((c+r)%2 ==0){//向上遍历
                if(c == cols -1){
                    r++;
                }
                else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{//向下遍历
                if (r == rows -1){
                    c++;
                }else if (c == 0){
                    r++;
                }else{
                    c--;
                    r++;
                }
            }
        }*/
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往右移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往下移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往上移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
