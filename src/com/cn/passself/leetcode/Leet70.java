package com.cn.passself.leetcode;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/comments/
 */
public class Leet70 {

    /**
     * 递归太慢了
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<= 2){
            return n;
        }
        return climbStairs(n -1) + climbStairs(n-2);
    }

    public int climbStairsBetter(int n) {

        if (n < 3){
            return n;
        }

        int oneStep = 2,twoStep = 1;int total = 0;
        for (int i = 3; i < n; i++) {
            total = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = total;
        }
        return total;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairsDP(int n){
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {

    }
}
