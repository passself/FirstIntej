package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/comments/
 * Created by shx on 2019/5/19.
 * 是否是数独
 */
public class Leetcode036 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];

        boolean[][] block = new boolean[9][9];

        for(int i=0; i<9;i++){
            for(int j = 0; j< 9; j++){
                if(board[i][j] !='.'){
                    int num = board[i][j] - '1';
                    int blockIndex = i/3*3+j/3;
                    if(row[i][num] || col[j][num] || block[blockIndex][num]){
                        return false;
                    }else{
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
