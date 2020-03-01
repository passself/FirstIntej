package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode75 {

    public void sortColors(int[] nums) {

        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==0){
                int count = maps.containsKey(0)?maps.get(0):0;
                count++;
                maps.put(0,count);
            }
            if (nums[i] ==1){
                int count = maps.containsKey(1)?maps.get(1):0;
                count++;
                maps.put(1,count);
            }
            if (nums[i] ==2){
                int count = maps.containsKey(2)?maps.get(2):0;
                count++;
                maps.put(2,count);
            }
        }
        int count0 = maps.get(0) ==null ? 0:maps.get(0);
        int count1 = maps.get(1)==null ? 0:maps.get(1);
        int count2 = maps.get(2)==null ? 0:maps.get(2);

        for (int j=0; j<count0;j++){
            nums[j] = 0;
        }
        for (int j=count0; j<count1+count0;j++){
            nums[j] = 1;
        }
        for (int j=count1+count0; j<count1+count0+count2;j++){
            nums[j] = 2;
        }
    }

    /**
     * 注意边界，可以设置zero = -1 另一种方式
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        if(nums ==null || nums.length <2){
            return;
        }

        int zero = 0;
        int i = 0; int two = nums.length;
        while(i<two){
            if (nums[i]==0){
                swap(nums,i,zero);
                zero++;
                i++;
            }else if(nums[i] ==1){
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }
    }

    private static void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,2,2};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
