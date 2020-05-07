package com.cn.passself.leetcode;

public class Review0108 {

    /**
     * https://leetcode-cn.com/problems/coin-lcci/
     * 硬币
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
