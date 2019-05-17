package com.cn.passself.lintcode;

/**
 * 盛最多水的容器
 * https://www.lintcode.com/problem/container-with-most-water/description
 * 双指针法
 */
public class Lintcode383 {

    /**
     * 简化的写法
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        if (height == null || height.length<2){
            return 0;
        }
        int max = 0;
        for (int l = 0, r = height.length -1 ; l < r;){
            int minHeight = height[l] > height[r] ? height[l++] : height[r--];
            max = Math.max(max,(r-l+1)*minHeight);
        }
        return max;
    }

    public int maxArea2(int[] heights){
        if (heights == null || heights.length<2){
            return 0;
        }
        int maxArea = 0;
        int l = 0, r = heights.length-1;
        while (l < r){
            maxArea = Math.max(maxArea,(r - l) * Math.min(heights[l],heights[r]));
            if (heights[l] < heights[r]){
                l ++;
            }else {
                r --;
            }
        }
        return maxArea;
    }
}
