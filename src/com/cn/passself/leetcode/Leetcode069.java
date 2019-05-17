package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/sqrtx/comments/
 * 求平方根
 */
public class Leetcode069 {

    /**
     * 二分
     * @param x
     * @return
     */
    public int mySqrt(int x){
        if(x==0 || x == 1) return x;
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = (left+right) >> 1;
            if (mid == x/mid) return mid;
            if (x/mid > mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    /**
     * 牛顿迭代
     * x^2 + C = 0 ==> x = (x+x/c)/2
     */
    public int mySqrt2(int x){
        if (x == 0 || x == 1){
            return x;
        }
        long res = x;
        while (res > (x/res)){
            res = (res/x + res)/2;
        }

        return (int) res;
    }
}
