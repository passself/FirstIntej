package com.cn.passself.leetcode;

import java.util.Arrays;

public class Leetcode85 {

    public static int removeDuplicates(int[] nums) {
        int i =1, k =1;
        int count = 1;

        int length = nums.length;
        while(i<length){
            if (nums[i]== nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            if (count>2){
            }else{
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return k;
    }


    public static int removeDuplicates2(int[] nums) {
        int i = 1,count = 1,length = nums.length;

        while(i<length){
            if (nums[i-1]==nums[i]){
                count++;
                if (count >2){
                    removeElement(nums,i);
                    length--;
                    i--;
                }
            }else{
                count=1;
            }
            i++;
        }
        return i;
    }


    public static int[] removeElement(int arr[],int index){
        for (int i = index+1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,3,4};
        //int result = removeDuplicates2(arr);
        //System.out.println(result);

        int[] test = removeElement(new int[]{1,2,3,4,5,6},2);
        System.out.println(Arrays.toString(test));
    }
}
