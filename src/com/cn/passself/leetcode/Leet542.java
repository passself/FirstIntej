package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class Leet542 {

    /**
     * BFS
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length,n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return matrix;
    }

    public int[][] updateMatrixDp(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList<>();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //四个方向广搜
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            //四个方向上找 1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //没有计算过的地方一定是 1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }

    /**
     * 时间复杂度：O(n) 两次遍历

    思路二：动态规划
    其实在广搜思路中，就已经能从结果集中搜索源点的值+1这里尝到DP的味道了，再加上方法返回的这个距离数组需要逐步填表的过程，
     就能想到一些DP思路了。

    dp[i][j]含义：就像题目中要求的matrix[i][j]距离0的最小距离。

    初始化：dp数组元素赋一个最大值，遍历矩阵元素为0的地方先填写完毕。

    状态转移：第一次遍历从左上到右下填表，每次只向右向下"搜索"；第二次遍历从右下到左上填表，每次只向左向上"搜索"。(有广搜内味了)
     **/
    public int[][] updateMatrixDp2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10001);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
            }
        }
        //状态转移
        //第一次填表从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        //第二次填表从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
