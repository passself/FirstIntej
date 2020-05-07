package com.cn.passself.leetcode;

public class Leet35 {

    public int searchInsert(int[] nums, int target) {
        if(nums ==null || nums.length ==0){
            return -1;
        }
        int l = 0,r = nums.length-1;//[l,r]
        int mid = -1;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] <target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }
        }
        return l;
    }
}
