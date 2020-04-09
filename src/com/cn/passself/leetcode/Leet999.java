package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/available-captures-for-rook/solution/mo-ni-ti-an-zhao-ti-mu-yi-si-shi-xian-ji-ke-java-b/
 */
public class Leet999 {

    public int numRookCaptures(char[][] board) {
        // 因为题目已经明确给出 board.length == board[i].length == 8，所以不做输入检查
        // 定义方向数组，可以认为是四个方向向量，在棋盘问题上是常见的做法

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j =0;j<8; j++) {
                if (board[i][j] == 'R'){
                    int res = 0;
                    for(int[] direction:directions){
                        if(burnout(board,i,j,direction)){
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }
    /**
     *
     * @param board     输入棋盘
     * @param x         当前白象位置的横坐标
     * @param y         当前白象位置的纵坐标
     * @param direction 方向向量
     * @return 消灭一个 p，就返回 true
     */
    private boolean burnout(char[][] board, int x, int y, int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i, j)) {
            // 是友军，路被堵死，直接返回
            if (board[i][j] == 'B') {
                break;
            }

            // 遇到卒子
            if (board[i][j] == 'p') {
                return true;
            }

            i += direction[0];
            j += direction[1];
        }
        return false;
    }

    /**
     * @param i 当前位置横坐标
     * @param j 当前位置纵坐标
     * @return 是否在棋盘有效范围内
     */
    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }


    public int numRookCapturesSimple(char[][] board) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('R' == board[i][j]) {
                    row = i;
                    col = j;
                }
            }
        }
        int sum = 0;
        //左
        for (int i = col - 1; i >= 0; i--) {
            if ('B' == board[row][i]) {
                break;
            }
            if ('p' == board[row][i]) {
                sum++;
                break;
            }
        }
        //右
        for (int i = col + 1; i < 8; i++) {
            if ('B' == board[row][i]) {
                break;
            }
            if ('p' == board[row][i]) {
                sum++;
                break;
            }
        }
        //下
        for (int i = row + 1; i < 8; i++) {
            if ('B' == board[i][col]) {
                break;
            }
            if ('p' == board[i][col]) {
                sum++;
                break;
            }
        }
        //上
        for (int i = row - 1; i >= 0; i--) {
            if ('B' == board[i][col]) {
                break;
            }
            if ('p' == board[i][col]) {
                sum++;
                break;
            }
        }
        return sum;
    }
}
