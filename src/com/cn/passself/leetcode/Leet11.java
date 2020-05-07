package com.cn.passself.leetcode;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Leet11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
