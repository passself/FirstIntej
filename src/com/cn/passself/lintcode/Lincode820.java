package com.cn.passself.lintcode;

/**
 * 解数独问题
 * Created by shx on 2019/5/19.
 * https://www.lintcode.com/problem/valid-sudoku/description
 */
public class Lincode820 {
    public void solveSudoku(char[][] board){
        /**
         * 记录某行
         * 某位数字是否已经被摆放
         *
         */
        boolean[][] row = new boolean[9][10];
        /**
         * 记录某一列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][10];

        /**
         * 记录某3*3宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i/3*3+j*3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board,boolean[][] row,boolean[][] col,
                        boolean[][] block,int i,int j){
        //找寻空位置
        while (board[i][j] !='.'){
            if (++ j>=9){
                i++;
                j=0;
            }
            if (i>=9) {
                return true;
            }
        }
        for (int num = 1;num <=9;num++){
            int blockIndex = i/3*3+j/3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
