package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 跳跃游戏 II
 */
public class Leet45 {

    public int jump(int[] nums) {
        int length = nums.length;

        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
