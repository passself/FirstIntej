package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *  搜索旋转排序数组
 */
public class Leet33 {

    public int search(int[] nums,int target){
        if (nums == null || nums.length ==0){
            return -1;
        }

        int start = 0;
        int end = nums.length -1;
        int mid = 0;

        while(start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }
            //前半部分有序
            if (nums[start] <= nums[mid]){
                //target 在前半部分
                if (target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }else{
                if (target <= nums[end] && target>nums[mid]){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
