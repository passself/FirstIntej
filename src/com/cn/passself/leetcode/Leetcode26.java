package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除排序数组中的重复项
 *
 */
public class Leetcode26 {

    public int removeDuplicates(int[] nums){
        if (nums == null || nums.length ==0){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>index) {
                if (nums[i] != nums[index]){
                    index++;
                    nums[index] = nums[i];
                }
            }
        }
        return index+1;
    }
}
