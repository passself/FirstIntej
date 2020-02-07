package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 27. 移除元素
 */
public class Leetcode27 {

    /**
     * index 游标来记录
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int size = nums.length;
        for (int i=0;i<size;i++){
            if (nums[i] != val){
                nums[index]= val;
                index++;
            }
        }
        return index;
    }

    public int removeElementPoint(int[] nums, int val) {
        int index = 0;
        int size = nums.length;
        while (index<size){
            if (nums[index] == val){
                nums[index] = nums[size-1];
                size--;
            }else {
                index++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,2,3};
        System.out.println(new Leetcode27().removeElement(nums,3));
    }
}
