package com.cn.passself.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet283 {

    /**
     * 暴力循环
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if(nums == null || nums.length <2){
            return;
        }

        Queue<Integer>  queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                queue.add(nums[i]);
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            nums[i] = ((LinkedList<Integer>) queue).get(i);
        }

        for (int i = queue.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length <2){
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if(nums == null || nums.length <2){
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (index != i){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                }
                index++;
            }
        }
    }


    public static void main(String[] args) {

    }
}
