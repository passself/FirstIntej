package com.cn.passself.leetcode;

import java.util.Arrays;

public class Leet189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for(int i = 0;i<k;i++){
            int temp = nums[n-1];
            for(int j = n-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public void rotateReverse(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums ,int start,int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            start++;
            nums[end] = temp;
            end--;
        }
    }

    private void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums  = {1,2,3,4,5,6,7};
        //new Leet189().rotate(nums,3);
        //new Leet189().rotateReverse(nums,3);
        new Leet189().rotate_3(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
