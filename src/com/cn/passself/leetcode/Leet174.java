package com.cn.passself.leetcode;

public class Leet174 {


    public int caculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                    int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        return dp[0][0];
    }

    public int caculateMinimumByArray(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int health = 0;
                if (i == m - 1) health = dp[j + 1] - dungeon[i][j];
                else if (j == n - 1) health = dp[j] - dungeon[i][j];
                else health = Math.min(dp[j + 1], dp[j]) - dungeon[i][j];
                dp[j] = health <= 0 ? 1 : health;
            }
        }
        return dp[0];
    }
}
